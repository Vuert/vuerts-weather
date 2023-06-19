package com.vuerts.weather.datasource.forecast.remote.mapper

import com.vuerts.weather.datasource.forecast.remote.model.ConditionDto
import com.vuerts.weather.domain.forecast.model.WeatherCondition

class ConditionDtoToWeatherConditionMapper {

    fun map(weatherDto: ConditionDto): WeatherCondition =
        requireNotNull(conditionsMap[weatherDto.code]) {
            "Cannot find ${WeatherCondition::name} item for code ${weatherDto.code}"
        }
}

private val conditionsMap = mapOf(
    1000 to WeatherCondition.SUNNY,
    1003 to WeatherCondition.PARTLY_CLOUDY,
    1006 to WeatherCondition.CLOUDY,
    1009 to WeatherCondition.OVERCAST,
    1030 to WeatherCondition.MIST,
    1063 to WeatherCondition.PATCHY_RAIN,
    1066 to WeatherCondition.PATCHY_SNOW,
    1069 to WeatherCondition.PATCHY_SLEET,
    1072 to WeatherCondition.PATCHY_FREEZING,
    1087 to WeatherCondition.THUNDERY_OUTBREAKS,
    1114 to WeatherCondition.BLOWING_SNOW,
    1117 to WeatherCondition.BLIZZARD,
    1135 to WeatherCondition.FOG,
    1147 to WeatherCondition.FREEZING_FOG,
    1150 to WeatherCondition.PATCHY_LIGHT_DRIZZLE,
    1153 to WeatherCondition.LIGHT_DRIZZLE,
    1168 to WeatherCondition.FREEZING_DRIZZLE,
    1171 to WeatherCondition.HEAVY_FREEZING_DRIZZLE,
    1180 to WeatherCondition.PATCHY_LIGHT_RAIN,
    1183 to WeatherCondition.LIGHT_RAIN,
    1186 to WeatherCondition.MODERATE_RAIN_AT_TIMES,
    1189 to WeatherCondition.MODERATE_RAIN,
    1192 to WeatherCondition.HEAVY_RAIN_AT_TIMES,
    1195 to WeatherCondition.HEAVY_RAIN,
    1198 to WeatherCondition.LIGHT_FREEZING_RAIN,
    1201 to WeatherCondition.MODERATE_OR_HEAVY_FREEZING_RAIN,
    1204 to WeatherCondition.LIGHT_SLEET,
    1207 to WeatherCondition.MODERATE_OR_HEAVY_SLEET,
    1210 to WeatherCondition.PATCHY_LIGHT_SNOW,
    1213 to WeatherCondition.LIGHT_SNOW,
    1216 to WeatherCondition.PATCHY_MODERATE_SNOW,
    1219 to WeatherCondition.MODERATE_SNOW,
    1222 to WeatherCondition.PATCHY_HEAVY_SNOW,
    1225 to WeatherCondition.HEAVY_SNOW,
    1237 to WeatherCondition.ICE_PELLETS,
    1240 to WeatherCondition.LIGHT_RAIN_SHOWER,
    1243 to WeatherCondition.MODERATE_OR_HEAVY_RAIN_SHOWER,
    1246 to WeatherCondition.TORRENTIAL_RAIN_SHOWER,
    1249 to WeatherCondition.LIGHT_SLEET_SHOWERS,
    1252 to WeatherCondition.MODERATE_OR_HEAVY_SLEET_SHOWERS,
    1255 to WeatherCondition.LIGHT_SNOW_SHOWERS,
    1258 to WeatherCondition.MODERATE_OR_HEAVY_SNOW_SHOWERS,
    1261 to WeatherCondition.LIGHT_SHOWERS_OF_ICE_PELLETS,
    1264 to WeatherCondition.MODERATE_OR_HEAVY_SHOWERS_OF_ICE_PELLETS,
    1273 to WeatherCondition.PATCHY_LIGHT_RAIN_WITH_THUNDER,
    1276 to WeatherCondition.MODERATE_OR_HEAVY_RAIN_WITH_THUNDER,
    1279 to WeatherCondition.PATCHY_LIGHT_SNOW_WITH_THUNDER,
    1282 to WeatherCondition.MODERATE_OR_HEAVY_SNOW_WITH_THUNDER,
)
