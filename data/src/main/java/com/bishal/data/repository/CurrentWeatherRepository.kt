package com.bishal.data.repository

import com.bishal.data.model.CurrentWeather
import com.bishal.data.network.ApiService
import javax.inject.Inject
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
interface CurrentWeatherRepository  {
    suspend fun getCurrentWeather() : Result<CurrentWeather>
    suspend fun getForecasting(days: String): Result<CurrentWeather>
}

class CurrentWeatherRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    CurrentWeatherRepository {

    override suspend fun getCurrentWeather(): Result<CurrentWeather> {
        return apiService.getCurrentWeather()
    }

    override suspend fun getForecasting(days : String): Result<CurrentWeather> {
        return apiService.getCurrentWeather(days = days)
    }

}