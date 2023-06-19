package com.vuerts.weather.di.module.app

import com.vuerts.weather.BuildConfig
import com.vuerts.weather.datasource.forecast.remote.service.ForecastService
import com.vuerts.weather.datasource.base.remote.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl(BuildConfig.WEATHER_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(ApiKeyInterceptor())
                .build()
        )
        .build()

    @Provides
    @Singleton
    fun provideForecastService(retrofit: Retrofit): ForecastService =
        retrofit.create(ForecastService::class.java)
}
