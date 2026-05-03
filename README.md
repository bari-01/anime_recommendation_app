# AnimeMate — Anime, Manga & Light Novel Recommendation App

**Author:** Shuvam Banerji Seal 
**License:** MIT
**Website:** [shuvam-banerji-seal.github.io/AnimeMate](https://shuvam-banerji-seal.github.io/AnimeMate)
**Build:** [![Build APK](https://github.com/Shuvam-Banerji-Seal/AnimeMate/actions/workflows/pages.yml/badge.svg)](https://github.com/Shuvam-Banerji-Seal/AnimeMate/actions/workflows/pages.yml)

> A dating-style swipe interface for discovering your next favourite anime, manga or light novel — powered by MyAnimeList and a Twitter/X-inspired recommendation engine.

AnimeMate is a native Android app that helps users discover content through a fun, card-based swipe interface. It connects to the [MyAnimeList](https://myanimelist.net/) API v2 to fetch personalised recommendations, manage watchlists, track history, and view detailed statistics — all within a polished Material Design 3 interface that supports both light and dark themes.

---

## Features

### Swipe-to-Discover Interface
| Gesture | Action |
|---------|--------|
| Swipe **RIGHT** | Add to watchlist (plan to watch / plan to read) |
| Swipe **LEFT** | Mark as not interested |
| Swipe **UP** | Mark as watched / completed |
| Swipe **DOWN** | View full details — synopsis, stats, similar content |

### Twitter/X-Style Recommendation Engine
- **Engagement prediction** — user interaction history weights
- **Content-user affinity** — genre/type matching with learned weights
- **Temporal decay** — boost currently airing & recently released content
- **Diversity injection** — genre caps prevent filter bubbles (max 40 % same genre)
- **Social proof** — MAL score & popularity as proxy signals
- **Negative signals** — penalise disliked genres
- **Exploration / Exploitation split** — 80 % personalised, 20 % discovery
- **Watched-content exclusion** — anime & manga already on your MAL list are automatically filtered out

### MyAnimeList Integration
- OAuth 2 login with your existing MAL account (PKCE flow)
- Automatic import of watch history, ratings and statistics
- Two-way sync — updates appear directly on your MAL profile
- View anime statistics (watching, completed, on-hold, dropped, plan-to-watch)

### Dynamic Genre Preferences
- **74 genres** grouped into three categories — Genres, Themes, Demographics
- Fetches genres from your MAL anime list to discover additional, user-relevant genres
- Material chip-based selection UI with coloured category headers
- Airing status filters and minimum MAL score slider

### Material Design 3 Theming
- Explicit `Theme.Material3.Light` and `Theme.Material3.Dark` — no colour intermixing
- Dark mode toggle on the Profile screen with DataStore persistence
- Proper status bar & navigation bar tinting per theme
- Designer SVG vector icons throughout (14 custom drawables + 2 gradient backgrounds)

### User Profile
- Circular profile picture with gradient stats button
- Quick Actions card (Edit Profile, Edit Preferences)
- Full MAL Statistics viewer with pie/bar charts
- Dark Mode toggle, Send Error Logs, Logout

### Comprehensive Content Management
- Watchlist, History and Profile tabs with bottom navigation
- Filter by anime, manga and light novels
- Rate and update status directly from the detail screen

### Error Logging & Diagnostics
- `ErrorLogManager` captures structured events across the entire app
- Timed API call logging (`logTimed`) for performance monitoring
- One-tap "Send Error Logs" from the Profile screen
- Covers: ViewModels, Fragments, Activity, Repository, API client, Auth, Recommendation Engine

---

## Screenshots

> *Coming soon — run the app and snap your own!*

---

## Installation

### Requirements
| Requirement | Version |
|-------------|---------|
| Android | 12+ (API 31) |
| Java (build) | 17+ |
| MyAnimeList account | Free |
| Internet | Required |

### Install Pre-built APK
1. Download the latest APK from the **Releases** section
2. Enable *Install from Unknown Sources* if needed
3. Open the APK to install
4. Launch and log in with your MyAnimeList credentials

### Build from Source (Linux)

```bash
cd anime_recom_date/AnimeRecApp
chmod +x build_apk.sh
./build_apk.sh
```

Or manually:

```bash
cd anime_recom_date/AnimeRecApp
./gradlew clean assembleDebug
```

The debug APK will be at `app/build/outputs/apk/debug/app-debug.apk`.

See also:
- [QUICKSTART.md](anime_recom_date/AnimeRecApp/QUICKSTART.md) — Quick build guide
- [BUILD_GUIDE.md](anime_recom_date/AnimeRecApp/BUILD_GUIDE.md) — Comprehensive build docs
- [ANDROID12_SETUP.md](anime_recom_date/AnimeRecApp/ANDROID12_SETUP.md) — Android 12 configuration
- [COMPILATION_SETUP_SUMMARY.md](COMPILATION_SETUP_SUMMARY.md) — Recent build changes

---

## Usage Guide

### First Launch
1. **Log in** with your MyAnimeList account (OAuth 2 PKCE)
2. **Complete profile setup** — select content types (anime, manga, novels)
3. **Choose genres** — 74 genres sorted by category, plus auto-discovered genres from your MAL list
4. **Start swiping** — personalised recommendations appear immediately

### Tabs
| Tab | Purpose |
|-----|---------|
| **Home** | Swipe through recommendations |
| **Watchlist** | View & manage plan-to-watch / plan-to-read items |
| **History** | Browse completed, on-hold, dropped items |
| **Profile** | Stats, preferences, dark mode, log out |

### Detail Screen
Swipe **DOWN** on a card or tap a list item to see:
- Full synopsis, alternative titles, airing status
- MAL score, popularity ranking, episode/chapter count
- Genre chips and content type badge
- Similar content carousel (fetched via the recommendation engine)

---

## Architecture

```
com.animerec.app
├── api/                 # Retrofit service, OkHttp client, retry interceptor
├── auth/                # OAuth 2 token management (AuthManager + SecureStorage)
├── data/                # Repository interface & implementation, API cache
├── models/              # Data classes (User, AnimeContent, AnimeStatistics, etc.)
├── recommendation/      # Twitter/X-style engine, UserPreferenceModel
├── ui/
│   ├── details/         # DetailsFragment + DetailsViewModel
│   ├── history/         # HistoryFragment + HistoryViewModel
│   ├── home/            # HomeFragment (CardStackView) + RecommendationViewModel
│   ├── profile/         # ProfileFragment, MalStatsFragment, PreferencesFragment
│   └── watchlist/       # WatchlistFragment + WatchlistViewModel
├── util/                # ErrorLogManager, connectivity helpers
├── utils/               # SecureStorage (EncryptedSharedPreferences)
├── AnimeRecApp.kt       # Application class (constants, fields, URLs)
└── MainActivity.kt      # Single Activity host with bottom navigation
```

### Key Patterns
- **MVVM** — `AndroidViewModel` + `LiveData` + coroutines
- **Repository** — `AnimeRepository` interface with `AnimeRepositoryImpl`
- **Navigation** — Jetpack Navigation Component with SafeArgs
- **Theming** — Explicit Light/Dark `Theme.Material3` parents (no `DayNight` mixing)
- **Memory safety** — Nullable view references with `onDestroyView()` cleanup in all fragments
- **Error resilience** — `ErrorLogManager` structured logging + `RetryInterceptor` with exponential back-off

### Build Configuration
| Setting | Value |
|---------|-------|
| Compile SDK | 35 |
| Min SDK | 31 (Android 12) |
| Target SDK | 35 (Android 15) |
| JVM Target | 17 |
| Kotlin | 1.9.20 |
| Gradle | 8.2 |
| AGP | 8.2.0 |

### Dependencies
| Library | Purpose |
|---------|---------|
| Retrofit 2 + Gson | MAL API communication |
| OkHttp + Logging Interceptor | HTTP client with retry & auth |
| Glide | Image loading & caching |
| CardStackView 2.3.4 | Swipe card interface |
| Room | Local database |
| DataStore | User preferences persistence |
| WorkManager | Background tasks |
| LeakCanary (debug) | Memory leak detection |
| Material Components | Material Design 3 UI |

---

## MAL API Integration

The app uses **MyAnimeList API v2** with OAuth 2 PKCE authentication.

### Endpoints Used
- `GET /v2/users/@me` — User profile & statistics
- `GET /v2/anime/ranking` — Ranked anime lists (all, airing, popular, favourite, upcoming)
- `GET /v2/manga/ranking` — Ranked manga lists
- `GET /v2/anime/suggestions` — MAL personalised suggestions
- `GET /v2/anime/{id}` — Anime details
- `GET /v2/manga/{id}` — Manga details
- `GET /v2/users/@me/animelist` — User's anime list (with status filters)
- `GET /v2/users/@me/mangalist` — User's manga list
- `PATCH /v2/anime/{id}/my_list_status` — Update anime status / rating
- `PATCH /v2/manga/{id}/my_list_status` — Update manga status / rating
- `GET /v2/anime/season/{year}/{season}` — Seasonal anime
- `GET /v2/anime?q=` — Search anime
- `GET /v2/manga?q=` — Search manga

### Auth Flow
1. App generates PKCE code verifier + challenge
2. Opens MAL authorisation URL in browser
3. User grants access → redirect to `animerec://auth`
4. App exchanges auth code for access + refresh tokens
5. Tokens stored in `EncryptedSharedPreferences`
6. `AuthManager` handles automatic token refresh with mutex locking

---

## Running Tests

```bash
# Unit tests
cd anime_recom_date/AnimeRecApp
./gradlew test

# Instrumented tests (requires device or emulator)
./gradlew connectedAndroidTest
```

---

## Privacy & Permissions

| Permission | Reason |
|------------|--------|
| `INTERNET` | Connect to MAL API |
| `ACCESS_NETWORK_STATE` | Detect network connectivity |

The app does **not** collect, store or transmit any personal data beyond what is required for MAL API integration. Error logs are stored locally and only sent when the user explicitly taps "Send Error Logs".

---

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [MyAnimeList](https://myanimelist.net/) for providing the API
- [CardStackView](https://github.com/yuyakaido/CardStackView) by yuyakaido
- Twitter/X "the-algorithm" open-source ranking concepts
- All the open-source libraries that made this project possible