package com.vuerts.weather.view.impl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vuerts.weather.view.impl.screen.weather.WeatherScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: Screen = Screen.Weather,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(Screen.Weather.route) {
            WeatherScreen()
        }
    }
}

sealed class Screen(val route: String) {
    object Weather : Screen("weather")
}
