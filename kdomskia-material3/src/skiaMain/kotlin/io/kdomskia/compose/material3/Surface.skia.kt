package io.kdomskia.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.Surface as SkiaSurface

@Composable
@NonRestartableComposable
actual fun Surface(
    modifier: Modifier,
    shape: Shape,
    color: Color,
    contentColor: Color,
    tonalElevation: Dp,
    shadowElevation: Dp,
    border: BorderStroke?,
    content: @Composable () -> Unit
) {
    SkiaSurface(
        modifier = modifier.skia,
        shape = shape,
        color = color,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = border,
        content = content
    )
}

@Composable
@NonRestartableComposable
actual fun Surface(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    color: Color,
    contentColor: Color,
    tonalElevation: Dp,
    shadowElevation: Dp,
    border: BorderStroke?,
    content: @Composable (() -> Unit)
) {
    SkiaSurface(
        onClick = onClick,
        modifier = modifier.skia,
        enabled = enabled,
        shape = shape,
        color = color,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = border,
        content = content
    )
}

@Composable
@NonRestartableComposable
actual fun Surface(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    color: Color,
    contentColor: Color,
    tonalElevation: Dp,
    shadowElevation: Dp,
    border: BorderStroke?,
    content: @Composable (() -> Unit)
) {
    SkiaSurface(
        selected = selected,
        onClick = onClick,
        modifier = modifier.skia,
        enabled = enabled,
        shape = shape,
        color = color,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = border,
        content = content
    )
}