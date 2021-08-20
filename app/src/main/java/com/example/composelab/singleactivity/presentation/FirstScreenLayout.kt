package com.example.composelab.singleactivity.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composelab.theme.ComposeLabTheme

@Composable
fun FirstScreenLayout(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the FIRST SCREEN")
        Button(
            onClick = {
                navController.navigate("second")
            }
        ) {
            Text(text = "Navigate to SECOND SCREEN")
        }
        Text(
            text = "1",
            fontSize = 150.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    val navController = rememberNavController()
    ComposeLabTheme {
        FirstScreenLayout(navController)
    }
}