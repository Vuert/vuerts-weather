package com.vuerts.weather.data.forecast.mapper

import com.vuerts.weather.data.forecast.api.model.LocationDto
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
