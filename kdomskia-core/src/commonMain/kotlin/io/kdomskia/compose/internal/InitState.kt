package io.kdomskia.compose.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import io.kdomskia.annotation.InternalKdomskiaApi

internal val LocalInitState = compositionLocalOf { false }

@Composable
@ReadOnlyComposable
@InternalKdomskiaApi
fun CheckKdomskiaInitialization() {
    require(LocalInitState.current) {
        "Kdomskia is not initialized. Make sure all composables are wrapped in KdomskiaApp() function."
    }
}