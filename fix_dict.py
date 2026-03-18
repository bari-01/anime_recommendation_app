import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/BasicRecommendationEngine.kt"
with open(file_path, "r") as f:
    text = f.read()

# Fix cache size explicitly
text = text.replace(
    "private val recommendationCache = mutableMapOf<String, Pair<List<AnimeContent>, Long>>()",
    """private val recommendationCache = object : java.util.LinkedHashMap<String, Pair<List<AnimeContent>, Long>>(50, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, Pair<List<AnimeContent>, Long>>?): Boolean {
            return size > 50
        }
    }"""
)

with open(file_path, "w") as f:
    f.write(text)

