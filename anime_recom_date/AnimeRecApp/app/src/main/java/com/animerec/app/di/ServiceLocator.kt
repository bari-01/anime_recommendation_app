package com.animerec.app.di

import android.content.Context
import com.animerec.app.api.MyAnimeListClient
import com.animerec.app.auth.AuthManager
import com.animerec.app.data.AnimeRepository
import com.animerec.app.data.AnimeRepositoryImpl
import com.animerec.app.recommendation.RecommendationEngine

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
            recommendationEngine ?: RecommendationEngine(
                provideAnimeRepository(context)
            ).also { recommendationEngine = it }
        }
    }
    
    private fun provideApiClient(context: Context): MyAnimeListClient {
        return apiClient ?: synchronized(this) {
            apiClient ?: MyAnimeListClient(
                context.applicationContext,
                provideAuthManager(context)
            ).also { apiClient = it }
        }
    }
}
