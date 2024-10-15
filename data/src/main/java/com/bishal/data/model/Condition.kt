package com.bishal.data.model


import com.google.gson.annotations.SerializedName
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
data class Condition(
    @SerializedName("code")
    val code: Int,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("text")
    val text: String
)