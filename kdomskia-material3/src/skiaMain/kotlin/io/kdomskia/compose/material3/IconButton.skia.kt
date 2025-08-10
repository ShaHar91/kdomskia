package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.IconButton as SkiaIconButton

val IconButtonColors.skia: SkiaIconButtonColors
    get() = _skia

@Composable
actual fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    colors: IconButtonColors,
    shape: Shape,
    content: @Composable () -> Unit
) {
    SkiaIconButton(
        onClick = onClick,
        modifier = modifier.skia,
        enabled = enabled,
        colors = colors.skia,
        shape = shape,
        content = content
    )
}