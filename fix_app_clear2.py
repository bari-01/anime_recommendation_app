import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/AnimeRecApp.kt"
with open(file_path, "r") as f:
    text = f.read()

text = text.replace("?.clearCache()", "?.clearMemoryCache()")
with open(file_path, "w") as f:
    f.write(text)
