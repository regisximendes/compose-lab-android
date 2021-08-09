package com.example.composelab.feed.domain

sealed class FeedPost {
    abstract val merchant: Merchant
    abstract val product: Product

    data class ImagePost(
        override val merchant: Merchant,
        override val product: Product,
        val imageUrl: String
    ) : FeedPost()

    data class TextPost(
        override val merchant: Merchant,
        override val product: Product,
        val text: String
    ) : FeedPost()
}

data class Merchant(
    val name: String,
    val status: String,
    val imageUrl: String,
)

data class Product(
    val name: String,
    val likeCount: Int,
    val isLikeClicked: Boolean,
    val shareUrl: String,
    val price: String,
    val originalPrice: String,
)
