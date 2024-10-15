package com.bishal.data.network
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
class ApiException(val code: String? = null, message: String? = null, localMessage: String? = null) : RuntimeException(message)
