package com.example.composelab.feed.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composelab.feed.domain.FeedPost
import com.example.composelab.feed.viewmodel.State

@Composable
fun FeedList(feedList: List<FeedPost>, state: State) {

    when(state) {
        State.LOADING -> Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Loading()
        }
        State.SUCCESS -> LazyColumn {
            items(feedList) { post ->
                when (post) {
                    is FeedPost.TextPost -> FeedTextCard(textPost = post)
                    is FeedPost.ImagePost -> FeedImageCard(imagePost = post)
                }
            }
        }
    }
}