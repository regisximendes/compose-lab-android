package com.example.composelab.menu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.composelab.menu.domain.MenuItemFactory
import com.example.composelab.theme.ComposeLabTheme

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLabTheme() {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()) {

                    LazyColumn() {
                        items(MenuItemFactory.make()) { menuItem ->
                            MenuItemLayout(menuItem)
                        }
                    }
                }
            }
        }
    }
}