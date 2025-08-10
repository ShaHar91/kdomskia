package io.kdomskia.compose.foundation

import io.kdomskia.compose.ui.DomModifier
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.overflowX
import com.varabyte.kobweb.compose.css.overflowY
import com.varabyte.kobweb.compose.ui.styleModifier

fun DomModifier.overflowY(overflow: Overflow) = styleModifier {
    overflowY(overflow)
}

fun DomModifier.overflowX(overflow: Overflow) = styleModifier {
    overflowX(overflow)
}