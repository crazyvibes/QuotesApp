package com.crazyvibes.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.crazyvibes.quotesapp.models.Quote
import com.google.gson.Gson
import java.nio.charset.Charset

/** DataManger class handling the state of data and current screens. */

object DataManager {
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote: Quote? = null
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false) //always thread safe

    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json") //open asset folder and get a input stream
        val size: Int = inputStream.available() //read input stream into byte form
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8) //after read convert into string
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java) //get in form of array
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quote
            currentPage.value = Pages.DETAILS
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}