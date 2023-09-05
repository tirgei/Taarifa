package com.tirgei.taarifa.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tirgei.taarifa.domain.models.NewsPost

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
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = newsPost.author,
                style = MaterialTheme.typography.displaySmall
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = newsPost.publishedAt,
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}