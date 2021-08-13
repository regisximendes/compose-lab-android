package com.example.composelab.feed.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.composelab.feed.domain.FeedPostFactory
import com.example.composelab.feed.domain.Product

class SampleProductProvider: PreviewParameterProvider<Product> {
    override val values = createProductSequence()
    override val count: Int = values.count()

    private fun createProductSequence() =
        sequenceOf(
            FeedPostFactory.makeProduct(),
            FeedPostFactory.makeProduct()
        )
}