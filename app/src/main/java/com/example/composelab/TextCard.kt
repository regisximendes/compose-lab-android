package com.example.composelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelab.ui.theme.ComposeLabTheme
import com.example.composelab.ui.theme.model.Post
import com.example.composelab.ui.theme.model.PostFactory

@Composable
fun TextCard(textPost: Post.TextPost) {
    Column {
        CardHeader(textPost.merchant)
        Row {
            Text(text = textPost.text)
        }
        CardFooter(textPost.product)
    }
}

@Preview(showBackground = true)
@Composable
fun TextCardPreview() {
    ComposeLabTheme {
        TextCard(PostFactory.makeTextPost())
    }
}
