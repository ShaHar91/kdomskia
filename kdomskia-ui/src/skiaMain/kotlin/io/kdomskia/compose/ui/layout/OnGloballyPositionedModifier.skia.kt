package io.kdomskia.compose.ui.layout

import androidx.compose.runtime.Stable
import io.kdomskia.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned as skiaOnGloballyPositioned

@Stable
actual fun Modifier.onGloballyPositioned(
    onGloballyPositioned: (LayoutCoordinates) -> Unit
) = unwrap {
    skiaOnGloballyPositioned {
        onGloballyPositioned(
            LayoutCoordinatesImpl(
                size = it.size
            )
        )
    }
}