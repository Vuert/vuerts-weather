package com.vuerts.weather.data.forecast.api.model

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Long,

    @SerializedName("last_updated")
    val lastUpdated: String,

    @SerializedName("temp_c")
    val tempC: Double,

    @SerializedName("is_day")
    val isDay: Int,

    @SerializedName("condition")
    val condition: ConditionDto,

    @SerializedName("wind_kph")
    val windKph: Double,

    @SerializedName("wind_degree")
    val windDegree: Int,

    @SerializedName("wind_dir")
    val windDir: String,

    @SerializedName("pressure_mb")
    val pressureMb: Long,

    @SerializedName("pressure_in")
    val pressureIn: Double,

    @SerializedName("precip_mm")
    val precipMm: Int,

    @SerializedName("precip_in")
    val precipIn: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("cloud")
    val cloud: Int,

    @SerializedName("feelslike_c")
    val feelslikeC: Double,

    @SerializedName("vis_km")
    val visKm: Int,

    @SerializedName("uv")
    val uv: Int,

    @SerializedName("gust_kph")
    val gustKph: Double,

    @SerializedName("air_quality")
    val airQuality: AirQualityDto?,
)
