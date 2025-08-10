package io.kdomskia.compose.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier

@Stable
expect fun Modifier.border(border: BorderStroke, shape: Shape = RectangleShape): Modifier

@Stable
expect fun Modifier.border(width: Dp, color: Color, shape: Shape = RectangleShape): Modifier

@Stable
expect fun Modifier.border(width: Dp, brush: Brush, shape: Shape): Modifier