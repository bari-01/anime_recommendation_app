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
package com.animerec.app.ui.watchlist

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.animerec.app.AnimeRecApp
import com.animerec.app.data.Resource
import com.animerec.app.models.AnimeContent
import com.animerec.app.models.ContentType
import com.animerec.app.util.ErrorLogManager
import kotlinx.coroutines.launch

/**
 * ViewModel for the watchlist screen.
 */
class WatchlistViewModel(application: Application) : AndroidViewModel(application) {
    
    private val TAG = "WatchlistViewModel"
    private val repository = (application as AnimeRecApp).repository
    
    private val _watchlistItems = MutableLiveData<Resource<List<AnimeContent>>>(Resource.Loading)
    val watchlistItems: LiveData<Resource<List<AnimeContent>>> = _watchlistItems
    
    /**
     * Load watchlist for specific content type.
     */
    fun loadWatchlist(contentType: ContentType) {
        _watchlistItems.value = Resource.Loading
        
        viewModelScope.launch {
            try {
                val result = when (contentType) {
                    ContentType.ANIME -> repository.getAnimeWatchlist()
                    ContentType.MANGA -> repository.getMangaWatchlist()
                    ContentType.NOVEL -> repository.getNovelWatchlist()
                }
                
                _watchlistItems.value = result
            } catch (e: Exception) {
                Log.e(TAG, "Error loading watchlist", e)
                ErrorLogManager.logEvent(TAG, "ERROR", "Watchlist load failed: ${e.message}")
                _watchlistItems.value = Resource.Error("Failed to load watchlist: ${e.message}")
            }
        }
    }
    
    /**
     * Update the status of a content item.
     */
    fun updateStatus(content: AnimeContent, newStatus: String) {
        viewModelScope.launch {
            try {
                val result = when (content.type) {
                    ContentType.ANIME -> repository.updateAnimeStatus(content.id, newStatus)
                    ContentType.MANGA, ContentType.NOVEL -> repository.updateMangaStatus(content.id, newStatus)
                }
                
                if (result is Resource.Success) {
                    // Refresh the watchlist to reflect changes
                    loadWatchlist(content.type)
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error updating status", e)
                ErrorLogManager.logEvent(TAG, "ERROR", "Status update failed: ${e.message}")
            }
        }
    }
    
    /**
     * Remove an item from the watchlist (by marking it as dropped or completed).
     */
    fun removeFromWatchlist(content: AnimeContent) {
        updateStatus(content, "dropped")
    }
}