@file:OptIn(ExperimentalMaterial3Api::class)

package io.kdomskia.compose.material3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.foundation.layout.RowScope
import io.kdomskia.compose.foundation.layout.WindowInsets
import io.kdomskia.compose.foundation.layout.skia
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.CenterAlignedTopAppBar as SkiaCenterAlignedTopAppBar
import androidx.compose.material3.TopAppBar as SkiaTopAppBar

val TopAppBarColors.skia: SkiaTopAppBarColors
    get() = _skia

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
    SkiaTopAppBar(
        title = title,
        modifier = modifier.skia,
        navigationIcon = navigationIcon,
        actions = { actions(RowScope(this)) },
        expandedHeight = expandedHeight,
        windowInsets = windowInsets.skia,
        colors = colors.skia
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
    SkiaCenterAlignedTopAppBar(
        title = title,
        modifier = modifier.skia,
        navigationIcon = navigationIcon,
        actions = { actions(RowScope(this)) },
        expandedHeight = expandedHeight,
        windowInsets = windowInsets.skia,
        colors = colors.skia
    )
}