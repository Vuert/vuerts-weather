package com.vuerts.weather.datasource.forecast.api.service

import com.vuerts.weather.datasource.forecast.api.model.ForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastService {

    @GET("/v1/forecast.json?days=3&aqi=yes&alerts=no")
    suspend fun getForecast(@Query("q") cityName: String): ForecastDto
}
