package io.kdomskia.compose.css

import org.jetbrains.compose.web.css.StylePropertyValue

sealed interface BoxOrient : StylePropertyValue {

    companion object {

        val Horizontal get() = "horizontal".unsafeCast<BoxOrient>()

        val Vertical get() = "vertical".unsafeCast<BoxOrient>()

        val InlineAxis get() = "inline-axis".unsafeCast<BoxOrient>()

        val BlockAxis get() = "block-axis".unsafeCast<BoxOrient>()

    }

}