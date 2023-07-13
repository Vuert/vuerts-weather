package com.vuerts.weather.di.module.app.common

import com.vuerts.weather.utils.logging.base.BaseLogger
import com.vuerts.weather.utils.logging.impl.standard.StandardLogger
import com.vuerts.weather.utils.logging.impl.standard.logdestination.impl.LogcatLogDestination
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilModule {

    @Singleton
    @Provides
    fun provideLogger(): BaseLogger = StandardLogger(
        LogcatLogDestination()
    )
}
