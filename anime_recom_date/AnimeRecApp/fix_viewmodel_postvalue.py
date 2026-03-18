import re

file_path = "/home/shuvam/codes/anime_recommendation_app/anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/ui/home/RecommendationViewModel.kt"
with open(file_path, "r") as f:
    text = f.read()

# Fix syntax: _recommendations.postValue = X  --> _recommendations.postValue(X)
text = re.sub(r'_recommendations\.postValue\s*=\s*(.*)', r'_recommendations.postValue(\1)', text)

with open(file_path, "w") as f:
    f.write(text)
