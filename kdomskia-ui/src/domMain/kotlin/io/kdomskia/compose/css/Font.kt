package io.kdomskia.compose.css

import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.css.StyleScope

fun StyleScope.src(value: StylePropertyValue) {
    property("src", value)
}