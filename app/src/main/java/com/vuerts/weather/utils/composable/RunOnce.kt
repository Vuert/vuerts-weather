package com.vuerts.weather.utils.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
inline fun RunOnce(block: () -> Unit) {
    val hasRunCode = rememberSaveable { mutableStateOf(false) }

    if (!hasRunCode.value) {
        hasRunCode.value = true
        block.invoke()
    }
}
