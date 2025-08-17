package io.kdomskia.compose.ui

import androidx.compose.runtime.Stable
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import kotlin.math.min

@Stable
actual fun Modifier.zIndex(zIndex: Float) = unwrap {
    zIndex(min(zIndex, Int.MAX_VALUE.toFloat()))
}