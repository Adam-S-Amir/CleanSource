package com.example.cleansource

import retrofit2.http.GET
import retrofit2.http.Query

class NewsApi {

    interface NewsApi {

        @GET("top-headlines")
        suspend fun getTopHeadlines(
            @Query("sources") sources: String,
            @Query("apiKey") apiKey: String
        ): NewsModels.NewsResponse
    }

}