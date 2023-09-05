package com.tirgei.taarifa.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.tirgei.taarifa.domain.models.NewsPost
import com.tirgei.taarifa.domain.models.NewsSource
import com.tirgei.taarifa.theme.TaarifaTheme
import com.tirgei.taarifa.ui.Screen
import com.tirgei.taarifa.ui.home.components.AppBar
import com.tirgei.taarifa.ui.home.components.NewsPostItem

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeScreenState by viewModel.homeScreenState.collectAsStateWithLifecycle()
    val newsList by viewModel.newsListState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetchNewsPosts()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        AppBar()

        Box(modifier = Modifier.fillMaxSize()) {
            if (homeScreenState.isLoading) {
                CircularProgressIndicator()
            } else if (homeScreenState.isErrorState) {
                Text(text = "Something went wrong.")
            } else {
                NewsList(news = newsList) {
                    navController.navigate("${Screen.Details}/${it.title}")
                }
            }
        }
    }
}


@Composable
fun NewsList(news: List<NewsPost>, onNewsClick: (NewsPost) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        items(news) { newsPost ->
            NewsPostItem(newsPost = newsPost, onNewsClick = onNewsClick)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val newsPost = listOf(
        NewsPost(
            source = NewsSource(id = "NTV", name = "NTV"),
            author = "John Doe",
            title = "Random News",
            description = "Some random news information",
            publishedAt = "27 June",
            content = "Some random news information content",
            url = "https://example.com",
            urlToImage = "https://example.com"
        )
    )

    TaarifaTheme {
        NewsList(news = newsPost) {

        }
    }
}