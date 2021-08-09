package com.example.composelab.feed.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.composelab.feed.domain.FeedPost
import com.example.composelab.feed.domain.FeedPostFactory
import com.example.composelab.theme.ComposeLabTheme

@Composable
fun FeedImageCard(imagePost: FeedPost.ImagePost) {
    Column(modifier = Modifier.fillMaxWidth()) {
        FeedCardHeader(imagePost.merchant)
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(imagePost.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )
        }
        FeedCardFooter(imagePost.product)
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedImageCardPreview() {
    ComposeLabTheme {
        FeedImageCard(FeedPostFactory.makeImagePost())
    }
}