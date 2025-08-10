package io.kdomskia.compose.material3

import io.kdomskia.compose.foundation.layout.WindowInsets
import io.kdomskia.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.kdomskia.compose.foundation.layout.ColumnScope
import io.kdomskia.compose.foundation.layout.kdomskia
import io.kdomskia.compose.ui.Modifier

enum class DrawerValue {

    Closed,

    Open,

}

@Stable
expect class DrawerState(
    initialValue: DrawerValue,
    confirmStateChange: (DrawerValue) -> Boolean = { true },
) {

    val isOpen: Boolean

    val isClosed: Boolean

    val currentValue: DrawerValue

    suspend fun open()

    suspend fun close()

    companion object {

        fun Saver(confirmStateChange: (DrawerValue) -> Boolean): Saver<DrawerState, DrawerValue>

    }

}

@Composable
expect fun ModalNavigationDrawer(
    drawerContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    gesturesEnabled: Boolean = true,
    scrimColor: Color = DrawerDefaults.scrimColor,
    content: @Composable () -> Unit,
)

@Composable
expect fun ModalDrawerSheet(
    modifier: Modifier = Modifier,
    drawerShape: Shape = DrawerDefaults.shape,
    drawerContainerColor: Color = DrawerDefaults.modalContainerColor,
    drawerContentColor: Color = contentColorFor(drawerContainerColor),
    drawerTonalElevation: Dp = DrawerDefaults.ModalDrawerElevation,
    windowInsets: WindowInsets = DrawerDefaults.windowInsets,
    content: @Composable ColumnScope.() -> Unit,
)

@Composable
expect fun NavigationDrawerItem(
    label: @Composable () -> Unit,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    badge: (@Composable () -> Unit)? = null,
    shape: Shape = DrawerDefaults.ActiveIndicatorShape,
    colors: NavigationDrawerItemColors = NavigationDrawerItemDefaults.colors()
)

@Composable
fun rememberDrawerState(
    initialValue: DrawerValue,
    confirmStateChange: (DrawerValue) -> Boolean = { true },
): DrawerState {
    return rememberSaveable(saver = DrawerState.Saver(confirmStateChange)) {
        DrawerState(initialValue, confirmStateChange)
    }
}

@Stable
interface NavigationDrawerItemColors {

    @Composable
    fun iconColor(selected: Boolean): State<Color>

    @Composable
    fun textColor(selected: Boolean): State<Color>

    @Composable
    fun badgeColor(selected: Boolean): State<Color>

    @Composable
    fun containerColor(selected: Boolean): State<Color>
}

private class DefaultDrawerItemsColor(
    val skia: SkiaNavigationDrawerItemColors
) : NavigationDrawerItemColors {

    @Composable
    override fun iconColor(selected: Boolean) = skia.iconColor(selected)

    @Composable
    override fun textColor(selected: Boolean) = skia.textColor(selected)

    @Composable
    override fun badgeColor(selected: Boolean) = skia.badgeColor(selected)

    @Composable
    override fun containerColor(selected: Boolean) = skia.containerColor(selected)

    override fun toString() = skia.toString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is DefaultDrawerItemsColor) return false

        return skia == other.skia
    }

    override fun hashCode() = skia.hashCode()

}

typealias SkiaDrawerState = androidx.compose.material3.DrawerState

typealias SkiaDrawerValue = androidx.compose.material3.DrawerValue

typealias SkiaDrawerDefaults = androidx.compose.material3.DrawerDefaults

typealias SkiaNavigationDrawerItemColors = androidx.compose.material3.NavigationDrawerItemColors

typealias SkiaNavigationDrawerItemDefaults = androidx.compose.material3.NavigationDrawerItemDefaults

internal val SkiaDrawerValue.kdomskia: DrawerValue
    get() = when (this) {
        SkiaDrawerValue.Closed -> DrawerValue.Closed
        SkiaDrawerValue.Open -> DrawerValue.Open
    }

internal val NavigationDrawerItemColors._skia: SkiaNavigationDrawerItemColors
    get() = (this as DefaultDrawerItemsColor).skia

private val skiaDefaultItemColors: SkiaNavigationDrawerItemColors
    @Composable
    get() = SkiaNavigationDrawerItemDefaults.colors()

object DrawerDefaults {

    internal val ActiveIndicatorHeight = 56.dp

    internal val MaxDrawerWidth = 360.dp

    val ActiveIndicatorShape = CircleShape

    val ModalDrawerElevation = SkiaDrawerDefaults.ModalDrawerElevation

    val PermanentDrawerElevation = SkiaDrawerDefaults.PermanentDrawerElevation

    val DismissibleDrawerElevation = SkiaDrawerDefaults.DismissibleDrawerElevation

    val shape: Shape
        @Composable get() = SkiaDrawerDefaults.shape

    val scrimColor: Color
        @Composable get() = SkiaDrawerDefaults.scrimColor

    val standardContainerColor: Color
        @Composable get() = SkiaDrawerDefaults.standardContainerColor

    val modalContainerColor: Color
        @Composable get() = SkiaDrawerDefaults.modalContainerColor

    val MaximumDrawerWidth = SkiaDrawerDefaults.MaximumDrawerWidth

    val windowInsets: WindowInsets
        @Composable
        get() = SkiaDrawerDefaults.windowInsets.kdomskia

}

object NavigationDrawerItemDefaults {

    @Composable
    fun colors(
        selectedContainerColor: Color = skiaDefaultItemColors.containerColor(selected = true).value,
        unselectedContainerColor: Color = skiaDefaultItemColors.containerColor(selected = false).value,
        selectedIconColor: Color = skiaDefaultItemColors.iconColor(selected = true).value,
        unselectedIconColor: Color = skiaDefaultItemColors.iconColor(selected = false).value,
        selectedTextColor: Color = skiaDefaultItemColors.textColor(selected = true).value,
        unselectedTextColor: Color = skiaDefaultItemColors.textColor(selected = false).value,
        selectedBadgeColor: Color = selectedTextColor,
        unselectedBadgeColor: Color = unselectedTextColor,
    ): NavigationDrawerItemColors {
        return DefaultDrawerItemsColor(
            skia = SkiaNavigationDrawerItemDefaults.colors(
                selectedContainerColor = selectedContainerColor,
                unselectedContainerColor = unselectedContainerColor,
                selectedIconColor = selectedIconColor,
                unselectedIconColor = unselectedIconColor,
                selectedTextColor = selectedTextColor,
                unselectedTextColor = unselectedTextColor,
                selectedBadgeColor = selectedBadgeColor,
                unselectedBadgeColor = unselectedBadgeColor
            )
        )
    }

}