package io.kdomskia.compose.foundation.shape

import androidx.compose.runtime.Immutable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Density
import androidx.compose.foundation.shape.CornerSize as SkiaCornerSize

@Immutable
interface CornerSize {

    fun toPx(shapeSize: Size, density: Density): Float

}

private class CornerSizeImpl(
    val _skia: SkiaCornerSize
) : CornerSize {

    override fun toPx(shapeSize: Size, density: Density) = _skia.toPx(shapeSize, density)

}

internal val CornerSize.commonSkia: SkiaCornerSize
    get() = (this as CornerSizeImpl)._skia