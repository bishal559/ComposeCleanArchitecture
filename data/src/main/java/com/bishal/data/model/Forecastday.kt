package com.bishal.data.model


import com.google.gson.annotations.SerializedName
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
data class Forecastday(
    @SerializedName("astro")
    val astro: Astro,
    @SerializedName("date")
    val date: String,
    @SerializedName("date_epoch")
    val dateEpoch: Int,
    @SerializedName("day")
    val day: Day,
    @SerializedName("hour")
    val hour: List<Hour>
)