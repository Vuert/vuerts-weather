package com.vuerts.weather.datasource.forecast.remote.model

import com.google.gson.annotations.SerializedName

data class ConditionDto(
    @SerializedName("text")
    val text: String,

    @SerializedName("icon")
    val icon: String,

    @SerializedName("code")
    val code: Int,
)
