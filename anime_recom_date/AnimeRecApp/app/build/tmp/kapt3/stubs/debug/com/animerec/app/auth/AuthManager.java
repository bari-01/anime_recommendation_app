package com.animerec.app.auth;

/**
 * Manages user authentication with MyAnimeList.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0082@\u00a2\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0013J(\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/animerec/app/auth/AuthManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "TAG", "", "secureStorage", "error/NonExistentClass", "Lerror/NonExistentClass;", "refreshLock", "Ljava/lang/Object;", "isAuthenticated", "", "getAccessToken", "forceRefresh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTokens", "", "accessToken", "refreshToken", "expiresIn", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "exchangeCodeForTokens", "authCode", "codeVerifier", "redirectUri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "AuthManager";
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass secureStorage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object refreshLock = null;
    
    public AuthManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Check if the user is authenticated.
     * @return true if the user has an access token.
     */
    public final boolean isAuthenticated() {
        return false;
    }
    
    /**
     * Get the current access token, refreshing if needed.
     * @param forceRefresh Force refresh the token even if it's not expired.
     * @return The access token, or null if not authenticated or refresh failed.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAccessToken(boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    /**
     * Save authentication tokens securely.
     */
    public final void saveTokens(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    java.lang.String refreshToken, long expiresIn) {
    }
    
    /**
     * Refresh an expired access token.
     * @param refreshToken The refresh token.
     * @return The new access token, or null if refresh failed.
     */
    private final java.lang.Object refreshToken(java.lang.String refreshToken, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    /**
     * Clear authentication data (logout).
     */
    public final void logout() {
    }
    
    /**
     * Exchange authorization code for tokens.
     * @param authCode The authorization code.
     * @param codeVerifier The code verifier.
     * @param redirectUri The redirect URI.
     * @return true if token exchange was successful.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object exchangeCodeForTokens(@org.jetbrains.annotations.NotNull()
    java.lang.String authCode, @org.jetbrains.annotations.NotNull()
    java.lang.String codeVerifier, @org.jetbrains.annotations.NotNull()
    java.lang.String redirectUri, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}