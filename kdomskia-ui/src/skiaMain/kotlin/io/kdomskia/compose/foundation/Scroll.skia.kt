package io.kdomskia.compose.foundation

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.kdomskia.compose.foundation.dom.DomScrollOptions
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.rememberScrollState as rememberSkiaScrollState

typealias SkiaScrollState = androidx.compose.foundation.ScrollState

@Stable
actual class ScrollState(
    val skia: SkiaScrollState
) {

    actual var value: Int
        get() = skia.value
        private set(value) {
            throw IllegalStateException("Update SkiaScrollState instead.")
        }

    actual suspend fun scrollTo(value: Int) = skia.scrollTo(value)

    actual suspend fun animateScrollTo(value: Int) = skia.animateScrollTo(value)

}

@Composable
actual fun rememberScrollState(initial: Int): ScrollState {
    val skia = rememberSkiaScrollState(initial = initial)
    return remember(skia) {
        ScrollState(skia)
    }
}

actual fun Modifier.verticalScroll(
    state: ScrollState,
    domOptions: DomScrollOptions,
    enabled: Boolean
): Modifier = unwrap {
    verticalScroll(
        state = state.skia,
        enabled = enabled
    )
}

actual fun Modifier.horizontalScroll(
    state: ScrollState,
    domOptions: DomScrollOptions,
    enabled: Boolean
): Modifier = unwrap {
    horizontalScroll(
        state = state.skia,
        enabled = enabled
    )
}