package com.bishal.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
data class BaseApiResponse(
    @SerializedName("code")
    var code: String? = null,
    @SerializedName("details")
    var details: List<ErrorDetails>? = null,
    @SerializedName("message")
    var message: String? = null
)

data class ErrorDetails(
    @SerializedName("@type")
    var type: String?,
    @SerializedName("data")
    var data: Any? = null,
    @SerializedName("errorCode")
    var errorCode: String? = null,
    @SerializedName("requestId")
    var requestId: String? = null,
    @SerializedName("statusCode")
    var statusCode: String? = null
) : Serializable
