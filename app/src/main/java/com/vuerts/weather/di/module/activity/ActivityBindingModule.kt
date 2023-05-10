package com.vuerts.weather.di.module.activity

import com.vuerts.weather.di.annotations.scope.ActivityScope
import com.vuerts.weather.di.module.screen.weather.WeatherDataModule
import com.vuerts.weather.di.module.screen.weather.WeatherPresentationModule
import com.vuerts.weather.view.impl.activity.SingleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            BaseViewModelModule::class,
            WeatherPresentationModule::class,
            WeatherDataModule::class,
        ]
    )
    abstract fun contributeSingleActivity(): SingleActivity
}
