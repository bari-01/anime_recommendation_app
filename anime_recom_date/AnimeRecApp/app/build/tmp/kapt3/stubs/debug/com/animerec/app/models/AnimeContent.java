package com.animerec.app.models;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b:\b\u0086\b\u0018\u00002\u00020\u0001B\u00e9\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0005H\u00c6\u0003J\u0015\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H\u00c6\u0003J\t\u0010=\u001a\u00020\u0005H\u00c6\u0003J\t\u0010>\u001a\u00020\u0005H\u00c6\u0003J\t\u0010?\u001a\u00020\u000bH\u00c6\u0003J\t\u0010@\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u00c6\u0003J\t\u0010B\u001a\u00020\u0010H\u00c6\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010/J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010/J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010/J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010/J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010H\u001a\u00020\u0010H\u00c6\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010/J\t\u0010J\u001a\u00020\u0005H\u00c6\u0003J\t\u0010K\u001a\u00020\u001aH\u00c6\u0003J\t\u0010L\u001a\u00020\u001aH\u00c6\u0003J\t\u0010M\u001a\u00020\u001aH\u00c6\u0003J\u00f4\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001aH\u00c6\u0001\u00a2\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020\u001a2\b\u0010Q\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010R\u001a\u00020\u0003H\u00d6\u0001J\t\u0010S\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b1\u0010/R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b2\u0010/R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b3\u0010/R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b6\u0010/R\u0011\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u00108R\u0011\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0011\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u00108\u00a8\u0006T"}, d2 = {"Lcom/animerec/app/models/AnimeContent;", "", "id", "", "title", "", "alternativeTitles", "", "synopsis", "imageUrl", "type", "Lcom/animerec/app/models/ContentType;", "status", "genres", "", "rating", "", "releaseYear", "episodes", "chapters", "volumes", "trailerUrl", "malScore", "userScore", "airingStatus", "isFavorite", "", "inWatchlist", "isCompleted", "<init>", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/animerec/app/models/ContentType;Ljava/lang/String;Ljava/util/List;DLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;DLjava/lang/Integer;Ljava/lang/String;ZZZ)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getAlternativeTitles", "()Ljava/util/Map;", "getSynopsis", "getImageUrl", "getType", "()Lcom/animerec/app/models/ContentType;", "getStatus", "getGenres", "()Ljava/util/List;", "getRating", "()D", "getReleaseYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisodes", "getChapters", "getVolumes", "getTrailerUrl", "getMalScore", "getUserScore", "getAiringStatus", "()Z", "getInWatchlist", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/animerec/app/models/ContentType;Ljava/lang/String;Ljava/util/List;DLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;DLjava/lang/Integer;Ljava/lang/String;ZZZ)Lcom/animerec/app/models/AnimeContent;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class AnimeContent {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> alternativeTitles = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String synopsis = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String imageUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final com.animerec.app.models.ContentType type = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> genres = null;
    private final double rating = 0.0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer releaseYear = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer episodes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer chapters = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer volumes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String trailerUrl = null;
    private final double malScore = 0.0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer userScore = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String airingStatus = null;
    private final boolean isFavorite = false;
    private final boolean inWatchlist = false;
    private final boolean isCompleted = false;
    
    public AnimeContent(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> alternativeTitles, @org.jetbrains.annotations.NotNull()
    java.lang.String synopsis, @org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull()
    com.animerec.app.models.ContentType type, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> genres, double rating, @org.jetbrains.annotations.Nullable()
    java.lang.Integer releaseYear, @org.jetbrains.annotations.Nullable()
    java.lang.Integer episodes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer chapters, @org.jetbrains.annotations.Nullable()
    java.lang.Integer volumes, @org.jetbrains.annotations.Nullable()
    java.lang.String trailerUrl, double malScore, @org.jetbrains.annotations.Nullable()
    java.lang.Integer userScore, @org.jetbrains.annotations.NotNull()
    java.lang.String airingStatus, boolean isFavorite, boolean inWatchlist, boolean isCompleted) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getAlternativeTitles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSynopsis() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.animerec.app.models.ContentType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getGenres() {
        return null;
    }
    
    public final double getRating() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getReleaseYear() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getEpisodes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getChapters() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getVolumes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTrailerUrl() {
        return null;
    }
    
    public final double getMalScore() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getUserScore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAiringStatus() {
        return null;
    }
    
    public final boolean isFavorite() {
        return false;
    }
    
    public final boolean getInWatchlist() {
        return false;
    }
    
    public final boolean isCompleted() {
        return false;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    public final double component15() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    public final boolean component18() {
        return false;
    }
    
    public final boolean component19() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final boolean component20() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.animerec.app.models.ContentType component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.animerec.app.models.AnimeContent copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> alternativeTitles, @org.jetbrains.annotations.NotNull()
    java.lang.String synopsis, @org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull()
    com.animerec.app.models.ContentType type, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> genres, double rating, @org.jetbrains.annotations.Nullable()
    java.lang.Integer releaseYear, @org.jetbrains.annotations.Nullable()
    java.lang.Integer episodes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer chapters, @org.jetbrains.annotations.Nullable()
    java.lang.Integer volumes, @org.jetbrains.annotations.Nullable()
    java.lang.String trailerUrl, double malScore, @org.jetbrains.annotations.Nullable()
    java.lang.Integer userScore, @org.jetbrains.annotations.NotNull()
    java.lang.String airingStatus, boolean isFavorite, boolean inWatchlist, boolean isCompleted) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}