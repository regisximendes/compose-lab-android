package com.example.composelab.feed.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.feed.domain.FeedPost
import com.example.composelab.feed.domain.FeedPostFactory
import com.example.composelab.theme.ComposeLabTheme

@Composable
fun FeedTextCard(textPost: FeedPost.TextPost) {
    Column(modifier = Modifier.fillMaxWidth()) {
        FeedCardHeader(textPost.merchant)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(Color.Red),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = textPost.text,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
        FeedCardFooter(textPost.product)
        Row(modifier = Modifier.fillMaxWidth()) { Divider() }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedTextCardPreview() {
    ComposeLabTheme {
        FeedTextCard(FeedPostFactory.makeTextPost())
    }
}
