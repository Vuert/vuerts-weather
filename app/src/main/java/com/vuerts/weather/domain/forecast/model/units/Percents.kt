package com.vuerts.weather.domain.forecast.model.units

class Percents(percents: Int) {

    val percents: Int

    init {
        require(percents in 0..100) {
            "$percents is invalid value for percents"
        }
        this.percents = percents
    }
}
