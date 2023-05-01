package com.vuerts.weather.presentation.base.datadelegate

import kotlinx.coroutines.CoroutineExceptionHandler
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import com.vuerts.weather.utils.logging.base.BaseLogger

/**
 * Accumulates common dependencies for all [BaseViewModel]s
 *
 * @property unexpectedExceptionHandler - basically, handles unexpected errors
 * that might occur during [BaseViewModel.launchSafe] execution
 */
interface PresentationDataDelegate {

    val logger: BaseLogger

    val unexpectedExceptionHandler: CoroutineExceptionHandler
}
