import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/BasicRecommendationEngine.kt"
with open(file_path, "r") as f:
    text = f.read()

replacement = """            val perRankingLimit = (limit * 2) / rankingTypes.size
            if (perRankingLimit < 1) return@withContext Resource.Error("Limit too small")
            
            val deferreds = rankingTypes.map { rankingType ->
                async {
                    try {
                        val result = when (normalizedType) {
                            "anime" -> repository.getAnimeRecommendations(genres, perRankingLimit, rankingType)
                            "manga" -> repository.getMangaRecommendations(genres, perRankingLimit, rankingType)
                            "novels" -> repository.getNovelRecommendations(genres, perRankingLimit, rankingType)
                            else -> Resource.Error("Invalid content type: $normalizedType")
                        }
                        if (result is Resource.Success) result.data else emptyList()
                    } catch (e: Exception) {
                        Log.w(TAG, "Failed to fetch $rankingType for $contentType", e)
                        emptyList()
                    }
                }
            }
            
            val suggestionsDeferred = if (normalizedType == "anime") {
                async {
                    try {
                        val suggestionsResult = repository.getRecommendations(limit)
                        if (suggestionsResult is Resource.Success) suggestionsResult.data else emptyList()
                    } catch (e: Exception) {
                        Log.w(TAG, "Failed to fetch MAL suggestions", e)
                        emptyList()
                    }
                }
            } else null
            
            val results = deferreds.awaitAll()
            for (res in results) {
                allItems.addAll(res)
            }
            if (suggestionsDeferred != null) {
                allItems.addAll(suggestionsDeferred.await())
            }"""

# Use regex to replace the loop block
import re
pattern = r"val perRankingLimit = \(limit \* 2\) / rankingTypes\.size.*?}\n\s*}"
text = re.sub(pattern, replacement, text, flags=re.DOTALL)
with open(file_path, "w") as f:
    f.write(text)

