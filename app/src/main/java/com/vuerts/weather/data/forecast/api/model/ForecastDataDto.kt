package com.vuerts.weather.data.forecast.api.model

import com.google.gson.annotations.SerializedName

data class ForecastDataDto(
    @SerializedName("forecastday")
    val forecastday: List<ForecastDayDto>,
)
