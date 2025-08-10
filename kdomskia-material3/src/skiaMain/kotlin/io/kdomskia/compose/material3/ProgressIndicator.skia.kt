package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.CircularProgressIndicator as SkiaCircularProgressIndicator

@Composable
actual fun CircularProgressIndicator(
    modifier: Modifier,
    color: Color,
    strokeWidth: Dp
) {
    SkiaCircularProgressIndicator(
        modifier = modifier.skia,
        color = color,
        strokeWidth = strokeWidth
    )
}