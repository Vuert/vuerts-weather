package com.vuerts.weather.domain.forecast.model

import com.vuerts.weather.domain.city.City
import java.util.Date

data class Forecast(
    val date: Date,
    val city: City,
    val current: Weather,
)
