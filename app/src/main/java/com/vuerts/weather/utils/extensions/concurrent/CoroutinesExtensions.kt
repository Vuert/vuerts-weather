package com.vuerts.weather.utils.extensions.concurrent

/**
 * Awaits for coroutine cancellation, invokes [onCancellation] on cancellation
 */
suspend inline fun awaitCancellation(onCancellation: () -> Unit): Nothing =
    try {
        kotlinx.coroutines.awaitCancellation()
    } finally {
        onCancellation.invoke()
    }
