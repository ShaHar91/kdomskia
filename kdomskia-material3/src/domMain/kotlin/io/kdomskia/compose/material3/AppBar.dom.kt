package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.foundation.layout.RowScope
import io.kdomskia.compose.foundation.layout.WindowInsets
import io.kdomskia.compose.material3.beer.BeerTopAppBar
import io.kdomskia.compose.ui.Modifier

@Composable
actual fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    titleHorizontalAlignment: Alignment.Horizontal,
    expandedHeight: Dp,
    windowInsets: WindowInsets,
    colors: TopAppBarColors
) {
    BeerTopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        titleHorizontalAlignment = titleHorizontalAlignment,
        expandedHeight = expandedHeight,
        colors = colors
    )
}