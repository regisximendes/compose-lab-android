package com.example.composelab.feed.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.composelab.feed.domain.FeedPost
import com.example.composelab.feed.domain.FeedPostFactory
import com.example.composelab.feed.domain.Product

class SampleTextPostProvider: PreviewParameterProvider<FeedPost.TextPost> {
    override val values = createTextPostSequence()
    override val count: Int = values.count()

    private fun createTextPostSequence() =
        sequenceOf(
            FeedPostFactory.makeTextPost(),
            FeedPostFactory.makeTextPost()
        )
}