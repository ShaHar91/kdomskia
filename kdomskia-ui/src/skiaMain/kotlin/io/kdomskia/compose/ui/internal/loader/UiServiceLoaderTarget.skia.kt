package io.kdomskia.compose.ui.internal.loader

import androidx.compose.runtime.Composable
import coil3.compose.setSingletonImageLoaderFactory
import io.kdomskia.compose.ui.settings.LocalUiSettings

@Composable
internal actual fun UiLoadModule(
    content: @Composable () -> Unit
) {
    content()
}

@Composable
internal actual fun UiAfterApplySettings(
    content: @Composable () -> Unit
) {
    val coilImageLoader = LocalUiSettings.current.coilImageLoader
    setSingletonImageLoaderFactory { context ->
        coilImageLoader(context)
    }
    content()
}