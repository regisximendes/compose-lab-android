package com.example.composelab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.composelab.ui.theme.ComposeLabTheme
import com.example.composelab.ui.theme.model.Merchant
import com.example.composelab.ui.theme.model.PostFactory
import com.example.composelab.ui.theme.model.Product

@Composable
fun CardFooter(product: Product) {
    Row(
        modifier = Modifier.padding(20.dp)
    ) {
        Column {
            Text(text = product.name)
            Row {
                Text(text = product.price)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = product.originalPrice)
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_user_avatar),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Composable
fun CardHeader(merchant: Merchant) {
    Row(
        modifier = Modifier.padding(20.dp)
    ) {

        Image(
            painter = rememberImagePainter(merchant.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .fillMaxHeight()
                .fillMaxWidth()

        )

        Column(
            modifier = Modifier.padding(start = 12.dp)
        ) {
            Text(text = merchant.name)
            Text(text = merchant.status)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardHeaderPreview() {
    ComposeLabTheme {
        CardHeader(PostFactory.makeMerchant())
    }
}

@Preview(showBackground = true)
@Composable
fun CardFooterPreview() {
    ComposeLabTheme {
        CardFooter(PostFactory.makeProduct())
    }
}