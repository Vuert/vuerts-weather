package com.vuerts.weather.di.module.mainactivity

import com.vuerts.weather.MainActivity
import com.vuerts.weather.di.annotations.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [BaseViewModelModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
