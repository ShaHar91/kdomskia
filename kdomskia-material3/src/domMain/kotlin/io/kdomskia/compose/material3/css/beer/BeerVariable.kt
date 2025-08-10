package io.kdomskia.compose.material3.css.beer

import com.varabyte.kobweb.compose.css.StyleVariable
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.StylePropertyValue

object BeerVariable {

    val primary = StyleVariable.PropertyValue<CSSColorValue>("primary")

    val size = StyleVariable.PropertyValue<StylePropertyValue>("_size")

    val speed2 = StyleVariable.PropertyValue<StylePropertyValue>("speed2")

}