package io.kdomskia.compose.material3.internal.loader

import androidx.compose.runtime.Composable

@Composable
actual fun LoadMaterial3(
    content: @Composable () -> Unit
) {
    content()
    //TODO load custom material theme
}