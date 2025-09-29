package com.animerec.app.recommendation;

/**
 * Main recommendation engine interface for the app.
 * This defines the contract for all recommendation engines.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0015J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u000bJ \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u00a6@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0016\u00c0\u0006\u0003"}, d2 = {"Lcom/animerec/app/recommendation/RecommendationEngine;", "", "getRecommendations", "error/NonExistentClass", "user", "limit", "", "(Lerror/NonExistentClass;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendationsForType", "contentType", "", "(Lerror/NonExistentClass;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSimilarContent", "contentId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordInteraction", "interactionType", "Lcom/animerec/app/recommendation/RecommendationEngine$InteractionType;", "(ILcom/animerec/app/recommendation/RecommendationEngine$InteractionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InteractionType", "app_debug"})
public abstract interface RecommendationEngine {
    
    /**
     * Get personalized recommendations for a user.
     * @param user The user to get recommendations for
     * @param limit The maximum number of recommendations to return
     * @return A Resource containing a list of recommended content
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecommendations(@org.jetbrains.annotations.NotNull()
    error.NonExistentClass user, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion);
    
    /**
     * Get recommendations for a specific content type.
     * @param user The user to get recommendations for
     * @param contentType The content type to get recommendations for (anime, manga, novels)
     * @param limit The maximum number of recommendations to return
     * @return A Resource containing a list of recommended content
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecommendationsForType(@org.jetbrains.annotations.NotNull()
    error.NonExistentClass user, @org.jetbrains.annotations.NotNull()
    java.lang.String contentType, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion);
    
    /**
     * Get similar content to a given item.
     * @param contentId The ID of the content to find similar items for
     * @param limit The maximum number of similar items to return
     * @return A Resource containing a list of similar content
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSimilarContent(int contentId, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion);
    
    /**
     * Record a user's interaction with a piece of content.
     * @param contentId The ID of the content
     * @param interactionType The type of interaction (like, dislike, watched, etc.)
     * @return A Resource indicating success or failure
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object recordInteraction(int contentId, @org.jetbrains.annotations.NotNull()
    com.animerec.app.recommendation.RecommendationEngine.InteractionType interactionType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion);
    
    /**
     * Clear the recommendation cache.
     * @return A Resource indicating success or failure
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearCache(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion);
    
    /**
     * Main recommendation engine interface for the app.
     * This defines the contract for all recommendation engines.
     */
    @kotlin.Metadata(mv = {2, 2, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
    
    /**
     * Types of interactions a user can have with content
     */
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/animerec/app/recommendation/RecommendationEngine$InteractionType;", "", "<init>", "(Ljava/lang/String;I)V", "LIKE", "DISLIKE", "SUPER_LIKE", "VIEW_DETAILS", "app_debug"})
    public static enum InteractionType {
        /*public static final*/ LIKE /* = new LIKE() */,
        /*public static final*/ DISLIKE /* = new DISLIKE() */,
        /*public static final*/ SUPER_LIKE /* = new SUPER_LIKE() */,
        /*public static final*/ VIEW_DETAILS /* = new VIEW_DETAILS() */;
        
        InteractionType() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.animerec.app.recommendation.RecommendationEngine.InteractionType> getEntries() {
            return null;
        }
    }
}