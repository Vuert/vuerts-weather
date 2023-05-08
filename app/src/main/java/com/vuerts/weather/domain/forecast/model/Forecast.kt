package com.vuerts.weather.domain.forecast.model

import com.vuerts.weather.domain.city.Location
import java.util.Date

data class Forecast(
    val date: Date,
    val location: Location,
    val current: Weather,
)
