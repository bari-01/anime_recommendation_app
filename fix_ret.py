import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/BasicRecommendationEngine.kt"
with open(file_path, "r") as f:
    text = f.read()

text = text.replace("weight = 0.5)\n                    return Resource.Success(true)", "weight = 0.5)\n                    return@withContext Resource.Success(true)")

with open(file_path, "w") as f:
    f.write(text)
