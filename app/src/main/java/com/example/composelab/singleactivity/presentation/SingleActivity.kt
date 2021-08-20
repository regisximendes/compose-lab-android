package com.example.composelab.singleactivity.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composelab.theme.ComposeLabTheme

// https://developer.android.com/jetpack/compose/navigation

class SingleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLabTheme {
                val navController = rememberNavController()

                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize(),
                    ) {
                    NavHost(navController = navController, startDestination = "first") {
                        composable("first") { FirstScreenLayout(navController) }
                        composable("second") { SecondScreenLayout(navController) }
                        composable("third") { ThirdScreenLayout() }
                    }
                }
            }
        }
    }
}