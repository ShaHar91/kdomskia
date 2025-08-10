package io.kdomskia.compose.foundation.layout

import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.captionBar
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.mandatorySystemGestures
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemGestures
import androidx.compose.foundation.layout.tappableElement
import androidx.compose.foundation.layout.waterfall
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.js.JsName
import kotlin.jvm.JvmInline
import androidx.compose.foundation.layout.WindowInsets as SkiaWindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides as SkiaWindowInsetsSides
import androidx.compose.foundation.layout.add as skiaAdd
import androidx.compose.foundation.layout.exclude as skiaExclude
import androidx.compose.foundation.layout.only as skiaOnly
import androidx.compose.foundation.layout.union as skiaUnion

@Stable
interface WindowInsets {

    fun getLeft(density: Density, layoutDirection: LayoutDirection): Int

    fun getTop(density: Density): Int

    fun getRight(density: Density, layoutDirection: LayoutDirection): Int

    fun getBottom(density: Density): Int

    companion object

}

internal class WindowInsetsImpl(
    val _skia: SkiaWindowInsets
) : WindowInsets {

    override fun getLeft(density: Density, layoutDirection: LayoutDirection) = _skia.getLeft(density, layoutDirection)

    override fun getTop(density: Density) = _skia.getTop(density)

    override fun getRight(density: Density, layoutDirection: LayoutDirection) = _skia.getRight(density, layoutDirection)

    override fun getBottom(density: Density) = _skia.getBottom(density)

}

internal val WindowInsets.commonSkia: SkiaWindowInsets
    get() = (this as WindowInsetsImpl)._skia

val SkiaWindowInsets.kdomskia: WindowInsets
    get() = WindowInsetsImpl(this)

@JvmInline
value class WindowInsetsSides private constructor(
    internal val skia: SkiaWindowInsetsSides
) {

    operator fun plus(sides: WindowInsetsSides): WindowInsetsSides = WindowInsetsSides(skia.plus(sides.skia))

    override fun toString() = skia.toString()

    companion object {

        val Start = WindowInsetsSides(SkiaWindowInsetsSides.Start)

        val End = WindowInsetsSides(SkiaWindowInsetsSides.End)

        val Top = WindowInsetsSides(SkiaWindowInsetsSides.Top)

        val Bottom = WindowInsetsSides(SkiaWindowInsetsSides.Bottom)

        val Left = WindowInsetsSides(SkiaWindowInsetsSides.Left)

        val Right = WindowInsetsSides(SkiaWindowInsetsSides.Right)

        val Horizontal = WindowInsetsSides(SkiaWindowInsetsSides.Horizontal)

        val Vertical = WindowInsetsSides(SkiaWindowInsetsSides.Vertical)

    }

}

fun WindowInsets.union(insets: WindowInsets): WindowInsets = WindowInsetsImpl(commonSkia.skiaUnion(insets.commonSkia))

fun WindowInsets.exclude(insets: WindowInsets): WindowInsets = WindowInsetsImpl(commonSkia.skiaExclude(insets.commonSkia))

fun WindowInsets.add(insets: WindowInsets): WindowInsets = WindowInsetsImpl(commonSkia.skiaAdd(insets.commonSkia))

fun WindowInsets.only(sides: WindowInsetsSides): WindowInsets = WindowInsetsImpl(commonSkia.skiaOnly(sides.skia))

@ReadOnlyComposable
@Composable
fun WindowInsets.asPaddingValues(): PaddingValues = PaddingValuesImpl(commonSkia.asPaddingValues())

fun WindowInsets.asPaddingValues(density: Density): PaddingValues = PaddingValuesImpl(commonSkia.asPaddingValues(density))

@JsName("makeEmptyWindowInsets")
fun WindowInsets(): WindowInsets = WindowInsetsImpl(SkiaWindowInsets())

fun WindowInsets(left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0): WindowInsets =
    WindowInsetsImpl(SkiaWindowInsets(left, top, right, bottom))

fun WindowInsets(
    left: Dp = 0.dp,
    top: Dp = 0.dp,
    right: Dp = 0.dp,
    bottom: Dp = 0.dp,
): WindowInsets = WindowInsetsImpl(SkiaWindowInsets(left, top, right, bottom))

val WindowInsets.Companion.captionBar: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.captionBar)

val WindowInsets.Companion.displayCutout: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.displayCutout)

val WindowInsets.Companion.ime: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.ime)

val WindowInsets.Companion.mandatorySystemGestures: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.mandatorySystemGestures)

val WindowInsets.Companion.navigationBars: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.navigationBars)

val WindowInsets.Companion.statusBars: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.statusBars)

val WindowInsets.Companion.systemBars: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.systemBars)

val WindowInsets.Companion.systemGestures: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.systemGestures)

val WindowInsets.Companion.tappableElement: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.tappableElement)

val WindowInsets.Companion.waterfall: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.waterfall)

val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.safeDrawing)

val WindowInsets.Companion.safeGestures: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.safeGestures)

val WindowInsets.Companion.safeContent: WindowInsets
    @Composable get() = WindowInsetsImpl(SkiaWindowInsets.safeContent)