package com.vuerts.weather.di.module.screen.weather

import com.vuerts.weather.data.forecast.datasource.RemoteForecastDataSource
import com.vuerts.weather.data.forecast.repository.ForecastRepositoryImpl
import com.vuerts.weather.datasource.forecast.remote.datasource.RemoteForecastDatasourceImpl
import com.vuerts.weather.datasource.forecast.remote.service.ForecastService
import com.vuerts.weather.domain.forecast.repository.ForecastRepository
import dagger.Module
import dagger.Provides

@Module
class WeatherDataModule {

    @Provides
    fun provideForecastRepository(
        remoteForecastDataSource: RemoteForecastDataSource,
    ): ForecastRepository = ForecastRepositoryImpl(remoteForecastDataSource)

    @Provides
    fun provideRemoteForecastRepository(
        forecastService: ForecastService,
    ): RemoteForecastDataSource = RemoteForecastDatasourceImpl(forecastService)
}
