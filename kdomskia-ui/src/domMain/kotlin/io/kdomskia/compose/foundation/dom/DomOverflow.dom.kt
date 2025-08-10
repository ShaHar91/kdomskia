package io.kdomskia.compose.foundation.dom

import com.varabyte.kobweb.compose.css.Overflow

actual enum class DomOverflow(
    val dom: Overflow
) {

    Visible(Overflow.Visible),

    Hidden(Overflow.Hidden),

    Clip(Overflow.Clip),

    Scroll(Overflow.Scroll),

    Auto(Overflow.Auto)

}