package io.kdomskia.compose.helper

import androidx.compose.runtime.Composable

@Composable
expect fun <T> getComposable(
    dom: @Composable () -> T,
    skia: @Composable  () -> T
): T