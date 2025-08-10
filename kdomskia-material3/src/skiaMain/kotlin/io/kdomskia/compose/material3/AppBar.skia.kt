@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package io.kdomskia.compose.material3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.foundation.layout.RowScope
import io.kdomskia.compose.foundation.layout.WindowInsets
import io.kdomskia.compose.foundation.layout.skia
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.TopAppBar as SkiaTopAppBar

val TopAppBarColors.skia: SkiaTopAppBarColors
    get() = _skia

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
    SkiaTopAppBar(
        title = title,
        modifier = modifier.skia,
        subtitle = {},
        navigationIcon = navigationIcon,
        actions = { actions(RowScope(this)) },
        titleHorizontalAlignment = titleHorizontalAlignment.skia,
        expandedHeight = expandedHeight,
        windowInsets = windowInsets.skia,
        colors = colors.skia
    )
}