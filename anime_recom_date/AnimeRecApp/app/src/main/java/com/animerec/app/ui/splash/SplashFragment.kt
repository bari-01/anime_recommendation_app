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
package com.animerec.app.ui.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.animerec.app.AnimeRecApp
import com.animerec.app.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Splash screen fragment shown on app startup.
 * Checks authentication status and navigates accordingly.
 */
class SplashFragment : Fragment() {

    private val TAG = "SplashFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    /** Prevents double-navigation if the coroutine fires more than once. */
    private var hasNavigated = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // If the fragment is being restored after activity recreation the nav
        // controller already has the real destination (e.g. homeFragment) in its
        // back stack.  Don't re-navigate — that would try to execute the splash
        // action from a non-splash destination and crash.
        if (savedInstanceState != null) {
            Log.d(TAG, "Restored after recreation — skipping splash navigation")
            return
        }

        // Check authentication and navigate
        viewLifecycleOwner.lifecycleScope.launch {
            delay(1500) // Show splash for at least 1.5 seconds

            // Guard: prevent double-navigation
            if (hasNavigated) return@launch

            // Guard: ensure fragment is still attached
            if (!isAdded || isDetached) {
                Log.w(TAG, "Fragment not attached, skipping navigation")
                return@launch
            }

            // Guard: ensure we are on the splash destination
            val navController = try {
                findNavController()
            } catch (e: IllegalStateException) {
                Log.w(TAG, "NavController not found, skipping navigation")
                return@launch
            }

            if (navController.currentDestination?.id != R.id.splashFragment) {
                Log.w(TAG, "No longer on splash destination, skipping navigation")
                return@launch
            }

            val app = requireActivity().application as AnimeRecApp
            val authManager = app.authManager

            try {
                hasNavigated = true
                when {
                    !authManager.isAuthenticated() -> {
                        Log.d(TAG, "User not authenticated, navigating to login")
                        navController.navigate(R.id.action_splashFragment_to_loginFragment)
                    }
                    else -> {
                        Log.d(TAG, "User authenticated, navigating to home")
                        navController.navigate(R.id.action_splashFragment_to_homeFragment)
                    }
                }
            } catch (e: IllegalArgumentException) {
                hasNavigated = false
                Log.e(TAG, "Navigation failed from splash", e)
            }
        }
    }
}
