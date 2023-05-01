package com.vuerts.weather.di.module.mainactivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vuerts.weather.di.annotations.key.ViewModelKey
import com.vuerts.weather.di.annotations.scope.ActivityScope
import com.vuerts.weather.presentation.base.datadelegate.PresentationDataDelegate
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import com.vuerts.weather.presentation.impl.datadelegate.DefaultPresentationDataDelegate
import com.vuerts.weather.presentation.stub.viewmodel.EmptyViewModel
import com.vuerts.weather.utils.concurrent.errorhandling.CoroutineExceptionHandler
import com.vuerts.weather.utils.logging.base.BaseLogger
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module(includes = [BaseViewModelModule.Binder::class])
class BaseViewModelModule {

    @Provides
    @ActivityScope
    fun providePresentationDataDelegate(
        logger: BaseLogger,
    ): PresentationDataDelegate =
        DefaultPresentationDataDelegate(
            logger = logger,
            unexpectedExceptionHandler = CoroutineExceptionHandler(logger),
        )

    @Provides
    @ActivityScope
    fun provideEmptyViewModel(
        dataDelegate: PresentationDataDelegate,
    ): EmptyViewModel = EmptyViewModel(dataDelegate)

    @Provides
    fun provideViewModelFactory(
        viewModelProvidersMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<BaseViewModel>>,
    ): ViewModelProvider.Factory = ViewModelFactory(viewModelProvidersMap)

    @Module
    interface Binder {

        @Binds
        @IntoMap
        @ViewModelKey(EmptyViewModel::class)
        fun bindViewEmptyViewModel(emptyViewModel: EmptyViewModel): BaseViewModel
    }
}
