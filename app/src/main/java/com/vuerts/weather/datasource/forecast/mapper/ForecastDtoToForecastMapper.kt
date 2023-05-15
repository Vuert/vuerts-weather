package com.vuerts.weather.datasource.forecast.mapper

import com.vuerts.weather.datasource.forecast.api.model.ForecastDto
import com.vuerts.weather.domain.forecast.model.Forecast
import com.vuerts.weather.domain.forecast.model.Weather
import com.vuerts.weather.domain.forecast.model.units.Celsius
import com.vuerts.weather.domain.forecast.model.units.KilometersPerHour
import com.vuerts.weather.domain.forecast.model.units.Meters
import com.vuerts.weather.domain.forecast.model.units.MilliBars
import com.vuerts.weather.domain.forecast.model.units.Percents
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date
import kotlin.math.roundToLong

class ForecastDtoToForecastMapper(
    private val weatherConditionMapper: ConditionDtoToWeatherConditionMapper =
        ConditionDtoToWeatherConditionMapper(),
    private val locationMapper: LocationDtoToLocation = LocationDtoToLocation(),
    private val dateTimeFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("hh:mm a"),
) {

    fun map(forecastDto: ForecastDto): Forecast = forecastDto.run {
        val forecastDayDto = forecast.forecastday[0]

        // Sec to ms
        val date = Date(current.lastUpdatedEpoch * 1000)

        val location = locationMapper.map(location)

        val weather = Weather(
            location = location,
            date = date,
            condition = weatherConditionMapper.map(current.condition),
            temp = Celsius(current.tempC),
            tempMax = Celsius(forecastDayDto.day.maxtempC),
            tempMin = Celsius(forecastDayDto.day.mintempC),
            feelsLike = Celsius(current.feelslikeC),
            pressure = MilliBars(current.pressureMb),
            humidity = Percents(current.humidity),
            clouds = Percents(current.cloud),
            // Kilometers to meters
            visibility = Meters((forecastDayDto.day.avgvisKm * 1000).roundToLong()),
            windSpeed = KilometersPerHour(current.windKph),
            windGust = KilometersPerHour(current.gustKph),
            sunrise = LocalTime.parse(forecastDayDto.astro.sunrise, dateTimeFormatter),
            sunset = LocalTime.parse(forecastDayDto.astro.sunset, dateTimeFormatter),
        )
        // TODO add forecast items
        Forecast(
            date = date,
            location = location,
            current = weather,
        )
    }
}
