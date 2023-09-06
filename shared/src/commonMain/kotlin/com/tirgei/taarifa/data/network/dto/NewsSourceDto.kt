package com.tirgei.taarifa.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsSourceDto(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?
)
