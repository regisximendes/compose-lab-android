package com.example.composelab.feed.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.composelab.feed.domain.Merchant
import com.example.composelab.feed.domain.FeedPostFactory
import com.example.composelab.feed.domain.Product
import com.example.composelab.theme.ComposeLabTheme

@Composable
fun FeedCardHeader(merchant: Merchant) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.width(42.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = rememberImagePainter(merchant.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.LightGray)
                    .height(42.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(text = merchant.name)
            Text(text = merchant.status)
        }
    }
}

@Composable
fun FeedCardFooter(product: Product) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(text = product.name)
            Row {
                Text(text = product.price)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    color = Color.LightGray,
                    text = product.originalPrice,
                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedCardHeaderPreview() {
    ComposeLabTheme {
        FeedCardHeader(FeedPostFactory.makeMerchant())
    }
}

@Preview(showBackground = true)
@Composable
fun FeedCardFooterPreview() {
    ComposeLabTheme {
        FeedCardFooter(FeedPostFactory.makeProduct())
    }
}