# File Structure

Complete source tree for the AnimeMate Android application.

---

## Project Root

```
anime_recom_date/AnimeRecApp/
├── app/
│   ├── build.gradle                          # App-level Gradle config (Groovy DSL)
│   ├── proguard-rules.pro                    # ProGuard / R8 rules
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/animerec/app/
│           │   └── (Kotlin source — see below)
│           └── res/
│               └── (Resources — see below)
├── build.gradle                              # Project-level Gradle config
├── gradle.properties                         # Gradle JVM args
├── settings.gradle                           # Module include
├── gradle/wrapper/                           # Gradle wrapper
├── build_apk.sh                              # Automated build script
├── QUICKSTART.md                             # Quick build guide
├── BUILD_GUIDE.md                            # Comprehensive build docs
└── ANDROID12_SETUP.md                        # Android 12 config details
```

---

## Kotlin Source

```
java/com/animerec/app/
│
├── AnimeRecApp.kt                # Application class — client ID, API URLs, field constants
├── MainActivity.kt               # Single Activity host, bottom nav, WindowInsets, ErrorLogManager
│
├── api/
│   ├── MyAnimeListService.kt     # Retrofit interface — all MAL API endpoints
│   ├── MyAnimeListClient.kt      # OkHttp + Retrofit setup, auth interceptor, caching
│   └── RetryInterceptor.kt       # Exponential backoff + rate-limit (429) handling
│
├── auth/
│   └── AuthManager.kt            # OAuth 2 PKCE — token exchange, refresh, logout
│
├── data/
│   ├── AnimeRepository.kt        # Repository interface (suspend functions)
│   ├── AnimeRepositoryImpl.kt    # Repository implementation — API calls, caching, preferences
│   ├── ApiResponseCache.kt       # In-memory TTL cache for API responses
│   └── Resource.kt               # Sealed class: Success / Error / Loading
│
├── models/
│   ├── ApiResponses.kt           # MAL API response data classes + .toAnimeContent() mappers
│   ├── AnimeContent.kt           # Domain model for anime, manga, novels
│   ├── User.kt                   # User profile model
│   ├── AnimeStatistics.kt        # User anime statistics
│   └── ContentType.kt            # Enum: ANIME, MANGA, NOVEL
│
├── recommendation/
│   ├── RecommendationEngine.kt   # Interface + InteractionType enum
│   ├── BasicRecommendationEngine.kt  # Twitter/X-style ranking algorithm
│   ├── UserPreferenceModel.kt    # Learned genre/content weights from interactions
│   └── RecommendationMetrics.kt  # Metrics tracking for recommendation quality
│
├── ui/
│   ├── home/
│   │   ├── HomeFragment.kt       # CardStackView swipe interface
│   │   ├── CardStackAdapter.kt   # RecyclerView adapter for swipe cards
│   │   └── RecommendationViewModel.kt  # Loads, caches, prefetches recommendations
│   │
│   ├── watchlist/
│   │   ├── WatchlistFragment.kt  # Watchlist tabs (anime, manga, novels)
│   │   └── WatchlistViewModel.kt # Loads watchlist by content type
│   │
│   ├── history/
│   │   ├── HistoryFragment.kt    # History list with status tabs
│   │   └── HistoryViewModel.kt   # Loads history, rate, update status
│   │
│   ├── details/
│   │   ├── DetailsFragment.kt    # Full content details + similar content
│   │   ├── DetailsViewModel.kt   # Loads details, similar content, status updates
│   │   └── SimilarContentAdapter.kt  # Horizontal RecyclerView adapter
│   │
│   ├── profile/
│   │   ├── ProfileFragment.kt    # Profile card, quick actions, dark mode, logout
│   │   ├── ProfileViewModel.kt   # Loads user profile + statistics
│   │   ├── MalStatsFragment.kt   # Full-page MAL statistics with charts
│   │   └── PreferencesFragment.kt # Genre/content type/airing preferences (74 genres)
│   │
│   ├── auth/
│   │   └── AuthFragment.kt       # Login screen + OAuth 2 flow trigger
│   │
│   ├── splash/
│   │   └── SplashFragment.kt     # Splash → auth check → navigate
│   │
│   └── setup/
│       ├── ContentTypeSetupFragment.kt  # Initial content type selection
│       ├── GenreSetupFragment.kt        # Initial genre selection
│       └── FavoritesSetupFragment.kt    # Confirm favourite titles from MAL
│
├── util/
│   └── ErrorLogManager.kt        # Structured logging to file + logTimed() profiling
│
└── utils/
    └── SecureStorage.kt          # EncryptedSharedPreferences wrapper for tokens
```

---

## Resources

```
res/
├── drawable/
│   ├── ic_anime_mate_logo.xml         # App logo vector
│   ├── ic_home.xml                    # Nav: Home (theme-aware)
│   ├── ic_watchlist.xml               # Nav: Watchlist (theme-aware)
│   ├── ic_history.xml                 # Nav: History (theme-aware)
│   ├── ic_profile.xml                 # Nav: Profile (theme-aware)
│   ├── ic_favorite.xml                # Favourite heart icon
│   ├── ic_bar_chart.xml               # Statistics icon
│   ├── ic_settings.xml                # Settings gear icon
│   ├── ic_dark_mode.xml               # Dark mode crescent moon
│   ├── ic_tune.xml                    # Tune/preferences icon
│   ├── ic_edit.xml                    # Edit pencil icon
│   ├── ic_logout.xml                  # Logout door icon
│   ├── ic_email.xml                   # Email icon (send logs)
│   ├── ic_star.xml                    # Rating star
│   ├── ic_swipe_right.xml             # Swipe tutorial: right
│   ├── ic_swipe_left.xml              # Swipe tutorial: left
│   ├── ic_swipe_up.xml                # Swipe tutorial: up
│   ├── ic_swipe_down.xml              # Swipe tutorial: down
│   ├── bg_stats_button_ripple.xml     # Gradient ripple background
│   ├── bg_gradient_card.xml           # Card gradient background
│   └── ... (additional drawables)
│
├── layout/
│   ├── activity_main.xml              # MainActivity: FragmentContainerView + BottomNav
│   ├── fragment_home.xml              # CardStackView + overlay buttons
│   ├── item_card.xml                  # Individual swipe card layout
│   ├── fragment_watchlist.xml         # TabLayout + ViewPager2
│   ├── fragment_history.xml           # TabLayout + RecyclerView
│   ├── fragment_profile.xml           # Circular photo, stats, quick actions
│   ├── fragment_details.xml           # Scrollable details + similar carousel
│   ├── fragment_mal_stats.xml         # Full statistics page
│   ├── fragment_preferences.xml       # Chip-based preference editor
│   ├── fragment_auth.xml              # Login screen
│   ├── fragment_splash.xml            # Splash screen
│   ├── fragment_content_type_setup.xml
│   ├── fragment_genre_setup.xml
│   ├── fragment_favorites_setup.xml
│   └── item_content.xml               # List item layout
│
├── navigation/
│   └── nav_graph.xml                  # Navigation graph with SafeArgs
│
├── values/
│   ├── colors.xml                     # 45+ colour definitions (light + dark palettes)
│   ├── themes.xml                     # Theme.Material3.Light parent
│   ├── strings.xml                    # String resources
│   └── dimens.xml                     # Dimension values
│
├── values-night/
│   └── themes.xml                     # Theme.Material3.Dark parent
│
└── mipmap-*/
    └── ic_launcher*.xml               # Adaptive launcher icons
```

---

## Documentation

```
docs/
├── architecture.md            # MVVM architecture, package structure, navigation
├── api-integration.md         # MAL API v2 endpoints, OAuth 2 flow, data models
├── recommendation-engine.md   # Twitter/X-style algorithm, scoring, diversity
└── file-structure.md          # This file
```

---

## Build & Config Files

| File | Purpose |
|------|---------|
| `app/build.gradle` | Dependencies, SDK versions, build types (Groovy DSL) |
| `build.gradle` | Project-level plugin declarations |
| `settings.gradle` | Module includes |
| `gradle.properties` | JVM args, AndroidX flags |
| `AndroidManifest.xml` | Permissions, activities, intent filters, splash theme |
