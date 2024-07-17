package com.prac.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import com.google.gson.Gson

object DataManager {

    var quotesList = emptyArray<QuoteModel>()
    val currentScreen = mutableStateListOf(Screen.QUOTES_LIST_SCREEN)
    val isDataLoaded = mutableStateListOf(false)
    val currentQuote = mutableStateListOf(QuoteModel("", ""))

    fun loadQuotesFromAssets(context: Context) {
        val inputStream = context.assets.open("data.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quotesList = gson.fromJson(json, Array<QuoteModel>::class.java)
        isDataLoaded[0] = true
    }
}