package com.vuerts.weather.domain.forecast.repository

import com.vuerts.weather.domain.city.City
import com.vuerts.weather.domain.forecast.model.Forecast

interface ForecastRepository {

    suspend fun getForecast(city: City): Forecast
}
