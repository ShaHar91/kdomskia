package io.kdomskia.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.foundation.layout.RowScope
import io.kdomskia.compose.foundation.layout.skia
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.Button as SkiaButton
import androidx.compose.material3.ElevatedButton as SkiaElevatedButton
import androidx.compose.material3.OutlinedButton as SkiaOutlinedButton
import androidx.compose.material3.OutlinedButton as SkiaTextButton

val ButtonColors.skia: SkiaButtonColors
    get() = _skia

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    colors: ButtonColors,
    contentPadding: PaddingValues,
    content: @Composable RowScope.() -> Unit
) {
    SkiaButton(
        onClick = onClick,
        modifier = modifier.skia,
        enabled = enabled,
        shape = shape,
        colors = colors.skia,
        contentPadding = contentPadding.skia
    ) {
        content(RowScope(this))
    }
}

@Composable
actual fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    colors: ButtonColors,
    border: BorderStroke?,
    contentPadding: PaddingValues,
    content: @Composable RowScope.() -> Unit
) {
    SkiaOutlinedButton(
        onClick = onClick,
        modifier = modifier.skia,
        enabled = enabled,
        shape = shape,
        colors = colors.skia,
        border = border,
        contentPadding = contentPadding.skia
    ) {
        content(RowScope(this))
    }
}

@Composable
actual fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    colors: ButtonColors,
    border: BorderStroke?,
    contentPadding: PaddingValues,
    content: @Composable (RowScope.() -> Unit)
) {
    SkiaTextButton(
        onClick = onClick,
        modifier = modifier.skia,
        enabled = enabled,
        shape = shape,
        colors = colors.skia,
        border = border,
        contentPadding = contentPadding.skia
    ) {
        content(RowScope(this))
    }
}

@Composable
actual fun ElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    colors: ButtonColors,
    contentPadding: PaddingValues,
    content: @Composable RowScope.() -> Unit
) {
    SkiaElevatedButton(
        onClick = onClick,
        modifier = modifier.skia,
        enabled = enabled,
        shape = shape,
        colors = colors.skia,
        contentPadding = contentPadding.skia
    ) {
        content(RowScope(this))
    }
}