import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/BasicRecommendationEngine.kt"
with open(file_path, "r") as f:
    text = f.read()

if "import kotlinx.coroutines.async" not in text:
    text = text.replace("import kotlinx.coroutines.withContext", "import kotlinx.coroutines.withContext\nimport kotlinx.coroutines.async\nimport kotlinx.coroutines.awaitAll")

with open(file_path, "w") as f:
    f.write(text)

