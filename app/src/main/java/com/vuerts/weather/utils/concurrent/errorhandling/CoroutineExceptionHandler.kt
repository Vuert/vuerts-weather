package com.vuerts.weather.utils.concurrent.errorhandling

import com.vuerts.weather.utils.logging.base.BaseLogger
import kotlinx.coroutines.CoroutineExceptionHandler

fun CoroutineExceptionHandler(logger: BaseLogger): CoroutineExceptionHandler =
    CoroutineExceptionHandler { _, throwable ->
        logger.error("CoroutineExceptionHandler", "Unexpected error", throwable)
    }