package com.vuerts.weather.domain.forecast.repository

import com.vuerts.weather.domain.location.model.Location
import com.vuerts.weather.domain.forecast.model.Forecast

interface ForecastRepository {

    suspend fun getForecast(location: Location): Forecast
}
