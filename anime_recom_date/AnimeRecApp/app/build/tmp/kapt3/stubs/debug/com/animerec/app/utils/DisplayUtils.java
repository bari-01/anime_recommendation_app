package com.animerec.app.utils;

/**
 * Utilities for handling different screen sizes and densities.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005\u00a8\u0006\u0015"}, d2 = {"Lcom/animerec/app/utils/DisplayUtils;", "", "<init>", "()V", "dpToPx", "", "context", "Landroid/content/Context;", "dp", "", "pxToDp", "px", "getScreenWidth", "getScreenHeight", "isTablet", "", "getDensityAdjustedValue", "originalValue", "defaultDensity", "calculateOptimalColumnCount", "itemWidthDp", "app_debug"})
public final class DisplayUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.animerec.app.utils.DisplayUtils INSTANCE = null;
    
    private DisplayUtils() {
        super();
    }
    
    /**
     * Convert dp to pixels.
     */
    public final int dpToPx(@org.jetbrains.annotations.NotNull()
    android.content.Context context, float dp) {
        return 0;
    }
    
    /**
     * Convert pixels to dp.
     */
    public final float pxToDp(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int px) {
        return 0.0F;
    }
    
    /**
     * Get screen width in pixels.
     */
    public final int getScreenWidth(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0;
    }
    
    /**
     * Get screen height in pixels.
     */
    public final int getScreenHeight(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0;
    }
    
    /**
     * Check if the device is a tablet.
     */
    public final boolean isTablet(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * Get a dimension value adjusted for the screen density.
     */
    public final int getDensityAdjustedValue(int originalValue, int defaultDensity) {
        return 0;
    }
    
    /**
     * Calculate the optimal number of columns for a grid based on screen width and item width.
     */
    public final int calculateOptimalColumnCount(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int itemWidthDp) {
        return 0;
    }
}