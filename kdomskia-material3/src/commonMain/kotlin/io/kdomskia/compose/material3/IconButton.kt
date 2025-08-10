package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import io.kdomskia.compose.ui.Modifier

internal typealias SkiaIconButtonColors = androidx.compose.material3.IconButtonColors
internal typealias SkiaIconButtonDefaults = androidx.compose.material3.IconButtonDefaults

@Composable
expect fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    shape: Shape = IconButtonDefaults.standardShape,
    content: @Composable () -> Unit
)

internal val SkiaIconButtonColors.kdomskia: IconButtonColors
    get() = IconButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

@Immutable
class IconButtonColors(
    containerColor: Color,
    contentColor: Color,
    disabledContainerColor: Color,
    disabledContentColor: Color,
) {

    internal val _skia = SkiaIconButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    val containerColor: Color
        get() = _skia.containerColor

    val contentColor: Color
        get() = _skia.contentColor

    val disabledContainerColor: Color
        get() = _skia.disabledContainerColor

    val disabledContentColor: Color
        get() = _skia.disabledContentColor

    fun copy(
        containerColor: Color = this.containerColor,
        contentColor: Color = this.contentColor,
        disabledContainerColor: Color = this.disabledContainerColor,
        disabledContentColor: Color = this.disabledContentColor
    ): IconButtonColors = _skia.copy(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    ).kdomskia

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is IconButtonColors) return false

        return _skia == other._skia
    }

    override fun hashCode() = _skia.hashCode()


}

object IconButtonDefaults {

    @Composable
    fun iconButtonColors(): IconButtonColors = SkiaIconButtonDefaults.iconButtonColors().kdomskia

    val standardShape: Shape
        @Composable
        get() = SkiaIconButtonDefaults.standardShape

}