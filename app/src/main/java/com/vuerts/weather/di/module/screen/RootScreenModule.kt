package com.vuerts.weather.di.module.screen

import com.vuerts.weather.di.annotations.key.ViewModelKey
import com.vuerts.weather.presentation.base.datadelegate.PresentationDataDelegate
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import com.vuerts.weather.presentation.impl.root.viewmodel.RootViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [RootScreenModule.Binder::class])
class RootScreenModule {

    @Provides
    fun provideViewModel(
        dataDelegate: PresentationDataDelegate,
    ): RootViewModel = RootViewModel(dataDelegate)

    @Module
    interface Binder {

        @Binds
        @IntoMap
        @ViewModelKey(RootViewModel::class)
        fun bindViewModel(viewModel: RootViewModel): BaseViewModel
    }
}
