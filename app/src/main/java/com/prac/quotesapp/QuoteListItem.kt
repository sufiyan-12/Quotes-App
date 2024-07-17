package com.prac.quotesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteListItem(quoteModel: QuoteModel, onItemClicked: (quoteModel: QuoteModel) -> Unit) {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = { onItemClicked(quoteModel) },
        modifier = Modifier.padding(6.dp)
            .height(80.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(8.dp)) {
            Image(painter = painterResource(id = R.drawable.icon_quote),
                colorFilter = ColorFilter.tint(color = Color.Black),
                modifier = Modifier
                    .rotate(180f)
                    .weight(.1f),
                contentDescription = "quote_icon"
            )
            ItemDescription(quoteModel.quoteMessage, quoteModel.quoteAuthor, Modifier.weight(.9f))
        }
    }
}

@Composable
private fun ItemDescription(quoteMessage: String, quoteAuthor: String, modifier: Modifier){
    Column(modifier = modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)
    ) {
        Text(text = quoteMessage,
            fontSize = 16.sp,
            color = Color.Black,
            style = MaterialTheme.typography.titleSmall)
        Text(text = quoteAuthor,
            fontSize = 14.sp,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic
        )
    }
}