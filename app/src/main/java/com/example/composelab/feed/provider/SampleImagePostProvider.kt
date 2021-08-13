package com.example.composelab.feed.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.composelab.feed.domain.FeedPost
import com.example.composelab.feed.domain.FeedPostFactory
import com.example.composelab.feed.domain.Product

class SampleImagePostProvider: PreviewParameterProvider<FeedPost.ImagePost> {
    override val values = createImagePostSequence()
    override val count: Int = values.count()

    private fun createImagePostSequence() =
        sequenceOf(
            FeedPostFactory.makeImagePost(),
            FeedPostFactory.makeImagePost()
        )
}