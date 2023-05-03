package com.vuerts.weather.di.module.activity

import com.vuerts.weather.view.impl.activity.MainActivity
import com.vuerts.weather.di.annotations.scope.ActivityScope
import com.vuerts.weather.di.module.fragment.FragmentBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            BaseViewModelModule::class,
            FragmentBindingModule::class,
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}
