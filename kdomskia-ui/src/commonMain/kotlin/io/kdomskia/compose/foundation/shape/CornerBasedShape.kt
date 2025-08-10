package io.kdomskia.compose.foundation.shape

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import io.kdomskia.annotation.InternalKdomskiaApi
import androidx.compose.foundation.shape.CornerBasedShape as SkiaCornerBasedShape

interface CornerBasedShape : Shape

@InternalKdomskiaApi
open class CornerBasedShapeImpl(
    internal val skia: SkiaCornerBasedShape
) : CornerBasedShape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) = skia.createOutline(size, layoutDirection, density)

}

val CornerBasedShape.commonSkia: SkiaCornerBasedShape
    get() = (this as CornerBasedShapeImpl).skia

val SkiaCornerBasedShape.kdomskia: CornerBasedShape
    get() = CornerBasedShapeImpl(this)