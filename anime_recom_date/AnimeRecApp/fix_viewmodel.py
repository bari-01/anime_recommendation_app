import re
file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/ui/home/RecommendationViewModel.kt"
with open(file_path, "r") as f:
    text = f.read()

# Replace in loadRecommendations()
text = re.sub(
    r"viewModelScope\.launch \{\s+try \{\s+// Get user profile",
    r"viewModelScope.launch(kotlinx.coroutines.Dispatchers.Default) {\n            try {\n                // Get user profile",
    text
)

# And similarly for loadRecommendationsForType
text = re.sub(
    r"viewModelScope\.launch \{\s+try \{\s+val userResource = repository\.getUserProfile\(\)",
    r"viewModelScope.launch(kotlinx.coroutines.Dispatchers.Default) {\n            try {\n                val userResource = repository.getUserProfile()",
    text
)

# And similarly for loadMoreRecommendations
text = re.sub(
    r"viewModelScope\.launch \{\s+try \{\s+// Get user profile\s+val userResource = repository\.getUserProfile\(\)",
    r"viewModelScope.launch(kotlinx.coroutines.Dispatchers.Default) {\n            try {\n                // Get user profile\n                val userResource = repository.getUserProfile()",
    text
)

text = text.replace("_recommendations.value", "_recommendations.postValue")

with open(file_path, "w") as f:
    f.write(text)
