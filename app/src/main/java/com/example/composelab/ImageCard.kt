package com.example.composelab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.composelab.ui.theme.ComposeLabTheme
import com.example.composelab.ui.theme.model.Post
import com.example.composelab.ui.theme.model.PostFactory

@Composable
fun ImageCard(imagePost: Post.ImagePost) {
    Column {
        CardHeader(imagePost.merchant)
        Row {
            Image(
                painter = rememberImagePainter(imagePost.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .height(200.dp),
            )
        }
        CardFooter(imagePost.product)
    }
}

@Preview(showBackground = true)
@Composable
fun ImageCardPreview() {
    ComposeLabTheme {
        ImageCard(PostFactory.makeImagePost())
    }
}