package com.vuerts.weather.di.module.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import javax.inject.Provider

/**
 * Common factory for all ViewModels, used for dependency injection in Dagger
 */
class ViewModelFactory(
    private val viewModelProvidersMap: Map<Class<out ViewModel>, Provider<BaseViewModel>>,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        try {
            viewModelProvidersMap[modelClass]?.get() as T
        } catch (_: Throwable) {
            throw NoSuchElementException("Cannot create ViewModel for $modelClass")
        }
}
