package com.prac.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            Thread.sleep(2000)
            DataManager.loadQuotesFromAssets(this@MainActivity)
        }
        setContent {
            App()
        }
    }
}

@Composable
private fun App(){
    if(DataManager.isDataLoaded[0]){
        val quotesList = DataManager.quotesList
        if(quotesList.isNotEmpty()){
            if(DataManager.currentScreen[0] == Screen.QUOTES_LIST_SCREEN){
                // show list
                QuoteList(quotesList){
                    DataManager.apply {
                        currentQuote[0] = it
                        currentScreen[0] = Screen.QUOTE_DETAIL_SCREEN
                    }
                }
            } else{
                QuoteDetail(DataManager.currentQuote[0])
            }
        }
    } else{
        // show loading
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
            ) {
            Text(text = "Loading...",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
                )
        }
    }
}

enum class Screen {
    QUOTES_LIST_SCREEN,
    QUOTE_DETAIL_SCREEN
}