package io.kdomskia.compose.foundation

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier

@Stable
expect fun Modifier.background(color: Color): Modifier

@Stable
expect fun Modifier.dottedShapeBackground(
    color: Color,
    size: Dp,
    spacing: Dp
): Modifier