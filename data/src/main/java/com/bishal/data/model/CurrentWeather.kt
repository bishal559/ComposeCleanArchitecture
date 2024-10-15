package com.bishal.data.model


import com.google.gson.annotations.SerializedName
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
data class CurrentWeather(
    @SerializedName("current")
    val current: Current? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("forecast")
    val forecast: Forecast? = null
)