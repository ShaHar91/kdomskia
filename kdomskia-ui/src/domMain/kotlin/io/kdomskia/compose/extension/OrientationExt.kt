package io.kdomskia.compose.extension

import io.kdomskia.compose.foundation.gestures.Orientation
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions

internal val Orientation.overflowProperty: String
    get() = when (this) {
        Orientation.Vertical -> "overflow-y"
        Orientation.Horizontal -> "overflow-x"
    }

internal fun Orientation.smoothScrollOptions(value: Double): ScrollToOptions {
    return when (this) {
        Orientation.Vertical -> ScrollToOptions(
            top = value,
            behavior = ScrollBehavior.SMOOTH
        )

        Orientation.Horizontal -> ScrollToOptions(
            left = value,
            behavior = ScrollBehavior.SMOOTH
        )
    }
}