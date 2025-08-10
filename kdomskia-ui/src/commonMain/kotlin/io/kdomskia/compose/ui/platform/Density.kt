package io.kdomskia.compose.ui.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Density

object LocalDensity {

    val current: Density
        @ReadOnlyComposable
        @Composable
        get() = currentDensity

}

@get:ReadOnlyComposable
@get:Composable
internal expect val currentDensity: Density