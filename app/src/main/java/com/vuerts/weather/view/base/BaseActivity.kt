package com.vuerts.weather.view.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.vuerts.weather.R
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import com.vuerts.weather.utils.extensions.createViewModel
import com.vuerts.weather.utils.extensions.inflateBinding
import com.vuerts.weather.utils.extensions.repeatOnStarted
import com.vuerts.weather.utils.extensions.unsafeLazy
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Base class of all activities
 */
abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> :
    DaggerAppCompatActivity(),
    BaseScreen<VB, VM> {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    protected val binding: VB by unsafeLazy { inflateBinding(layoutInflater) }

    protected val viewModel: VM by unsafeLazy { createViewModel(viewModelFactory) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.let {
            setContentView(it.root)
            listenViewModelErrors(it)
            onViewBound(it, savedInstanceState)
        }
    }

    private fun listenViewModelErrors(binding: VB) {
        repeatOnStarted {
            viewModel.errorFlow.collect { handleError(binding, it) }
        }
    }

    override fun handleError(binding: VB, throwable: Throwable) {
        Snackbar.make(binding.root, R.string.error_occurred, Snackbar.LENGTH_LONG).show()
    }
}
