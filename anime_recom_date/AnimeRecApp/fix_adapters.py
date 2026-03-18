import glob, re

for fp in glob.glob("app/src/main/java/com/animerec/app/ui/**/*Adapter.kt", recursive=True):
    with open(fp, "r") as f:
        text = f.read()

    if "onViewRecycled(" not in text and "Glide.with" in text:
        # Find the image view field Name
        match = re.search(r"private val (\w+(?:Image|Cover)View) *: *ImageView", text)
        if not match:
             match = re.search(r"private val (\w+?) *: *ImageView", text)
        
        if match:
            iv = match.group(1)
            vh_match = re.search(r"class (\w+) *\(", text[text.find("RecyclerView.ViewHolder"):])
            if not vh_match:
                vh_match = re.search(r"inner class (\w+)", text)
            
            if vh_match:
                vh_name = vh_match.group(1)
                
                addition = f"""
    override fun onViewRecycled(holder: {vh_name}) {{
        super.onViewRecycled(holder)
        Glide.with(context).clear(holder.itemView.findViewById<ImageView>(R.id.{iv}))
    }}
}}"""
                text = text.rstrip()
                if text.endswith("}"):
                    text = text[:-1] + addition
                    
                    with open(fp, "w") as f:
                        f.write(text)
                    print(f"Patched {fp}")

