package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.foundation.layout.dom.DomFlexBasis
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier

@Composable
expect fun Column(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit
)

@Immutable
expect class ColumnScope {

    @Stable
    fun Modifier.weight(
        weight: Float,
        skiaFill: Boolean = true,
        domFlexBasis: DomFlexBasis? = DomFlexBasis.MinContent
    ): Modifier

    @Stable
    fun Modifier.align(alignment: Alignment.Horizontal): Modifier

}