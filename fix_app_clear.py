import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/AnimeRecApp.kt"
with open(file_path, "r") as f:
    text = f.read()

text = text.replace(
    "(repository as? AnimeRepositoryImpl)?.clearCache()",
    "(repository as? AnimeRepositoryImpl)?.clearCache()\n                (recommendationEngine as? com.animerec.app.recommendation.BasicRecommendationEngine)?.clearCache()"
)

with open(file_path, "w") as f:
    f.write(text)
