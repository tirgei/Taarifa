package com.tirgei.taarifa.ui.details

import com.tirgei.taarifa.domain.models.NewsPost

data class DetailsScreenState(
    val isLoading: Boolean = false,
    val newsPost: NewsPost? = null,
    val isErrorState: Boolean = false
)
