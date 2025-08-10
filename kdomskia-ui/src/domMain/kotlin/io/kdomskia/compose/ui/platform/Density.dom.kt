package io.kdomskia.compose.ui.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Density

internal actual val currentDensity: Density
    @ReadOnlyComposable
    @Composable
    get() = Density(1f)