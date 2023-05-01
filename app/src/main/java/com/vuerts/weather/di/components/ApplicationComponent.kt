package com.vuerts.weather.di.components

import com.vuerts.weather.app.WeatherApplication
import com.vuerts.weather.di.module.mainactivity.ActivityBindingModule
import com.vuerts.weather.di.module.app.UtilModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityBindingModule::class,
        UtilModule::class,
        AndroidInjectionModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<WeatherApplication> {

    override fun inject(application: WeatherApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: WeatherApplication): Builder

        fun build(): ApplicationComponent
    }
}
