package com.bishal.forecasting.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.bishal.forecasting.viewmodel.ForecastingViewModel
import com.bishal.core_ui.ErrorDialog
import com.bishal.core_ui.FullScreenLoading
import com.bishal.data.model.CurrentWeather
import com.bishal.data.model.Day
import com.bishal.data.network.Resource
/**
 *
 * Created by bishal adhikari on 08/10/2024
 * */
@Composable
fun ForecastingScreen(
    navController: NavController,
    viewModel: ForecastingViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getForecastedWeather()
    }

    val state by viewModel.state.collectAsState()

    var forecastedWeatherState by remember {
        mutableStateOf(CurrentWeather())
    }

    when (val pageState = state) {
        is Resource.Loading -> {
            FullScreenLoading()
        }
        is Resource.Error -> {
            ErrorDialog(message = pageState.message, {})
        }

        is Resource.Success -> {
            forecastedWeatherState = pageState.data as CurrentWeather
        }
        else -> {}
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
            forecastedWeatherState.forecast?.forecastday?.let {
                items(items = it) { forecastDay ->
                    DaysItem(date = forecastDay.date, days = forecastDay.day, viewModel = viewModel)
                }
            }
        }
    }
}


@Composable
fun DaysItem(
    viewModel: ForecastingViewModel,
    date: String,
    days: Day
) {
    Card(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text( //date
                    text = viewModel.parseDateToDay(date),
                    style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text( //condition
                    text = days.condition.text,
                    style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground)
                )
            }

            AsyncImage(
                contentDescription = "Weather icon",
                model = "https:${days.condition.icon}",
                placeholder = painterResource(
                    id = com.bishal.core_ui.R.drawable.current_weather
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text( //Max
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 16.0.sp,
                                fontWeight = FontWeight(700.0.toInt()),
                                fontStyle = FontStyle.Normal,
                            )
                        ) {
                            append((days.maxtempC ?: "..").toString())
                        }
                        withStyle(
                            style = SpanStyle(
                                baselineShift = BaselineShift.Superscript,
                                fontSize = 8.0.sp,
                                fontWeight = FontWeight(300.0.toInt()),
                                fontStyle = FontStyle.Normal,
                            )
                        ) { // AnnotatedString.Builder
                            append("o")
                        }
                    },
                    style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text( //Min
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 16.0.sp,
                                fontWeight = FontWeight(700.0.toInt()),
                                fontStyle = FontStyle.Normal,
                            )
                        ) {
                            append((days.mintempC ?: "..").toString())
                        }
                        withStyle(
                            style = SpanStyle(
                                baselineShift = BaselineShift.Superscript,
                                fontSize = 8.0.sp,
                                fontWeight = FontWeight(300.0.toInt()),
                                fontStyle = FontStyle.Normal,
                            )
                        ) { // AnnotatedString.Builder
                            append("o")
                        }
                    },
                    style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground)
                )
            }

        }

    }
}