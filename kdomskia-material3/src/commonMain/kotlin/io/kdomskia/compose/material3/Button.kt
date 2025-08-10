package io.kdomskia.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.foundation.layout.RowScope
import io.kdomskia.compose.foundation.layout.kdomskia
import io.kdomskia.compose.ui.Modifier

internal typealias SkiaButtonColors = androidx.compose.material3.ButtonColors
internal typealias SkiaButtonDefaults = androidx.compose.material3.ButtonDefaults

@Composable
expect fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
)

@Composable
expect fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.outlinedShape,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    border: BorderStroke? = ButtonDefaults.outlinedButtonBorder(enabled),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
)

@Composable
expect fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.textShape,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    content: @Composable RowScope.() -> Unit
)

@Composable
expect fun ElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.elevatedShape,
    colors: ButtonColors = ButtonDefaults.elevatedButtonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
)

internal val SkiaButtonColors.kdomskia: ButtonColors
    get() = ButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

@Immutable
class ButtonColors(
    containerColor: Color,
    contentColor: Color,
    disabledContainerColor: Color,
    disabledContentColor: Color
) {

    internal val _skia = SkiaButtonColors(
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
    ): ButtonColors = ButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is ButtonColors) return false

        return _skia == other._skia
    }

    override fun hashCode() = _skia.hashCode()

}

object ButtonDefaults {

    @Composable
    fun buttonColors() = SkiaButtonDefaults.buttonColors().kdomskia

    @Composable
    fun outlinedButtonColors() = SkiaButtonDefaults.outlinedButtonColors().kdomskia

    @Composable
    fun elevatedButtonColors() = SkiaButtonDefaults.elevatedButtonColors().kdomskia

    @Composable
    fun outlinedButtonBorder(
        enabled: Boolean = true
    ): BorderStroke = SkiaButtonDefaults.outlinedButtonBorder(enabled = enabled)

    @Composable
    fun textButtonColors() = SkiaButtonDefaults.textButtonColors().kdomskia

    val shape: Shape
        @Composable
        get() = SkiaButtonDefaults.shape

    val elevatedShape: Shape
        @Composable
        get() = SkiaButtonDefaults.elevatedShape

    val filledTonalShape: Shape
        @Composable
        get() = SkiaButtonDefaults.filledTonalShape

    val outlinedShape: Shape
        @Composable
        get() = SkiaButtonDefaults.outlinedShape

    val textShape: Shape
        @Composable
        get() = SkiaButtonDefaults.textShape

    val ContentPadding: PaddingValues = SkiaButtonDefaults.ContentPadding.kdomskia

    val TextButtonContentPadding: PaddingValues = SkiaButtonDefaults.TextButtonContentPadding.kdomskia

}