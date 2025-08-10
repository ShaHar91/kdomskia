package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.ui.Alignment
import androidx.compose.ui.UiComposable
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier

@Composable
@UiComposable
expect fun BoxWithConstraints(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable @UiComposable BoxWithConstraintsScope.() -> Unit,
)

@Stable
interface BoxWithConstraintsScope : BoxScope {

    val minWidth: Dp

    val maxWidth: Dp

    val minHeight: Dp

    val maxHeight: Dp

}