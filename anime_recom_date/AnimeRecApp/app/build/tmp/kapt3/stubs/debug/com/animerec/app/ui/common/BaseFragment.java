package com.animerec.app.ui.common;

/**
 * Base fragment with common functionality for all fragments.
 * Handles memory management and resource cleanup.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0004J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0004J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0004J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0004R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/animerec/app/ui/common/BaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "requestManagers", "", "Lcom/bumptech/glide/RequestManager;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "getGlideRequestManager", "onDestroyView", "showError", "message", "", "showSuccess", "applyHardwareAcceleration", "app_debug"})
public abstract class BaseFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.bumptech.glide.RequestManager> requestManagers = null;
    
    public BaseFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Get a Glide request manager that will be automatically cleaned up.
     * Use this instead of Glide.with() directly to prevent memory leaks.
     */
    @org.jetbrains.annotations.NotNull()
    protected final com.bumptech.glide.RequestManager getGlideRequestManager() {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    /**
     * Show a simple error toast.
     */
    protected final void showError(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * Show a simple success toast.
     */
    protected final void showSuccess(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * Apply hardware acceleration to a view for better animation performance.
     */
    protected final void applyHardwareAcceleration(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
}