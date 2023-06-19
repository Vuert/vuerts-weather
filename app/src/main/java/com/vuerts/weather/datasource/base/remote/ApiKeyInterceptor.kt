package com.vuerts.weather.datasource.base.remote

import com.vuerts.weather.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

private const val API_KEY_PARAM = "key"

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val url = originalRequest
            .url()
            .newBuilder()
            .addQueryParameter(API_KEY_PARAM, BuildConfig.WEATHER_API_KEY)
            .build()

        return chain.proceed(originalRequest.newBuilder().url(url).build())
    }
}
