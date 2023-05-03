package com.vuerts.weather.di.module.fragment

import com.vuerts.weather.view.impl.fragment.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}
