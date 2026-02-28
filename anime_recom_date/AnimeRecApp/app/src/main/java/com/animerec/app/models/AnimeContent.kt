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
package com.animerec.app.models

data class AnimeContent(
    val id: Int,
    val title: String,
    val alternativeTitles: Map<String, String> = mapOf(),
    val synopsis: String = "",
    val imageUrl: String = "",
    val type: ContentType = ContentType.ANIME,
    val status: String = "",
    val genres: List<String> = listOf(),
    val rating: Double = 0.0,
    val releaseYear: Int? = null,
    val episodes: Int? = null,
    val chapters: Int? = null,
    val volumes: Int? = null,
    val trailerUrl: String? = null,
    val malScore: Double = 0.0,
    val userScore: Int? = null,
    val airingStatus: String = "",
    val isFavorite: Boolean = false,
    val inWatchlist: Boolean = false,
    val isCompleted: Boolean = false,
    // Additional properties for compatibility
    val mediaType: String = "",
    val startDate: String? = null,
    val endDate: String? = null,
    val numEpisodes: Int? = episodes
)

enum class ContentType {
    ANIME,
    MANGA,
    NOVEL
}