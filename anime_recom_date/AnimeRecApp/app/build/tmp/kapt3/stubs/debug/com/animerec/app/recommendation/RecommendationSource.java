package com.animerec.app.recommendation;

/**
 * Sources for recommendations to track effectiveness of different algorithms.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/animerec/app/recommendation/RecommendationSource;", "", "<init>", "(Ljava/lang/String;I)V", "CONTENT_BASED", "COLLABORATIVE", "THEME_BASED", "POPULARITY", "SEASONAL", "USER_HISTORY", "MAL_SUGGESTIONS", "app_debug"})
public enum RecommendationSource {
    /*public static final*/ CONTENT_BASED /* = new CONTENT_BASED() */,
    /*public static final*/ COLLABORATIVE /* = new COLLABORATIVE() */,
    /*public static final*/ THEME_BASED /* = new THEME_BASED() */,
    /*public static final*/ POPULARITY /* = new POPULARITY() */,
    /*public static final*/ SEASONAL /* = new SEASONAL() */,
    /*public static final*/ USER_HISTORY /* = new USER_HISTORY() */,
    /*public static final*/ MAL_SUGGESTIONS /* = new MAL_SUGGESTIONS() */;
    
    RecommendationSource() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.animerec.app.recommendation.RecommendationSource> getEntries() {
        return null;
    }
}