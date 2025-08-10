package io.kdomskia.compose.ui

import androidx.compose.runtime.Stable
import androidx.compose.ui.zIndex

@Stable
actual fun Modifier.zIndex(zIndex: Float) = unwrap { zIndex(zIndex) }