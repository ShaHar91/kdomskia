package io.kdomskia.compose.ui.unit

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.varabyte.kobweb.compose.css.CSSLengthNumericValue
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

@Stable
val TextUnit.dom: CSSLengthNumericValue?
    get() = when (type) {
        TextUnitType.Unspecified -> null
        TextUnitType.Sp -> value.px
        TextUnitType.Em -> value.em
        else -> null
    }