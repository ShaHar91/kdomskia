package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import io.kdomskia.compose.foundation.dom.DomScrollOptions
import io.kdomskia.compose.foundation.gestures.Orientation
import io.kdomskia.compose.foundation.scroll.SmoothScrollTo
import io.kdomskia.compose.ui.Modifier
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Composable
actual fun rememberScrollState(initial: Int) = rememberSaveable(saver = ScrollState.Saver) {
    ScrollState(initial = initial)
}

@Stable
actual class ScrollState(
    initial: Int
) {

    actual var value: Int by mutableIntStateOf(initial)
        private set

    internal var doubleValue: Double by mutableDoubleStateOf(value.toDouble())

    internal var smoothScrollTo: SmoothScrollTo? by mutableStateOf(null)

    internal var onUpdateSmoothScrollTo: ((SmoothScrollTo) -> Unit)? = null

    actual suspend fun scrollTo(value: Int): Float {
        updateValue(value.toDouble())
        return 0f
    }

    actual suspend fun animateScrollTo(value: Int) {
        @OptIn(ExperimentalUuidApi::class)
        val newValue = SmoothScrollTo(
            value = value,
            uuid = Uuid.random().toString()
        )
        smoothScrollTo = newValue
        onUpdateSmoothScrollTo?.invoke(newValue)
    }

    internal fun updateValue(value: Double) {
        this.doubleValue = value
        this.value = value.toInt()
    }

    companion object {

        val Saver: Saver<ScrollState, *> = Saver(save = { it.value }, restore = { ScrollState(it) })

    }

}

actual fun Modifier.verticalScroll(
    state: ScrollState,
    domOptions: DomScrollOptions,
    enabled: Boolean
): Modifier = scroll(state, Orientation.Vertical, domOptions, enabled)

actual fun Modifier.horizontalScroll(
    state: ScrollState,
    domOptions: DomScrollOptions,
    enabled: Boolean
): Modifier = scroll(state, Orientation.Horizontal, domOptions, enabled)