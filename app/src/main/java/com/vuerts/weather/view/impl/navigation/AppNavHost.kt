package com.vuerts.weather.view.impl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vuerts.weather.view.impl.screen.root.RootScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: Screen = Screen.Root,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(Screen.Root.route) {
            RootScreen()
        }
    }
}

sealed class Screen(val route: String) {
    object Root : Screen("root")
}
