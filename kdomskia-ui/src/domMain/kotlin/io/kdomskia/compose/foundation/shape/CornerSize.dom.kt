package io.kdomskia.compose.foundation.shape

import androidx.compose.ui.platform.InspectableValue
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.css.px
import androidx.compose.foundation.shape.CornerSize as SkiaCornerSize

private val SkiaCornerSize.valueOverride: Any?
    get() = (this as? InspectableValue)?.valueOverride

val CornerSize.dom: StylePropertyValue
    get() = commonSkia.dom

val SkiaCornerSize.dom: StylePropertyValue
    get() {
        val value = valueOverride
        val valueStr = value?.toString().orEmpty()

        val style = when {
            value is Dp -> {
                value.dom
            }

            value is Float -> {
                value.px
            }

            valueStr.contains("%") -> {
                StylePropertyValue(valueStr)
            }

            else -> 0.px
        }

        return style
    }