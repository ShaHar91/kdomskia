package io.kdomskia.compose.ui.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.platform.LocalDensity as SkiaLocalDensity

internal actual val currentDensity: Density
    @ReadOnlyComposable
    @Composable
    get() = SkiaLocalDensity.current