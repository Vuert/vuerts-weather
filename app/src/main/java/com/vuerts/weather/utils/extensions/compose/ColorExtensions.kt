package com.vuerts.weather.utils.extensions.compose

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

inline val Color.isDarkContent: Boolean get() = luminance() > 0.5f
