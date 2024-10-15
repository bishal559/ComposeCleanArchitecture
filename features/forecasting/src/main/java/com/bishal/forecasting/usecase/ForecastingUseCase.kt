package com.bishal.forecasting.usecase


import com.bishal.data.repository.CurrentWeatherRepository
import javax.inject.Inject
/**
 *
 * Created by bishal adhikari on 08/10/2024
 * */
class ForecastingUseCase @Inject constructor(private val repository : CurrentWeatherRepository) {

    suspend fun getForecastingDays() = repository.getForecasting("10")

}