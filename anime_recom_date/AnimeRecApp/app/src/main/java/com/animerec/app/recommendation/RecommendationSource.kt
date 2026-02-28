/*
 * AnimeRec - Anime Recommendation App
 * Copyright (C) 2025 Shuvam Banerji Seal
 *
 * Developed by: Shuvam Banerji Seal
 * GitHub: https://github.com/technicallittlemaster
 *
 * This file is part of AnimeRec.
 * Licensed under the MIT License.
 */
package com.animerec.app.recommendation

/**
 * Sources for recommendations to track effectiveness of different algorithms.
 */
enum class RecommendationSource {
    CONTENT_BASED,     // Based on content similarity
    COLLABORATIVE,     // Based on user similarity
    THEME_BASED,       // Based on themes and tropes
    POPULARITY,        // Based on overall popularity
    SEASONAL,          // Currently airing/publishing
    USER_HISTORY,      // Based on user's watch history
    MAL_SUGGESTIONS    // Directly from MAL API suggestions
}