package io.kdomskia.compose.ui.graphics

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import kotlin.math.round
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgba

private const val MULTIPLIER = 255f

@Stable
val Color.dom: CSSColorValue
    get() = rgba(
        r = round(red * MULTIPLIER),
        g = round(green * MULTIPLIER),
        b = round(blue * MULTIPLIER),
        a = alpha
    )