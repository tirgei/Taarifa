package com.tirgei.taarifa.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tirgei.taarifa.domain.models.NewsPost
import com.tirgei.taarifa.ui.details.components.DetailsAppBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    navController: NavHostController,
    newsPostId: String,
    viewModel: DetailsViewModel = koinViewModel()
) {
    val detailsScreenState by viewModel.detailsScreenState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetchNewsPost(newsPostId)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (detailsScreenState.isLoading) {
            CircularProgressIndicator()
        } else if (detailsScreenState.isErrorState || detailsScreenState.newsPost == null) {
            Text(text = "Something went wrong")
        } else {
            val newsPost = detailsScreenState.newsPost!!

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
            ) {
                item {
                    ImageSection(
                        image = newsPost.urlToImage,
                        description = newsPost.title
                    )
                }

                item {
                    NewsDetails(newsPost = newsPost)
                }
            }

            DetailsAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                onBackPressed = { navController.popBackStack() },
                onFavoritePressed = { print("Favorite") },
                onSharePressed = { print("Share") }
            )
        }
    }
}

@Composable
fun ImageSection(image: String, description: String) {
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(image)
        .crossfade(true)
        .build()

    AsyncImage(
        model = imageRequest,
        contentDescription = description,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    )
}

@Composable
fun NewsDetails(newsPost: NewsPost) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        AuthorDetails(author = newsPost.author)

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = newsPost.title,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = newsPost.publishedAt,
            style = MaterialTheme.typography.displaySmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = newsPost.content,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun AuthorDetails(author: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = author,
                tint = MaterialTheme.colorScheme.onTertiary,
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Article By",
                style = MaterialTheme.typography.displaySmall
            )

            Text(
                text = author,
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}