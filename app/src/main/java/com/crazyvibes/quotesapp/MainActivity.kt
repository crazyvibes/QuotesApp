package com.crazyvibes.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.crazyvibes.quotesapp.screens.QuoteDetails
import com.crazyvibes.quotesapp.screens.QuoteListScreen
import com.crazyvibes.quotesapp.ui.theme.QuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * - Data always handle in top composable.
 * - Event always flow from child to parent composable.
 * - Here, onClick function define in top composable, and getting data from child composable.
 * - DataManger class handling the state of data and current screens.
 * - There is only one activity(MainActivity) act as a container.
 * */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getting data in background thread
        CoroutineScope(Dispatchers.IO).launch {
            // delay(5000)   //added for testing purpose
            DataManager.loadAssetFromFile(applicationContext)
        }

        setContent {
            App()
        }
    }
}

@Composable
fun App() {

    if (DataManager.isDataLoaded.value) {  //if data have loaded
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                //defined onclick here
                DataManager.switchPages(it)
            }
        } else {
            //passing quote in QuoteDetails page
            DataManager.currentQuote?.let { QuoteDetails(quote = it) }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(text = "Loading....", style = MaterialTheme.typography.h6)
        }

    }
}

enum class Pages {
    LISTING,
    DETAILS
}
