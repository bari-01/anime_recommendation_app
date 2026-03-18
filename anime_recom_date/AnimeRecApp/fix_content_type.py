import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/UserPreferenceModel.kt"
with open(file_path, "r") as f:
    text = f.read()

replacement = """        val contentType = when (content.type) {
            com.animerec.app.models.ContentType.ANIME -> "anime"
            com.animerec.app.models.ContentType.MANGA -> "manga"
            com.animerec.app.models.ContentType.NOVEL -> "novels"
        }"""
text = text.replace("        val contentType = content.type.name.lowercase()", replacement)

# We should also check line 99 "val contentType = content.type.name"
replacement_99 = """        val contentType = when (content.type) {
            com.animerec.app.models.ContentType.ANIME -> "ANIME"
            com.animerec.app.models.ContentType.MANGA -> "MANGA"
            com.animerec.app.models.ContentType.NOVEL -> "NOVEL"
        }"""
text = text.replace("        val contentType = content.type.name\n", replacement_99 + "\n")

with open(file_path, "w") as f:
    f.write(text)
