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

import com.animerec.app.data.Resource
import com.animerec.app.models.AnimeContent
import com.animerec.app.models.User

/**
 * Main recommendation engine interface for the app.
 * This defines the contract for all recommendation engines.
 */
interface RecommendationEngine {
    
    /**
     * Get personalized recommendations for a user.
     * @param user The user to get recommendations for
     * @param limit The maximum number of recommendations to return
     * @return A Resource containing a list of recommended content
     */
    suspend fun getRecommendations(user: User, limit: Int = 20): Resource<List<AnimeContent>>
    
    /**
     * Get recommendations for a specific content type.
     * @param user The user to get recommendations for
     * @param contentType The content type to get recommendations for (anime, manga, novels)
     * @param limit The maximum number of recommendations to return
     * @return A Resource containing a list of recommended content
     */
    suspend fun getRecommendationsForType(
        user: User,
        contentType: String,
        limit: Int = 20
    ): Resource<List<AnimeContent>>
    
    /**
     * Get similar content to a given item.
     * @param contentId The ID of the content to find similar items for
     * @param limit The maximum number of similar items to return
     * @return A Resource containing a list of similar content
     */
    suspend fun getSimilarContent(contentId: Int, limit: Int = 10): Resource<List<AnimeContent>>
    
    /**
     * Record a user's interaction with a piece of content.
     * @param contentId The ID of the content
     * @param interactionType The type of interaction (like, dislike, watched, etc.)
     * @return A Resource indicating success or failure
     */
    suspend fun recordInteraction(contentId: Int, interactionType: InteractionType): Resource<Boolean>
    
    /**
     * Types of interactions a user can have with content
     */
    enum class InteractionType {
        LIKE,         // Swiped right - add to watchlist
        DISLIKE,      // Swiped left - not interested
        SUPER_LIKE,   // Swiped up - already watched/read and liked
        VIEW_DETAILS  // Swiped down - view more details
    }
    
    /**
     * Clear the recommendation cache.
     * @return A Resource indicating success or failure
     */
    fun clearCache(): Resource<Boolean>
}