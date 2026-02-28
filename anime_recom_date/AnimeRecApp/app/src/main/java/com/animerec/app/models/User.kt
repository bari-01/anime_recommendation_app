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

/**
 * User model representing the current logged-in user.
 */
data class User(
    val id: Int = 0,
    val name: String = "",
    val picture: String = "",
    val profilePictureUrl: String? = null,
    val age: Int? = null,
    val gender: String = "",
    val location: String = "",
    val joinedAt: String = "",
    val animeStatistics: AnimeStatistics = AnimeStatistics(),
    val contentPreferences: List<String> = listOf("anime"), // anime, manga, novels
    val genrePreferences: List<String> = listOf(),
    val favoriteIds: List<Int> = listOf(),
    val isProfileComplete: Boolean = false
)

/**
 * Anime statistics for a user from MAL.
 */
data class AnimeStatistics(
    val numItemsWatching: Int = 0,
    val numItemsCompleted: Int = 0,
    val numItemsOnHold: Int = 0,
    val numItemsDropped: Int = 0,
    val numItemsPlanToWatch: Int = 0,
    val numItems: Int = 0,
    val numDaysWatched: Double = 0.0,
    val numDaysWatching: Double = 0.0,
    val numDaysCompleted: Double = 0.0,
    val numDaysOnHold: Double = 0.0,
    val numDaysDropped: Double = 0.0,
    val numTimesRewatched: Int = 0,
    val meanScore: Double = 0.0,
    val numEpisodes: Int = 0
)
