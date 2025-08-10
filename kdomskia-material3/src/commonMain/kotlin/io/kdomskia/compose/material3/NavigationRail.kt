package io.kdomskia.compose.material3

import io.kdomskia.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import io.kdomskia.compose.foundation.layout.ColumnScope
import io.kdomskia.compose.foundation.layout.kdomskia
import io.kdomskia.compose.ui.Modifier

@Composable
expect fun NavigationRail(
    modifier: Modifier = Modifier,
    containerColor: Color = NavigationRailDefaults.ContainerColor,
    contentColor: Color = contentColorFor(containerColor),
    header: @Composable (ColumnScope.() -> Unit)? = null,
    windowInsets: WindowInsets = NavigationRailDefaults.windowInsets,
    content: @Composable ColumnScope.() -> Unit,
)

@Composable
expect fun NavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
    colors: NavigationRailItemColors = NavigationRailItemDefaults.colors()
)

@Immutable
class NavigationRailItemColors(
    selectedIconColor: Color,
    selectedTextColor: Color,
    selectedIndicatorColor: Color,
    unselectedIconColor: Color,
    unselectedTextColor: Color,
    disabledIconColor: Color,
    disabledTextColor: Color,
) {

    internal val _skia = SkiaNavigationRailItemColors(
        selectedIconColor = selectedIconColor,
        selectedTextColor = selectedTextColor,
        selectedIndicatorColor = selectedIndicatorColor,
        unselectedIconColor = unselectedIconColor,
        unselectedTextColor = unselectedTextColor,
        disabledIconColor = disabledIconColor,
        disabledTextColor = disabledTextColor
    )

    val selectedIconColor: Color
        get() = _skia.selectedIconColor

    val selectedTextColor: Color
        get() = _skia.selectedTextColor

    val selectedIndicatorColor: Color
        get() = _skia.selectedIndicatorColor

    val unselectedIconColor: Color
        get() = _skia.unselectedIconColor

    val unselectedTextColor: Color
        get() = _skia.unselectedTextColor

    val disabledIconColor: Color
        get() = _skia.disabledIconColor

    val disabledTextColor: Color
        get() = _skia.disabledTextColor

    fun copy(
        selectedIconColor: Color = this.selectedIconColor,
        selectedTextColor: Color = this.selectedTextColor,
        selectedIndicatorColor: Color = this.selectedIndicatorColor,
        unselectedIconColor: Color = this.unselectedIconColor,
        unselectedTextColor: Color = this.unselectedTextColor,
        disabledIconColor: Color = this.disabledIconColor,
        disabledTextColor: Color = this.disabledTextColor,
    ) = NavigationRailItemColors(
        selectedIconColor.takeOrElse { this.selectedIconColor },
        selectedTextColor.takeOrElse { this.selectedTextColor },
        selectedIndicatorColor.takeOrElse { this.selectedIndicatorColor },
        unselectedIconColor.takeOrElse { this.unselectedIconColor },
        unselectedTextColor.takeOrElse { this.unselectedTextColor },
        disabledIconColor.takeOrElse { this.disabledIconColor },
        disabledTextColor.takeOrElse { this.disabledTextColor },
    )

    @Stable
    internal fun iconColor(selected: Boolean, enabled: Boolean): Color = when {
        !enabled -> disabledIconColor
        selected -> selectedIconColor
        else -> unselectedIconColor
    }

    @Stable
    internal fun textColor(selected: Boolean, enabled: Boolean): Color = when {
        !enabled -> disabledTextColor
        selected -> selectedTextColor
        else -> unselectedTextColor
    }

    internal val indicatorColor: Color
        get() = selectedIndicatorColor

    override fun toString() = _skia.toString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is NavigationRailItemColors) return false

        return _skia == other._skia
    }

    override fun hashCode() = _skia.hashCode()

}

object NavigationRailDefaults {

    internal val HeaderPadding = 8.dp

    internal val VerticalPadding = 4.dp

    internal val IconLabelSpace = 4.0.dp

    internal val NarrowContainerWidth = 80.dp

    val ContainerColor: Color
        @Composable
        get() = SkiaNavigationRailDefaults.ContainerColor

    val windowInsets: WindowInsets
        @Composable
        get() = SkiaNavigationRailDefaults.windowInsets.kdomskia

}

object NavigationRailItemDefaults {

    val Height = 32.dp

    val Width = 56.dp

    val VerticalPadding = 2.dp

    val VerticalPaddingNoLabel = 14.dp

    @Composable
    fun colors() = SkiaNavigationRailItemDefaults.colors().kdomskia

    val LabelTextFont: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.labelMedium

}

internal typealias SkiaNavigationRailDefaults = androidx.compose.material3.NavigationRailDefaults

internal typealias SkiaNavigationRailItemColors = androidx.compose.material3.NavigationRailItemColors

internal typealias SkiaNavigationRailItemDefaults = androidx.compose.material3.NavigationRailItemDefaults

internal val SkiaNavigationRailItemColors.kdomskia: NavigationRailItemColors
    get() = NavigationRailItemColors(
        selectedIconColor = selectedIconColor,
        selectedTextColor = selectedTextColor,
        selectedIndicatorColor = selectedIndicatorColor,
        unselectedIconColor = unselectedIconColor,
        unselectedTextColor = unselectedTextColor,
        disabledIconColor = disabledIconColor,
        disabledTextColor = disabledTextColor
    )