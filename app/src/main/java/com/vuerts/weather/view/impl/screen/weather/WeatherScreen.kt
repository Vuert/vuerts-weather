package com.vuerts.weather.view.impl.screen.weather

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vuerts.weather.presentation.impl.weather.viewmodel.WeatherViewModel
import com.vuerts.weather.view.base.injectViewModel

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = injectViewModel(),
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Weather screen")
    }
}
