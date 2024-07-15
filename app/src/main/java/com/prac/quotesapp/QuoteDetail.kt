package com.prac.quotesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun QuoteDetail() {
    Box(contentAlignment =  Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFe3e3e3)
                    )
                )
            )
    ) {
        Card(elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.padding(36.dp)
            ) {
            Column(verticalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.icon_quote), contentDescription = "")
            }
        }
    }
}

@Composable
fun QuoteDetailItem(){
    Card {
        QuoteListItem(quoteMessage = "", quoteAuthor = "")
    }
}