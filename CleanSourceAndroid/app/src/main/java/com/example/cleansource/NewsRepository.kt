package com.example.cleansource

class NewsRepository {
    suspend fun getTopHeadlines(apiKey: String): List<NewsModels.Article> {
        val response = RetrofitInstance.RetrofitInstance.api.getTopHeadlines("cnn", apiKey)
        return if (response.status == "ok") {
            response.articles.take(5)
        } else {
            emptyList()
        }
    }
}
