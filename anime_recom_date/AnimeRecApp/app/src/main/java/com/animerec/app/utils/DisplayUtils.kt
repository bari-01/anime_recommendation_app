/*
 * AnimeRec - Anime Recommendation App
 * Copyright (C) 2025 Shuvam Banerji Seal
 *
 * Developed by: Shuvam Banerji Seal
 * GitHub: https://github.com/technicallittlemaster
 *
 * This file is part of AnimeRec.
 * Licensed under the MIT License.
 */
package com.animerec.app.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.util.DisplayMetrics
import kotlin.math.roundToInt

/**
 * Utilities for handling different screen sizes and densities.
 */
object DisplayUtils {
    
    /**
     * Convert dp to pixels.
     */
    fun dpToPx(context: Context, dp: Float): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density).roundToInt()
    }
    
    /**
     * Convert pixels to dp.
     */
    fun pxToDp(context: Context, px: Int): Float {
        val density = context.resources.displayMetrics.density
        return px / density
    }
    
    /**
     * Get screen width in pixels.
     */
    fun getScreenWidth(context: Context): Int {
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.widthPixels
    }
    
    /**
     * Get screen height in pixels.
     */
    fun getScreenHeight(context: Context): Int {
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.heightPixels
    }
    
    /**
     * Check if the device is a tablet.
     */
    fun isTablet(context: Context): Boolean {
        return (context.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE
    }
    
    /**
     * Get a dimension value adjusted for the screen density.
     */
    fun getDensityAdjustedValue(originalValue: Int, defaultDensity: Int = DisplayMetrics.DENSITY_MEDIUM): Int {
        val currentDensity = Resources.getSystem().displayMetrics.densityDpi
        return (originalValue * (currentDensity.toFloat() / defaultDensity)).roundToInt()
    }
    
    /**
     * Calculate the optimal number of columns for a grid based on screen width and item width.
     */
    fun calculateOptimalColumnCount(context: Context, itemWidthDp: Int): Int {
        val screenWidth = getScreenWidth(context)
        val itemWidthPx = dpToPx(context, itemWidthDp.toFloat())
        
        val columnCount = screenWidth / itemWidthPx
        return if (columnCount >= 2) columnCount else 2 // Minimum 2 columns
    }
}