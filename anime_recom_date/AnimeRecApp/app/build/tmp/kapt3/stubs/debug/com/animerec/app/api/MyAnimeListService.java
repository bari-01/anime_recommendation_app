package com.animerec.app.api;

/**
 * Retrofit service interface for MyAnimeList API.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b%\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000bJF\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\n2\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014JF\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\n2\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J<\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\n2\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0018J<\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\n2\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0018JP\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u001b\u001a\u00020\n2\b\b\u0001\u0010\u001c\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\n2\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u001d\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001eJ2\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0010\u001a\u00020\n2\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010 JH\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u001d\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\n2\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010#JH\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u001d\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\n2\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010#J\u00a2\u0001\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\'\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u0006H\u00a7@\u00a2\u0006\u0002\u00100J\u00ae\u0001\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\r\u001a\u00020\n2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\n2\n\b\u0003\u00102\u001a\u0004\u0018\u00010\n2\n\b\u0003\u00103\u001a\u0004\u0018\u00010\n2\n\b\u0003\u00104\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\n2\n\b\u0003\u00105\u001a\u0004\u0018\u00010\n2\n\b\u0003\u00106\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u0006H\u00a7@\u00a2\u0006\u0002\u00107\u00a8\u00068\u00c0\u0006\u0003"}, d2 = {"Lcom/animerec/app/api/MyAnimeListService;", "", "getUserProfile", "Lretrofit2/Response;", "error/NonExistentClass", "fields", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimeDetails", "animeId", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMangaDetails", "mangaId", "searchAnime", "query", "limit", "offset", "nsfw", "", "(Ljava/lang/String;IILjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchManga", "getAnimeRankings", "rankingType", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMangaRankings", "getSeasonalAnime", "year", "season", "sort", "(ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimeRecommendations", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserAnimeList", "status", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserMangaList", "updateAnimeStatus", "score", "numWatchedEpisodes", "isRewatching", "startDate", "finishDate", "priority", "numTimesRewatched", "rewatchValue", "tags", "comments", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMangaStatus", "numVolumesRead", "numChaptersRead", "isRereading", "numTimesReread", "rereadValue", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MyAnimeListService {
    
    @retrofit2.http.GET(value = "users/@me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserProfile(@retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "anime/{anime_id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAnimeDetails(@retrofit2.http.Path(value = "anime_id")
    int animeId, @retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "manga/{manga_id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMangaDetails(@retrofit2.http.Path(value = "manga_id")
    int mangaId, @retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "anime")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchAnime(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @retrofit2.http.Query(value = "nsfw")
    boolean nsfw, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "manga")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchManga(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @retrofit2.http.Query(value = "nsfw")
    boolean nsfw, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "anime/ranking")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAnimeRankings(@retrofit2.http.Query(value = "ranking_type")
    @org.jetbrains.annotations.NotNull()
    java.lang.String rankingType, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "manga/ranking")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMangaRankings(@retrofit2.http.Query(value = "ranking_type")
    @org.jetbrains.annotations.NotNull()
    java.lang.String rankingType, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "anime/season/{year}/{season}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSeasonalAnime(@retrofit2.http.Path(value = "year")
    int year, @retrofit2.http.Path(value = "season")
    @org.jetbrains.annotations.NotNull()
    java.lang.String season, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @retrofit2.http.Query(value = "sort")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "anime/suggestions")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAnimeRecommendations(@retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "users/@me/animelist")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserAnimeList(@retrofit2.http.Query(value = "status")
    @org.jetbrains.annotations.Nullable()
    java.lang.String status, @retrofit2.http.Query(value = "sort")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sort, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.GET(value = "users/@me/mangalist")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserMangaList(@retrofit2.http.Query(value = "status")
    @org.jetbrains.annotations.Nullable()
    java.lang.String status, @retrofit2.http.Query(value = "sort")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sort, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "fields")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<error.NonExistentClass>> $completion);
    
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.PATCH(value = "anime/{anime_id}/my_list_status")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAnimeStatus(@retrofit2.http.Path(value = "anime_id")
    int animeId, @retrofit2.http.Field(value = "status")
    @org.jetbrains.annotations.Nullable()
    java.lang.String status, @retrofit2.http.Field(value = "score")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer score, @retrofit2.http.Field(value = "num_watched_episodes")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer numWatchedEpisodes, @retrofit2.http.Field(value = "is_rewatching")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRewatching, @retrofit2.http.Field(value = "start_date")
    @org.jetbrains.annotations.Nullable()
    java.lang.String startDate, @retrofit2.http.Field(value = "finish_date")
    @org.jetbrains.annotations.Nullable()
    java.lang.String finishDate, @retrofit2.http.Field(value = "priority")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer priority, @retrofit2.http.Field(value = "num_times_rewatched")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer numTimesRewatched, @retrofit2.http.Field(value = "rewatch_value")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer rewatchValue, @retrofit2.http.Field(value = "tags")
    @org.jetbrains.annotations.Nullable()
    java.lang.String tags, @retrofit2.http.Field(value = "comments")
    @org.jetbrains.annotations.Nullable()
    java.lang.String comments, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.Object>> $completion);
    
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.PATCH(value = "manga/{manga_id}/my_list_status")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateMangaStatus(@retrofit2.http.Path(value = "manga_id")
    int mangaId, @retrofit2.http.Field(value = "status")
    @org.jetbrains.annotations.Nullable()
    java.lang.String status, @retrofit2.http.Field(value = "score")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer score, @retrofit2.http.Field(value = "num_volumes_read")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer numVolumesRead, @retrofit2.http.Field(value = "num_chapters_read")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer numChaptersRead, @retrofit2.http.Field(value = "is_rereading")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRereading, @retrofit2.http.Field(value = "start_date")
    @org.jetbrains.annotations.Nullable()
    java.lang.String startDate, @retrofit2.http.Field(value = "finish_date")
    @org.jetbrains.annotations.Nullable()
    java.lang.String finishDate, @retrofit2.http.Field(value = "priority")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer priority, @retrofit2.http.Field(value = "num_times_reread")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer numTimesReread, @retrofit2.http.Field(value = "reread_value")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer rereadValue, @retrofit2.http.Field(value = "tags")
    @org.jetbrains.annotations.Nullable()
    java.lang.String tags, @retrofit2.http.Field(value = "comments")
    @org.jetbrains.annotations.Nullable()
    java.lang.String comments, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.Object>> $completion);
    
    /**
     * Retrofit service interface for MyAnimeList API.
     */
    @kotlin.Metadata(mv = {2, 2, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}