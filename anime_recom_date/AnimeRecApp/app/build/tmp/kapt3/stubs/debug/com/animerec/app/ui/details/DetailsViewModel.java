package com.animerec.app.ui.details;

/**
 * ViewModel for the content details screen.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007J\u0016\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006#"}, d2 = {"Lcom/animerec/app/ui/details/DetailsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "TAG", "", "repository", "error/NonExistentClass", "Lerror/NonExistentClass;", "recommendationEngine", "Lcom/animerec/app/recommendation/RecommendationEngine;", "_contentDetails", "Landroidx/lifecycle/MutableLiveData;", "contentDetails", "Landroidx/lifecycle/LiveData;", "getContentDetails", "()Landroidx/lifecycle/LiveData;", "_similarContent", "similarContent", "getSimilarContent", "loadContentDetails", "", "contentId", "", "contentType", "Lcom/animerec/app/models/ContentType;", "loadSimilarContent", "updateStatus", "content", "Lcom/animerec/app/models/AnimeContent;", "newStatus", "rateContent", "score", "app_debug"})
public final class DetailsViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "DetailsViewModel";
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.animerec.app.recommendation.RecommendationEngine recommendationEngine = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<error.NonExistentClass> _contentDetails = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<error.NonExistentClass> contentDetails = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<error.NonExistentClass> _similarContent = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<error.NonExistentClass> similarContent = null;
    
    public DetailsViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<error.NonExistentClass> getContentDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<error.NonExistentClass> getSimilarContent() {
        return null;
    }
    
    /**
     * Load content details.
     */
    public final void loadContentDetails(int contentId, @org.jetbrains.annotations.NotNull()
    com.animerec.app.models.ContentType contentType) {
    }
    
    /**
     * Load similar content recommendations.
     */
    public final void loadSimilarContent(int contentId) {
    }
    
    /**
     * Update the status of the content.
     */
    public final void updateStatus(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.AnimeContent content, @org.jetbrains.annotations.NotNull()
    java.lang.String newStatus) {
    }
    
    /**
     * Rate the content.
     */
    public final void rateContent(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.AnimeContent content, int score) {
    }
}