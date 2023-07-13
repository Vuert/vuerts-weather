package com.vuerts.weather.view.impl.activity

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.vuerts.weather.view.base.BaseActivity
import com.vuerts.weather.view.impl.navigation.AppNavHost

class SingleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
    }

    @Composable
    override fun Content() {
        AppNavHost()
    }
}
