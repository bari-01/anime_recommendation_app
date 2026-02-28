# Recommendation Engine

AnimeMate uses a **Twitter/X-inspired ranking algorithm** adapted for anime/manga discovery. The implementation lives in `BasicRecommendationEngine.kt`.

---

## Overview

The engine follows a multi-stage pipeline:

```
Candidate Pool → Deduplication → Exclusion → Scoring → Exploitation/Exploration → Diversity → Output
```

### Stage 1: Candidate Pool

Candidates are fetched from multiple MAL ranking endpoints to ensure diversity:

**Anime rankings:**
- `all` — overall top anime
- `airing` — currently airing
- `bypopularity` — most popular
- `favorite` — most favourited
- `upcoming` — upcoming releases

**Manga rankings:**
- `all`, `bypopularity`, `favorite`

Additionally, for anime, the MAL `suggestions` endpoint is called as a supplementary source.

The engine fetches **3× the requested limit** to provide enough headroom after filtering.

### Stage 2: Deduplication & Exclusion

Three exclusion sets are built:
1. **Not-interested IDs** — content the user swiped left on (stored locally)
2. **User's anime list** — all anime on the user's MAL list (any status)
3. **User's manga list** — all manga on the user's MAL list (any status)

Combined into a single `exclusionSet`, candidates are filtered by `content.id !in exclusionSet`.

### Stage 3: Twitter-Style Scoring

Each candidate receives a composite score based on seven signals:

| Signal | Weight | Description |
|--------|--------|-------------|
| Genre affinity | +3.0 per match | Content genre matches user's explicit preferences |
| Genre negative | -2.5 per match | Content genre matches user's disliked genres |
| Content type match | +2.0 | Content type (anime/manga/novel) matches user preference |
| Learned genre weight | +1.0 | Genre appears in UserPreferenceModel's top-10 learned genres |
| MAL score | 0–1.5 | Community score normalised from 0-10 scale |
| Popularity | 0.8 × log | Log-scaled popularity to avoid domination by mega-popular titles |
| Airing boost | +4.0 | Currently airing content gets a significant boost |
| Recent boost | +2.0 | Released within the past 2 years |
| Random jitter | 0–1.5 | Small random value to prevent identical rankings |

### Stage 4: Exploitation / Exploration Split

```
80% Exploitation — top-ranked candidates by score
20% Exploration  — random sample from remaining pool
```

This ensures the user sees mostly relevant content while still being exposed to potentially surprising discoveries.

### Stage 5: Diversity Injection

Adapted from Twitter's diversity mixer:
- Maximum **40%** of results can share the same dominant genre
- First pass: add items respecting genre caps
- Second pass: fill remaining slots with any un-added items
- Final: shuffle within 4-item windows to add natural variation while preserving approximate rank order

---

## UserPreferenceModel

A persistent model that **learns** from user interactions over time.

### Interaction Weights

| Interaction | Positive? | Weight |
|-------------|-----------|--------|
| Like (swipe right) | ✅ | 1.0 |
| Super Like (swipe up) | ✅ | 2.0 |
| View Details (swipe down) | ✅ | 0.5 |
| Dislike (swipe left) | ❌ | -0.5 |

Weights are applied to each genre of the interacted content and clamped to `[-10.0, 10.0]`.

### Storage
- Genre weights: `SharedPreferences("genre_weights")`
- Content type weights: `SharedPreferences("content_type_weights")`
- Studio weights: `SharedPreferences("studio_weights")`

### Methods
- `getTopGenres(limit)` — genres with weight > 0, sorted descending
- `getDislikedGenres()` — genres with weight < -2
- `rankContentForUser(content, user)` — sort content by preference score
- `clearPreferences()` — reset all learned weights

---

## Caching

The recommendation engine maintains an **in-memory cache** with a 10-minute TTL.

```kotlin
val cacheKey = "recs_${user.name}_${limit}_$timeSlot"
// timeSlot = currentTimeMillis / CACHE_EXPIRATION
```

The time-slot-based key ensures results naturally change between sessions without requiring explicit cache invalidation.

When a user **dislikes** content, the entire recommendation cache is cleared immediately so that the deprioritised genre takes effect on the next load.

---

## Performance Logging

The engine logs timing data via `ErrorLogManager`:

```
[BasicRecommendationEngine] [RECS] Starting recommendation generation for user=X, limit=Y
[BasicRecommendationEngine] [RECS] Recommendation generation completed in 850ms — 20 items (candidates=120, unique=95)
```

API calls within `AnimeRepositoryImpl` use `ErrorLogManager.logTimed()` to track individual endpoint latencies.

---

## Configuration Constants

```kotlin
companion object {
    const val W_GENRE_AFFINITY = 3.0
    const val W_GENRE_NEGATIVE = -2.5
    const val W_CONTENT_TYPE_MATCH = 2.0
    const val W_LEARNED_GENRE = 1.0
    const val W_MAL_SCORE = 1.5
    const val W_POPULARITY = 0.8
    const val W_AIRING_BOOST = 4.0
    const val W_RECENT_BOOST = 2.0
    const val EXPLOITATION_RATIO = 0.80
    const val MAX_SAME_GENRE_RATIO = 0.4
}
```

All values are defined as `private const val` in the companion object of `BasicRecommendationEngine` for easy tuning.
