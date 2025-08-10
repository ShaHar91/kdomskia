package io.kdomskia.compose.helper

import androidx.compose.runtime.Composable

@Composable
actual fun <T> ComposableWhen(
    dom: @Composable () -> T,
    skia: @Composable () -> T
) {
    skia()
}