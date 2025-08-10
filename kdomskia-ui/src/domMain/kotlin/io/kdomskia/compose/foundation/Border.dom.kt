package io.kdomskia.compose.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import com.varabyte.kobweb.compose.ui.modifiers.border
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.draw.clip
import io.kdomskia.compose.ui.graphics.dom
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.css.LineStyle

@Stable
actual fun Modifier.border(
    border: BorderStroke,
    shape: Shape
) = unwrap {
    border(border = border)
        .clip(shape = shape)
}

@Stable
actual fun Modifier.border(
    width: Dp,
    color: Color,
    shape: Shape
) = unwrap {
    border(width = width, color = color)
        .clip(shape = shape)
}

@Stable
actual fun Modifier.border(
    width: Dp,
    brush: Brush,
    shape: Shape
) = unwrap {
    border(width = width, brush = brush)
        .clip(shape = shape)
}

@Stable
fun DomModifier.border(
    width: Dp,
    color: Color
): DomModifier = border(
    width = width.dom,
    style = LineStyle.Solid,
    color = color.dom
)

@Stable
fun DomModifier.border(
    width: Dp,
    brush: Brush
): DomModifier = border(
    width = width,
    color = when (brush) {
        is ShaderBrush -> Color.Black //TODO
        is SolidColor -> brush.value
    }
)

@Stable
fun DomModifier.border(
    border: BorderStroke
): DomModifier = border(
    width = border.width,
    color = when (val brush = border.brush) {
        is ShaderBrush -> Color.Black //TODO
        is SolidColor -> brush.value
    }
)