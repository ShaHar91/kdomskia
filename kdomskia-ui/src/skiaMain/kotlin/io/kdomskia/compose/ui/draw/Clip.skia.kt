package io.kdomskia.compose.ui.draw

import androidx.compose.runtime.Stable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Shape
import io.kdomskia.compose.ui.Modifier

@Stable
actual fun Modifier.clipToBounds() = unwrap { clipToBounds() }

@Stable
actual fun Modifier.clip(shape: Shape) = unwrap { clip(shape) }