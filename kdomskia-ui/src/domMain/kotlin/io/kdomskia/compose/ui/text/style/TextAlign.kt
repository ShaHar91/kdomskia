package io.kdomskia.compose.ui.text.style

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.style.TextAlign
import com.varabyte.kobweb.compose.css.TextAlign as DomTextAlign

@Stable
val TextAlign.dom: DomTextAlign
    get() = when (this) {
        TextAlign.Left -> DomTextAlign.Left
        TextAlign.Right -> DomTextAlign.Right
        TextAlign.Center -> DomTextAlign.Center
        TextAlign.Justify -> DomTextAlign.Justify
        TextAlign.Start -> DomTextAlign.Start
        else -> DomTextAlign.Unset
    }