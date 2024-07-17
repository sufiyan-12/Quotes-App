package com.prac.quotesapp

import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("quote") val quoteMessage: String,
    @SerializedName("author") val quoteAuthor: String
)
