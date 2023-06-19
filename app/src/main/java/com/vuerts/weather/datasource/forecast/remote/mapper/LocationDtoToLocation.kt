package com.vuerts.weather.datasource.forecast.remote.mapper

import com.vuerts.weather.datasource.forecast.remote.model.LocationDto
import com.vuerts.weather.domain.location.model.Location

class LocationDtoToLocation {

    fun map(locationDto: LocationDto): Location = locationDto.run {
        Location(
            id = "$lon$lat",
            name = name,
            latitude = lat,
            longitude = lon,
        )
    }
}
