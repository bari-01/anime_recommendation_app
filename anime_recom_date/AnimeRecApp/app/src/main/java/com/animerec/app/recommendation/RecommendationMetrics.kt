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

import android.util.Log

/**
 * Tracks metrics for recommendation quality and user engagement.
 */
class RecommendationMetrics {
    
    private val TAG = "RecommendationMetrics"
    
    // Interaction counts
    private var totalInteractions = 0
    private var likes = 0
    private var dislikes = 0
    private var superLikes = 0
    private var viewDetails = 0
    
    // Source tracking
    private val sourceInteractions = mutableMapOf<String, Int>()
    
    // Genre engagement
    private val genreEngagement = mutableMapOf<String, Int>()
    
    /**
     * Record a user interaction.
     */
    fun recordInteraction(
        interactionType: RecommendationEngine.InteractionType,
        source: RecommendationSource,
        genres: List<String>
    ) {
        totalInteractions++
        
        when (interactionType) {
            RecommendationEngine.InteractionType.LIKE -> likes++
            RecommendationEngine.InteractionType.DISLIKE -> dislikes++
            RecommendationEngine.InteractionType.SUPER_LIKE -> superLikes++
            RecommendationEngine.InteractionType.VIEW_DETAILS -> viewDetails++
        }
        
        // Track by source
        val sourceName = source.name
        val sourceCount = sourceInteractions.getOrDefault(sourceName, 0)
        sourceInteractions[sourceName] = sourceCount + 1
        
        // Track genre engagement for positive interactions
        if (interactionType != RecommendationEngine.InteractionType.DISLIKE) {
            for (genre in genres) {
                val genreCount = genreEngagement.getOrDefault(genre, 0)
                genreEngagement[genre] = genreCount + 1
            }
        }
    }
    
    /**
     * Get the engagement rate (positive interactions / total).
     */
    fun getEngagementRate(): Double {
        if (totalInteractions == 0) return 0.0
        val positiveInteractions = likes + superLikes + viewDetails
        return positiveInteractions.toDouble() / totalInteractions
    }
    
    /**
     * Get the like rate (likes + super likes / total).
     */
    fun getLikeRate(): Double {
        if (totalInteractions == 0) return 0.0
        return (likes + superLikes).toDouble() / totalInteractions
    }
    
    /**
     * Get the dislike rate.
     */
    fun getDislikeRate(): Double {
        if (totalInteractions == 0) return 0.0
        return dislikes.toDouble() / totalInteractions
    }
    
    /**
     * Get the super like rate.
     */
    fun getSuperLikeRate(): Double {
        if (totalInteractions == 0) return 0.0
        return superLikes.toDouble() / totalInteractions
    }
    
    /**
     * Get engagement by source.
     */
    fun getSourceEngagement(): Map<String, Int> {
        return sourceInteractions.toMap()
    }
    
    /**
     * Get top engaged genres.
     */
    fun getTopEngagedGenres(limit: Int = 5): List<Pair<String, Int>> {
        return genreEngagement.entries
            .sortedByDescending { it.value }
            .take(limit)
            .map { it.key to it.value }
    }
    
    /**
     * Log a metrics report.
     */
    fun logMetricsReport() {
        Log.d(TAG, """
            === Recommendation Metrics Report ===
            Total Interactions: $totalInteractions
            Likes: $likes (${String.format("%.1f", getLikeRate() * 100)}%)
            Dislikes: $dislikes (${String.format("%.1f", getDislikeRate() * 100)}%)
            Super Likes: $superLikes (${String.format("%.1f", getSuperLikeRate() * 100)}%)
            View Details: $viewDetails
            Engagement Rate: ${String.format("%.1f", getEngagementRate() * 100)}%
            Top Genres: ${getTopEngagedGenres().joinToString { "${it.first}(${it.second})" }}
            =====================================
        """.trimIndent())
    }
    
    /**
     * Reset all metrics.
     */
    fun reset() {
        totalInteractions = 0
        likes = 0
        dislikes = 0
        superLikes = 0
        viewDetails = 0
        sourceInteractions.clear()
        genreEngagement.clear()
    }
}
