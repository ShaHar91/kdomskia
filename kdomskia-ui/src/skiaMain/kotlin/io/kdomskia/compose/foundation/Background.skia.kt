package io.kdomskia.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.foundation.shape.DottedShape
import io.kdomskia.compose.ui.Modifier

@Stable
actual fun Modifier.background(color: Color) = unwrap { background(color) }

@Stable
actual fun Modifier.dottedShapeBackground(
    color: Color,
    size: Dp,
    spacing: Dp
) = unwrap {
    background(
        color = color,
        shape = DottedShape(
            width = size,
            spacing = size
        )
    )
}