import glob, re

for fp in glob.glob("app/src/main/java/com/animerec/app/ui/**/*Fragment.kt", recursive=True):
    with open(fp, "r") as f:
        text = f.read()

    if "Glide.with" in text and "onDestroyView" in text and "Glide.with(this).clear" not in text:
        # Just simple append
        match = re.search(r"override fun onDestroyView\(\)(?:\s*|.*?)*?\{", text)
        if match:
            # Let's see if we can find ImageView fields by looking at the class
            iv_matches = re.findall(r"private var (\w+ImageView) *: *ImageView\?", text)
            if iv_matches:
                addition = "\n" + "\n".join([f"        {iv}?.let {{ Glide.with(this).clear(it) }}" for iv in iv_matches])
                
                # replace
                start = match.end()
                text = text[:start] + addition + text[start:]
                with open(fp, "w") as f:
                    f.write(text)
                print(f"Patched fragment {fp}")

