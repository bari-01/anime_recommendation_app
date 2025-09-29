package com.animerec.app.ui.watchlist;

/**
 * Fragment for displaying user's watchlist (plan to watch/read).
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0002J\u001c\u0010&\u001a\u00020\u00142\u0006\u0010\'\u001a\u00020%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/animerec/app/ui/watchlist/WatchlistFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/animerec/app/ui/watchlist/WatchlistAdapter$OnItemClickListener;", "<init>", "()V", "TAG", "", "viewModel", "Lcom/animerec/app/ui/watchlist/WatchlistViewModel;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "loadingIndicator", "Landroid/widget/ProgressBar;", "emptyStateTextView", "Landroid/widget/TextView;", "adapter", "Lcom/animerec/app/ui/watchlist/WatchlistAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupTabLayout", "loadWatchlist", "contentType", "Lcom/animerec/app/models/ContentType;", "showLoading", "isLoading", "", "showEmptyState", "isEmpty", "errorMessage", "onItemClick", "content", "Lcom/animerec/app/models/AnimeContent;", "onStatusChange", "newStatus", "app_debug"})
public final class WatchlistFragment extends androidx.fragment.app.Fragment implements com.animerec.app.ui.watchlist.WatchlistAdapter.OnItemClickListener {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "WatchlistFragment";
    private com.animerec.app.ui.watchlist.WatchlistViewModel viewModel;
    private com.google.android.material.tabs.TabLayout tabLayout;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private android.widget.ProgressBar loadingIndicator;
    private android.widget.TextView emptyStateTextView;
    private com.animerec.app.ui.watchlist.WatchlistAdapter adapter;
    
    public WatchlistFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupTabLayout() {
    }
    
    private final void loadWatchlist(com.animerec.app.models.ContentType contentType) {
    }
    
    private final void showLoading(boolean isLoading) {
    }
    
    private final void showEmptyState(boolean isEmpty, java.lang.String errorMessage) {
    }
    
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.AnimeContent content) {
    }
    
    @java.lang.Override()
    public void onStatusChange(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.AnimeContent content, @org.jetbrains.annotations.NotNull()
    java.lang.String newStatus) {
    }
}