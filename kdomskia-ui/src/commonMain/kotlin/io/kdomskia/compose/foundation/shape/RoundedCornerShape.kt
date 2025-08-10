package io.kdomskia.compose.foundation.shape

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape as SkiaCircleShape
import androidx.compose.foundation.shape.CornerBasedShape as SkiaCornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape as SkiaRoundedCornerShape

interface RoundedCornerShape : CornerBasedShape

internal class RoundedCornerShapeImpl(
    skia: SkiaCornerBasedShape
) : CornerBasedShapeImpl(skia), RoundedCornerShape

val CircleShape: RoundedCornerShape = RoundedCornerShapeImpl(SkiaCircleShape)

fun RoundedCornerShape(corner: CornerSize): RoundedCornerShape = RoundedCornerShapeImpl(SkiaRoundedCornerShape(corner.commonSkia))

fun RoundedCornerShape(size: Dp): RoundedCornerShape = RoundedCornerShapeImpl(SkiaRoundedCornerShape(size))

fun RoundedCornerShape(size: Float): RoundedCornerShape = RoundedCornerShapeImpl(SkiaRoundedCornerShape(size))

fun RoundedCornerShape(percent: Int): RoundedCornerShape = RoundedCornerShapeImpl(SkiaRoundedCornerShape(percent))

fun RoundedCornerShape(
    topStart: Dp = 0.dp,
    topEnd: Dp = 0.dp,
    bottomEnd: Dp = 0.dp,
    bottomStart: Dp = 0.dp,
): RoundedCornerShape = RoundedCornerShapeImpl(
    SkiaRoundedCornerShape(
        topStart = topStart,
        topEnd = topEnd,
        bottomEnd = bottomEnd,
        bottomStart = bottomStart,
    )
)

fun RoundedCornerShape(
    topStart: Float = 0.0f,
    topEnd: Float = 0.0f,
    bottomEnd: Float = 0.0f,
    bottomStart: Float = 0.0f,
): RoundedCornerShape = RoundedCornerShapeImpl(
    SkiaRoundedCornerShape(
        topStart = topStart,
        topEnd = topEnd,
        bottomEnd = bottomEnd,
        bottomStart = bottomStart,
    )
)

fun RoundedCornerShape(
    topStartPercent: Int = 0,
    topEndPercent: Int = 0,
    bottomEndPercent: Int = 0,
    bottomStartPercent: Int = 0,
): RoundedCornerShape = RoundedCornerShapeImpl(
    SkiaRoundedCornerShape(
        topStartPercent = topStartPercent,
        topEndPercent = topEndPercent,
        bottomEndPercent = bottomEndPercent,
        bottomStartPercent = bottomStartPercent,
    )
)