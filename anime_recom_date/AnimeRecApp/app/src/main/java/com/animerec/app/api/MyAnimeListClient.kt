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
package com.animerec.app.api

import android.content.Context
import android.util.Log
import com.animerec.app.AnimeRecApp
import com.animerec.app.auth.AuthManager
import com.animerec.app.data.ApiResponseCache
import com.animerec.app.util.ErrorLogManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Client for the MyAnimeList API.
 */
class MyAnimeListClient(private val context: Context) {
    
    private val TAG = "MyAnimeListClient"
    private val authManager = AuthManager(context)
    
    // Cache instances
    private val apiResponseCache = ApiResponseCache()
    
    // Create OkHttp client with auth interceptor
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                // Get the original request
                val original = chain.request()
                
                // Build new request with auth token
                val builder = original.newBuilder()
                
                // Add authorization header if token is available
                val accessToken = runBlocking { authManager.getAccessToken() }
                if (!accessToken.isNullOrEmpty()) {
                    builder.header("Authorization", "Bearer $accessToken")
                }
                
                // Add required X-MAL-CLIENT-ID header
                builder.header("X-MAL-CLIENT-ID", AnimeRecApp.CLIENT_ID)
                
                // Proceed with modified request
                chain.proceed(builder.build())
            }
            .addInterceptor(RetryInterceptor()) // Add the retry interceptor
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            })
            .build()
    }
    
    // Create Retrofit instance
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(AnimeRecApp.MAL_API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    // Create the API service
    val service: MyAnimeListService by lazy {
        retrofit.create(MyAnimeListService::class.java)
    }
    
    /**
     * Execute an API request with caching.
     */
    suspend fun <T> executeWithCache(
        cacheKey: String,
        expirationMs: Long,
        apiCall: suspend () -> retrofit2.Response<T>
    ): T? = withContext(Dispatchers.IO) {
        try {
            // Check cache first
            val cachedResponse = apiResponseCache.get<T>(cacheKey)
            if (cachedResponse != null) {
                return@withContext cachedResponse
            }
            
            // Cache miss, execute API call
            val response = apiCall()
            
            if (response.isSuccessful) {
                val body = response.body()
                
                if (body != null) {
                    // Cache the response
                    apiResponseCache.put(cacheKey, body, expirationMs)
                    return@withContext body
                }
            } else {
                val errorBody = response.errorBody()?.string()
                Log.e(TAG, "API error (${response.code()}): $errorBody")
                ErrorLogManager.logEvent(TAG, "ERROR", "API error (${response.code()}): $errorBody")
                
                // Handle 401 Unauthorized (token expired)
                if (response.code() == 401) {
                    // Force token refresh
                    val refreshed = authManager.getAccessToken(forceRefresh = true)
                    if (refreshed != null) {
                        // Retry the request
                        val retryResponse = apiCall()
                        if (retryResponse.isSuccessful) {
                            val retryBody = retryResponse.body()
                            if (retryBody != null) {
                                // Cache the response
                                apiResponseCache.put(cacheKey, retryBody, expirationMs)
                                return@withContext retryBody
                            }
                        }
                    }
                }
            }
            
            return@withContext null
        } catch (e: Exception) {
            Log.e(TAG, "API call failed", e)
            ErrorLogManager.logEvent(TAG, "ERROR", "API call failed: ${e.message}")
            return@withContext null
        }
    }
    
    /**
     * Clear the API cache.
     */
    fun clearCache() {
        apiResponseCache.clear()
    }
}