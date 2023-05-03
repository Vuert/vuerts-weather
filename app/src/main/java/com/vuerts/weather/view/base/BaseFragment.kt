package com.vuerts.weather.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import com.vuerts.weather.utils.extensions.common.unsafeLazy
import com.vuerts.weather.utils.extensions.lifecycle.launchOnLifecycleDestroy
import com.vuerts.weather.utils.extensions.lifecycle.repeatOnStarted
import com.vuerts.weather.utils.extensions.view.createViewModel
import com.vuerts.weather.utils.extensions.view.inflateBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> :
    DaggerFragment(),
    BaseScreen<VB, VM> {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    protected var binding: VB? = null

    protected val viewModel: VM by unsafeLazy { createViewModel(viewModelFactory) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflateBinding(inflater, container, false)
        .also {
            binding = it
            viewLifecycleOwner.launchOnLifecycleDestroy { binding = null }
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireBinding().let {
            listenViewModelErrors(it)
            onViewBound(it, savedInstanceState)
        }
    }

    private fun listenViewModelErrors(binding: VB) {
        viewLifecycleOwner.repeatOnStarted {
            viewModel.errorFlow.collect { handleError(binding, it) }
        }
    }

    protected fun requireBinding(): VB = requireNotNull(binding) {
        "Binding is null"
    }
}
