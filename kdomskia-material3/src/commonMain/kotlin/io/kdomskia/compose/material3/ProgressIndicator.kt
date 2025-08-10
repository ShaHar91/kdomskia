package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.ProgressIndicatorDefaults as SkiaProgressIndicatorDefaults

@Composable
expect fun CircularProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = ProgressIndicatorDefaults.circularColor,
    strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth
)

object ProgressIndicatorDefaults {

    val circularColor: Color
        @Composable
        get() = SkiaProgressIndicatorDefaults.circularColor

    val CircularStrokeWidth: Dp = SkiaProgressIndicatorDefaults.CircularStrokeWidth

}