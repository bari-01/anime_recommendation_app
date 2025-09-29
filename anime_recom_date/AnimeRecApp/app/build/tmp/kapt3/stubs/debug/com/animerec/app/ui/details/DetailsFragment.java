package com.animerec.app.ui.details;

/**
 * Fragment for displaying content details.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010\'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/animerec/app/ui/details/DetailsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "TAG", "", "viewModel", "Lcom/animerec/app/ui/details/DetailsViewModel;", "coverImageView", "Landroid/widget/ImageView;", "titleTextView", "Landroid/widget/TextView;", "typeAndStatusTextView", "ratingTextView", "synopsisTextView", "genresChipGroup", "Lcom/google/android/material/chip/ChipGroup;", "watchStatusButton", "Landroid/widget/Button;", "watchTrailerButton", "userRatingBar", "Landroid/widget/RatingBar;", "similarContentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "loadingIndicator", "Landroid/widget/ProgressBar;", "errorTextView", "similarContentAdapter", "Lcom/animerec/app/ui/details/SimilarContentAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "updateUIWithContentDetails", "content", "Lcom/animerec/app/models/AnimeContent;", "formatStatus", "status", "showLoading", "isLoading", "", "app_debug"})
public final class DetailsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "DetailsFragment";
    private com.animerec.app.ui.details.DetailsViewModel viewModel;
    private android.widget.ImageView coverImageView;
    private android.widget.TextView titleTextView;
    private android.widget.TextView typeAndStatusTextView;
    private android.widget.TextView ratingTextView;
    private android.widget.TextView synopsisTextView;
    private com.google.android.material.chip.ChipGroup genresChipGroup;
    private android.widget.Button watchStatusButton;
    private android.widget.Button watchTrailerButton;
    private android.widget.RatingBar userRatingBar;
    private androidx.recyclerview.widget.RecyclerView similarContentRecyclerView;
    private android.widget.ProgressBar loadingIndicator;
    private android.widget.TextView errorTextView;
    private com.animerec.app.ui.details.SimilarContentAdapter similarContentAdapter;
    
    public DetailsFragment() {
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
    
    private final void updateUIWithContentDetails(com.animerec.app.models.AnimeContent content) {
    }
    
    private final java.lang.String formatStatus(java.lang.String status) {
        return null;
    }
    
    private final void showLoading(boolean isLoading) {
    }
}