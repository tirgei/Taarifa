package com.tirgei.taarifa.data.network.responses

import com.tirgei.taarifa.data.network.dto.NewsPostDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("status")
    val status: String,
    @SerialName("articles")
    val articles: List<NewsPostDto>
)
