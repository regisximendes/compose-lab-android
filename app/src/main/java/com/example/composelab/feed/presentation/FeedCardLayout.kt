package com.example.composelab.feed.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.composelab.feed.domain.*
import com.example.composelab.feed.provider.SampleMerchantProvider
import com.example.composelab.feed.provider.SampleProductProvider

@Preview(showBackground = true)
@Composable
fun FeedCardHeader(@PreviewParameter(SampleMerchantProvider::class) merchant: Merchant) {
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

@Preview(showBackground = true)
@Composable
fun FeedCardFooter(@PreviewParameter(SampleProductProvider::class) product: Product) {
    val currentPrice = if (product.price.isEmpty())
        product.originalPrice else product.price

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
                Text(text = currentPrice)
                Spacer(modifier = Modifier.width(8.dp))
                TextOrGone(
                    color = Color.LightGray,
                    text = product.originalPrice,
                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
                )
            }
        }
    }
}

@Composable
fun TextOrGone(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {
    if (text.isNotEmpty()) {
        Text(
            text = text,
            modifier = modifier,
            onTextLayout = onTextLayout,
            color = color,
            fontSize = fontSize,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            textDecoration = textDecoration,
            textAlign = textAlign,
            lineHeight = lineHeight,
            overflow = overflow,
            softWrap = softWrap,
            maxLines = maxLines,
            style = style
        )
    }
}