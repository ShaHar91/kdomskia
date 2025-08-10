package io.kdomskia.compose.css

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

private const val PERCENT_MULTIPLIER = 100F

val Float.fractionToPercent: Float
    get() = (this * PERCENT_MULTIPLIER)

val Float.fractionToCssPercent: CSSSizeValue<CSSUnit.percent>
    get() = fractionToPercent.percent