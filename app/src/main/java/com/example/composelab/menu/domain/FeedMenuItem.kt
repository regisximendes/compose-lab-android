package com.example.composelab.menu.domain

import android.content.Context
import android.content.Intent
import com.example.composelab.feed.presentation.FeedActivity

class FeedMenuItem : MenuItem {
    override val title: String = "Feed"

    override val navigate: (Context) -> Unit = { context ->
        context.startActivity(Intent(context, FeedActivity::class.java))
    }
}