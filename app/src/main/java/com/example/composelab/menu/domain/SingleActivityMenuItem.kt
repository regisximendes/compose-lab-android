package com.example.composelab.menu.domain

import android.content.Context
import android.content.Intent
import com.example.composelab.singleactivity.presentation.SingleActivity
import com.example.composelab.singleactivity.presentation.TesteActivity

class SingleActivityMenuItem: MenuItem {
    override val title: String = "Single Activity"

    override val navigate: (Context) -> Unit = { context ->
        context.startActivity(Intent(context, TesteActivity::class.java))
    }
}