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
package com.animerec.app.ui.profile

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.animerec.app.AnimeRecApp
import com.animerec.app.data.Resource
import com.animerec.app.models.AnimeStatistics
import com.animerec.app.models.User
import com.animerec.app.util.ErrorLogManager
import kotlinx.coroutines.launch

/**
 * ViewModel for user profile display and management.
 */
class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    
    private val TAG = "ProfileViewModel"
    private val repository = (application as AnimeRecApp).repository
    
    private val _userProfile = MutableLiveData<Resource<User>>()
    val userProfile: LiveData<Resource<User>> = _userProfile
    
    private val _animeStats = MutableLiveData<Resource<AnimeStatistics>>()
    val animeStats: LiveData<Resource<AnimeStatistics>> = _animeStats
    
    /**
     * Load the current user's profile from the MyAnimeList API.
     */
    fun loadUserProfile() {
        _userProfile.value = Resource.Loading
        
        viewModelScope.launch {
            try {
                val result = repository.getUserProfile()
                _userProfile.value = result
            } catch (e: Exception) {
                Log.e(TAG, "Error loading user profile", e)
                ErrorLogManager.logEvent(TAG, "ERROR", "Profile load failed: ${e.message}")
                _userProfile.value = Resource.Error("Failed to load profile: ${e.message}")
            }
        }
    }
    
    /**
     * Load anime statistics for the current user.
     * Stats are embedded in the User object from getUserProfile(),
     * so we extract them from the already-loaded profile.
     */
    fun loadAnimeStats() {
        val profileValue = _userProfile.value
        if (profileValue is Resource.Success) {
            _animeStats.value = Resource.Success(profileValue.data.animeStatistics)
        } else {
            _animeStats.value = Resource.Error("Profile not loaded")
        }
    }
}
