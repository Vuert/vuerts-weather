package com.vuerts.weather.di.module.screen.weather

import com.vuerts.weather.di.annotations.key.ViewModelKey
import com.vuerts.weather.domain.forecast.repository.ForecastRepository
import com.vuerts.weather.presentation.base.datadelegate.PresentationDataDelegate
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import com.vuerts.weather.presentation.impl.weather.viewmodel.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [WeatherPresentationModule.Binder::class])
class WeatherPresentationModule {

    @Provides
    fun provideViewModel(
        dataDelegate: PresentationDataDelegate,
        forecastRepository: ForecastRepository,
    ): WeatherViewModel = WeatherViewModel(
        dataDelegate = dataDelegate,
        forecastRepository = forecastRepository,
    )

    @Module
    interface Binder {

        @Binds
        @IntoMap
        @ViewModelKey(WeatherViewModel::class)
        fun bindViewModel(viewModel: WeatherViewModel): BaseViewModel
    }
}
