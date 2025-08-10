package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.layout.Spacer as SkiaSpacer

@Composable
@NonRestartableComposable
actual fun Spacer(modifier: Modifier) {
    SkiaSpacer(modifier = modifier.skia)
}