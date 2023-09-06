package com.tirgei.taarifa.ui.details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsAppBar(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    onFavoritePressed: () -> Unit,
    onSharePressed: () -> Unit
) {
    Row(
        modifier = modifier.padding(10.dp)
    ) {
        IconButton(onClick = onBackPressed) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = onFavoritePressed) {
            Icon(
                imageVector = Icons.Rounded.FavoriteBorder,
                contentDescription = "Favorite",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }

        IconButton(onClick = onSharePressed) {
            Icon(
                imageVector = Icons.Rounded.Share,
                contentDescription = "Share",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}