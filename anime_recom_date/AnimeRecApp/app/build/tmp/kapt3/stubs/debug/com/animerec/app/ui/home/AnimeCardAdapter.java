package com.animerec.app.ui.home;

/**
 * Adapter for anime/manga card items in the swipe stack.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0014\u0010\u0011\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u0000H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/animerec/app/ui/home/AnimeCardAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/animerec/app/models/AnimeContent;", "Lcom/animerec/app/ui/home/AnimeCardAdapter$AnimeCardViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "AnimeCardViewHolder", "AnimeContentDiffCallback", "app_debug"})
public final class AnimeCardAdapter extends androidx.recyclerview.widget.ListAdapter<com.animerec.app.models.AnimeContent, com.animerec.app.ui.home.AnimeCardAdapter.AnimeCardViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    public AnimeCardAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.animerec.app.ui.home.AnimeCardAdapter.AnimeCardViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.animerec.app.ui.home.AnimeCardAdapter.AnimeCardViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onViewRecycled(@org.jetbrains.annotations.NotNull()
    com.animerec.app.ui.home.AnimeCardAdapter.AnimeCardViewHolder holder) {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/animerec/app/ui/home/AnimeCardAdapter$AnimeCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/animerec/app/ui/home/AnimeCardAdapter;Landroid/view/View;)V", "coverImageView", "Landroid/widget/ImageView;", "titleTextView", "Landroid/widget/TextView;", "genresTextView", "ratingTextView", "synopsisTextView", "bind", "", "content", "Lcom/animerec/app/models/AnimeContent;", "app_debug"})
    public final class AnimeCardViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView coverImageView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView titleTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView genresTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView ratingTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView synopsisTextView = null;
        
        public AnimeCardViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.animerec.app.models.AnimeContent content) {
        }
    }
    
    /**
     * DiffUtil for efficient updates.
     */
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/animerec/app/ui/home/AnimeCardAdapter$AnimeContentDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/animerec/app/models/AnimeContent;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "app_debug"})
    public static final class AnimeContentDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.animerec.app.models.AnimeContent> {
        
        public AnimeContentDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.animerec.app.models.AnimeContent oldItem, @org.jetbrains.annotations.NotNull()
        com.animerec.app.models.AnimeContent newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.animerec.app.models.AnimeContent oldItem, @org.jetbrains.annotations.NotNull()
        com.animerec.app.models.AnimeContent newItem) {
            return false;
        }
    }
}