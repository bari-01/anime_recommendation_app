package com.animerec.app;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010 \u001a\u00020!H\u0016J\u000e\u0010\"\u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006)"}, d2 = {"Lcom/animerec/app/AnimeRecApp;", "Landroid/app/Application;", "Landroid/content/ComponentCallbacks2;", "<init>", "()V", "TAG", "", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "getDataStore", "()Landroidx/datastore/core/DataStore;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "repository", "error/NonExistentClass", "getRepository", "()Lerror/NonExistentClass;", "repository$delegate", "Lkotlin/Lazy;", "authManager", "Lcom/animerec/app/auth/AuthManager;", "getAuthManager", "()Lcom/animerec/app/auth/AuthManager;", "authManager$delegate", "recommendationEngine", "Lcom/animerec/app/recommendation/RecommendationEngine;", "getRecommendationEngine", "()Lcom/animerec/app/recommendation/RecommendationEngine;", "recommendationEngine$delegate", "onCreate", "", "preloadEssentialData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTrimMemory", "level", "", "onLowMemory", "Companion", "app_debug"})
public final class AnimeRecApp extends android.app.Application implements android.content.ComponentCallbacks2 {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "AnimeRecApp";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadOnlyProperty dataStore$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy authManager$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy recommendationEngine$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CLIENT_ID = "c65a18864c7e9d6ef7a8f5c7eb6f5a06";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String REDIRECT_URI = "animerec://auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAL_AUTH_URL = "https://myanimelist.net/v1/oauth2/authorize";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAL_TOKEN_URL = "https://myanimelist.net/v1/oauth2/token";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAL_API_BASE_URL = "https://api.myanimelist.net/v2/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS_WATCHING = "watching";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS_COMPLETED = "completed";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS_ON_HOLD = "on_hold";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS_DROPPED = "dropped";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS_PLAN_TO_WATCH = "plan_to_watch";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS_READING = "reading";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATUS_PLAN_TO_READ = "plan_to_read";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ANIME_FIELDS = "id,title,main_picture,alternative_titles,synopsis,mean,rank,popularity,num_list_users,media_type,status,genres,my_list_status,num_episodes,start_season,broadcast,source,average_episode_duration,rating,pictures,background,related_anime,related_manga,recommendations,studios,statistics";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MANGA_FIELDS = "id,title,main_picture,alternative_titles,synopsis,mean,rank,popularity,num_list_users,media_type,status,genres,my_list_status,num_volumes,num_chapters,authors{first_name,last_name},pictures,background,related_anime,related_manga,recommendations";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "anime_rec_database";
    @org.jetbrains.annotations.NotNull()
    public static final com.animerec.app.AnimeRecApp.Companion Companion = null;
    
    public AnimeRecApp() {
        super();
    }
    
    private final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> getDataStore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final error.NonExistentClass getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.animerec.app.auth.AuthManager getAuthManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.animerec.app.recommendation.RecommendationEngine getRecommendationEngine() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final java.lang.Object preloadEssentialData(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void onTrimMemory(int level) {
    }
    
    @java.lang.Override()
    public void onLowMemory() {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/animerec/app/AnimeRecApp$Companion;", "", "<init>", "()V", "CLIENT_ID", "", "REDIRECT_URI", "MAL_AUTH_URL", "MAL_TOKEN_URL", "MAL_API_BASE_URL", "STATUS_WATCHING", "STATUS_COMPLETED", "STATUS_ON_HOLD", "STATUS_DROPPED", "STATUS_PLAN_TO_WATCH", "STATUS_READING", "STATUS_PLAN_TO_READ", "ANIME_FIELDS", "MANGA_FIELDS", "DATABASE_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}