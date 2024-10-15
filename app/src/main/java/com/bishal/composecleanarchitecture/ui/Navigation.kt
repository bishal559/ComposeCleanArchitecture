package com.bishal.composecleanarchitecture.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bishal.core_ui.NavigationItem
import com.bishal.current_weather.view.CurrentWeatherScreen
import com.bishal.forecasting.view.ForecastingScreen

/**
 *
 * Created by bishal adhikari on 08/10/2024
 * */
@Composable
fun Navigation (navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.CurrentWeather.route){
        composable(NavigationItem.CurrentWeather.route){
            CurrentWeatherScreen(navController)
        }

        composable(NavigationItem.Forecasting.route){
            ForecastingScreen(navController)
        }

    }
}