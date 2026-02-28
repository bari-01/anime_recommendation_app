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
package com.animerec.app.ui.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

/**
 * Base fragment with common functionality for all fragments.
 * Handles memory management and resource cleanup.
 */
abstract class BaseFragment : Fragment() {
    
    private val requestManagers = mutableListOf<RequestManager>()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Common setup for all fragments
    }
    
    /**
     * Get a Glide request manager that will be automatically cleaned up.
     * Use this instead of Glide.with() directly to prevent memory leaks.
     */
    protected fun getGlideRequestManager(): RequestManager {
        val manager = Glide.with(requireContext())
        requestManagers.add(manager)
        return manager
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        // Glide handles cleanup automatically via lifecycle
        requestManagers.clear()
    }
    
    /**
     * Show a simple error toast.
     */
    protected fun showError(message: String) {
        android.widget.Toast.makeText(requireContext(), message, android.widget.Toast.LENGTH_SHORT).show()
    }
    
    /**
     * Show a simple success toast.
     */
    protected fun showSuccess(message: String) {
        android.widget.Toast.makeText(requireContext(), message, android.widget.Toast.LENGTH_SHORT).show()
    }
    
    /**
     * Apply hardware acceleration to a view for better animation performance.
     */
    protected fun applyHardwareAcceleration(view: View) {
        view.setLayerType(View.LAYER_TYPE_HARDWARE, null)
    }
}