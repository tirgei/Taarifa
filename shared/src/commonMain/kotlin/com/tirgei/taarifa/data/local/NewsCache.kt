package com.tirgei.taarifa.data.local

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tirgei.taarifa.core.Dispatcher
import com.tirgei.taarifa.data.network.dto.NewsPostDto
import com.tirgei.taarifa.database.NewsPostEntity
import com.tirgei.taarifa.database.TaarifaDatabase
import kotlinx.coroutines.withContext

class NewsCache (
    database: TaarifaDatabase,
    private val dispatcher: Dispatcher
) {
    private val dbQueries = database.newsPostQueries

    @NativeCoroutines
    suspend fun insertNewsPosts(newsPosts: List<NewsPostDto>) = withContext(dispatcher.io) {
        newsPosts.forEach { insertNewsPost(it) }
    }

    @NativeCoroutines
    suspend fun insertNewsPost(newsPostDto: NewsPostDto) = withContext(dispatcher.io) {
        dbQueries.insertNewsPost(
            id = null,
            title = newsPostDto.title.orEmpty(),
            author = newsPostDto.author,
            description = newsPostDto.description.orEmpty(),
            content = newsPostDto.content.orEmpty(),
            sourceId = newsPostDto.source.id,
            sourceName = newsPostDto.source.name,
            publishedAt = newsPostDto.publishedAt.orEmpty(),
            urlToImage = newsPostDto.urlToImage,
            url = newsPostDto.url.orEmpty()
        )
    }

    @NativeCoroutines
    suspend fun fetchNewsPost(title: String): NewsPostEntity = withContext(dispatcher.io) {
        dbQueries.getNewsPost(title)
            .executeAsOne()
    }

    @NativeCoroutines
    suspend fun deleteNewsPosts() = withContext(dispatcher.io) {
        dbQueries.deleteNewsPosts()
    }
}