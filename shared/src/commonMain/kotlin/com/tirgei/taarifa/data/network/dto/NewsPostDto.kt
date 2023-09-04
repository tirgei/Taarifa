package com.tirgei.taarifa.data.network.dto

data class NewsPostDto(
    val source: NewsSourceDto,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)
