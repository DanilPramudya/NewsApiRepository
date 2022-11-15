package com.example.danildevelop.ui.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.danildevelop.model.Article
import com.example.danildevelop.network.Api
import com.example.danildevelop.network.NewsApiService
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    init {
        getListNews()
    }
    fun getListNews() {
        viewModelScope.launch {
            val response = Api.newsApiService.getTopHeadline()
            val articles = response.articles

            articles.forEach{ article: Article ->
                Log.d("response", article.toString())
            }
        }
    }
}