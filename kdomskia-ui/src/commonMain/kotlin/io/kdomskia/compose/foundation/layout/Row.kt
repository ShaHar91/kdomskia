package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.foundation.layout.dom.DomFlexBasis
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier

@Composable
expect fun Row(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable RowScope.() -> Unit
)

@Immutable
expect class RowScope {

    @Stable
    fun Modifier.weight(
        weight: Float,
        skiaFill: Boolean = true,
        domFlexBasis: DomFlexBasis? = DomFlexBasis.MinContent
    ): Modifier

    @Stable
    fun Modifier.align(alignment: Alignment.Vertical): Modifier

}