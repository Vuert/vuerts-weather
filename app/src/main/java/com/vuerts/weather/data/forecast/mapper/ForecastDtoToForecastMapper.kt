package com.vuerts.weather.data.forecast.mapper

import com.vuerts.weather.data.forecast.api.model.ForecastDto
import com.vuerts.weather.domain.city.City
import com.vuerts.weather.domain.forecast.model.Forecast
import com.vuerts.weather.domain.forecast.model.Weather
import com.vuerts.weather.domain.forecast.model.units.Celsius
import com.vuerts.weather.domain.forecast.model.units.Meters
import com.vuerts.weather.domain.forecast.model.units.KilometersPerHour
import com.vuerts.weather.domain.forecast.model.units.MilliBars
import com.vuerts.weather.domain.forecast.model.units.Percents
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date
import kotlin.math.roundToLong

class ForecastDtoToForecastMapper(
    private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a"),
) {

    fun map(forecastDto: ForecastDto, city: City): Forecast = forecastDto.run {
        val forecastDayDto = forecastDto.forecast.forecastday[0]

        val date = Date(current.lastUpdatedEpoch * 1000)


        val weather = Weather(
            id = location.run { "$lon$lat" },
            date = date,
            temp = Celsius(current.tempC),
            tempMax = Celsius(forecastDayDto.day.maxtempC),
            tempMin = Celsius(forecastDayDto.day.mintempC),
            feelsLike = Celsius(current.feelslikeC),
            pressure = MilliBars(current.pressureMb),
            humidity = Percents(current.humidity),
            clouds = Percents(current.cloud),
            // Kilometers to meters
            visibility = Meters((forecastDayDto.day.avgvisKm / 1000).roundToLong()),
            windSpeed = KilometersPerHour(current.windKph),
            windGust = KilometersPerHour(current.gustKph),
            sunrise = LocalTime.parse(forecastDayDto.astro.sunrise, dateTimeFormatter),
            sunset = LocalTime.parse(forecastDayDto.astro.sunset, dateTimeFormatter),

            )
        Forecast(
            date = date,
            city = city,
            current = weather,
        )
    }
}
