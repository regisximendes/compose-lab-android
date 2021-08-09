package com.example.composelab.menu.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.menu.domain.MenuItem
import com.example.composelab.menu.domain.MenuItemFactory
import com.example.composelab.theme.ComposeLabTheme


@Composable
fun MenuItemLayout(menuItem: MenuItem) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = { menuItem.navigate(context) })
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = menuItem.title, fontSize = 24.sp)
        }
        Divider(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuItemPreview() {
    ComposeLabTheme {
        MenuItemLayout(MenuItemFactory.make().first())
    }
}