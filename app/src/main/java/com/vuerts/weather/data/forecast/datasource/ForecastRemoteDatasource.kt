package com.vuerts.weather.data.forecast.datasource

import com.vuerts.weather.data.forecast.api.service.ForecastService
import com.vuerts.weather.data.forecast.mapper.ForecastDtoToForecastMapper
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
