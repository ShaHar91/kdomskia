package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.foundation.layout.RowScope
import io.kdomskia.compose.foundation.layout.WindowInsets
import io.kdomskia.compose.material3.beer.BeerTopAppBar
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier

@Composable
actual fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    expandedHeight: Dp,
    windowInsets: WindowInsets,
    colors: TopAppBarColors
) {
    BeerTopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        titleHorizontalAlignment = Alignment.Start,
        expandedHeight = expandedHeight,
        colors = colors
    )
}

@Composable
actual fun CenterAlignedTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    expandedHeight: Dp,
    windowInsets: WindowInsets,
    colors: TopAppBarColors
) {
    BeerTopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        titleHorizontalAlignment = Alignment.CenterHorizontally,
        expandedHeight = expandedHeight,
        colors = colors
    )
}