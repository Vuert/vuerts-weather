package com.vuerts.weather.utils.extensions

fun <T> unsafeLazy(block: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, block)

fun <T> safeInitLazy(block: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.PUBLICATION, block)

fun <T> safeLazy(block: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.SYNCHRONIZED, block)
