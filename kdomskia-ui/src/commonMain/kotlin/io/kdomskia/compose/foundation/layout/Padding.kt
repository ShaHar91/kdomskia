package io.kdomskia.compose.foundation.layout

import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import io.kdomskia.annotation.InternalKdomskiaApi
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.layout.PaddingValues as SkiaPaddingValues

@Stable
expect fun Modifier.padding(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp
): Modifier

@Stable
expect fun Modifier.padding(
    horizontal: Dp = 0.dp,
    vertical: Dp = 0.dp
): Modifier

@Stable
expect fun Modifier.padding(all: Dp): Modifier

@Stable
expect fun Modifier.padding(paddingValues: PaddingValues): Modifier

@Stable
interface PaddingValues {

    fun calculateLeftPadding(layoutDirection: LayoutDirection): Dp

    fun calculateTopPadding(): Dp

    fun calculateRightPadding(layoutDirection: LayoutDirection): Dp

    fun calculateBottomPadding(): Dp

    companion object {

        @Stable
        @get:Stable
        val Zero: PaddingValues = PaddingValuesImpl(SkiaPaddingValues.Zero)

    }

}

@Immutable
internal class PaddingValuesImpl(
    val _skia: SkiaPaddingValues
) : PaddingValues {

    override fun calculateLeftPadding(layoutDirection: LayoutDirection) = _skia.calculateLeftPadding(layoutDirection)

    override fun calculateTopPadding() = _skia.calculateTopPadding()

    override fun calculateRightPadding(layoutDirection: LayoutDirection) = _skia.calculateRightPadding(layoutDirection)

    override fun calculateBottomPadding() = _skia.calculateBottomPadding()

}

internal val PaddingValues.commonSkia: SkiaPaddingValues
    get() = (this as PaddingValuesImpl)._skia


@InternalKdomskiaApi
val SkiaPaddingValues.kdomskia: PaddingValues
    get() = PaddingValuesImpl(this)

@Stable
fun PaddingValues.calculateStartPadding(layoutDirection: LayoutDirection) = commonSkia.calculateStartPadding(layoutDirection)

@Stable
fun PaddingValues.calculateEndPadding(layoutDirection: LayoutDirection) = commonSkia.calculateEndPadding(layoutDirection)

@Stable
fun PaddingValues(all: Dp): PaddingValues = PaddingValuesImpl(SkiaPaddingValues(all))

@Stable
fun PaddingValues(horizontal: Dp = 0.dp, vertical: Dp = 0.dp): PaddingValues = PaddingValuesImpl(
    SkiaPaddingValues(horizontal, vertical)
)

@Stable
fun PaddingValues(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp,
): PaddingValues = PaddingValuesImpl(
    SkiaPaddingValues(start, top, end, bottom)
)

val PaddingValues.start: Dp
    @Composable
    get() = calculateStartPadding(LocalLayoutDirection.current)

val PaddingValues.top: Dp
    @Composable
    get() = calculateTopPadding()

val PaddingValues.end: Dp
    @Composable
    get() = calculateEndPadding(LocalLayoutDirection.current)

val PaddingValues.bottom: Dp
    @Composable
    get() = calculateBottomPadding()

@Composable
fun PaddingValues.copy(
    start: Dp = this.start,
    top: Dp = this.top,
    end: Dp = this.end,
    bottom: Dp = this.bottom,
): PaddingValues = PaddingValues(
    start = start,
    top = top,
    end = end,
    bottom = bottom
)