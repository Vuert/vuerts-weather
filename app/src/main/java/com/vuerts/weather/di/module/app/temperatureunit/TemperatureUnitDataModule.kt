package com.vuerts.weather.di.module.app.temperatureunit

import com.vuerts.weather.data.temperatureunit.repository.TemperatureUnitMockRepository
import com.vuerts.weather.domain.temperatureunit.repository.TemperatureUnitRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TemperatureUnitDataModule {

    @Singleton
    @Provides
    fun provideTemperatureUnitRepository(): TemperatureUnitRepository =
        TemperatureUnitMockRepository()
}
