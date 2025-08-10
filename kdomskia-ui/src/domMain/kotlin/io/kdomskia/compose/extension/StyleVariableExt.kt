package io.kdomskia.compose.extension

import com.varabyte.kobweb.compose.css.StyleVariable

val StyleVariable<*, *>.nameWithPrefix: String
    get() = "--$name"