package com.vuerts.weather.datasource.forecast.remote.model

import com.google.gson.annotations.SerializedName

data class ForecastDataDto(
    @SerializedName("forecastday")
    val forecastday: List<ForecastDayDto>,
)
