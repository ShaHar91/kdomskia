package io.kdomskia.compose.css

import com.varabyte.kobweb.compose.ui.styleModifier
import io.kdomskia.compose.ui.DomModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.StylePropertyValue

inline val DisplayStyle.Companion.WebkitInlineBox: DisplayStyle
    get() = DisplayStyle("-webkit-inline-box")

fun DomModifier.lineClamp(lines: Int) = styleModifier {
    property("-webkit-line-clamp", StylePropertyValue(lines))
}

fun DomModifier.boxOrient(boxOrient: BoxOrient) = styleModifier {
    property("-webkit-box-orient", boxOrient)
}