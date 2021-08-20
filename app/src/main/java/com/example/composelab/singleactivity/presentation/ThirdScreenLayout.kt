package com.example.composelab.singleactivity.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composelab.theme.ComposeLabTheme

@Composable
fun ThirdScreenLayout() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the THIRD SCREEN")
        Text(
            text = "3",
            fontSize = 150.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview() {
    ComposeLabTheme {
        ThirdScreenLayout()
    }
}