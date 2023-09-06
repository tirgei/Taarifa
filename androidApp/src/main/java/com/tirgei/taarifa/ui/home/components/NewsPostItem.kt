package com.tirgei.taarifa.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tirgei.taarifa.domain.models.NewsPost

@Composable
fun NewsPostItem(
    modifier: Modifier = Modifier,
    newsPost: NewsPost,
    onNewsClick: (NewsPost) -> Unit
) {
    Row(
        modifier = modifier
            .padding(vertical = 16.dp, horizontal = 10.dp)
            .clickable { onNewsClick(newsPost) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        NewsImage(
            imageUrl = newsPost.urlToImage,
            description = newsPost.title
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = newsPost.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = newsPost.publishedAt,
                style = MaterialTheme.typography.displaySmall
            )
        }
    }

}

@Composable
fun NewsImage(imageUrl: String, description: String) {
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(imageUrl)
        .crossfade(true)
        .build()

    AsyncImage(
        model = imageRequest,
        contentDescription = description,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(100.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}