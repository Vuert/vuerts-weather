package com.vuerts.weather.data.forecast.datasource

import com.vuerts.weather.BuildConfig
import com.vuerts.weather.data.forecast.api.service.ForecastService
import com.vuerts.weather.data.forecast.mapper.ForecastDtoToForecastMapper
import com.vuerts.weather.data.util.ApiKeyInterceptor
import com.vuerts.weather.domain.city.Location
import com.vuerts.weather.domain.forecast.model.Forecast
import com.vuerts.weather.domain.forecast.repository.ForecastRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ForecastRemoteDatasource : ForecastRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.WEATHER_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(ApiKeyInterceptor())
                .build()
        )
        .build()
        .create(ForecastService::class.java)

    override suspend fun getForecast(location: Location): Forecast {
        val forecastDto = retrofit.getForecast(location.name)

        return ForecastDtoToForecastMapper().map(forecastDto)
    }
}
