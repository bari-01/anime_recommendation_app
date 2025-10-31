package com.animerec.app.data

import com.animerec.app.models.AnimeContent

/**
 * Repository interface for anime data operations
 */
interface AnimeRepository {
    suspend fun getUserProfile(): Resource<Any>
    suspend fun getRecommendations(limit: Int): Resource<List<AnimeContent>>
    suspend fun searchAnime(query: String): Resource<List<AnimeContent>>
    suspend fun getAnimeDetails(id: Int): Resource<AnimeContent>
}
