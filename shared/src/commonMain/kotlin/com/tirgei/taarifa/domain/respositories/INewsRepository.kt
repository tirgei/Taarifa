package com.tirgei.taarifa.domain.respositories

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tirgei.taarifa.domain.models.NewsPost

interface INewsRepository {
    @NativeCoroutines
    suspend fun fetchNews(): List<NewsPost>

    @NativeCoroutines
    suspend fun fetchNewsPost(id: String): NewsPost

    @NativeCoroutines
    suspend fun fetchNewsCategories(): List<String>
}