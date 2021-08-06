package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.composelab.ui.theme.ComposeLabTheme
import com.example.composelab.ui.theme.model.Post
import com.example.composelab.ui.theme.model.PostFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn {
                        items(PostFactory.makeProductList()) { post ->
                            when (post) {
                                is Post.TextPost -> TextCard(textPost = post)
                                is Post.ImagePost -> ImageCard(imagePost = post)
                            }
                        }
                    }
                }
            }
        }
    }
}