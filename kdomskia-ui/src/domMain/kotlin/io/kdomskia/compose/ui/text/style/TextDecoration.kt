package io.kdomskia.compose.ui.text.style

import androidx.compose.ui.text.style.TextDecoration
import com.varabyte.kobweb.compose.css.TextDecorationLine

val TextDecoration.dom: TextDecorationLine
    get() = when (this) {
        TextDecoration.None -> TextDecorationLine.None
        TextDecoration.Underline -> TextDecorationLine.Underline
        TextDecoration.LineThrough -> TextDecorationLine.LineThrough
        else -> TextDecorationLine.None
    }