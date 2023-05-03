package com.vuerts.weather.view.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.vuerts.weather.R
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel

/**
 * Accumulates common methods for fragment and activity
 */
interface BaseScreen<VB : ViewBinding, VM : BaseViewModel> {

    /**
     * Invoked after binding creation
     */
    fun onViewBound(binding: VB, savedInstanceState: Bundle?) {
        // None
    }

    /**
     * Handles errors that come from a ViewModel
     */
    fun handleError(binding: VB, throwable: Throwable) {
        Snackbar.make(binding.root, R.string.error_occurred, Snackbar.LENGTH_LONG).show()
    }
}
