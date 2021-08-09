package com.example.composelab.menu.domain

object MenuItemFactory {

    fun make() = listOf(
        FeedMenuItem(),
        CheckoutMenuItem()
    )
}