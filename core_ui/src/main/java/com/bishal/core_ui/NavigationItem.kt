package com.bishal.core_ui
/**
 *
 * Created by bishal adhikari on 08/10/2024
 * */
sealed class NavigationItem(val route: String, val icon: Int, val title: String) {
    object CurrentWeather :
        NavigationItem(Routes.WEATHER, R.drawable.current_weather, "Current Weather")

    object Forecasting :
        NavigationItem(Routes.FORECASTING, R.drawable.weather_forecasting, "Forecasting")

}
