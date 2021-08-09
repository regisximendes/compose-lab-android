package com.example.composelab.feed.domain

object FeedPostFactory {

    fun makeFeedPostList(count: Int = 10) = mutableListOf<FeedPost>().apply {
        repeat(count) {
            add(if (it % 2 == 0) makeImagePost() else makeTextPost())
        }
    }

    fun makeTextPost() = FeedPost.TextPost(
        merchant = makeMerchant(),
        product = makeProduct(),
        text = "Está caro pra caramba!!"
    )

    fun makeImagePost() = FeedPost.ImagePost(
        merchant = makeMerchant(),
        product = makeProduct(),
        imageUrl = "https://agendasorocaba.com.br/wp-content/uploads/2019/07/McDonalds-02.jpg"
    )

    fun makeMerchant() = Merchant(
        name = "McDonald's ",
        status = "Aberto",
        imageUrl = "https://store-images.s-microsoft.com/image/apps.16337.9007199266250163.293580a2-5012-424d-b06c-1eb7220cd6e5.a3be4897-772d-484c-9209-bfeaeb4898c8?mode=scale&q=90&h=300&w=300"
    )

    fun makeProduct() = Product(
        name = "Big Mac",
        likeCount = 12,
        isLikeClicked = false,
        shareUrl = "https://agendasorocaba.com.br/wp-content/uploads/2019/07/McDonalds-02.jpg",
        originalPrice = "R$ 31,00",
        price = "18,00"
    )
}