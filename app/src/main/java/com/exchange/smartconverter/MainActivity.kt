package com.exchange.smartconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.exchange.smartconverter.composables.ListScreen
import com.exchange.smartconverter.composables.provideQueries
import com.exchange.smartconverter.models.Rates
import com.exchange.smartconverter.ui.theme.SmartConverterTheme
import com.exchange.smartconverter.utils.NetworkResult
import com.exchange.smartconverter.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val exchangeRateList = mutableStateListOf<Rates>()
    private lateinit var mainViewModel: MainViewModel

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartConverterTheme {
                mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
                mainViewModel.getExchangeRates(provideQueries("EUR"))
                mainViewModel.exchangeRatesResponse.observe(this as LifecycleOwner, { response ->
                    when (response) {
                        is NetworkResult.Success -> {
                            val responseBody = response.data?.rates!!
                            exchangeRateList.clear()
                            exchangeRateList.addAll(listOf(responseBody))
                        }
                        is NetworkResult.Error -> {
                            Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                        }
                        is NetworkResult.Loading -> {
                            Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
                ListScreen(
                    context = this,
                    mainViewModel = mainViewModel,
                    response = exchangeRateList
                )
            }
        }
    }
}