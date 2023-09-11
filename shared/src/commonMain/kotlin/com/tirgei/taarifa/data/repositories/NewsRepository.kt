package com.tirgei.taarifa.data.repositories

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tirgei.taarifa.core.Dispatcher
import com.tirgei.taarifa.data.local.NewsCache
import com.tirgei.taarifa.data.mappers.toDomain
import com.tirgei.taarifa.data.network.ApiService
import com.tirgei.taarifa.domain.models.NewsPost
import kotlinx.coroutines.withContext

class NewsRepository(
    private val apiService: ApiService,
    private val dispatcher: Dispatcher,
    private val newsCache: NewsCache
) {

    @NativeCoroutines
    suspend fun fetchNews(): List<NewsPost> = withContext(dispatcher.io) {
        val response = apiService.fetchTopNews()
        response.articles
            .also {
                newsCache.deleteNewsPosts()
                newsCache.insertNewsPosts(it)
            }
            .map { it.toDomain() }
    }

    @NativeCoroutines
    suspend fun fetchNewsPost(id: String): NewsPost = withContext(dispatcher.io) {
        newsCache.fetchNewsPost(id).toDomain()
    }

    @NativeCoroutines
    suspend fun fetchNewsCategories(): List<String> {
        return listOf(
            "For You", "Featured", "Tech", "Sports", "Finance", "Weather", "Government",
            "Business", "Fashion", "Entertainment"
        )
    }
}