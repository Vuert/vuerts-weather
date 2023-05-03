package com.vuerts.weather.utils.extensions.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

inline fun LifecycleOwner.repeatOnStarted(
    crossinline block: suspend CoroutineScope.() -> Unit,
): Job = lifecycle.repeatOnStarted(block)

inline fun LifecycleOwner.launchOnLifecycleCreate(
    crossinline block: CoroutineScope.() -> Unit,
): Job = lifecycle.launchOnLifecycleEvent(Lifecycle.Event.ON_CREATE) { block() }

inline fun LifecycleOwner.launchOnLifecycleStart(
    crossinline block: CoroutineScope.() -> Unit,
): Job = lifecycle.launchOnLifecycleEvent(Lifecycle.Event.ON_START) { block() }

inline fun LifecycleOwner.launchOnLifecycleResume(
    crossinline block: CoroutineScope.() -> Unit,
): Job = lifecycle.launchOnLifecycleEvent(Lifecycle.Event.ON_RESUME) { block() }

inline fun LifecycleOwner.launchOnLifecyclePause(
    crossinline block: CoroutineScope.() -> Unit,
): Job = lifecycle.launchOnLifecycleEvent(Lifecycle.Event.ON_PAUSE) { block() }

inline fun LifecycleOwner.launchOnLifecycleStop(
    crossinline block: CoroutineScope.() -> Unit,
): Job = lifecycle.launchOnLifecycleEvent(Lifecycle.Event.ON_STOP) { block() }

inline fun LifecycleOwner.launchOnLifecycleDestroy(
    crossinline block: CoroutineScope.() -> Unit,
): Job = lifecycle.launchOnLifecycleEvent(Lifecycle.Event.ON_DESTROY) { block() }

inline fun LifecycleOwner.launchOnAnyLifecycleEvent(
    crossinline block: CoroutineScope.(Lifecycle.Event) -> Unit,
): Job = lifecycle.launchOnLifecycleEvent(Lifecycle.Event.ON_ANY, block)

inline fun LifecycleOwner.launchOnLifecycleEvent(
    event: Lifecycle.Event,
    crossinline block: CoroutineScope.(Lifecycle.Event) -> Unit,
): Job = lifecycle.launchOnLifecycleEvent(event, block)
