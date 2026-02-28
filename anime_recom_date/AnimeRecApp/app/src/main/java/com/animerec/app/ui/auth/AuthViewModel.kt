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
package com.animerec.app.ui.auth

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.animerec.app.AnimeRecApp
import kotlinx.coroutines.launch

/**
 * ViewModel for authentication operations.
 */
class AuthViewModel(application: Application) : AndroidViewModel(application) {
    
    private val app = application as AnimeRecApp
    private val authManager = app.authManager
    
    val authState = MutableLiveData<AuthState>(AuthState.Idle)
    
    fun isAuthenticated(): Boolean = authManager.isAuthenticated()
    
    fun checkUserSetupStatus() {
        viewModelScope.launch {
            val prefs = getApplication<Application>().getSharedPreferences("anime_repo_prefs", Context.MODE_PRIVATE)
            val isComplete = prefs.getBoolean("profile_complete", false)
            authState.value = AuthState.Success(isComplete)
        }
    }
    
    suspend fun exchangeCodeForTokens(code: String, codeVerifier: String): Boolean {
        authState.value = AuthState.Loading
        return authManager.exchangeCodeForTokens(code, codeVerifier)
    }
    
    fun logout() {
        authManager.logout()
        authState.value = AuthState.Idle
    }
    
    sealed class AuthState {
        object Idle : AuthState()
        object Loading : AuthState()
        data class Success(val isSetupCompleted: Boolean) : AuthState()
        data class Error(val message: String) : AuthState()
    }
}
