# MyAnimeList API Integration

AnimeMate integrates with the **MyAnimeList API v2** for all content data, user profiles, list management, and authentication.

- **Base URL:** `https://api.myanimelist.net`
- **Auth URL:** `https://myanimelist.net/v1/oauth2/authorize`
- **Token URL:** `https://myanimelist.net/v1/oauth2/token`
- **Client ID:** Configured in `AnimeRecApp.kt`
- **Redirect URI:** `animerec://auth`

---

## Authentication (OAuth 2 PKCE)

MAL uses the **Authorization Code with PKCE** flow (no client secret required for mobile apps).

### Flow

```
1. App generates codeVerifier (random 128-char string)
2. App computes codeChallenge = codeVerifier (plain method)
3. Opens browser:
   https://myanimelist.net/v1/oauth2/authorize
     ?response_type=code
     &client_id={CLIENT_ID}
     &code_challenge={codeChallenge}
     &redirect_uri=animerec://auth
4. User logs in and grants access
5. MAL redirects → animerec://auth?code={authCode}
6. App intercepts URI in MainActivity
7. AuthManager.exchangeCodeForTokens(authCode, codeVerifier)
     POST https://myanimelist.net/v1/oauth2/token
     Body: client_id, grant_type=authorization_code, code, code_verifier, redirect_uri
8. Response: { access_token, refresh_token, expires_in }
9. Tokens stored in EncryptedSharedPreferences via SecureStorage
```

### Token Refresh

`AuthManager.getAccessToken()` automatically refreshes when the token is within 5 minutes of expiry:

```kotlin
if (forceRefresh || currentTime >= expiryTime - 5 * 60 * 1000) {
    refreshLock.withLock { ... }
}
```

A `Mutex` prevents concurrent refresh attempts. If refresh fails, the user is logged out.

### Secure Storage

Tokens are stored using `EncryptedSharedPreferences` (AndroidX Security):
- `SecureStorage.ACCESS_TOKEN_KEY`
- `SecureStorage.REFRESH_TOKEN_KEY`
- `SecureStorage.TOKEN_EXPIRY_KEY`

---

## API Endpoints

### User Profile

```
GET /v2/users/@me?fields=id,name,gender,location,picture,anime_statistics
Authorization: Bearer {accessToken}
```

Returns: User profile with anime statistics (watching, completed, on-hold, dropped, plan-to-watch, total items, days watched, mean score, episodes).

### Anime Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/v2/anime/ranking?ranking_type={type}&limit={n}&fields={f}` | Ranked anime lists |
| GET | `/v2/anime/suggestions?limit={n}&fields={f}` | Personalised suggestions |
| GET | `/v2/anime/{id}?fields={f}` | Anime details |
| GET | `/v2/anime?q={query}&fields={f}` | Search anime |
| GET | `/v2/anime/season/{year}/{season}?limit={n}&fields={f}` | Seasonal anime |
| GET | `/v2/users/@me/animelist?status={s}&fields={f}` | User's anime list |
| PATCH | `/v2/anime/{id}/my_list_status` | Update status/score |

**Ranking types:** `all`, `airing`, `bypopularity`, `favorite`, `upcoming`

### Manga Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/v2/manga/ranking?ranking_type={type}&limit={n}&fields={f}` | Ranked manga lists |
| GET | `/v2/manga/{id}?fields={f}` | Manga details |
| GET | `/v2/manga?q={query}&fields={f}` | Search manga |
| GET | `/v2/users/@me/mangalist?status={s}&fields={f}` | User's manga list |
| PATCH | `/v2/manga/{id}/my_list_status` | Update status/score |

**Ranking types:** `all`, `bypopularity`, `favorite`

### Field Constants

Defined in `AnimeRecApp.kt`:

```kotlin
const val ANIME_FIELDS = "id,title,main_picture,alternative_titles,start_date,end_date," +
    "synopsis,mean,rank,popularity,num_list_users,num_scoring_users,nsfw," +
    "genres,media_type,status,num_episodes,start_season,broadcast,source," +
    "average_episode_duration,rating,studios"

const val MANGA_FIELDS = "id,title,main_picture,alternative_titles,start_date,end_date," +
    "synopsis,mean,rank,popularity,num_list_users,num_scoring_users,nsfw," +
    "genres,media_type,status,num_volumes,num_chapters,authors{first_name,last_name}"
```

---

## Retrofit Service Interface

Defined in `MyAnimeListService.kt` as a Retrofit interface. All methods return `Response<T>` for explicit error handling.

---

## OkHttp Configuration

### Auth Interceptor (inline in MyAnimeListClient)
- Adds `Authorization: Bearer {token}` header
- Adds `X-MAL-CLIENT-ID` header
- Token is fetched synchronously via `runBlocking { authManager.getAccessToken() }`

### RetryInterceptor
- Handles HTTP 429 (rate limiting) with `Retry-After` header parsing
- Exponential backoff: 1s → 2s → 4s (max 20 s) with 10-30 % jitter
- Max 3 retries
- Logs retries and failures via `ErrorLogManager`

### Logging
- `HttpLoggingInterceptor` at `BASIC` level (network interceptor)

---

## Rate Limiting

MAL API has undocumented rate limits. The app handles this via:
1. **RetryInterceptor** — automatic retry on 429 responses
2. **Caching** — in-memory cache in `ApiResponseCache` and `BasicRecommendationEngine`
3. **Batch fetching** — fetches multiple ranking types per recommendation request rather than individual item lookups

---

## Data Models

### API Response Models (in `ApiResponses.kt`)

```kotlin
data class AnimeListResponse(val data: List<AnimeListItem>, val paging: Paging?)
data class AnimeListItem(val node: AnimeNode)
data class AnimeNode(val id: Int, val title: String, ...)
data class Genre(val id: Int, val name: String)
```

### Domain Models (in `Models.kt` / `AnimeContent.kt`)

```kotlin
data class AnimeContent(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val synopsis: String,
    val genres: List<String>,
    val type: ContentType,
    val malScore: Double,
    val rating: Int,
    val airingStatus: String,
    ...
)

enum class ContentType { ANIME, MANGA, NOVEL }
```

Response models include `.toAnimeContent()` extension functions to map API responses to domain models.

---

## Error Handling

All repository methods return `Resource<T>`:

```kotlin
sealed class Resource<T> {
    class Success<T>(val data: T) : Resource<T>()
    class Error<T>(val message: String) : Resource<T>()
    class Loading<T> : Resource<T>()
}
```

Every `catch` block logs via both `Log.e()` and `ErrorLogManager.logEvent()`, and returns `Resource.Error` with a user-friendly message.

---

## Genre Handling

MAL does not expose a standalone genres endpoint. Genres are:
1. Embedded in anime/manga detail responses as `List<Genre>` (id + name)
2. The app maintains a static catalogue of 74 genres (19 Genres + 50 Themes + 5 Demographics) in `PreferencesFragment.kt`
3. At runtime, the app also fetches the user's anime list and extracts unique genre names to discover genres not in the static catalogue
