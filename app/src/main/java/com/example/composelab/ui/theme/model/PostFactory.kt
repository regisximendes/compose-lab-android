package com.example.composelab.ui.theme.model

object PostFactory {

    fun makeProductList(count: Int = 10) = mutableListOf<Post>().apply {
        repeat(count) {
            add(
                if (it % 2 == 0) {
                    makeImagePost()
                } else {
                    makeTextPost()
                }
            )
        }
    }

    fun makeTextPost() = Post.TextPost(
        merchant = makeMerchant(),
        product = makeProduct(),
        text = "Está caro pra caramba!!"
    )

    fun makeImagePost() = Post.ImagePost(
        merchant = makeMerchant(),
        product = makeProduct(),
        imageUrl = "https://agendasorocaba.com.br/wp-content/uploads/2019/07/McDonalds-02.jpg"
    )

    fun makeMerchant() = Merchant(
        name = "McDonald's ",
        status = "Aberto",
        imageUrl = " https://1.bp.blogspot.com/-fcolkHbrqYU/XyJAR1FcEdI/AAAAAAABzo4/OQaHcAY6j70T3KNeXuHSmDN40hOzXgpRQCLcBGAsYHQ/s1600/mc%2Blogos%2B4.jpg"
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