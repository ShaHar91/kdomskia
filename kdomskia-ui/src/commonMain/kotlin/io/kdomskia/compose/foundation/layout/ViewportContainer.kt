package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.ZIndexLayer

@Composable
expect fun ViewportContainer(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    zIndex: Float = ZIndexLayer.layer3.start,
    content: @Composable BoxScope.() -> Unit
)