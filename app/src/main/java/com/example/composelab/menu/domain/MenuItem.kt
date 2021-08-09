package com.example.composelab.menu.domain

import android.content.Context

interface MenuItem {
    val title: String
    val navigate: (Context) -> Unit
}