package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.heightIn
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.sizeIn
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.widthIn
import com.varabyte.kobweb.compose.ui.thenIf
import io.kdomskia.compose.css.fractionToCssPercent
import io.kdomskia.compose.css.fractionToPercent
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.vw

@Stable
actual fun Modifier.width(width: Dp) = unwrap { width(width.dom) }

@Stable
actual fun Modifier.width(intrinsicSize: IntrinsicSize) = unwrap { width(intrinsicSize.dom.width) }

@Stable
actual fun Modifier.height(height: Dp) = unwrap { height(height.dom) }

@Stable
actual fun Modifier.height(intrinsicSize: IntrinsicSize) = unwrap { height(intrinsicSize.dom.height) }

@Stable
actual fun Modifier.size(size: Dp) = unwrap { size(size.dom) }

@Stable
actual fun Modifier.size(
    width: Dp,
    height: Dp
) = unwrap { size(width.dom, height.dom) }

@Stable
actual fun Modifier.sizeIn(
    minWidth: Dp,
    minHeight: Dp,
    maxWidth: Dp,
    maxHeight: Dp
) = unwrap {
    sizeIn(
        minWidth = minWidth.takeIf { it != Dp.Unspecified }?.dom,
        minHeight = minHeight.takeIf { it != Dp.Unspecified }?.dom,
        maxWidth = maxWidth.takeIf { it != Dp.Unspecified }?.dom,
        maxHeight = maxHeight.takeIf { it != Dp.Unspecified }?.dom
    ).fillMaxSize()
}

@Stable
actual fun Modifier.widthIn(min: Dp, max: Dp) = unwrap {
    widthIn(
        min = min.takeIf { it != Dp.Unspecified }?.dom,
        max = max.takeIf { it != Dp.Unspecified }?.dom,
    ).fillMaxWidth()
}

@Stable
actual fun Modifier.heightIn(min: Dp, max: Dp) = unwrap {
    heightIn(
        min = min.takeIf { it != Dp.Unspecified }?.dom,
        max = max.takeIf { it != Dp.Unspecified }?.dom,
    ).fillMaxHeight()
}

@Stable
actual fun Modifier.defaultMinSize(
    minWidth: Dp,
    minHeight: Dp
) = unwrap {
    thenIf(minWidth != Dp.Unspecified) {
        minWidth(minWidth.dom)
    }.thenIf(minHeight != Dp.Unspecified) {
        minHeight(minHeight.dom)
    }
}

@Stable
actual fun Modifier.fillMaxWidth(
    fraction: Float
) = unwrap {
    fillMaxWidth(fraction.fractionToCssPercent)
}

@Stable
actual fun Modifier.fillMaxHeight(
    fraction: Float
) = unwrap {
    fillMaxHeight(fraction.fractionToCssPercent)
}

@Stable
actual fun Modifier.fillMaxSize(
    fraction: Float
) = unwrap {
    fillMaxSize(fraction.fractionToCssPercent)
}

@Stable
actual fun Modifier.fillViewportWidth(
    fraction: Float
) = unwrap {
    minWidth(fraction.fractionToPercent.vw)
}

@Stable
actual fun Modifier.fillViewportHeight(
    fraction: Float
) = unwrap {
    minHeight(fraction.fractionToPercent.vh)
}