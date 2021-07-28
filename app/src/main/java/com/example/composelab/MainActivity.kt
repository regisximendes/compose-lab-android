package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelab.ui.theme.ComposeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BuildCard()
                }
            }
        }
    }
}

@Composable
fun BuildCard() {

    Column{
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_user_avatar),
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(32.dp)
            )

           Column(
               modifier = Modifier.padding(start = 12.dp)
           ) {
               Text(text = "Novo post titulo")
               Text(text = "Aberto Agora")
           }
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_user_avatar),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Column {
                Text(text = "Titulo do produto")
                Row {
                    Text(text = "R$ 19,90")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "R$ 25,90")
                }
            }
            Image(
                painter = painterResource(id = R.drawable.ic_user_avatar),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLabTheme {
        BuildCard()
    }
}