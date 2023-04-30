package com.vuerts.weather.presentation.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.hadilq.liveevent.LiveEvent
import com.vuerts.weather.presentation.base.datadelegate.PresentationDataDelegate
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Base ViewModel class, must be a superclass for all ViewModels
 *
 * @param presentationDataDelegate - allows to inject common dependencies to all ViewModels easily
 *
 * @property errorLiveEvent - allows to send error to the view layer one time
 * @property errorFlow - allows to subscribe to ViewModel errors from the view layer
 * @property scope - provides access to ViewModel coroutine scope.
 * Used instead [ViewModel.viewModelScope] to keep all [ViewModel] class stuff in this class
 */
abstract class BaseViewModel(
    private val presentationDataDelegate: PresentationDataDelegate,
) : ViewModel(), PresentationDataDelegate by presentationDataDelegate {

    private val errorLiveEvent = LiveEvent<Throwable>()
    val errorFlow: Flow<Throwable> = errorLiveEvent.asFlow()

    protected val scope: CoroutineScope = viewModelScope

    /**
     * Allows to launch new coroutine safely inside [scope]
     *
     * @param context - coroutine context of a new coroutine
     * @param start - define the start options of a new coroutine
     * @param onCancellation - some code that executes on coroutine cancellation
     * @param onError - some code that executes on error during coroutine execution
     * @param finally - some code that executes when coroutine is finished
     * @param block - some code that executes inside coroutine
     *
     * @return [Job] to provide more control over coroutine
     */
    protected inline fun launchSafe(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        crossinline onCancellation: (CancellationException) -> Unit = {},
        crossinline onError: (Throwable) -> Unit = ::onError,
        crossinline finally: () -> Unit = { },
        crossinline block: CoroutineScope.() -> Unit,
    ): Job = scope.launch(context = context + unexpectedExceptionHandler, start = start) {
        try {
            block.invoke(this)
        } catch (exception: CancellationException) {
            onCancellation.invoke(exception)
        } catch (throwable: Throwable) {
            onError.invoke(throwable)
        } finally {
            finally.invoke()
        }
    }

    /**
     * Handles exceptions that might occur during coroutine execution
     *
     * @param throwable - exception, that occurred during coroutine execution
     */
    protected open fun onError(throwable: Throwable) {
        errorLiveEvent.postValue(throwable)
    }

    final override fun onCleared() {
        onDestroyed()
        super.onCleared()
    }

    /**
     * Allows to close all resources when ViewModel is destroyed.
     * Used instead [onCleared] to keep all [ViewModel] class stuff in this class
     */
    protected open fun onDestroyed() {
        // None
    }
}