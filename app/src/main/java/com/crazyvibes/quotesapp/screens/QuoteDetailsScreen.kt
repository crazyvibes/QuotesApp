package com.crazyvibes.quotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.crazyvibes.quotesapp.DataManager
import com.crazyvibes.quotesapp.R
import com.crazyvibes.quotesapp.models.Quote

/** Quote detail screen */
@Composable
fun QuoteDetails(quote: Quote) {

    //handling back button
    BackHandler() {
        DataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f) //use all width and height and make it center
            .background(
                Brush.linearGradient(  //can be use different gradient
                    colors = listOf(
                        Color(0xFFff000),
                        Color(0xFFE3E3E3),
                    )
                )
            )
    ) {
        Card(
            elevation = 4.dp,
            modifier = Modifier.padding(32.dp)
        )
        {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp, 24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180f)
                )
                Text(
                    text = quote.quote,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)), //must import R manually
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = quote.author,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),//must import R manually
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}