package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import io.kdomskia.compose.ui.Modifier

@Composable
@NonRestartableComposable
expect fun Spacer(modifier: Modifier)