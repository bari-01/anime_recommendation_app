package com.animerec.app.ui.watchlist;

/**
 * ViewModel for the watchlist screen.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/animerec/app/ui/watchlist/WatchlistViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "TAG", "", "repository", "error/NonExistentClass", "Lerror/NonExistentClass;", "_watchlistItems", "Landroidx/lifecycle/MutableLiveData;", "watchlistItems", "Landroidx/lifecycle/LiveData;", "getWatchlistItems", "()Landroidx/lifecycle/LiveData;", "loadWatchlist", "", "contentType", "Lcom/animerec/app/models/ContentType;", "updateStatus", "content", "Lcom/animerec/app/models/AnimeContent;", "newStatus", "removeFromWatchlist", "app_debug"})
public final class WatchlistViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "WatchlistViewModel";
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<error.NonExistentClass> _watchlistItems = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<error.NonExistentClass> watchlistItems = null;
    
    public WatchlistViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<error.NonExistentClass> getWatchlistItems() {
        return null;
    }
    
    /**
     * Load watchlist for specific content type.
     */
    public final void loadWatchlist(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.ContentType contentType) {
    }
    
    /**
     * Update the status of a content item.
     */
    public final void updateStatus(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.AnimeContent content, @org.jetbrains.annotations.NotNull()
    java.lang.String newStatus) {
    }
    
    /**
     * Remove an item from the watchlist (by marking it as dropped or completed).
     */
    public final void removeFromWatchlist(@org.jetbrains.annotations.NotNull()
    com.animerec.app.models.AnimeContent content) {
    }
}