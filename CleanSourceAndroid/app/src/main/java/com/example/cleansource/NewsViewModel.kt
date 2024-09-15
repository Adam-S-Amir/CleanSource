package com.example.cleansource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewsViewModel {

    class NewsViewModel(private val repository: NewsRepository) : ViewModel() {
        private val _articles = MutableLiveData<List<Article>>()
        val articles: LiveData<List<Article>> get() = _articles

        fun fetchTopHeadlines(apiKey: String) {
            viewModelScope.launch() {
                val topArticles = repository.getTopHeadlines(apiKey)
                _articles.postValue(topArticles)
            }
        }
    }

}