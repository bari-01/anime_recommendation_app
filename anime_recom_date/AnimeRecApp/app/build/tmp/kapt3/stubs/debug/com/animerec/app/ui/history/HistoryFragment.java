package com.animerec.app.ui.history;

/**
 * Fragment for displaying user's history (completed and dropped items).
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00152\u0006\u0010\'\u001a\u00020\u0006H\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0002J\u001c\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020*2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u00020\u00182\u0006\u0010/\u001a\u0002002\u0006\u00102\u001a\u000203H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/animerec/app/ui/history/HistoryFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/animerec/app/ui/history/HistoryAdapter$OnItemClickListener;", "<init>", "()V", "TAG", "", "viewModel", "Lcom/animerec/app/ui/history/HistoryViewModel;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "statusTabLayout", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "loadingIndicator", "Landroid/widget/ProgressBar;", "emptyStateTextView", "Landroid/widget/TextView;", "adapter", "Lcom/animerec/app/ui/history/HistoryAdapter;", "currentContentType", "Lcom/animerec/app/models/ContentType;", "currentStatus", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupContentTypeTabs", "setupStatusTabs", "loadHistory", "contentType", "status", "showLoading", "isLoading", "", "showEmptyState", "isEmpty", "errorMessage", "onItemClick", "content", "Lcom/animerec/app/models/AnimeContent;", "onRateItem", "score", "", "app_debug"})
public final class HistoryFragment extends androidx.fragment.app.Fragment implements com.animerec.app.ui.history.HistoryAdapter.OnItemClickListener {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "HistoryFragment";
    private com.animerec.app.ui.history.HistoryViewModel viewModel;
    private com.google.android.material.tabs.TabLayout tabLayout;
    private com.google.android.material.tabs.TabLayout statusTabLayout;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private android.widget.ProgressBar loadingIndicator;
    private android.widget.TextView emptyStateTextView;
    private com.animerec.app.ui.history.HistoryAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private com.animerec.app.models.ContentType currentContentType = com.animerec.app.models.ContentType.ANIME;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentStatus = "completed";
    
    public HistoryFragment() {
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
    
    private final void setupContentTypeTabs() {
    }
    
    private final void setupStatusTabs() {
    }
    
    private final void loadHistory(com.animerec.app.models.ContentType contentType, java.lang.String status) {
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
    public void onRateItem(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.AnimeContent content, int score) {
    }
}