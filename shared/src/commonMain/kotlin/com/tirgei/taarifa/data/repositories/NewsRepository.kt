package com.tirgei.taarifa.data.repositories

import com.tirgei.taarifa.core.Dispatcher
import com.tirgei.taarifa.data.local.NewsCache
import com.tirgei.taarifa.data.mappers.toDomain
import com.tirgei.taarifa.data.network.ApiService
import com.tirgei.taarifa.domain.models.NewsPost
import com.tirgei.taarifa.domain.respositories.INewsRepository
import kotlinx.coroutines.withContext

class NewsRepository(
    private val apiService: ApiService,
    private val dispatcher: Dispatcher,
    private val newsCache: NewsCache
) : INewsRepository {

    override suspend fun fetchNews(): List<NewsPost> = withContext(dispatcher.io) {
        val response = apiService.fetchTopNews()
        response.articles
            .also {
                newsCache.deleteNewsPosts()
                newsCache.insertNewsPosts(it)
            }
            .map { it.toDomain() }
    }

    override suspend fun fetchNewsPost(id: String): NewsPost = withContext(dispatcher.io) {
        newsCache.fetchNewsPost(id).toDomain()
    }
}