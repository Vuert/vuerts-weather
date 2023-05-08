package com.vuerts.weather.domain.forecast.model

import com.vuerts.weather.domain.location.model.Location
import com.vuerts.weather.domain.forecast.model.units.Celsius
import com.vuerts.weather.domain.forecast.model.units.Meters
import com.vuerts.weather.domain.forecast.model.units.KilometersPerHour
import com.vuerts.weather.domain.forecast.model.units.MilliBars
import com.vuerts.weather.domain.forecast.model.units.Percents
import java.time.LocalTime
import java.util.Date

data class Weather(
    val location: Location,
    val date: Date,
    val condition: WeatherCondition,
    val temp: Celsius,
    val tempMin: Celsius,
    val tempMax: Celsius,
    val feelsLike: Celsius,
    val pressure: MilliBars,
    val humidity: Percents,
    val clouds: Percents,
    val visibility: Meters,
    val windSpeed: KilometersPerHour,
    val windGust: KilometersPerHour,
    val sunrise: LocalTime,
    val sunset: LocalTime,
)
