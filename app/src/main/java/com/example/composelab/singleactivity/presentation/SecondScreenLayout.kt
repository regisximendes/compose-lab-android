package com.example.composelab.singleactivity.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composelab.theme.ComposeLabTheme

@Composable
fun SecondScreenLayout(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "This is the SECOND SCREEN")
        Button(
            onClick = {
                navController.navigate("third")
            }
        ) {
            Text(text = "Navigate to THIRD SCREEN")
        }
        Spacer(modifier = Modifier.height(5.dp))
        Button(
            onClick = {
                navController.navigate("third") {
                    popUpTo("first")
                }
            }
        ) {
            Text(text = "Navigate to THIRD SCREEN pop to first")
        }
        Text(
            text = "2",
            fontSize = 150.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    val navController = rememberNavController()
    ComposeLabTheme {
        SecondScreenLayout(navController)
    }
}