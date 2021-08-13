package com.example.composelab.feed.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
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

        /**exemplo com foreach*/
//                    Column(modifier = Modifier
//                        .fillMaxWidth()
//                        .verticalScroll(ScrollState(0))) {
//                        FeedPostFactory.makeFeedPostList(10).forEach { post ->
//                            when (post) {
//                                is FeedPost.TextPost -> FeedTextCard(textPost = post)
//                                is FeedPost.ImagePost -> FeedImageCard(imagePost = post)
//                            }
//                        }
//                    }
                }
            }
        }
    }
}