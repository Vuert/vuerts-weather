package com.vuerts.weather.data.forecast.api.model

import com.google.gson.annotations.SerializedName

data class AirQualityDto(
    @SerializedName("co")
    val co: Double,

    @SerializedName("no2")
    val no2: Double,

    @SerializedName("o3")
    val o3: Double,

    @SerializedName("so2")
    val so2: Double,

    @SerializedName("pm2_5")
    val pm25: Double,

    @SerializedName("pm10")
    val pm10: Double,

    @SerializedName("us-epa-index")
    val usEpaIndex: Int,

    @SerializedName("gb-defra-index")
    val gbDefraIndex: Int,
)
