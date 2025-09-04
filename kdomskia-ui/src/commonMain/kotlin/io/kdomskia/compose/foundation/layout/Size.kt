package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import io.kdomskia.compose.ui.Modifier

@Stable
expect fun Modifier.width(width: Dp): Modifier

@Stable
expect fun Modifier.width(intrinsicSize: IntrinsicSize): Modifier

@Stable
expect fun Modifier.height(height: Dp): Modifier

@Stable
expect fun Modifier.height(intrinsicSize: IntrinsicSize): Modifier

@Stable
expect fun Modifier.size(size: Dp): Modifier

@Stable
expect fun Modifier.size(
    width: Dp,
    height: Dp
): Modifier

@Stable
fun Modifier.size(size: DpSize) = size(size.width, size.height)

@Stable
expect fun Modifier.widthIn(min: Dp = Dp.Unspecified, max: Dp = Dp.Unspecified): Modifier

@Stable
expect fun Modifier.heightIn(min: Dp = Dp.Unspecified, max: Dp = Dp.Unspecified): Modifier

@Stable
expect fun Modifier.sizeIn(
    minWidth: Dp = Dp.Unspecified,
    minHeight: Dp = Dp.Unspecified,
    maxWidth: Dp = Dp.Unspecified,
    maxHeight: Dp = Dp.Unspecified
): Modifier

@Stable
expect fun Modifier.defaultMinSize(minWidth: Dp = Dp.Unspecified, minHeight: Dp = Dp.Unspecified): Modifier

@Stable
expect fun Modifier.fillMaxWidth(
    fraction: Float = 1f
): Modifier

@Stable
expect fun Modifier.fillMaxHeight(
    fraction: Float = 1f
): Modifier

@Stable
expect fun Modifier.fillMaxSize(
    fraction: Float = 1f
): Modifier

@Stable
expect fun Modifier.fillViewportWidth(
    fraction: Float = 1f
): Modifier

@Stable
expect fun Modifier.fillViewportHeight(
    fraction: Float = 1f
): Modifier

@Stable
expect fun Modifier.fillViewportSize(
    fraction: Float = 1f
): Modifier