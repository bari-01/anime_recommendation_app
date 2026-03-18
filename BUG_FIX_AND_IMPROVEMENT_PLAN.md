# AnimeMate Bug Fix & Improvement Plan

## Executive Summary
After deep analysis of the codebase, I've identified **3 critical UI/theme bugs**, **5 performance issues**, and **4 recommendation algorithm improvements**. This plan addresses all issues, then describes the signed APK release process with R8 minimization and obfuscation.

---

## PHASE 1: CRITICAL BUG FIXES

### Bug #1: Theme Not Reapplying on Cold Start (PRIMARY COMPLAINT)
**Severity:** HIGH  
**Root Cause:** Theme is applied in `onCreate()` BEFORE `setContentView()`, but system default is applied by framework AFTER. The issue manifests when system's preferred theme differs from user's saved preference.

**Current Flow:**
```
MainActivity.onCreate() starts
  → Apply saved theme via AppCompatDelegate.setDefaultNightMode()
  → setContentView(R.layout.activity_main)
  → Framework applies system default over it
  → window.decorView callbacks fire (too late)
```

**Problem:** When app starts in light theme but device is set to dark mode (or vice versa), the UI briefly shows one theme before switching. User sees "messed up" UI until they manually toggle.

**Fix:** 
1. Move theme application to a custom `Application.onCreate()` OVERRIDE so it runs before any activities
2. Use immediate theme application instead of `MODE_NIGHT_FOLLOW_SYSTEM` by default
3. Force immediate recomposition via `recreate()` ONLY when user manually toggles (not on app launch)
4. Add theme caching with checksum to detect system changes

---

### Bug #2: Theme Switch Causes ActivityRecreation Loop
**Severity:** MEDIUM  
**Root Cause:** Dark mode toggle in ProfileFragment directly calls `AppCompatDelegate.setDefaultNightMode()` → triggers activity recreation → invokes `onCreate()` which re-runs theme logic → causes UI flicker and visual glitches.

**Current Code:**
```kotlin
// ProfileFragment.kt line ~198
darkModeSwitch?.setOnCheckedChangeListener { _, isChecked ->
    val nightMode = if (isChecked) 
        AppCompatDelegate.MODE_NIGHT_YES 
        else AppCompatDelegate.MODE_NIGHT_NO
    AppCompatDelegate.setDefaultNightMode(nightMode)  // ← TRIGGERS recreate()
}
```

**Fix:**
1. Delay the `setDefaultNightMode()` call by 300ms to let the UI stablize first
2. Or better: Use `recreate()` INSTEAD of `setDefaultNightMode()` for explicit control

---

### Bug #3: Status Bar & Navigation Bar Colors Not Respecting Theme
**Severity:** MEDIUM  
**Root Cause:** Window attributes are set in `onCreate()` but system bars might override them after inset dispatch. The `values/themes.xml` has the colors, but they're not being actively re-applied when theme changes.

**Current Code:**
```xml
<!-- themes.xml: Set once, forgotten -->
<item name="android:statusBarColor">@color/status_bar_light</item>
<item name="android:navigationBarColor">@color/bottom_nav_light</item>
```

**Fix:**
1. Add explicit window color setters in MainActivity after theme is applied
2. Sync window colors in ProfileFragment right after `setDefaultNightMode()` is called
3. Use `WindowCompat.getInsetsController()` to also set light/dark icons appropriately

---

## PHASE 2: PERFORMANCE OPTIMIZATIONS

### Perf Issue #1: Unbounded Recommendation Cache Memory Leak
**Severity:** HIGH  
**Location:** `BasicRecommendationEngine.kt` line 41-48

**Problem:**
```kotlin
private val recommendationCache = mutableMapOf<String, Pair<List<AnimeContent>, Long>>()
// ← NO SIZE LIMIT! 
// With time-slotted keys (line 92), creates 6 new keys per hour = 144 per day
// Each key holds ~20-50 AnimeContent objects (~1-2KB each) = 20-100KB per key
// Over 1 week: 1000+ keys, 20-100MB+ of RAM NEVER FREED
```

**Fix:**
1. Add `LinkedHashMap` with `removeEldestEntry()` override (LRU cache)
2. Cap cache at 50 entries max
3. Call `cache.clear()` on memory pressure (already done in `AnimeRecApp.onTrimMemory()` but NOT wired to the engine)

---

### Perf Issue #2: N+1 API Queries in Recommendation Generation
**Severity:** MEDIUM  
**Location:** `BasicRecommendationEngine.kt` lines 295-330

**Problem:**
```kotlin
for (rankingType in rankingTypes) {  // 5 types for anime
    val result = when (normalizedType) {
        "anime" → repository.getAnimeRecommendations(...)  // ← API CALL
        // ...
    }
}
// Then separately:
if (normalizedType == "anime") {
    val suggestionsResult = repository.getRecommendations(limit)  // ← 6TH API CALL
}
```

For ANIME: **6 API calls minimum** every recommendation load!  
Current caching uses 10-minute expiry, but cache key includes contentType, so switching tabs creates new keys → 6 more calls.

**Fix:**
1. Batch API calls using `async` + `awaitAll()` instead of sequential `for` loop
2. Merge suggestions endpoint call into the ranking loop (not separate)
3. Cache at CONTENT TYPE level (not time-slotted), expire only on explicit refresh
4. Use `distinctBy { it.id }` BEFORE filtering, not after (wasteful)

---

### Perf Issue #3: Main Thread Coroutine Overhead
**Severity:** MEDIUM  
**Location:** `RecommendationViewModel.kt` line 87, 206

**Problem:**
```kotlin
viewModelScope.launch {  // ← Defaults to Dispatchers.Main + superview job
    // Heavy work here:
    // - getRecommendationsForType() runs on IO (good)
    // - But filtering, merging, deduplication on Main thread (bad)
    val uniqueNewRecommendations = newRecommendations.filter { it.id !in existingIds }
    allRecommendations = allRecommendations + uniqueNewRecommendations  // Memory allocation
    val filteredList = applyMediaFilter(allRecommendations)  // Linear scan
    _recommendations.value = Resource.Success(filteredList)
}
```

**Fix:**
1. Explicitly use `viewModelScope.launch(Dispatchers.Default)` for CPU-heavy work
2. Only switch back to Main for `_recommendations.value = ...`
3. Pre-compute deduplication ids as a Set, not a list (O(1) lookup instead of O(n))

---

### Perf Issue #4: ProfileFragment Theme Preferences Loading on Every Resume
**Severity:** LOW-MEDIUM  
**Location:** `ProfileFragment.kt` line 110-115

**Problem:**
```kotlin
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    
    val themePrefs = requireContext().getSharedPreferences(...)  // ← Re-read EVERY TIME
    val currentNightMode = themePrefs.getInt("night_mode", ...)
    darkModeSwitch?.isChecked = ...
}
```

Each `onViewCreated()` re-reads SharedPrefs. For orientation changes or fragment replace, this repeats unnecessarily.

**Fix:**
1. Cache theme preference in instance variable initialized in `onCreate()` (Fragment-level, not View)
2. Update instance cache only when user toggles switch
3. Sync from SharedPrefs only in `onResume()` if another instance changed it

---

### Perf Issue #5: Glide Image Loading Not Cancelled on Fragment Destroy
**Severity:** MEDIUM  
**Location:** Multiple fragments - `HomeFragment.kt` line 300, `DetailsFragment.kt` line 303

**Problem:**
While fragments DO null out view references in `onDestroyView()`, the Glide requests are not explicitly cancelled. Glide handles this via lifecycle integration BUT:
- `Glide.with(context)` in some places instead of `Glide.with(this)` (fragment)
- If you pass `requireActivity()` instead of `this`, cancellation doesn't work
- Image loading continues in background after fragment is destroyed

**Fix:**
1. Audit all `Glide.with()` calls → ensure ALL are `Glide.with(this)` or `Glide.with(viewLifecycleOwner)`
2. Call `Glide.with(this).clear(imageView)` explicitly in `onDestroyView()`
3. Use `RequestManager` pool from BaseFragment (already exists but not widely used)

---

## PHASE 3: RECOMMENDATION ALGORITHM IMPROVEMENTS

### Improve #1: Cold-Start Problem (New Users / New Content Types)
**Current:** When user selects a new content type (e.g., switches to manga for first time), engine has NO interaction history. Falls back to 100% popularity-based → boring, repetitive.

**Improvement:**
1. Implement **exploration vs exploitation** properly:
   - 80% personalised (current)
   - 20% random/exploration (NEW)
2. Add **seeds** for new content types:
   - If user has no manga interactions, bootstrap with 1-2 trending manga from each of their favorite genres
   - Then blend in personalized + exploration
3. Add **user segmentation** scoring:
   - If user watched action anime, prefer action manga (cross-type affinity)

**Impact:** Much better recommendations for new content types, prevents "cold start" blandness.

---

### Improve #2: Content Type Scoring Mismatch (Still Lingering Bug)
**Current Bug:** `UserPreferenceModel.kt` line 149 uses `contentType.name.lowercase()` which returns `"novel"`, but preferences store `"novels"` (plural).

```kotlin
val contentType = content.type.name.lowercase()  // "novel"
score += contentTypeWeights.getOrDefault(contentType, 0.0)  // Key: "novel"
if (contentType in user.contentPreferences) { ... }  // ← Never true!
```

**ALREADY PARTIALLY FIXED** in BasicRecommendationEngine, but NOT in UserPreferenceModel!

**Improvement:**
1. Centralize pluralization: create `ContentType.displayName()` method
2. Use consistently everywhere
3. OR: Change all storage to singular form

---

### Improve #3: Temporal Decay Not Adaptive
**Current:** Hard-coded bonus weights (W_AIRING_BOOST = 4.0, W_RECENT_BOOST = 2.0) for all users.

**Improvement:**
1. Add `userPreferencesForRecency` tracking
2. If user watched recent anime (past month), increase W_RECENT_BOOST to 3.0
3. If user has watched many ongoing series, increase W_AIRING_BOOST
4. Track this preference, update monthly

**Impact:** Richer personalization, recommendations adapt to user habits over time.

---

### Improve #4: Genre Diversity Injection Too Strict
**Current:** `MAX_SAME_GENRE_RATIO = 0.4` means max 40% from same genre in 20 items = max 8 of same genre.

**Problem:** If user loves "Action" genre, they're artificially limited to only 8 action items out of 20. This punishes dedicated fans.

**Improvement:**
1. Make `MAX_SAME_GENRE_RATIO` user-adaptive
2. If user has watched 50+ action items AND rated them 8+, allow 60%
3. Otherwise keep at 40%
4. Track preference history to compute this dynamically

---

## PHASE 4: SIGNED APK RELEASE WITH R8 & OBFUSCATION

### Step 1: Create Debug Keystore (if not exists)
Already done for debug builds. No action needed.

### Step 2: Create Release Keystore
```bash
keytool -genkey -v -keystore ~/AnimeMate.keystore \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias AnimeMate \
  -storepass [PASSWORD] \
  -keypass [PASSWORD]
```

### Step 3: Configure Release Signing in build.gradle
```gradle
signingConfigs {
    release {
        storeFile file(System.getenv("KEYSTORE_PATH") ?: "/path/to/AnimeMate.keystore")
        storePassword System.getenv("KEYSTORE_PASSWORD")
        keyAlias System.getenv("KEY_ALIAS") ?: "AnimeMate"
        keyPassword System.getenv("KEY_PASSWORD")
    }
}

buildTypes {
    release {
        signingConfig signingConfigs.release
        minifyEnabled true
        shrinkResources true
        proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
    }
}
```

### Step 4: Enhance ProGuard Rules
**Current:** Uses default + minimal custom rules  
**Needed:** Add specific rules for:
- Gson serialization (preserve model classes)
- Retrofit interfaces
- OkHttp
- CardStackView
- Navigation components

See `PROGUARD_RULES_ENHANCEMENT.txt` (created in next section).

### Step 5: Enable R8 (already enabled by default in AGP 8.2.0)
Verify in `gradle.properties`:
```properties
android.enableR8=true
android.enableR8.fullMode=true
```

### Step 6: Build Release APK
```bash
./gradlew assembleRelease
```

**Output:** `AnimeMate-1.0.0-release.apk` (signed, minified, obfuscated)

### Step 7: Create GitHub Release with Signed APK
```bash
gh release create v1.0.0-final ./app/build/outputs/apk/release/AnimeMate-1.0.0-release.apk \
  --title "AnimeMate v1.0.0" \
  --notes "..."
```

---

## Summary of Changes

| Category | Count | Priority |
|----------|-------|----------|
| **Critical UI/Theme Bugs** | 3 | ⚠️ HIGH |
| **Performance Issues** | 5 | ⚠️ MEDIUM |
| **Recommendation Improvements** | 4 | ℹ️ LOW-MEDIUM |
| **Release Build Config** | 4 steps | ✓ |

---

## Implementation Order
1. **CRITICAL FIRST:** Bug #1 - Theme cold start (user's main complaint)
2. Then: Bugs #2, #3
3. Then: Perf Issues #1-5
4. Then: Recommendation Improvements #1-4
5. Finally: Build signed release APK

---

## Files to Modify
- `AnimeRecApp.kt` (add theme caching)
- `MainActivity.kt` (window color sync)
- `ProfileFragment.kt` (theme logic, delayed toggle)
- `BasicRecommendationEngine.kt` (cache bounding, API batching)
- `RecommendationViewModel.kt` (coroutine dispatcher, dedup optimization)
- `UserPreferenceModel.kt` (content type pluralization)
- `app/build.gradle` (signing config, R8 setup)
- `proguard-rules.pro` (enhanced rules)

---

**Next Steps:** Approve this plan → I'll implement all fixes → build signed release APK
