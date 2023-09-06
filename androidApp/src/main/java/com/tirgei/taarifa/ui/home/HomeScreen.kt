package com.tirgei.taarifa.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.tirgei.taarifa.domain.models.NewsPost
import com.tirgei.taarifa.domain.models.NewsSource
import com.tirgei.taarifa.theme.TaarifaTheme
import com.tirgei.taarifa.ui.Screen
import com.tirgei.taarifa.ui.home.components.AppBar
import com.tirgei.taarifa.ui.home.components.NewsCategoryItem
import com.tirgei.taarifa.ui.home.components.NewsPostItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = koinViewModel()
) {
    val homeScreenState by viewModel.homeScreenState.collectAsStateWithLifecycle()
    val newsCategoriesState by viewModel.newsCategoriesState.collectAsStateWithLifecycle()
    val newsList by viewModel.newsListState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetchNewsCategories()
        viewModel.fetchNewsPosts()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        AppBar(
            modifier = Modifier.fillMaxWidth()
        )

        Box(modifier = Modifier.fillMaxSize()) {
            if (homeScreenState.isLoading) {
                CircularProgressIndicator()
            } else if (homeScreenState.isErrorState) {
                Text(text = "Something went wrong.")
            } else {
                Column {
                    CategoriesList(newsCategoriesState)

                    NewsList(news = newsList) {
                        navController.navigate("${Screen.Details.route}/${it.title}")
                    }
                }
            }
        }
    }
}

@Composable
fun CategoriesList(categories: List<String>) {
    var selectedItem by remember {
        mutableIntStateOf(1)
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        itemsIndexed(categories) { index, category ->
            NewsCategoryItem(
                title = category,
                isSelected = index == selectedItem
            ) {
                selectedItem = index
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