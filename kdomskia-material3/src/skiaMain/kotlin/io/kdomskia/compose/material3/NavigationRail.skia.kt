package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.kdomskia.compose.foundation.layout.ColumnScope
import io.kdomskia.compose.foundation.layout.WindowInsets
import io.kdomskia.compose.foundation.layout.skia
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.NavigationRail as SkiaNavigationRail
import androidx.compose.material3.NavigationRailItem as SkiaNavigationRailItem

val NavigationRailItemColors.skia: SkiaNavigationRailItemColors
    get() = _skia

@Composable
actual fun NavigationRail(
    modifier: Modifier,
    containerColor: Color,
    contentColor: Color,
    header: @Composable (ColumnScope.() -> Unit)?,
    windowInsets: WindowInsets,
    content: @Composable (ColumnScope.() -> Unit)
) {
    SkiaNavigationRail(
        modifier = modifier.skia,
        containerColor = containerColor,
        contentColor = contentColor,
        header = { header?.invoke(ColumnScope(this)) },
        windowInsets = windowInsets.skia,
        content = { content(ColumnScope(this)) }
    )
}

@Composable
actual fun NavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    label: @Composable (() -> Unit)?,
    alwaysShowLabel: Boolean,
    colors: NavigationRailItemColors
) {
    SkiaNavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        modifier = modifier.skia,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = colors.skia
    )
}