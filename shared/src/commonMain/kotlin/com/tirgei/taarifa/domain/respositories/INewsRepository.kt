package com.tirgei.taarifa.domain.respositories

import com.tirgei.taarifa.domain.models.NewsPost

interface INewsRepository {
    suspend fun fetchNews(): List<NewsPost>

    suspend fun fetchNewsPost(id: String): NewsPost
}