package com.example.composelab.feed.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.composelab.feed.domain.FeedPost
import com.example.composelab.feed.domain.FeedPostFactory
import com.example.composelab.theme.ComposeLabTheme

class FeedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn {
                        items(FeedPostFactory.makeFeedPostList()) { post ->
                            when (post) {
                                is FeedPost.TextPost -> FeedTextCard(textPost = post)
                                is FeedPost.ImagePost -> FeedImageCard(imagePost = post)
                            }
                        }
                    }
                }
            }
        }
    }
}