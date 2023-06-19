package com.vuerts.weather.view.impl.screen.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vuerts.weather.presentation.impl.root.viewmodel.RootViewModel
import com.vuerts.weather.view.base.injectViewModel

@Composable
fun RootScreen(
    viewModel: RootViewModel = injectViewModel(),
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Root screen")
    }
}
