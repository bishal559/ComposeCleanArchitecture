package com.bishal.data.model


import com.google.gson.annotations.SerializedName
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
data class Astro(
    @SerializedName("is_moon_up")
    val isMoonUp: Int,
    @SerializedName("is_sun_up")
    val isSunUp: Int,
    @SerializedName("moon_illumination")
    val moonIllumination: String,
    @SerializedName("moon_phase")
    val moonPhase: String,
    @SerializedName("moonrise")
    val moonrise: String,
    @SerializedName("moonset")
    val moonset: String,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String
)