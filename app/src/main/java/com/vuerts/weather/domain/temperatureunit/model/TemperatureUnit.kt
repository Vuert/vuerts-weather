package com.vuerts.weather.domain.temperatureunit.model

import com.vuerts.weather.domain.forecast.model.units.Celsius

enum class TemperatureUnit {

    CELSIUS {
        override fun from(celsius: Celsius): Double = celsius.celsius
    },
    FAHRENHEIT {
        override fun from(celsius: Celsius): Double =
            (celsius.celsius * 9 / 5) + 32
    };

    abstract fun from(celsius: Celsius): Double
}
