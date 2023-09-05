package com.tirgei.taarifa.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewsCategoryItem(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Column(
        modifier = modifier.padding(horizontal = 12.dp)
            .clickable { onSelect() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.alpha(if (isSelected) 1f else 0.4f)
        )

        Box(
            modifier = Modifier
                .width(20.dp)
                .height(2.dp)
                .background(if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.background)
                .clip(RoundedCornerShape(10.dp))
        )
    }
}

@Preview
@Composable
fun NewsCategoryItemPreview() {
    NewsCategoryItem(title = "For You", isSelected = true) {
        
    }
}