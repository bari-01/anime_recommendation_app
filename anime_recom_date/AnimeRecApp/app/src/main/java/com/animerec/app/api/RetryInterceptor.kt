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

import android.util.Log
import com.animerec.app.util.ErrorLogManager
import okhttp3.Interceptor
import okhttp3.Response
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

/**
 * OkHttp interceptor that handles rate limiting and retries failed requests with 
 * exponential backoff.
 */
class RetryInterceptor : Interceptor {
    
    private val TAG = "RetryInterceptor"
    
    companion object {
        private const val MAX_RETRIES = 3
        private const val INITIAL_BACKOFF_MS = 1000L
        private const val MAX_BACKOFF_MS = 20000L
    }
    
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var response: Response? = null
        var retriesLeft = MAX_RETRIES
        var backoffMs = INITIAL_BACKOFF_MS
        var lastException: Exception? = null
        
        while (retriesLeft > 0) {
            try {
                // If this isn't the first attempt, apply delay with jitter
                if (response != null) {
                    // Add jitter to backoff (10-30% variance)
                    val jitter = backoffMs * (0.1 + Random.nextDouble(0.2))
                    val delayMs = (backoffMs + jitter).toLong()
                    
                    Log.d(TAG, "Retrying request after ${delayMs}ms delay, ${retriesLeft - 1} retries left")
                    Thread.sleep(delayMs)
                }
                
                // Execute the request
                response = chain.proceed(request)
                
                // Check for rate limiting (429 status code)
                if (response.code == 429) {
                    val retryAfterHeader = response.header("Retry-After")
                    val retryAfterMs = if (!retryAfterHeader.isNullOrEmpty()) {
                        // Parse retry-after header (in seconds) and convert to milliseconds
                        retryAfterHeader.toLongOrNull()?.times(1000) ?: backoffMs
                    } else {
                        backoffMs
                    }
                    
                    Log.d(TAG, "Rate limited. Retrying after ${retryAfterMs}ms")
                    
                    // Close the previous response
                    response.close()
                    
                    // Sleep for the specified time
                    Thread.sleep(retryAfterMs)
                    
                    // Decrement retries and increase backoff for next attempt
                    retriesLeft--
                    backoffMs = min(backoffMs * 2, MAX_BACKOFF_MS)
                } else {
                    // Not rate limited, return the response
                    return response
                }
            } catch (e: Exception) {
                // Close the previous response
                response?.close()
                
                // Log the error
                Log.e(TAG, "Request failed: ${e.message}")
                ErrorLogManager.logEvent(TAG, "ERROR", "Request failed (retries=$retriesLeft): ${e.message}")
                
                // Save the exception to throw if all retries fail
                lastException = e
                
                // Decrement retries and increase backoff for next attempt
                retriesLeft--
                backoffMs = min(backoffMs * 2, MAX_BACKOFF_MS)
            }
        }
        
        // If we got here, all retries failed
        if (response != null) {
            return response
        } else {
            throw lastException ?: IllegalStateException("Request failed after $MAX_RETRIES retries")
        }
    }
}