package com.crazyvibes.quotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.crazyvibes.quotesapp.models.Quote


//type comp or prev for create composable functions.

@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote) -> Unit) {
    Card(elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(quote) }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                imageVector = Icons.Filled.FormatQuote, contentDescription = "Quote",
                colorFilter = ColorFilter.tint(Color.White), alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180F)
                    .background(Color.Black)
            )

            Spacer(modifier = Modifier.padding(4.dp)) //to create space

            Column(modifier = Modifier.weight(1f)) { //take all available space after image
                Text(
                    text = quote.quote,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )

                Box(
                    modifier = Modifier
                        .background(Color(0xFFEEEEEE))
                        .fillMaxWidth(.4f) //take 40% width
                        .height(1.dp)
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
            }
        }
    }
}


