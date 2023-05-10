package com.vuerts.weather.data.forecast.repository

import com.vuerts.weather.data.forecast.datasource.RemoteForecastDataSource
import com.vuerts.weather.domain.forecast.model.Forecast
import com.vuerts.weather.domain.forecast.repository.ForecastRepository
import com.vuerts.weather.domain.location.model.Location

class ForecastRepositoryImpl(
    private val remoteDatasource: RemoteForecastDataSource,
) : ForecastRepository {

    override suspend fun getForecast(location: Location): Forecast =
        remoteDatasource.getForecast(location)
}
