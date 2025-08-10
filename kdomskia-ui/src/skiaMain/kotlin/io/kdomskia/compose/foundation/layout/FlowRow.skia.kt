package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.layout.FlowRow as SkiaFlowRow

@Composable
actual fun FlowRow(
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal,
    itemVerticalAlignment: Alignment.Vertical,
    content: @Composable (FlowRowScope.() -> Unit)
) {
    CheckKdomskiaInitialization()
    SkiaFlowRow(
        modifier = modifier.skia,
        horizontalArrangement = horizontalArrangement.skia,
        itemVerticalAlignment = itemVerticalAlignment.skia,
        content = {
            FlowRowScope.content()
        }
    )
}