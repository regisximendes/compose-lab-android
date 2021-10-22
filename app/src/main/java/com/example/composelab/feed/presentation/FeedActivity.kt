package com.example.composelab.feed.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.composelab.feed.domain.FeedPost
import com.example.composelab.feed.domain.FeedPostFactory
import com.example.composelab.feed.viewmodel.FeedViewModel
import com.example.composelab.theme.ComposeLabTheme
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composelab.feed.viewmodel.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedActivity : ComponentActivity() {

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.init()

        setContent {
            ComposeLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    FeedScreen(viewModel)

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

@Composable
fun FeedScreen(viewModel: FeedViewModel) {
    val feed: List<FeedPost> by viewModel.feedList.observeAsState(emptyList())
    val state: State by viewModel.state.observeAsState(State.LOADING)

    FeedList(feedList = feed, state = state)
}