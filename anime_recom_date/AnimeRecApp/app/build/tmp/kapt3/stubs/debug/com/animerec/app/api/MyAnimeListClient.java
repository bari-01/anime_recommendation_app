package com.animerec.app.api;

/**
 * Client for the MyAnimeList API.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005JJ\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\"\u0010\"\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0%0$\u0012\u0006\u0012\u0004\u0018\u00010\u00010#H\u0086@\u00a2\u0006\u0002\u0010&J\u0006\u0010\'\u001a\u00020(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/animerec/app/api/MyAnimeListClient;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "TAG", "", "authManager", "Lcom/animerec/app/auth/AuthManager;", "apiResponseCache", "error/NonExistentClass", "Lerror/NonExistentClass;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", "service", "Lcom/animerec/app/api/MyAnimeListService;", "getService", "()Lcom/animerec/app/api/MyAnimeListService;", "service$delegate", "executeWithCache", "T", "cacheKey", "expirationMs", "", "apiCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "(Ljava/lang/String;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCache", "", "app_debug"})
public final class MyAnimeListClient {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "MyAnimeListClient";
    @org.jetbrains.annotations.NotNull()
    private final com.animerec.app.auth.AuthManager authManager = null;
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass apiResponseCache = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy okHttpClient$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy retrofit$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy service$delegate = null;
    
    public MyAnimeListClient(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final okhttp3.OkHttpClient getOkHttpClient() {
        return null;
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.animerec.app.api.MyAnimeListService getService() {
        return null;
    }
    
    /**
     * Execute an API request with caching.
     */
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>java.lang.Object executeWithCache(@org.jetbrains.annotations.NotNull()
    java.lang.String cacheKey, long expirationMs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super retrofit2.Response<T>>, ? extends java.lang.Object> apiCall, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super T> $completion) {
        return null;
    }
    
    /**
     * Clear the API cache.
     */
    public final void clearCache() {
    }
}