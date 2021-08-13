package com.example.composelab.feed.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.composelab.feed.domain.FeedPostFactory
import com.example.composelab.feed.domain.Merchant

class SampleMerchantProvider: PreviewParameterProvider<Merchant> {
    override val values = createMerchantSequence()
    override val count: Int = values.count()

    private fun createMerchantSequence() =
        sequenceOf(
            FeedPostFactory.makeMerchant(),
            FeedPostFactory.makeMerchant()
        )
}