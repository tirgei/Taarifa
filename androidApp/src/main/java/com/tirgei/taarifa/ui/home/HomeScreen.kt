package com.tirgei.taarifa.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.tirgei.taarifa.domain.models.NewsPost
import com.tirgei.taarifa.domain.models.NewsSource
import com.tirgei.taarifa.ui.Screen
import com.tirgei.taarifa.ui.home.components.AppBar

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
        items(news, key = { newsPost -> newsPost.title }) { newsPost ->
            NewsPostItem(newsPost = newsPost, onNewsClick = onNewsClick)
        }
    }
}

@Composable
fun NewsPostItem(newsPost: NewsPost, onNewsClick: (NewsPost) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onNewsClick(newsPost) }
    ) {
        Text(
            text = newsPost.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = newsPost.author,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSecondary
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = newsPost.publishedAt,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSecondary
            )
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

    NewsList(news = newsPost) {

    }
}