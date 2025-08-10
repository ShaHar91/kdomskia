package io.kdomskia.compose.internal

import androidx.compose.runtime.Composable

@Composable
internal expect fun PlatformApp(
    content: @Composable () -> Unit
)