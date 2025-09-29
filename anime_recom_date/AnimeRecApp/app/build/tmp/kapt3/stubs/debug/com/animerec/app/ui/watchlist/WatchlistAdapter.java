package com.animerec.app.ui.watchlist;

/**
 * Adapter for displaying watchlist items.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0013\u0014\u0015B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/animerec/app/ui/watchlist/WatchlistAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/animerec/app/models/AnimeContent;", "Lcom/animerec/app/ui/watchlist/WatchlistAdapter$WatchlistViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/animerec/app/ui/watchlist/WatchlistAdapter$OnItemClickListener;", "<init>", "(Landroid/content/Context;Lcom/animerec/app/ui/watchlist/WatchlistAdapter$OnItemClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "OnItemClickListener", "WatchlistViewHolder", "WatchlistDiffCallback", "app_debug"})
public final class WatchlistAdapter extends androidx.recyclerview.widget.ListAdapter<com.animerec.app.models.AnimeContent, com.animerec.app.ui.watchlist.WatchlistAdapter.WatchlistViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.animerec.app.ui.watchlist.WatchlistAdapter.OnItemClickListener listener = null;
    
    public WatchlistAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.animerec.app.ui.watchlist.WatchlistAdapter.OnItemClickListener listener) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.animerec.app.ui.watchlist.WatchlistAdapter.WatchlistViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.animerec.app.ui.watchlist.WatchlistAdapter.WatchlistViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t\u00c0\u0006\u0003"}, d2 = {"Lcom/animerec/app/ui/watchlist/WatchlistAdapter$OnItemClickListener;", "", "onItemClick", "", "content", "Lcom/animerec/app/models/AnimeContent;", "onStatusChange", "newStatus", "", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        com.animerec.app.models.AnimeContent content);
        
        public abstract void onStatusChange(@org.jetbrains.annotations.NotNull()
        com.animerec.app.models.AnimeContent content, @org.jetbrains.annotations.NotNull()
        java.lang.String newStatus);
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/animerec/app/ui/watchlist/WatchlistAdapter$WatchlistDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/animerec/app/models/AnimeContent;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "app_debug"})
    public static final class WatchlistDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.animerec.app.models.AnimeContent> {
        
        public WatchlistDiffCallback() {
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
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/animerec/app/ui/watchlist/WatchlistAdapter$WatchlistViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/animerec/app/ui/watchlist/WatchlistAdapter;Landroid/view/View;)V", "coverImageView", "Landroid/widget/ImageView;", "titleTextView", "Landroid/widget/TextView;", "typeAndStatusTextView", "ratingTextView", "moreOptionsButton", "bind", "", "content", "Lcom/animerec/app/models/AnimeContent;", "showPopupMenu", "view", "formatStatus", "", "status", "app_debug"})
    public final class WatchlistViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView coverImageView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView titleTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView typeAndStatusTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView ratingTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView moreOptionsButton = null;
        
        public WatchlistViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.animerec.app.models.AnimeContent content) {
        }
        
        private final void showPopupMenu(android.view.View view, com.animerec.app.models.AnimeContent content) {
        }
        
        private final java.lang.String formatStatus(java.lang.String status) {
            return null;
        }
    }
}