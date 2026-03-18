import re

file_path = "anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/ui/home/RecommendationViewModel.kt"
with open(file_path, "r") as f:
    text = f.read()

# Replace all viewModelScope.launch { to viewModelScope.launch(Dispatchers.Default) { 
# EXCEPT IN recordInteraction, addToWatchlist, markAsNotInterested, markAsWatched
text = text.replace("import kotlinx.coroutines.launch", "import kotlinx.coroutines.launch\nimport kotlinx.coroutines.Dispatchers")

def repl_launch(m):
    return "viewModelScope.launch(Dispatchers.Default) {"

text = re.sub(r'viewModelScope\.launch\s*\{(?=\s*try\s*\{\s*(//\s*Get user profile|val userResource =))', repl_launch, text)

# Set LiveData via postValue
text = text.replace("_recommendations.value", "_recommendations.postValue")

with open(file_path, "w") as f:
    f.write(text)

