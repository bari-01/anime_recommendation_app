import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/BasicRecommendationEngine.kt"
with open(file_path, "r") as f:
    text = f.read()

text = text.replace("override fun clearCache(): Resource<Boolean> = withContext(Dispatchers.IO) {", "override fun clearCache(): Resource<Boolean> {")

text = text.replace("return@withContext Resource.Success(true)", "return Resource.Success(true)")
text = text.replace("return@withContext Resource.Error(\"Error clearing cache: ${e.message}\")", "return Resource.Error(\"Error clearing cache: ${e.message}\")")

with open(file_path, "w") as f:
    f.write(text)

file_path2 = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/data/AnimeRepositoryImpl.kt"
with open(file_path2, "r") as f:
    text2 = f.read()

text2 = text2.replace("override fun clearCache() {", "override fun clearCache() {")

with open(file_path2, "w") as f:
    f.write(text2)

