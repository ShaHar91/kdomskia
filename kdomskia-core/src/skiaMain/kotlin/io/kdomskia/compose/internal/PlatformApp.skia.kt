package io.kdomskia.compose.internal

import androidx.compose.runtime.Composable

@Composable
actual fun PlatformApp(
    content: @Composable () -> Unit
) {
    content()
}