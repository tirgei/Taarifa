package com.tirgei.taarifa.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tirgei.taarifa.data.repositories.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    private val mutableDetailsScreenState = MutableStateFlow(DetailsScreenState())
    val detailsScreenState = mutableDetailsScreenState.asStateFlow()

    fun fetchNewsPost(id: String) = viewModelScope.launch {
        val news = newsRepository.fetchNewsPost(id)
        mutableDetailsScreenState.update {
            it.copy(
                isLoading = false,
                isErrorState = false,
                newsPost = news
            )
        }
    }

}