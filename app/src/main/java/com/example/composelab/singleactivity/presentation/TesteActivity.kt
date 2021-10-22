package com.example.composelab.singleactivity.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelab.R
import com.example.composelab.feed.domain.FeedPostFactory
import com.example.composelab.feed.presentation.FeedTextCard
import java.lang.reflect.Modifier

class TesteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        val composeView = findViewById<ComposeView>(R.id.compose_view)
        val formComposeView = findViewById<ComposeView>(R.id.form_compose_view)
        var textToChange = findViewById<TextView>(R.id.title_text)

        composeView.setContent {
            FeedTextCard(FeedPostFactory.makeTextPost())
        }

        formComposeView.setContent {
            Form { name, email ->
                textToChange.text = "$name - $email"
            }
        }
    }
}

@Composable
fun Form(onBtnClick: (name: String, email: String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column {
        TextField(value = name, onValueChange = { name = it }, label = { Text(text = "Nome") })
        TextField(value = email, onValueChange = { email = it }, label = { Text(text = "Email") })
        Button(
            onClick = {
                onBtnClick(name, email)
            },
        ) {
            Text(text = "Enviar")
        }
    }
}