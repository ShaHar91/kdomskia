package io.kdomskia.compose.ui.layout

import androidx.compose.runtime.Stable
import io.kdomskia.compose.ui.Modifier

@Stable
expect fun Modifier.onGloballyPositioned(
    onGloballyPositioned: (LayoutCoordinates) -> Unit
): Modifier