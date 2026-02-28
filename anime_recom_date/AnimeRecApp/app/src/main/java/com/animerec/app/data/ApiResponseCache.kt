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
package com.animerec.app.data

import android.util.Log

/**
 * Simple in-memory cache for API responses.
 */
class ApiResponseCache {
    
    private val TAG = "ApiResponseCache"
    
    private data class CacheEntry<T>(
        val data: T,
        val expirationTime: Long
    )
    
    private val cache = mutableMapOf<String, CacheEntry<*>>()
    
    /**
     * Get a cached response if it exists and is not expired.
     */
    @Suppress("UNCHECKED_CAST")
    fun <T> get(key: String): T? {
        val entry = cache[key] as? CacheEntry<T> ?: return null
        
        return if (System.currentTimeMillis() < entry.expirationTime) {
            Log.d(TAG, "Cache hit for key: $key")
            entry.data
        } else {
            Log.d(TAG, "Cache expired for key: $key")
            cache.remove(key)
            null
        }
    }
    
    /**
     * Put a response in the cache.
     * @param key The cache key
     * @param data The data to cache
     * @param expirationMs How long until the cache expires (in milliseconds)
     */
    fun <T> put(key: String, data: T, expirationMs: Long) {
        val entry = CacheEntry(data, System.currentTimeMillis() + expirationMs)
        cache[key] = entry
        Log.d(TAG, "Cached response for key: $key (expires in ${expirationMs}ms)")
    }
    
    /**
     * Remove a specific entry from the cache.
     */
    fun remove(key: String) {
        cache.remove(key)
    }
    
    /**
     * Clear all cached entries.
     */
    fun clear() {
        cache.clear()
        Log.d(TAG, "Cache cleared")
    }
    
    /**
     * Clear expired entries from the cache.
     */
    fun clearExpired() {
        val currentTime = System.currentTimeMillis()
        val expiredKeys = cache.filter { it.value.expirationTime < currentTime }.keys
        expiredKeys.forEach { cache.remove(it) }
        Log.d(TAG, "Cleared ${expiredKeys.size} expired cache entries")
    }
    
    /**
     * Get the current cache size.
     */
    fun size(): Int = cache.size
}
