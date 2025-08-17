package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.zIndex

@Composable
actual fun ViewportContainer(
    modifier: Modifier,
    contentAlignment: Alignment,
    zIndex: Float,
    content: @Composable (BoxScope.() -> Unit)
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .zIndex(zIndex),
        contentAlignment = contentAlignment
    ) {
        content()
    }
}