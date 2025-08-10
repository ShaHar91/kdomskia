package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Stable
import androidx.compose.foundation.layout.IntrinsicSize as SkiaIntrinsicSize

@Stable
val IntrinsicSize.skia: SkiaIntrinsicSize
    get() = when (this) {
        IntrinsicSize.Min -> SkiaIntrinsicSize.Min
        IntrinsicSize.Max -> SkiaIntrinsicSize.Max
    }