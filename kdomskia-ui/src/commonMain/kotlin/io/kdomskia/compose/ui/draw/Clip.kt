package io.kdomskia.compose.ui.draw

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Shape
import io.kdomskia.compose.ui.Modifier

@Stable
expect fun Modifier.clipToBounds(): Modifier

@Stable
expect fun Modifier.clip(shape: Shape): Modifier