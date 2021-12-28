package com.exchange.smartconverter.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import com.exchange.smartconverter.models.Rates
import com.exchange.smartconverter.ui.theme.Aqua_700
import com.exchange.smartconverter.ui.theme.Label_Color
import com.exchange.smartconverter.ui.theme.White_900
import com.exchange.smartconverter.utils.Constants.Companion.APP_BAR_TITLE
import com.exchange.smartconverter.utils.NetworkResult
import com.exchange.smartconverter.viewModel.MainViewModel

@ExperimentalMaterialApi
@Composable
fun ListScreen(
    context: Context,
    mainViewModel: MainViewModel,
    response: SnapshotStateList<Rates>
) {
    val isDarkMode: Boolean = isSystemInDarkTheme()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = APP_BAR_TITLE,
                        fontSize = 24.sp,
                        color = if (isDarkMode) White_900 else Aqua_700,
                        style = TextStyle(
                            fontWeight = FontWeight.Black,
                            lineHeight = 30.sp
                        )
                    )
                },
                backgroundColor = if (isDarkMode) Color.Black else White_900,
                elevation = 0.dp
            )
        },
        content = {
            ListContent(response, mainViewModel, context)
        }
    )


}

@ExperimentalMaterialApi
@Composable
fun ListContent(
    response: SnapshotStateList<Rates>,
    mainViewModel: MainViewModel,
    context: Context
) {
    val fromCurrencyCode = remember { mutableStateOf("EUR") }
    val toCurrencyCode = remember { mutableStateOf("USD") }
    val amountValue = remember { mutableStateOf("") }
    val convertedAmount = remember { mutableStateOf("") }
    val singleConvertedAmount = remember { mutableStateOf("") }

    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = response) { item ->
            Column {
                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Australia",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "AUD",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Column(Modifier.padding(start = 8.dp)) {
                        Text(
                            text = item.aUD.toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Right
                        )
                    }
                }
                Divider()
                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Germany",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "EUR",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Column(Modifier.padding(start = 8.dp)) {
                        Text(
                            text = item.eUR.toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.End

                        )
                    }
                }
                Divider()
                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "India",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "INR",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Column(Modifier.padding(start = 8.dp)) {
                        Text(
                            text = item.iNR.toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Divider()
                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "United Kingdom",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "GBP",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Column(Modifier.padding(start = 8.dp)) {
                        Text(
                            text = item.gBP.toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Right
                        )
                    }
                }
                Divider()
                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Canada",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "CAD",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Column(Modifier.padding(start = 8.dp)) {
                        Text(
                            text = item.cAD.toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Right
                        )
                    }
                }
                Divider()
                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Bit Coin",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "BTC",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Column(Modifier.padding(start = 8.dp)) {

                        Text(
                            text = item.bTC.toBigDecimal().toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Right
                        )
                    }
                }
                Divider()
                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Ethereum",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "ETH",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Column(Modifier.padding(start = 8.dp)) {
                        Text(
                            text = item.eTH.toBigDecimal().toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Right
                        )
                    }
                }
                Divider()
                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "United States",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "USD",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Column(Modifier.padding(start = 8.dp)) {
                        Text(
                            text = item.uSD.toBigDecimal().toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Right
                        )
                    }
                }
                Divider()
                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Poland",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "PLN",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Column(Modifier.padding(start = 8.dp)) {
                        Text(
                            text = item.pLN.toBigDecimal().toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Right
                        )
                    }
                }
                Divider()
                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "New Zealand",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "NZD",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Column(Modifier.padding(start = 8.dp)) {
                        Text(
                            text = item.nZD.toBigDecimal().toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Right
                        )
                    }
                }
                Divider()
            }
            Spacer(modifier = Modifier.padding(top = 50.dp))

            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()
            ) {

                Spacer(modifier = Modifier.padding(3.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "From", color = Label_Color)
                }

                Spacer(modifier = Modifier.padding(3.dp))
                OutlinedTextField(
                    value = fromCurrencyCode.value,
                    onValueChange = { fromCurrencyCode.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(fromCurrencyCode.value, style = MaterialTheme.typography.body1)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "To", color = Label_Color)
                }

                Spacer(modifier = Modifier.padding(3.dp))
                OutlinedTextField(
                    value = toCurrencyCode.value,
                    onValueChange = { toCurrencyCode.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(toCurrencyCode.value, style = MaterialTheme.typography.body1)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Amount", color = Label_Color)
                    Text(text = fromCurrencyCode.value, color = Label_Color)
                }

                Spacer(modifier = Modifier.padding(3.dp))
                OutlinedTextField(
                    value = amountValue.value,
                    onValueChange = { amountValue.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text("0.00", style = MaterialTheme.typography.body1)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Button(
                    onClick = {
                        mainViewModel.getExchangeRates(provideQueries(fromCurrencyCode.value))
                        mainViewModel.exchangeRatesResponse.observe(
                            context as LifecycleOwner,
                            { response ->
                                when (response) {
                                    is NetworkResult.Success -> {
                                        response.data?.let {
                                            if (amountValue.value.isEmpty()) {
                                                amountValue.value = "1.00"
                                            }

                                            if (fromCurrencyCode.value == "INR") {
                                                val currency =
                                                    getToValue(toCurrencyCode.value, it.rates)
                                                val amount = amountValue.value.toDouble()
                                                convertedAmount.value =
                                                    "${getOutputString((amount * currency) / 100)} ${toCurrencyCode.value}"
                                                singleConvertedAmount.value =
                                                    "1 ${fromCurrencyCode.value} = ${
                                                        getOutputString(currency)
                                                    } ${toCurrencyCode.value}"
                                            } else {
                                                val currency =
                                                    getToValue(toCurrencyCode.value, it.rates)
                                                val amount = amountValue.value.toDouble()
                                                convertedAmount.value =
                                                    "${getOutputString(amount * currency)} ${toCurrencyCode.value}"
                                                singleConvertedAmount.value =
                                                    "1 ${fromCurrencyCode.value} = ${
                                                        getOutputString(currency)
                                                    } ${toCurrencyCode.value}"
                                            }
                                        }
                                    }
                                    is NetworkResult.Error -> {
                                        Toast.makeText(
                                            context,
                                            response.message,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    is NetworkResult.Loading -> {
                                        Toast.makeText(context, "Loading", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }

                            })
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "CONVERT", fontSize = 20.sp, color = White_900)
                }
                Spacer(modifier = Modifier.padding(30.dp))
                Text(
                    text = convertedAmount.value,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 30.sp,
                    color = Aqua_700,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = singleConvertedAmount.value,
                    modifier = Modifier.fillMaxWidth(),
                    color = Label_Color,
                    style = TextStyle(textAlign = TextAlign.Center)
                )
            }
        }
    }

}

fun getToValue(currencyCode: String, rates: Rates): Double =
    when (currencyCode) {
        //hRK, iSK, kRW
        "AUD" -> rates.aUD
        "BRL" -> rates.bRL
        "BGN" -> rates.bGN
        "CAD" -> rates.cAD
        "CNY" -> rates.cNY
        "CZK" -> rates.cZK
        "DKK" -> rates.dKK
        "EUR" -> rates.eUR
        "GBP" -> rates.gBP
        "HKD" -> rates.hKD
        "HUF" -> rates.hUF
        "INR" -> rates.iNR
        "IDR" -> rates.iDR
        "ILS" -> rates.iLS
        "JPY" -> rates.jPY
        "MYR" -> rates.mYR
        "MXN" -> rates.mXN
        "NZD" -> rates.nZD
        "NOK" -> rates.nOK
        "PHP" -> rates.pHP
        "PLN" -> rates.pLN
        "RON" -> rates.rON
        "RUB" -> rates.rUB
        "SGD" -> rates.sGD
        "ZAR" -> rates.zAR
        "SEK" -> rates.sEK
        "CHF" -> rates.cHF
        "THB" -> rates.tHB
        "TRY" -> rates.tRY
        "USD" -> rates.uSD
        "BTC" -> rates.bTC
        "ETH" -> rates.eTH
        else -> 0.00
    }

fun getOutputString(value: Double): String {
    return "%.3f".format(value)
}

fun provideQueries(from: String): HashMap<String, String> {
    val queries = HashMap<String, String>()
    queries["base"] = from
    return queries
}