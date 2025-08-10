package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.material3.beer.BeerProgressIndicator
import io.kdomskia.compose.ui.Modifier

@Composable
actual fun CircularProgressIndicator(
    modifier: Modifier,
    color: Color,
    strokeWidth: Dp
) {
    BeerProgressIndicator(
        modifier = modifier.dom,
        color = color,
        strokeWidth = strokeWidth
    )
}