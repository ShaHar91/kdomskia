package io.kdomskia.compose.foundation.layout

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.layout.PaddingValues as SkiaPaddingValues

@Stable
actual fun Modifier.padding(
    start: Dp,
    top: Dp,
    end: Dp,
    bottom: Dp
) = unwrap {
    padding(
        start = start,
        top = top,
        end = end,
        bottom = bottom
    )
}

@Stable
actual fun Modifier.padding(
    horizontal: Dp,
    vertical: Dp
) = unwrap {
    padding(
        horizontal = horizontal,
        vertical = vertical
    )
}

@Stable
actual fun Modifier.padding(all: Dp) = unwrap { padding(all = all) }

@Stable
actual fun Modifier.padding(paddingValues: PaddingValues): Modifier = unwrap {
    padding(
        paddingValues = paddingValues.skia
    )
}

val PaddingValues.skia: SkiaPaddingValues
    get() = commonSkia