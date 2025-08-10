package io.kdomskia.compose.material3

import io.kdomskia.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.foundation.layout.ColumnScope
import io.kdomskia.compose.foundation.layout.skia
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.ModalDrawerSheet as SkiaModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer as SkiaModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem as SkiaNavigationDrawerItem

@Stable
actual class DrawerState actual constructor(
    initialValue: DrawerValue,
    confirmStateChange: (DrawerValue) -> Boolean
) {

    internal val _skia = SkiaDrawerState(
        initialValue = initialValue.skia,
        confirmStateChange = { confirmStateChange(it.kdomskia) }
    )

    actual val isOpen: Boolean
        get() = _skia.isOpen

    actual val isClosed: Boolean
        get() = _skia.isClosed

    actual val currentValue: DrawerValue
        get() = _skia.currentValue.kdomskia

    actual suspend fun open() = _skia.open()

    actual suspend fun close() = _skia.close()

    actual companion object {

        actual fun Saver(confirmStateChange: (DrawerValue) -> Boolean) =
            Saver<DrawerState, DrawerValue>(
                save = { it.currentValue },
                restore = { DrawerState(it, confirmStateChange) },
            )

    }

}

internal val DrawerValue.skia: SkiaDrawerValue
    get() = when (this) {
        DrawerValue.Closed -> SkiaDrawerValue.Closed
        DrawerValue.Open -> SkiaDrawerValue.Open
    }

@Composable
actual fun ModalNavigationDrawer(
    drawerContent: @Composable (() -> Unit),
    modifier: Modifier,
    drawerState: DrawerState,
    gesturesEnabled: Boolean,
    scrimColor: Color,
    content: @Composable (() -> Unit)
) {
    SkiaModalNavigationDrawer(
        drawerContent = drawerContent,
        modifier = modifier.skia,
        drawerState = drawerState._skia,
        gesturesEnabled = gesturesEnabled,
        scrimColor = scrimColor,
        content = content
    )
}

@Composable
actual fun ModalDrawerSheet(
    modifier: Modifier,
    drawerShape: Shape,
    drawerContainerColor: Color,
    drawerContentColor: Color,
    drawerTonalElevation: Dp,
    windowInsets: WindowInsets,
    content: @Composable (ColumnScope.() -> Unit)
) {
    SkiaModalDrawerSheet(
        modifier = modifier.skia,
        drawerShape = drawerShape,
        drawerContainerColor = drawerContainerColor,
        drawerContentColor = drawerContentColor,
        drawerTonalElevation = drawerTonalElevation,
        windowInsets = windowInsets.skia,
        content = { content(ColumnScope(this)) }
    )
}

@Composable
actual fun NavigationDrawerItem(
    label: @Composable (() -> Unit),
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
    icon: @Composable (() -> Unit)?,
    badge: @Composable (() -> Unit)?,
    shape: Shape,
    colors: NavigationDrawerItemColors
) {
    SkiaNavigationDrawerItem(
        label = label,
        selected = selected,
        onClick = onClick,
        modifier = modifier.skia,
        icon = icon,
        badge = badge,
        shape = shape,
        colors = colors._skia
    )
}