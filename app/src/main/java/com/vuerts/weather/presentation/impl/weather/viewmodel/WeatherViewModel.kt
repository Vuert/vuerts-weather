package com.vuerts.weather.presentation.impl.weather.viewmodel

import com.vuerts.weather.domain.forecast.model.Forecast
import com.vuerts.weather.domain.forecast.repository.ForecastRepository
import com.vuerts.weather.domain.location.model.Location
import com.vuerts.weather.presentation.base.datadelegate.PresentationDataDelegate
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherViewModel(
    dataDelegate: PresentationDataDelegate,
    private val forecastRepository: ForecastRepository,
) : BaseViewModel(dataDelegate) {

    private val _forecastStateFlow = MutableStateFlow<Forecast?>(null)
    val forecastStateFlow = _forecastStateFlow.asStateFlow()

    init {
        launchSafe {
            val mockLocation = Location(
                id = "",
                name = "Toronto",
                latitude = 0.0,
                longitude = 0.0,
            )
            val forecast = forecastRepository.getForecast(mockLocation)

            _forecastStateFlow.value = forecast
        }
    }
}
