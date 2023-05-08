package com.vuerts.weather.domain.forecast.repository

import com.vuerts.weather.domain.city.Location
import com.vuerts.weather.domain.forecast.model.Forecast

interface ForecastRepository {

    suspend fun getForecast(location: Location): Forecast
}
