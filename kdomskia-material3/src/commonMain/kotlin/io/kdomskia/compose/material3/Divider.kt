package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.DividerDefaults as SkiaDividerDefaults

@Composable
expect fun HorizontalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = DividerDefaults.Thickness,
    color: Color = DividerDefaults.color,
)

@Composable
expect fun VerticalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = DividerDefaults.Thickness,
    color: Color = DividerDefaults.color,
)

object DividerDefaults {

    val Thickness: Dp = SkiaDividerDefaults.Thickness

    val color: Color
        @Composable
        get() = SkiaDividerDefaults.color

}