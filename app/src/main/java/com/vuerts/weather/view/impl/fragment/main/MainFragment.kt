package com.vuerts.weather.view.impl.fragment.main

import android.os.Bundle
import com.vuerts.weather.data.forecast.datasource.ForecastRemoteDatasource
import com.vuerts.weather.databinding.FragmentMainBinding
import com.vuerts.weather.domain.city.Location
import com.vuerts.weather.presentation.stub.viewmodel.EmptyViewModel
import com.vuerts.weather.utils.extensions.view.viewLifecycleScope
import com.vuerts.weather.view.base.BaseFragment
import kotlinx.coroutines.launch

class MainFragment : BaseFragment<FragmentMainBinding, EmptyViewModel>() {

    private val datasource = ForecastRemoteDatasource()

    override fun onViewBound(binding: FragmentMainBinding, savedInstanceState: Bundle?) {
        viewLifecycleScope.launch {
            datasource.getForecast(Location("", "London", 44.34, 10.99))
                .also {
                    it
                }
        }
    }
}
