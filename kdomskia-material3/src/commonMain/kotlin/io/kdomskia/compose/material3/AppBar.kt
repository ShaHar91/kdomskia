@file:OptIn(ExperimentalMaterial3Api::class)

package io.kdomskia.compose.material3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.foundation.layout.RowScope
import io.kdomskia.compose.foundation.layout.WindowInsets
import io.kdomskia.compose.foundation.layout.kdomskia
import io.kdomskia.compose.ui.Modifier

internal typealias SkiaTopAppBarColors = androidx.compose.material3.TopAppBarColors
internal typealias SkiaTopAppBarDefaults = androidx.compose.material3.TopAppBarDefaults

@Composable
expect fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    expandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors()
)

@Composable
expect fun CenterAlignedTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    expandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors()
)

internal val SkiaTopAppBarColors.kdomskia: TopAppBarColors
    get() = TopAppBarColors(
        containerColor = containerColor,
        scrolledContainerColor = scrolledContainerColor,
        navigationIconContentColor = navigationIconContentColor,
        titleContentColor = titleContentColor,
        actionIconContentColor = actionIconContentColor,
        subtitleContentColor = subtitleContentColor
    )

@Stable
class TopAppBarColors(
    containerColor: Color,
    scrolledContainerColor: Color,
    navigationIconContentColor: Color,
    titleContentColor: Color,
    actionIconContentColor: Color,
    subtitleContentColor: Color
) {

    internal val _skia = SkiaTopAppBarColors(
        containerColor = containerColor,
        scrolledContainerColor = scrolledContainerColor,
        navigationIconContentColor = navigationIconContentColor,
        titleContentColor = titleContentColor,
        actionIconContentColor = actionIconContentColor,
        subtitleContentColor = subtitleContentColor
    )

    val containerColor: Color
        get() = _skia.containerColor

    val scrolledContainerColor: Color
        get() = _skia.scrolledContainerColor

    val navigationIconContentColor: Color
        get() = _skia.navigationIconContentColor

    val titleContentColor: Color
        get() = _skia.titleContentColor

    val actionIconContentColor: Color
        get() = _skia.actionIconContentColor

    val subtitleContentColor: Color
        get() = _skia.subtitleContentColor

    fun copy(
        containerColor: Color = this.containerColor,
        scrolledContainerColor: Color = this.scrolledContainerColor,
        navigationIconContentColor: Color = this.navigationIconContentColor,
        titleContentColor: Color = this.titleContentColor,
        actionIconContentColor: Color = this.actionIconContentColor,
        subtitleContentColor: Color = this.subtitleContentColor,
    ) = TopAppBarColors(
        containerColor.takeOrElse { this.containerColor },
        scrolledContainerColor.takeOrElse { this.scrolledContainerColor },
        navigationIconContentColor.takeOrElse { this.navigationIconContentColor },
        titleContentColor.takeOrElse { this.titleContentColor },
        actionIconContentColor.takeOrElse { this.actionIconContentColor },
        subtitleContentColor.takeOrElse { this.subtitleContentColor }
    )

    override fun toString() = _skia.toString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is TopAppBarColors) return false

        return _skia == other._skia
    }

    override fun hashCode() = _skia.hashCode()

}

object TopAppBarDefaults {

    @Composable
    fun topAppBarColors() = SkiaTopAppBarDefaults.topAppBarColors().kdomskia

    val TopAppBarExpandedHeight: Dp = SkiaTopAppBarDefaults.TopAppBarExpandedHeight

    val windowInsets: WindowInsets
        @Composable
        get() = SkiaTopAppBarDefaults.windowInsets.kdomskia

}