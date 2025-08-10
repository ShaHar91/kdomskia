package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.material3.beer.BeerButton
import io.kdomskia.compose.ui.Modifier

@Composable
actual fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    colors: IconButtonColors,
    shape: Shape,
    content: @Composable () -> Unit
) {
    BeerButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        containerColor = colors.containerColor,
        contentColor = colors.contentColor,
        buttonSize = null,
        contentPadding = PaddingValues(8.dp),
        shape = shape,
        content = {
            content()
        }
    )
}