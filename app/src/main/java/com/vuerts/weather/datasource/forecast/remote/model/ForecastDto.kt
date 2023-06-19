package com.vuerts.weather.datasource.forecast.remote.model

import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("location")
    val location: LocationDto,

    @SerializedName("current")
    val current: WeatherDto,

    @SerializedName("forecast")
    val forecast: ForecastDataDto,
)
