package com.tirgei.taarifa.data.mappers

import com.tirgei.taarifa.core.DateFormatter
import com.tirgei.taarifa.data.network.dto.NewsPostDto
import com.tirgei.taarifa.data.network.dto.NewsSourceDto
import com.tirgei.taarifa.domain.models.NewsPost
import com.tirgei.taarifa.domain.models.NewsSource
import com.tirgei.taarifa.utils.formatToDate

fun NewsSourceDto.toDomain() = NewsSource(
    id = this.id.orEmpty(),
    name = this.name.orEmpty()
)

fun NewsPostDto.toDomain() = NewsPost(
    source = this.source.toDomain(),
    author = this.author.orEmpty(),
    title = this.title.orEmpty(),
    description = this.description.orEmpty(),
    url = this.url.orEmpty(),
    urlToImage = this.urlToImage.orEmpty(),
    publishedAt = this.publishedAt?.formatToDate("dd MMM yyyy").orEmpty(),
    content = this.content.orEmpty()
)