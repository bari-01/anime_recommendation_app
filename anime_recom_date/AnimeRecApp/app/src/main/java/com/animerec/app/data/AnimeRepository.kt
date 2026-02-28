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
package com.animerec.app.data

import com.animerec.app.models.AnimeContent
import com.animerec.app.models.User

/**
 * Repository interface for anime data operations
 */
interface AnimeRepository {
    // User operations
    suspend fun getUserProfile(): Resource<User>
    suspend fun isProfileComplete(): Boolean
    
    // Content retrieval
    suspend fun getRecommendations(limit: Int): Resource<List<AnimeContent>>
    suspend fun searchAnime(query: String): Resource<List<AnimeContent>>
    suspend fun searchManga(query: String): Resource<List<AnimeContent>>
    suspend fun getAnimeDetails(id: Int): Resource<AnimeContent>
    suspend fun getMangaDetails(id: Int): Resource<AnimeContent>
    
    // Recommendation-specific methods
    suspend fun getAnimeRecommendations(genres: List<String>, limit: Int, rankingType: String = "all"): Resource<List<AnimeContent>>
    suspend fun getMangaRecommendations(genres: List<String>, limit: Int, rankingType: String = "all"): Resource<List<AnimeContent>>
    suspend fun getNovelRecommendations(genres: List<String>, limit: Int, rankingType: String = "novels"): Resource<List<AnimeContent>>
    suspend fun getAnimeRankings(rankingType: String, limit: Int): Resource<List<AnimeContent>>
    suspend fun getSeasonalAnime(year: Int, season: String, limit: Int): Resource<List<AnimeContent>>
    
    // User list operations
    suspend fun getUserAnimeList(status: String? = null): Resource<List<AnimeContent>>
    suspend fun getUserMangaList(status: String? = null): Resource<List<AnimeContent>>
    suspend fun updateAnimeStatus(animeId: Int, status: String): Resource<Boolean>
    suspend fun updateMangaStatus(mangaId: Int, status: String): Resource<Boolean>
    
    // Convenience methods for ViewModels
    suspend fun getAnimeWatchlist(): Resource<List<AnimeContent>>
    suspend fun getMangaWatchlist(): Resource<List<AnimeContent>>
    suspend fun getNovelWatchlist(): Resource<List<AnimeContent>>
    suspend fun getAnimeList(status: String): Resource<List<AnimeContent>>
    suspend fun getMangaList(status: String): Resource<List<AnimeContent>>
    suspend fun getNovelList(status: String): Resource<List<AnimeContent>>
    suspend fun rateAnime(animeId: Int, score: Int): Resource<Boolean>
    suspend fun rateManga(mangaId: Int, score: Int): Resource<Boolean>
    
    // Not interested tracking
    suspend fun markAsNotInterested(contentId: Int): Resource<Boolean>
    suspend fun getNotInterestedIds(): Resource<List<Int>>
    
    // Cache management
    fun clearCache()
}
