package com.vuerts.weather.view.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import com.vuerts.weather.utils.extensions.view.createViewModel
import com.vuerts.weather.utils.extensions.view.inflateBinding
import com.vuerts.weather.utils.extensions.lifecycle.repeatOnStarted
import com.vuerts.weather.utils.extensions.common.unsafeLazy
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
}
