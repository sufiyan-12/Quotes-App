package com.prac.quotesapp

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuoteDetail(quoteModel: QuoteModel) {
    BackHandler {
        DataManager.currentScreen[0] = Screen.QUOTES_LIST_SCREEN
    }
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
            modifier = Modifier
                .padding(36.dp)
                .height(250.dp)
                .fillMaxWidth(1f)
            ) {
            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(18.dp)) {
                Image(painter = painterResource(id = R.drawable.icon_quote)
                    , contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .rotate(180f),
                    colorFilter = ColorFilter.tint(Color.Black)
                )
                Column(modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    Text(text = quoteModel.quoteMessage,
                        fontSize = 16.sp,
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = quoteModel.quoteAuthor,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}