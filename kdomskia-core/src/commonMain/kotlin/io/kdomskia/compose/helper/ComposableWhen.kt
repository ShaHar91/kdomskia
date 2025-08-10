package io.kdomskia.compose.helper

import androidx.compose.runtime.Composable

@Composable
expect fun <T> ComposableWhen(
    dom: @Composable () -> T,
    skia: @Composable () -> T
)