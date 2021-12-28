package com.exchange.smartconverter.models


import com.google.gson.annotations.SerializedName

data class CurrencyConvert(
    @SerializedName("target")
    val target: String,
    @SerializedName("rates")
    val rates: Rates,
    @SerializedName("timestamp")
    val timestamp: Int
)