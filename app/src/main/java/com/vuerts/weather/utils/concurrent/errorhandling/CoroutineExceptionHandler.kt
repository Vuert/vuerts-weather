package com.vuerts.weather.utils.concurrent.errorhandling

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler

fun CoroutineExceptionHandler(): CoroutineExceptionHandler =
    CoroutineExceptionHandler { _, throwable ->
        // TODO Add AppLogger here
        Log.e("SafeCoroutineExceptionHandler", "Unexpected error", throwable)
    }