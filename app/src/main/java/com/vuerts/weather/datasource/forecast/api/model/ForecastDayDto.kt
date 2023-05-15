package com.vuerts.weather.datasource.forecast.api.model

import com.google.gson.annotations.SerializedName

data class ForecastDayDto(
    @SerializedName("date")
    val date: String,

    @SerializedName("date_epoch")
    val dateEpoch: Long,

    @SerializedName("day")
    val day: ForecastDayDataDto,

    @SerializedName("astro")
    val astro: AstroDto,
)
