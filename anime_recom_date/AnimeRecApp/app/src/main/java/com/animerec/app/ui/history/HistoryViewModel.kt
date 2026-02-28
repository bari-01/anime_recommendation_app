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
package com.animerec.app.ui.history

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
 * ViewModel for the history screen.
 */
class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    
    private val TAG = "HistoryViewModel"
    private val repository = (application as AnimeRecApp).repository
    
    private val _historyItems = MutableLiveData<Resource<List<AnimeContent>>>(Resource.Loading)
    val historyItems: LiveData<Resource<List<AnimeContent>>> = _historyItems
    
    /**
     * Load history items for a specific content type and status.
     */
    fun loadHistory(contentType: ContentType, status: String) {
        _historyItems.value = Resource.Loading
        
        viewModelScope.launch {
            try {
                val result = when (contentType) {
                    ContentType.ANIME -> repository.getAnimeList(status)
                    ContentType.MANGA -> repository.getMangaList(status)
                    ContentType.NOVEL -> repository.getNovelList(status)
                }
                
                _historyItems.value = result
            } catch (e: Exception) {
                Log.e(TAG, "Error loading history", e)
                ErrorLogManager.logEvent(TAG, "ERROR", "History load failed: ${e.message}")
                _historyItems.value = Resource.Error("Failed to load history: ${e.message}")
            }
        }
    }
    
    /**
     * Rate a content item.
     */
    fun rateContent(content: AnimeContent, score: Int) {
        viewModelScope.launch {
            try {
                val result = when (content.type) {
                    ContentType.ANIME -> repository.rateAnime(content.id, score)
                    ContentType.MANGA, ContentType.NOVEL -> repository.rateManga(content.id, score)
                }
                
                if (result is Resource.Success) {
                    // Refresh the list to reflect changes
                    val status = when {
                        content.status.contains("watching") -> "watching"
                        content.status.contains("reading") -> "reading"
                        content.status.contains("completed") -> "completed"
                        content.status.contains("on_hold") -> "on_hold"
                        content.status.contains("dropped") -> "dropped"
                        else -> "completed"
                    }
                    loadHistory(content.type, status)
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error rating content", e)
                ErrorLogManager.logEvent(TAG, "ERROR", "Rating failed: ${e.message}")
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
                    // Refresh the list to reflect changes
                    loadHistory(content.type, newStatus)
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error updating status", e)
                ErrorLogManager.logEvent(TAG, "ERROR", "Status update failed: ${e.message}")
            }
        }
    }
}