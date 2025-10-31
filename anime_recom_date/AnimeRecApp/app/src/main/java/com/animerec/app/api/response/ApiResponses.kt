package com.animerec.app.api.response

import com.google.gson.annotations.SerializedName

// Stub response classes for API calls
// TODO: Complete implementation based on MyAnimeList API documentation

data class AnimeDetailsResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String
)

data class AnimeListResponse(
    @SerializedName("data") val data: List<AnimeDetailsResponse>
)

data class MangaDetailsResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String
)

data class MangaListResponse(
    @SerializedName("data") val data: List<MangaDetailsResponse>
)

data class RankingResponse(
    @SerializedName("data") val data: List<AnimeDetailsResponse>
)

data class RecommendationsResponse(
    @SerializedName("data") val data: List<AnimeDetailsResponse>
)

data class SeasonalAnimeResponse(
    @SerializedName("data") val data: List<AnimeDetailsResponse>
)

data class UserAnimeListResponse(
    @SerializedName("data") val data: List<AnimeDetailsResponse>
)

data class UserMangaListResponse(
    @SerializedName("data") val data: List<MangaDetailsResponse>
)

data class UserProfileResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)
