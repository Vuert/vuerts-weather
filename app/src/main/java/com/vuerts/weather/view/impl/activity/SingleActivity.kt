package com.vuerts.weather.view.impl.activity

import androidx.compose.runtime.Composable
import com.vuerts.weather.view.base.BaseActivity
import com.vuerts.weather.view.impl.navigation.AppNavHost

class SingleActivity : BaseActivity() {

    @Composable
    override fun Content() {
        AppNavHost()
    }
}
