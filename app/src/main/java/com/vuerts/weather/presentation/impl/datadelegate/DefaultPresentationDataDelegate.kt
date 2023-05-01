package com.vuerts.weather.presentation.impl.datadelegate

import com.vuerts.weather.presentation.base.datadelegate.PresentationDataDelegate
import com.vuerts.weather.utils.logging.base.BaseLogger
import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * @see [PresentationDataDelegate]
 */
class DefaultPresentationDataDelegate(
    override val logger: BaseLogger,
    override val unexpectedExceptionHandler: CoroutineExceptionHandler,
) : PresentationDataDelegate
