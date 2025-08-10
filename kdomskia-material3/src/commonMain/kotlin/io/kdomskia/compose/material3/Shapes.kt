package io.kdomskia.compose.material3

import androidx.compose.runtime.Immutable
import io.kdomskia.compose.foundation.shape.CornerBasedShape
import io.kdomskia.compose.foundation.shape.CornerBasedShapeImpl
import io.kdomskia.compose.foundation.shape.commonSkia
import io.kdomskia.compose.foundation.shape.kdomskia
import androidx.compose.material3.ShapeDefaults as SkiaShapeDefaults

internal typealias SkiaShapes = androidx.compose.material3.Shapes

val SkiaShapes.kdomskia: Shapes
    get() = Shapes(
        extraSmall = extraSmall.kdomskia,
        small = small.kdomskia,
        medium = medium.kdomskia,
        large = large.kdomskia,
        extraLarge = extraLarge.kdomskia
    )

@Immutable
class Shapes(
    extraSmall: CornerBasedShape = ShapeDefaults.ExtraSmall,
    small: CornerBasedShape = ShapeDefaults.Small,
    medium: CornerBasedShape = ShapeDefaults.Medium,
    large: CornerBasedShape = ShapeDefaults.Large,
    extraLarge: CornerBasedShape = ShapeDefaults.ExtraLarge
) {

    internal val _skia = SkiaShapes(
        extraSmall = extraSmall.commonSkia,
        small = small.commonSkia,
        medium = medium.commonSkia,
        large = large.commonSkia,
        extraLarge = extraLarge.commonSkia
    )

    val extraSmall: CornerBasedShape
        get() = CornerBasedShapeImpl(_skia.extraSmall)

    val small: CornerBasedShape
        get() = CornerBasedShapeImpl(_skia.small)

    val medium: CornerBasedShape
        get() = CornerBasedShapeImpl(_skia.medium)

    val large: CornerBasedShape
        get() = CornerBasedShapeImpl(_skia.large)

    val extraLarge: CornerBasedShape
        get() = CornerBasedShapeImpl(_skia.extraLarge)

    fun copy(
        extraSmall: CornerBasedShape = this.extraSmall,
        small: CornerBasedShape = this.small,
        medium: CornerBasedShape = this.medium,
        large: CornerBasedShape = this.large,
        extraLarge: CornerBasedShape = this.extraLarge,
    ): Shapes = Shapes(
        extraSmall = extraSmall,
        small = small,
        medium = medium,
        large = large,
        extraLarge = extraLarge,
    )

    override fun toString() = _skia.toString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is Shapes) return false

        return _skia == other._skia
    }

    override fun hashCode() = _skia.hashCode()

}

object ShapeDefaults {

    val ExtraSmall: CornerBasedShape = CornerBasedShapeImpl(SkiaShapeDefaults.ExtraSmall)

    val Small: CornerBasedShape = CornerBasedShapeImpl(SkiaShapeDefaults.Small)

    val Medium: CornerBasedShape = CornerBasedShapeImpl(SkiaShapeDefaults.Medium)

    val Large: CornerBasedShape = CornerBasedShapeImpl(SkiaShapeDefaults.Large)

    val ExtraLarge: CornerBasedShape = CornerBasedShapeImpl(SkiaShapeDefaults.ExtraLarge)

}