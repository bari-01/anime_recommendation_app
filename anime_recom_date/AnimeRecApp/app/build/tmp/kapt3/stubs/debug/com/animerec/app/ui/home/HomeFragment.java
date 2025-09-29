package com.animerec.app.ui.home;

/**
 * Home fragment with the swipe recommendation interface.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010$\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010\'\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010(\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016J\u001a\u0010*\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010+\u001a\u00020,H\u0016J\u001a\u0010-\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/animerec/app/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "<init>", "()V", "viewModel", "Lcom/animerec/app/ui/home/RecommendationViewModel;", "cardStackView", "Lcom/yuyakaido/android/cardstackview/CardStackView;", "layoutManager", "Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "adapter", "Lcom/animerec/app/ui/home/AnimeCardAdapter;", "loadingIndicator", "Landroid/widget/ProgressBar;", "emptyStateText", "Landroid/widget/TextView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "showSwipeTutorialIfNeeded", "performSwipe", "direction", "Lcom/yuyakaido/android/cardstackview/Direction;", "showLoading", "isLoading", "", "onCardDragging", "ratio", "", "onCardSwiped", "onCardRewound", "onCardCanceled", "onCardAppeared", "position", "", "onCardDisappeared", "onDestroyView", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment implements com.yuyakaido.android.cardstackview.CardStackListener {
    private com.animerec.app.ui.home.RecommendationViewModel viewModel;
    private com.yuyakaido.android.cardstackview.CardStackView cardStackView;
    private com.yuyakaido.android.cardstackview.CardStackLayoutManager layoutManager;
    private com.animerec.app.ui.home.AnimeCardAdapter adapter;
    private android.widget.ProgressBar loadingIndicator;
    private android.widget.TextView emptyStateText;
    
    public HomeFragment() {
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
    
    /**
     * Show swipe tutorial dialog for first-time users.
     */
    private final void showSwipeTutorialIfNeeded() {
    }
    
    /**
     * Perform a swipe in the given direction.
     */
    private final void performSwipe(com.yuyakaido.android.cardstackview.Direction direction) {
    }
    
    /**
     * Show or hide the loading indicator.
     */
    private final void showLoading(boolean isLoading) {
    }
    
    @java.lang.Override()
    public void onCardDragging(@org.jetbrains.annotations.Nullable()
    com.yuyakaido.android.cardstackview.Direction direction, float ratio) {
    }
    
    @java.lang.Override()
    public void onCardSwiped(@org.jetbrains.annotations.Nullable()
    com.yuyakaido.android.cardstackview.Direction direction) {
    }
    
    @java.lang.Override()
    public void onCardRewound() {
    }
    
    @java.lang.Override()
    public void onCardCanceled() {
    }
    
    @java.lang.Override()
    public void onCardAppeared(@org.jetbrains.annotations.Nullable()
    android.view.View view, int position) {
    }
    
    @java.lang.Override()
    public void onCardDisappeared(@org.jetbrains.annotations.Nullable()
    android.view.View view, int position) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}