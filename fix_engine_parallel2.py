with open("anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/BasicRecommendationEngine.kt", "r") as f:
    lines = f.readlines()

new_lines = []
skip = False
for line in lines:
    if "allItems.addAll(suggestionsDeferred.await())" in line:
        new_lines.append(line)
        skip = True
    elif "// De-duplicate" in line:
        skip = False
        new_lines.append("            }\n            \n")
        new_lines.append(line)
    elif not skip:
        new_lines.append(line)

with open("anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/recommendation/BasicRecommendationEngine.kt", "w") as f:
    f.writelines(new_lines)
