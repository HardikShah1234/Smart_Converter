package com.exchange.smartconverter.models


import com.google.gson.annotations.SerializedName

data class Rates(
    @SerializedName("ADA")
    val aDA: Double,
    @SerializedName("AED")
    val aED: Double,
    @SerializedName("AUD")
    val aUD: Double,
    @SerializedName("BAT")
    val bAT: Double,
    @SerializedName("BDT")
    val bDT: Double,
    @SerializedName("BGN")
    val bGN: Double,
    @SerializedName("BIF")
    val bIF: Double,
    @SerializedName("BNB")
    val bNB: Double,
    @SerializedName("BRL")
    val bRL: Double,
    @SerializedName("BTC")
    val bTC: Double,
    @SerializedName("CAD")
    val cAD: Double,
    @SerializedName("CHF")
    val cHF: Double,
    @SerializedName("CNY")
    val cNY: Double,
    @SerializedName("CZK")
    val cZK: Double,
    @SerializedName("DKK")
    val dKK: Double,
    @SerializedName("DOT")
    val dOT: Double,
    @SerializedName("EGP")
    val eGP: Double,
    @SerializedName("ETH")
    val eTH: Double,
    @SerializedName("EUR")
    val eUR: Double,
    @SerializedName("FIL")
    val fIL: Double,
    @SerializedName("GBP")
    val gBP: Double,
    @SerializedName("GHS")
    val gHS: Double,
    @SerializedName("HKD")
    val hKD: Double,
    @SerializedName("HUF")
    val hUF: Double,
    @SerializedName("IDR")
    val iDR: Double,
    @SerializedName("ILS")
    val iLS: Double,
    @SerializedName("INR")
    val iNR: Double,
    @SerializedName("IOT")
    val iOT: Double,
    @SerializedName("JPY")
    val jPY: Double,
    @SerializedName("KES")
    val kES: Double,
    @SerializedName("KZT")
    val kZT: Double,
    @SerializedName("LTC")
    val lTC: Double,
    @SerializedName("MXN")
    val mXN: Double,
    @SerializedName("MYR")
    val mYR: Double,
    @SerializedName("NEO")
    val nEO: Double,
    @SerializedName("NOK")
    val nOK: Double,
    @SerializedName("NZD")
    val nZD: Double,
    @SerializedName("OMG")
    val oMG: Double,
    @SerializedName("PHP")
    val pHP: Double,
    @SerializedName("PLN")
    val pLN: Double,
    @SerializedName("RON")
    val rON: Double,
    @SerializedName("RUB")
    val rUB: Double,
    @SerializedName("RWF")
    val rWF: Double,
    @SerializedName("SEK")
    val sEK: Double,
    @SerializedName("SGD")
    val sGD: Double,
    @SerializedName("THB")
    val tHB: Double,
    @SerializedName("TRX")
    val tRX: Double,
    @SerializedName("TRY")
    val tRY: Double,
    @SerializedName("UAH")
    val uAH: Double,
    @SerializedName("UNI")
    val uNI: Double,
    @SerializedName("USD")
    val uSD: Double,
    @SerializedName("XAF")
    val xAF: Double,
    @SerializedName("XAG")
    val xAG: Double,
    @SerializedName("XAU")
    val xAU: Double,
    @SerializedName("XLM")
    val xLM: Double,
    @SerializedName("XMR")
    val xMR: Double,
    @SerializedName("ZAR")
    val zAR: Double,
    @SerializedName("ZEC")
    val zEC: Double,
    @SerializedName("ZMW")
    val zMW: Double
) {
    val exchangeList: MutableList<Double>
        get() = mutableListOf(
            aDA,
            bTC,
            eTH
        )
}