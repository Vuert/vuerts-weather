package com.vuerts.weather.datasource.forecast.remote.datasource

import com.vuerts.weather.datasource.forecast.remote.service.ForecastService
import com.vuerts.weather.datasource.forecast.remote.mapper.ForecastDtoToForecastMapper
import com.vuerts.weather.domain.location.model.Location
import com.vuerts.weather.domain.forecast.model.Forecast
import com.vuerts.weather.domain.forecast.repository.ForecastRepository

class ForecastRemoteDatasource(
    private val forecastService: ForecastService,
) : ForecastRepository {

    override suspend fun getForecast(location: Location): Forecast {
        val forecastDto = forecastService.getForecast(location.name)

        return ForecastDtoToForecastMapper().map(forecastDto)
    }
}
