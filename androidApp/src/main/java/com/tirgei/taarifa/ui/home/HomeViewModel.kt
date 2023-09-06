package com.tirgei.taarifa.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tirgei.taarifa.domain.models.NewsPost
import com.tirgei.taarifa.domain.respositories.INewsRepository
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val newsRepository: INewsRepository
): ViewModel() {

    private val mutableNewsListState = MutableStateFlow(listOf<NewsPost>())
    val newsListState = mutableNewsListState.asStateFlow() // Flow for news posts

    private val mutableNewsCategoriesState = MutableStateFlow(listOf<String>())
    val newsCategoriesState = mutableNewsCategoriesState.asStateFlow() // Flow for news categories

    private val mutableHomeScreenState = MutableStateFlow(HomeScreenState())
    val homeScreenState = mutableHomeScreenState.asStateFlow() // Flow for home screen state

    fun fetchNewsPosts() = viewModelScope.launch {
        mutableHomeScreenState.update {
            it.copy(isLoading = true)
        }

        try {
            val news = newsRepository.fetchNews()
            mutableHomeScreenState.update {
                it.copy(isLoading = false, isErrorState = false)
            }
            mutableNewsListState.emit(news)
        } catch (e: Exception) {
            Napier.e("Error fetching news: ${e.localizedMessage}")
            mutableHomeScreenState.update {
                it.copy(isLoading = false, isErrorState = true)
            }
        }
    }

    fun fetchNewsCategories() = viewModelScope.launch {
        mutableNewsCategoriesState.emit(listOf(
            "For You", "Featured", "Tech", "Sports", "Finance", "Weather", "Government",
            "Business", "Fashion", "Entertainment"
        ))
    }

}