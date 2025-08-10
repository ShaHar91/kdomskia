package io.kdomskia.compose.helper

import androidx.compose.runtime.Composable

@Composable
actual fun <T> getComposable(
    dom: @Composable () -> T,
    skia: @Composable () -> T
): T = skia()