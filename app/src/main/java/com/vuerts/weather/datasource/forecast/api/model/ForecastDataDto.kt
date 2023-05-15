package com.vuerts.weather.datasource.forecast.api.model

import com.google.gson.annotations.SerializedName

data class ForecastDataDto(
    @SerializedName("forecastday")
    val forecastday: List<ForecastDayDto>,
)
