package io.kdomskia.compose.ui.text.font

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontStyle.Companion.Normal
import com.varabyte.kobweb.compose.css.FontStyle as DomFontStyle

@Stable
val FontStyle.dom: DomFontStyle?
    get() = when (this) {
        Normal -> DomFontStyle.Normal
        Italic -> DomFontStyle.Italic
        else -> null
    }