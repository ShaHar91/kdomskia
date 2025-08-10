package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.ExtendedFloatingActionButton as SkiaExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton as SkiaFloatingActionButton

@Composable
actual fun FloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier,
    shape: Shape,
    containerColor: Color,
    contentColor: Color,
    content: @Composable () -> Unit
) {
    SkiaFloatingActionButton(
        onClick = onClick,
        modifier = modifier.skia,
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        content = content
    )
}

@Composable
actual fun ExtendedFloatingActionButton(
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier,
    expanded: Boolean,
    shape: Shape,
    containerColor: Color,
    contentColor: Color
) {
    SkiaExtendedFloatingActionButton(
        text = text,
        icon = icon,
        onClick = onClick,
        modifier = modifier.skia,
        expanded = expanded,
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor
    )
}