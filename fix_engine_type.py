import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/BasicRecommendationEngine.kt"
with open(file_path, "r") as f:
    text = f.read()

text = text.replace("val suggestionsDeferred = if (normalizedType == \"anime\") {", "val suggestionsDeferred: kotlinx.coroutines.Deferred<List<AnimeContent>>? = if (normalizedType == \"anime\") {")

with open(file_path, "w") as f:
    f.write(text)
