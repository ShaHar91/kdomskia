package io.kdomskia.compose.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.border as skiaBorder

@Stable
actual fun Modifier.border(
    border: BorderStroke,
    shape: Shape
) = unwrap { skiaBorder(border = border, shape = shape) }

@Stable
actual fun Modifier.border(
    width: Dp,
    color: Color,
    shape: Shape
) = unwrap { skiaBorder(width = width, color = color, shape = shape) }

@Stable
actual fun Modifier.border(
    width: Dp,
    brush: Brush,
    shape: Shape
) = unwrap { skiaBorder(width = width, brush = brush, shape = shape) }