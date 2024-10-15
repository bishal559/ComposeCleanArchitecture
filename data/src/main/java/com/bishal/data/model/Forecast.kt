package com.bishal.data.model


import com.google.gson.annotations.SerializedName
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
data class Forecast(
    @SerializedName("forecastday")
    val forecastday: List<Forecastday>
)