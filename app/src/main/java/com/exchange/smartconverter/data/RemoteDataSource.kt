package com.exchange.smartconverter.data

import com.exchange.smartconverter.models.CurrencyConvert
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val currencyRatesApi: CurrencyRatesApi
) {
    suspend fun getExchangeRates(queries: Map<String, String>): Response<CurrencyConvert> =
        currencyRatesApi.getExchangeRates(queries)
}