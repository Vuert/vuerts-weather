package com.vuerts.weather.data.temperatureunit.repository

import com.vuerts.weather.domain.temperatureunit.model.TemperatureUnit
import com.vuerts.weather.domain.temperatureunit.repository.TemperatureUnitRepository
import kotlinx.coroutines.flow.flowOf

// TODO add possibility to change temperature unit
class TemperatureUnitMockRepository : TemperatureUnitRepository {

    override val temperatureUnit = flowOf(TemperatureUnit.CELSIUS)
}
