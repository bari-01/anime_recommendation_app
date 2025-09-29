package com.animerec.app.ui.history;

/**
 * ViewModel for the history screen.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/animerec/app/ui/history/HistoryViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "TAG", "", "repository", "error/NonExistentClass", "Lerror/NonExistentClass;", "_historyItems", "Landroidx/lifecycle/MutableLiveData;", "historyItems", "Landroidx/lifecycle/LiveData;", "getHistoryItems", "()Landroidx/lifecycle/LiveData;", "loadHistory", "", "contentType", "Lcom/animerec/app/models/ContentType;", "status", "rateContent", "content", "Lcom/animerec/app/models/AnimeContent;", "score", "", "updateStatus", "newStatus", "app_debug"})
public final class HistoryViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "HistoryViewModel";
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<error.NonExistentClass> _historyItems = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<error.NonExistentClass> historyItems = null;
    
    public HistoryViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<error.NonExistentClass> getHistoryItems() {
        return null;
    }
    
    /**
     * Load history items for a specific content type and status.
     */
    public final void loadHistory(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.ContentType contentType, @org.jetbrains.annotations.NotNull()
    java.lang.String status) {
    }
    
    /**
     * Rate a content item.
     */
    public final void rateContent(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.AnimeContent content, int score) {
    }
    
    /**
     * Update the status of a content item.
     */
    public final void updateStatus(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.AnimeContent content, @org.jetbrains.annotations.NotNull()
    java.lang.String newStatus) {
    }
}