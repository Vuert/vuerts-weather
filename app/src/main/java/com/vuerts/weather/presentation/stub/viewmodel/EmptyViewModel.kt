package com.vuerts.weather.presentation.stub.viewmodel

import com.vuerts.weather.presentation.base.datadelegate.PresentationDataDelegate
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel

/**
 * Stub ViewModel, used for screens where ViewModel with any logic is not needed
 */
class EmptyViewModel(dataDelegate: PresentationDataDelegate) : BaseViewModel(dataDelegate)
