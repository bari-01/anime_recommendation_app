# Architecture Overview

AnimeMate follows the **MVVM** (Model-View-ViewModel) architecture pattern with a Repository layer, built on Jetpack components and Kotlin coroutines.

---

## High-Level Diagram

```
┌─────────────────────────────────────────────────────┐
│                    UI Layer                          │
│  MainActivity ─── Fragments (Home, Watchlist,       │
│                    History, Profile, Details,        │
│                    MalStats, Preferences)            │
│            ↕ LiveData / observe                      │
│  ViewModels (Recommendation, Watchlist, History,    │
│              Profile, Details)                       │
└─────────────────────┬───────────────────────────────┘
                      │ suspend calls
┌─────────────────────▼───────────────────────────────┐
│              Domain / Business Layer                 │
│  RecommendationEngine (Twitter/X-style)             │
│  UserPreferenceModel (learned genre weights)        │
│  AnimeRepository (interface)                        │
└─────────────────────┬───────────────────────────────┘
                      │
┌─────────────────────▼───────────────────────────────┐
│                Data Layer                            │
│  AnimeRepositoryImpl                                │
│    ├── MyAnimeListClient (Retrofit + OkHttp)        │
│    │     ├── AuthInterceptor (Bearer token)         │
│    │     └── RetryInterceptor (exp. back-off)       │
│    ├── ApiResponseCache (in-memory TTL cache)       │
│    └── SharedPreferences (local state)              │
│                                                     │
│  AuthManager + SecureStorage (tokens)               │
│  ErrorLogManager (structured diagnostics)           │
│  DataStore (user theme preference)                  │
└─────────────────────────────────────────────────────┘
```

---

## Package Structure

| Package | Responsibility |
|---------|---------------|
| `com.animerec.app` | Application class, MainActivity, constants |
| `com.animerec.app.api` | Retrofit service interface, OkHttp client, RetryInterceptor |
| `com.animerec.app.auth` | AuthManager (OAuth 2 PKCE), token lifecycle |
| `com.animerec.app.data` | Repository interface + implementation, API cache, Resource sealed class |
| `com.animerec.app.models` | Data classes: User, AnimeContent, AnimeStatistics, ContentType, Genre |
| `com.animerec.app.recommendation` | Twitter/X-style engine, UserPreferenceModel, RecommendationMetrics |
| `com.animerec.app.ui.*` | Fragments + ViewModels per feature |
| `com.animerec.app.util` | ErrorLogManager |
| `com.animerec.app.utils` | SecureStorage (EncryptedSharedPreferences) |

---

## Navigation

AnimeMate uses **Jetpack Navigation Component** with a single Activity host.

```
SplashFragment ──→ AuthFragment (if not logged in)
      │                    │
      │                    ▼
      │            MAL OAuth 2 browser flow
      │                    │
      │                    ▼
      └──→ HomeFragment ←──┘
              │
    BottomNavigationView
              │
    ┌─────────┼─────────┬───────────┐
    │         │         │           │
  Home    Watchlist  History    Profile
    │                               │
    ▼                         ┌─────┼──────┐
 Details ◄────────────────   MalStats  Preferences
```

### Bottom Navigation Setup

The bottom nav is configured manually (not via `setupWithNavController`) to handle the splash → home transition cleanly. The Home tab uses `setRestoreState(false)` to prevent a back-stack restoration bug when switching back from Profile.

---

## Key Design Decisions

### 1. Explicit Light / Dark Themes
Instead of using `Theme.Material3.DayNight` (which caused colour intermixing), the app defines:
- `values/themes.xml` → `Theme.Material3.Light`
- `values-night/themes.xml` → `Theme.Material3.Dark`

This ensures 100 % separation of light and dark colour palettes.

### 2. Nullable View References
All fragments use `var binding: View? = null` (not `lateinit var`) and null everything in `onDestroyView()`. This prevents memory leaks from view references surviving fragment re-creation.

### 3. Twitter/X-Style Recommendation Engine
See [recommendation-engine.md](recommendation-engine.md) for full details. The engine balances personalisation with discovery using a 80/20 exploitation/exploration split.

### 4. ErrorLogManager
A singleton that writes structured `[TAG] [LEVEL] message` entries to a file. Covers the entire call stack: Activity → Fragments → ViewModels → Repository → API Client → Auth. Supports `logTimed()` for performance profiling.

### 5. Repository Pattern with Caching
`AnimeRepositoryImpl` wraps all API calls and provides:
- In-memory TTL cache (`ApiResponseCache`)
- SharedPreferences for user preferences and not-interested IDs
- `Resource<T>` sealed class for Success/Error/Loading states

---

## Concurrency Model

- All ViewModels use `viewModelScope.launch` for coroutine management
- Repository methods are `suspend` functions running on `Dispatchers.IO`
- `AuthManager.refreshToken()` uses a `Mutex` to prevent concurrent token refreshes
- `RetryInterceptor` uses `Thread.sleep()` (OkHttp interceptor runs on OkHttp dispatcher threads)

---

## Data Flow Example: Loading Recommendations

```
HomeFragment.onViewCreated()
  → viewModel.loadRecommendations()
    → viewModelScope.launch
      → recommendationEngine.getRecommendations(user, limit)
        → repository.getAnimeRecommendations(genres, limit, rankingType) × N
        → repository.getUserAnimeList(null)  // for exclusion
        → repository.getUserMangaList(null)  // for exclusion
        → calculateTwitterScore() for each candidate
        → exploitation/exploration split
        → applyDiversityInjection()
      ← Resource.Success(recommendations)
    → _recommendations.value = result
  ← observe → adapter.submitList(list)
```
