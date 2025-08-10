package io.kdomskia.compose.foundation.layout

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier

@Stable
actual fun Modifier.width(width: Dp) = unwrap { width(width) }

@Stable
actual fun Modifier.width(intrinsicSize: IntrinsicSize) = unwrap { width(intrinsicSize.skia) }

@Stable
actual fun Modifier.height(height: Dp) = unwrap { height(height) }

@Stable
actual fun Modifier.height(intrinsicSize: IntrinsicSize) = unwrap { height(intrinsicSize.skia) }

@Stable
actual fun Modifier.size(size: Dp) = unwrap { size(size) }

@Stable
actual fun Modifier.size(
    width: Dp,
    height: Dp
) = unwrap { size(width, height) }

@Stable
actual fun Modifier.sizeIn(
    minWidth: Dp,
    minHeight: Dp,
    maxWidth: Dp,
    maxHeight: Dp
) = unwrap {
    sizeIn(
        minWidth = minWidth,
        minHeight = minHeight,
        maxWidth = maxWidth,
        maxHeight = maxHeight
    )
}

@Stable
actual fun Modifier.widthIn(min: Dp, max: Dp) = unwrap {
    widthIn(min = min, max = max)
}

@Stable
actual fun Modifier.heightIn(min: Dp, max: Dp) = unwrap {
    heightIn(min = min, max = max)
}

@Stable
actual fun Modifier.defaultMinSize(
    minWidth: Dp,
    minHeight: Dp
) = unwrap { defaultMinSize(minWidth, minHeight) }

@Stable
actual fun Modifier.fillMaxWidth(
    fraction: Float
) = unwrap { fillMaxWidth(fraction) }

@Stable
actual fun Modifier.fillMaxHeight(
    fraction: Float
) = unwrap { fillMaxHeight(fraction) }

@Stable
actual fun Modifier.fillMaxSize(
    fraction: Float
) = unwrap { fillMaxSize(fraction) }

@Stable
actual fun Modifier.fillViewportWidth(
    fraction: Float
) = fillMaxWidth(fraction)

@Stable
actual fun Modifier.fillViewportHeight(
    fraction: Float
) = fillMaxHeight(fraction)