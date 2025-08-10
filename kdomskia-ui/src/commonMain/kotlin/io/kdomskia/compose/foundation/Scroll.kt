package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import io.kdomskia.compose.foundation.dom.DomScrollOptions
import io.kdomskia.compose.ui.Modifier

expect class ScrollState {

    var value: Int
        private set

    suspend fun scrollTo(value: Int): Float

    suspend fun animateScrollTo(value: Int)

}

@Composable
expect fun rememberScrollState(initial: Int = 0): ScrollState

expect fun Modifier.verticalScroll(
    state: ScrollState,
    domOptions: DomScrollOptions,
    enabled: Boolean = true
): Modifier

expect fun Modifier.horizontalScroll(
    state: ScrollState,
    domOptions: DomScrollOptions,
    enabled: Boolean = true
): Modifier