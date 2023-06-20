package com.vuerts.weather.view.base

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vuerts.weather.presentation.base.viewmodel.BaseViewModel
import com.vuerts.weather.view.theme.AppTheme
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

val LocalViewModelFactory = staticCompositionLocalOf<ViewModelProvider.Factory> {
    error("CompositionLocal LocalViewModelFactory not present")
}

@Composable
inline fun <reified VM : BaseViewModel> injectViewModel(): VM =
    viewModel(factory = LocalViewModelFactory.current)

/**
 * Base class of all activities
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                CompositionLocalProvider(LocalViewModelFactory provides viewModelFactory) {
                    Content()
                }
            }
        }
    }

    @Composable
    protected open fun Content() {
        // Empty
    }
}
