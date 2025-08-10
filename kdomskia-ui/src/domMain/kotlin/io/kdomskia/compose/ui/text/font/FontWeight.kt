package io.kdomskia.compose.ui.text.font

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.font.FontWeight
import com.varabyte.kobweb.compose.css.FontWeight as DomFontWeight

@Stable
val FontWeight.dom: DomFontWeight
    get() = weight.toString().unsafeCast<DomFontWeight>()