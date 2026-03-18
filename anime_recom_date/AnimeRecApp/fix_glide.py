import glob, re

for fp in glob.glob("anime_recom_date/AnimeRecApp/app/src/main/java/com/animerec/app/ui/**/*Adapter.kt", recursive=True):
    with open(fp, "r") as f:
        text = f.read()

    if "onViewRecycled(" not in text and "Glide.with" in text:
        # Find the adapter class name
        # We want to add onViewRecycled
        # Actually it's easier to just inject the method
        match = re.search(r"class (\w+Adapter).*?\{", text)
        if match:
            # We can just add onViewRecycled at the end of the class
            # Wait, better to just look for the class closing brace, but it's hard with regex.
            pass
