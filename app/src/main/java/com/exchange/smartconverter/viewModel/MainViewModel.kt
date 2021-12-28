package com.exchange.smartconverter.viewModel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.exchange.smartconverter.data.Repository
import com.exchange.smartconverter.models.CurrencyConvert
import com.exchange.smartconverter.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    var exchangeRatesResponse: MutableLiveData<NetworkResult<CurrencyConvert>> = MutableLiveData()

    fun getExchangeRates(queries: Map<String, String>) {
        viewModelScope.launch {
            getExchangeRateSafeCall(queries)
        }
    }

    private suspend fun getExchangeRateSafeCall(queries: Map<String, String>) {
        if (checkInternetConnection()) {
            try {
                val response = repository.remote.getExchangeRates(queries)
                exchangeRatesResponse.value = handleExchangeRatesResponse(response)
            } catch (e: Exception) {
                exchangeRatesResponse.value = NetworkResult.Error(message = "No Response.....")
            }
        } else {
            exchangeRatesResponse.value = NetworkResult.Error(message = "No InternetConnection")
        }
    }

    private fun handleExchangeRatesResponse(response: Response<CurrencyConvert>): NetworkResult<CurrencyConvert>? {
        return when {
            response.message().toString().contains("timeout") -> {
                NetworkResult.Error(message = "Time Out")
            }
            response.isSuccessful -> {
                val exchangeResponse = response.body()
                NetworkResult.Success(data = exchangeResponse!!)
            }
            else -> {
                NetworkResult.Error(message = "Could Not Fetch Results")
            }
        }
    }

    private fun checkInternetConnection(): Boolean {
        val connectivityManager =
            getApplication<Application>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}