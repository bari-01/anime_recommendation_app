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

import android.net.Uri
import com.animerec.app.AnimeRecApp
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.Base64

/**
 * Utility class for OAuth PKCE flow with MyAnimeList.
 */
object OAuthUtil {
    
    private const val CODE_VERIFIER_LENGTH = 128
    
    /**
     * Generate a random code verifier for PKCE.
     */
    fun generateCodeVerifier(): String {
        val secureRandom = SecureRandom()
        val codeVerifier = ByteArray(CODE_VERIFIER_LENGTH)
        secureRandom.nextBytes(codeVerifier)
        return Base64.getUrlEncoder().withoutPadding().encodeToString(codeVerifier)
            .take(128)
            .replace("+", "-")
            .replace("/", "_")
            .replace("=", "")
    }
    
    /**
     * Generate code challenge from code verifier using S256 method.
     * MAL uses plain method, so we just return the verifier.
     */
    fun generateCodeChallenge(codeVerifier: String): String {
        // MAL uses "plain" code challenge method
        return codeVerifier
    }
    
    /**
     * Build the authorization URL for MyAnimeList.
     */
    fun buildAuthorizationUrl(codeChallenge: String): String {
        return Uri.parse(AnimeRecApp.MAL_AUTH_URL)
            .buildUpon()
            .appendQueryParameter("response_type", "code")
            .appendQueryParameter("client_id", AnimeRecApp.CLIENT_ID)
            .appendQueryParameter("redirect_uri", AnimeRecApp.REDIRECT_URI)
            .appendQueryParameter("code_challenge", codeChallenge)
            .appendQueryParameter("code_challenge_method", "plain")
            .build()
            .toString()
    }
    
    /**
     * Extract authorization code from redirect URI.
     */
    fun extractAuthCode(uri: Uri): String? {
        return uri.getQueryParameter("code")
    }
    
    /**
     * Check if redirect URI contains an error.
     */
    fun extractError(uri: Uri): String? {
        return uri.getQueryParameter("error")
    }
}
