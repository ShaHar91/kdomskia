package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier

@Composable
expect fun FlowRow(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemVerticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable FlowRowScope.() -> Unit
)

@Immutable
object FlowRowScope