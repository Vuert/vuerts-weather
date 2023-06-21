package com.vuerts.weather.view.impl.screen.weather

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.vuerts.weather.R
import com.vuerts.weather.presentation.impl.weather.viewmodel.WeatherViewModel
import com.vuerts.weather.utils.composable.PullToRefresh
import com.vuerts.weather.view.base.injectViewModel
import kotlinx.coroutines.flow.map

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = injectViewModel(),
) {
    Scaffold { paddings ->
        val isRefreshing = viewModel.isLoading.collectAsState()

        Crossfade(
            targetState = remember { viewModel.forecastStateFlow.map { it == null } }
                .collectAsState(initial = true)
                .value,
        ) { isForecastNull ->
            if (isForecastNull) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddings),
                ) {
                    Text(
                        text = "Empty",
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        PullToRefresh(
            isRefreshing = isRefreshing.value,
            onRefresh = { viewModel.onRefresh() },
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            refreshIndicatorOffset = paddings.calculateTopPadding(),
        ) {
            Crossfade(targetState = viewModel.forecastStateFlow.collectAsState().value) { forecast ->

                if (forecast == null) return@Crossfade

                // TODO fill UI, implement mappers

                Column(modifier = Modifier.padding(paddings)) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(dimensionResource(id = R.dimen.standard_margin)),
                        colors = CardDefaults
                            .cardColors(MaterialTheme.colorScheme.primaryContainer),
                    ) {
                        ConstraintLayout(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(dimensionResource(id = R.dimen.standard_margin))
                        ) {
                            val (
                                dateText,
                                tempText,
                                tempUnitText,
                                conditionText,
                                feelsLikeText,
                                image,
                            ) = createRefs()
                            val centerGuideline = createGuidelineFromStart(0.5f)

                            constrain(
                                createHorizontalChain(
                                    tempText,
                                    tempUnitText,
                                    chainStyle = ChainStyle.Packed(0F)
                                )
                            ) {
                                end.linkTo(centerGuideline)
                            }

                            Text(
                                text = "Sun, 13 April, 11:05",
                                modifier = Modifier.constrainAs(dateText) {
                                    linkTo(parent.start, centerGuideline)
                                    top.linkTo(parent.top)
                                    width = Dimension.fillToConstraints
                                },
                                maxLines = 1,
                                color = MaterialTheme.colorScheme.outline,
                                style = MaterialTheme.typography.labelSmall,
                            )

                            Text(
                                text = "32",
                                modifier = Modifier.constrainAs(tempText) {
                                    top.linkTo(dateText.bottom)
                                    width = Dimension.preferredWrapContent
                                },
                                maxLines = 1,
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.displayLarge,
                            )

                            Text(
                                text = "°C",
                                modifier = Modifier.constrainAs(tempUnitText) {
                                    linkTo(tempText.top, tempText.bottom, bias = 0F)
                                    width = Dimension.preferredWrapContent
                                },
                                maxLines = 1,
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.headlineLarge,
                            )

                            Text(
                                text = "Weather condition",
                                modifier = Modifier
                                    .constrainAs(conditionText) {
                                        linkTo(parent.start, centerGuideline, bias = 0f)
                                        top.linkTo(tempText.bottom)
                                        width = Dimension.fillToConstraints
                                    }
                                    .padding(
                                        top = dimensionResource(R.dimen.half_standard_margin),
                                    ),
                                color = MaterialTheme.colorScheme.outline,
                            )

                            Text(
                                text = "Feels like",
                                modifier = Modifier
                                    .constrainAs(feelsLikeText) {
                                        linkTo(parent.start, centerGuideline, bias = 0f)
                                        linkTo(conditionText.bottom, parent.bottom, bias = 0f)
                                        width = Dimension.fillToConstraints
                                    }
                                    .padding(
                                        top = dimensionResource(R.dimen.quarter_standard_margin),
                                    ),
                                color = MaterialTheme.colorScheme.outline,
                            )

                            Image(
                                modifier = Modifier.constrainAs(image) {
                                    linkTo(centerGuideline, parent.end, bias = 0.8f)
                                    linkTo(parent.top, parent.bottom)
                                    width = Dimension.ratio("1:1")
                                },
                                contentDescription = "",
                                imageVector = ImageVector.vectorResource(
                                    R.drawable.ic_launcher_background,
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
