import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/data/AnimeRepository.kt"
with open(file_path, "r") as f:
    text = f.read()

text = text.replace("suspend fun clearCache()", "fun clearCache()")
with open(file_path, "w") as f:
    f.write(text)

file_path2 = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/data/AnimeRepositoryImpl.kt"
with open(file_path2, "r") as f:
    text2 = f.read()
text2 = text2.replace("override suspend fun clearCache()", "override fun clearCache()")
with open(file_path2, "w") as f:
    f.write(text2)

# Recommendation
file_path3 = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/RecommendationEngine.kt"
with open(file_path3, "r") as f:
    text3 = f.read()
text3 = text3.replace("suspend fun clearCache()", "fun clearCache()")
with open(file_path3, "w") as f:
    f.write(text3)

file_path4 = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/BasicRecommendationEngine.kt"
with open(file_path4, "r") as f:
    text4 = f.read()
text4 = text4.replace("override suspend fun clearMemoryCache()", "override fun clearCache()")
with open(file_path4, "w") as f:
    f.write(text4)

import glob
for fp in glob.glob("anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/AnimeRecApp.kt"):
    with open(fp, "r") as f:
        t = f.read()
    t = t.replace("clearMemoryCache()", "clearCache()")
    with open(fp, "w") as f:
        f.write(t)
