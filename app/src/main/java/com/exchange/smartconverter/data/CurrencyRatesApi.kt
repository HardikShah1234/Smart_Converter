package com.exchange.smartconverter.data

import com.exchange.smartconverter.models.CurrencyConvert
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CurrencyRatesApi {

    @GET("latest?key=w7gw8wlw0HtanVaJxDRvlGkJK0xzCimS")
    suspend fun getExchangeRates(@QueryMap queries: Map<String, String>): Response<CurrencyConvert>
}