package com.bishal.current_weather.usecase

import com.bishal.data.model.CurrentWeather
import com.bishal.data.repository.CurrentWeatherRepository
import javax.inject.Inject
/**
 *
 * Created by bishal adhikari on 08/10/2024
 * */
class CurrentWeatherUseCase @Inject constructor(private val repositories : CurrentWeatherRepository) {
    suspend fun getCurrentWeather() : Result<CurrentWeather> = repositories.getCurrentWeather()

}