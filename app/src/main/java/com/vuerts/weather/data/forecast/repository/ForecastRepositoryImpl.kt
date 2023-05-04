package com.vuerts.weather.data.forecast.repository

import com.vuerts.weather.data.forecast.datasource.ForecastRemoteDatasource
import com.vuerts.weather.domain.city.City
import com.vuerts.weather.domain.forecast.model.Forecast
import com.vuerts.weather.domain.forecast.repository.ForecastRepository

class ForecastRepositoryImpl(
    private val remoteDatasource: ForecastRemoteDatasource,
) : ForecastRepository {

    override suspend fun getForecast(city: City): Forecast =
        remoteDatasource.getForecast(city)
}
