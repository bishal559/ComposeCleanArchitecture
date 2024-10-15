package com.bishal.data.network

import okhttp3.Interceptor
import okhttp3.Response
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
class BaseHeadersInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            header("AppId", "1")
            header("Platform", "Android")
        }.build()
        return chain.proceed(request)
    }
}