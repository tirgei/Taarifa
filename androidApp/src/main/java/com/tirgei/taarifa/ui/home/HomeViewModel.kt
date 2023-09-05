package com.tirgei.taarifa.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tirgei.taarifa.data.repositories.NewsRepository
import com.tirgei.taarifa.domain.models.NewsPost
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    private val mutableNewsListState = MutableStateFlow(listOf<NewsPost>())
    val newsListState = mutableNewsListState.asStateFlow() // Flow for news posts

    private val mutableNewsCategoriesState = MutableStateFlow(listOf<String>())
    val newsCategoriesState = mutableNewsCategoriesState.asStateFlow() // Flow for news categories

    private val mutableHomeScreenState = MutableStateFlow(HomeScreenState())
    val homeScreenState = mutableHomeScreenState.asStateFlow() // Flow for home screen state

    fun fetchNewsPosts() = viewModelScope.launch {
        mutableNewsListState.emit(newsRepository.fetchNews())
    }

    fun fetchNewsCategories() = viewModelScope.launch {
        mutableNewsCategoriesState.emit(listOf(
            "For You", "Featured", "Tech", "Sports", "Finance", "Weather", "Government",
            "Business", "Fashion", "Entertainment"
        ))
    }

}