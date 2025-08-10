package io.kdomskia.compose.ui.unit

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

@Stable
val Dp.dom: CSSSizeValue<CSSUnit.px>
    get() = value.px