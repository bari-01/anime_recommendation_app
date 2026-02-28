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
package com.animerec.app.di

import android.content.Context
import com.animerec.app.api.MyAnimeListClient
import com.animerec.app.auth.AuthManager
import com.animerec.app.data.AnimeRepository
import com.animerec.app.data.AnimeRepositoryImpl
import com.animerec.app.recommendation.BasicRecommendationEngine
import com.animerec.app.recommendation.RecommendationEngine
import com.animerec.app.recommendation.UserPreferenceModel

/**
 * Service locator for dependency injection
 */
object ServiceLocator {
    
    @Volatile
    private var animeRepository: AnimeRepository? = null
    
    @Volatile
    private var authManager: AuthManager? = null
    
    @Volatile
    private var recommendationEngine: RecommendationEngine? = null
    
    @Volatile
    private var apiClient: MyAnimeListClient? = null
    
    @Volatile
    private var userPreferenceModel: UserPreferenceModel? = null
    
    fun provideAnimeRepository(context: Context): AnimeRepository {
        return animeRepository ?: synchronized(this) {
            animeRepository ?: AnimeRepositoryImpl(
                context.applicationContext,
                provideApiClient(context)
            ).also { animeRepository = it }
        }
    }
    
    fun provideAuthManager(context: Context): AuthManager {
        return authManager ?: synchronized(this) {
            authManager ?: AuthManager(context.applicationContext).also { authManager = it }
        }
    }
    
    fun provideRecommendationEngine(context: Context): RecommendationEngine {
        return recommendationEngine ?: synchronized(this) {
            recommendationEngine ?: BasicRecommendationEngine(
                provideAnimeRepository(context),
                provideUserPreferenceModel(context)
            ).also { recommendationEngine = it }
        }
    }
    
    fun provideUserPreferenceModel(context: Context): UserPreferenceModel {
        return userPreferenceModel ?: synchronized(this) {
            userPreferenceModel ?: UserPreferenceModel(
                context.applicationContext
            ).also { userPreferenceModel = it }
        }
    }
    
    fun provideApiClient(context: Context): MyAnimeListClient {
        return apiClient ?: synchronized(this) {
            apiClient ?: MyAnimeListClient(
                context.applicationContext
            ).also { apiClient = it }
        }
    }
    
    /**
     * Clear all cached instances (useful for testing or logout)
     */
    fun resetAll() {
        animeRepository = null
        authManager = null
        recommendationEngine = null
        apiClient = null
        userPreferenceModel = null
    }
}
