# AnimeMate Documentation

Welcome to the AnimeMate technical documentation. These docs cover the architecture, API integration, recommendation algorithm, and project structure.

## Contents

| Document | Description |
|----------|-------------|
| [Architecture](architecture.md) | MVVM pattern, package structure, navigation graph, key design decisions |
| [API Integration](api-integration.md) | MyAnimeList API v2 endpoints, OAuth 2 PKCE flow, data models, error handling |
| [Recommendation Engine](recommendation-engine.md) | Twitter/X-style scoring algorithm, diversity injection, user preference learning |
| [File Structure](file-structure.md) | Complete source tree with file descriptions |

## Quick Links

- **Main README:** [../README.md](../README.md)
- **Quick Build Guide:** [../anime_recom_date/AnimeRecApp/QUICKSTART.md](../anime_recom_date/AnimeRecApp/QUICKSTART.md)
- **Full Build Guide:** [../anime_recom_date/AnimeRecApp/BUILD_GUIDE.md](../anime_recom_date/AnimeRecApp/BUILD_GUIDE.md)

## Key Source Files

| File | What it does |
|------|-------------|
| `AnimeRecApp.kt` | Application constants — client ID, API base URL, field strings |
| `MainActivity.kt` | Single Activity host, bottom nav setup, WindowInsets handling |
| `BasicRecommendationEngine.kt` | Core ranking algorithm (500 lines) |
| `AnimeRepositoryImpl.kt` | All MAL API calls with caching (540 lines) |
| `AuthManager.kt` | OAuth 2 token lifecycle (214 lines) |
| `ErrorLogManager.kt` | Structured diagnostic logging |
| `PreferencesFragment.kt` | 74-genre selection UI with async MAL list enrichment |
