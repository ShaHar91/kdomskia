package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.HorizontalDivider as SkiaHorizontalDivider
import androidx.compose.material3.VerticalDivider as SkiaVerticalDivider

@Composable
actual fun HorizontalDivider(
    modifier: Modifier,
    thickness: Dp,
    color: Color
) {
    SkiaHorizontalDivider(
        modifier = modifier.skia,
        thickness = thickness,
        color = color
    )
}

@Composable
actual fun VerticalDivider(
    modifier: Modifier,
    thickness: Dp,
    color: Color
) {
    SkiaVerticalDivider(
        modifier = modifier.skia,
        thickness = thickness,
        color = color
    )
}