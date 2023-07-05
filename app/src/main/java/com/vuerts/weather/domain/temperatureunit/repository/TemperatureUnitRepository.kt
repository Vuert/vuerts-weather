package com.vuerts.weather.domain.temperatureunit.repository

import com.vuerts.weather.domain.temperatureunit.model.TemperatureUnit
import kotlinx.coroutines.flow.Flow

interface TemperatureUnitRepository {

    val temperatureUnit: Flow<TemperatureUnit>
}
