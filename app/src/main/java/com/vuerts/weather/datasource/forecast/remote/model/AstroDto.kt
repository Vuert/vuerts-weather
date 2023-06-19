package com.vuerts.weather.datasource.forecast.remote.model

import com.google.gson.annotations.SerializedName

data class AstroDto(
    @SerializedName("sunrise")
    val sunrise: String,

    @SerializedName("sunset")
    val sunset: String,

    @SerializedName("moonrise")
    val moonrise: String,

    @SerializedName("moonset")
    val moonset: String,

    @SerializedName("moon_phase")
    val moonPhase: String,

    @SerializedName("moon_illumination")
    val moonIllumination: Double,

    @SerializedName("is_moon_up")
    val isMoonUp: Int,

    @SerializedName("is_sun_up")
    val isSunUp: Int,
)
