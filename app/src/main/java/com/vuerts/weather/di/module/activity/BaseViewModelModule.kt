package com.vuerts.weather.di.module.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vuerts.weather.di.annotations.scope.ActivityScope
import com.vuerts.weather.presentation.base.datadelegate.PresentationDataDelegate
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import com.vuerts.weather.presentation.impl.common.datadelegate.DefaultPresentationDataDelegate
import com.vuerts.weather.utils.concurrent.errorhandling.CoroutineExceptionHandler
import com.vuerts.weather.utils.logging.base.BaseLogger
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class BaseViewModelModule {

    @Provides
    fun providePresentationDataDelegate(
        logger: BaseLogger,
    ): PresentationDataDelegate =
        DefaultPresentationDataDelegate(
            logger = logger,
            unexpectedExceptionHandler = CoroutineExceptionHandler(logger),
        )

    @Provides
    @ActivityScope
    fun provideViewModelFactory(
        viewModelProvidersMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<BaseViewModel>>,
    ): ViewModelProvider.Factory = ViewModelFactory(viewModelProvidersMap)
}
