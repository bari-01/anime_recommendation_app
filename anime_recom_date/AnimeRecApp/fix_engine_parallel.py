import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/BasicRecommendationEngine.kt"
with open(file_path, "r") as f:
    text = f.read()

# Replace the un-parallelized contentTypes loop with a parallel one
old_loop = """            for (contentType in contentTypes) {
                val typeResult = getRecommendationsForType(user, contentType, itemsPerType)
                if (typeResult is Resource.Success) {
                    candidatePool.addAll(typeResult.data)
                }
            }"""

new_loop = """            val deferredResults = contentTypes.map { contentType ->
                async {
                    getRecommendationsForType(user, contentType, itemsPerType)
                }
            }
            val results = deferredResults.awaitAll()
            for (typeResult in results) {
                if (typeResult is Resource.Success) {
                    candidatePool.addAll(typeResult.data)
                }
            }"""

if old_loop in text:
    text = text.replace(old_loop, new_loop)
    with open(file_path, "w") as f:
        f.write(text)
    print("Replaced loop in generateRecommendations")
else:
    print("Loop not found")

