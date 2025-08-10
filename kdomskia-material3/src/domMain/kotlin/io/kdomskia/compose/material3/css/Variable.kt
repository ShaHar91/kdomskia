package io.kdomskia.compose.material3.css

import com.varabyte.kobweb.compose.css.StyleVariable
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.StylePropertyValue

object Variable {

    val buttonColor = StyleVariable.PropertyValue<CSSColorValue>("button-color")

    val rippleColor = StyleVariable.PropertyValue<CSSColorValue>("ripple-color")

    val rippleOpacity = StyleVariable.PropertyValue<StylePropertyValue>("ripple-opacity")

    val tabContainerColor = StyleVariable.PropertyValue<StylePropertyValue>("tab-container-color")

    val tabContainerHorizontalPadding = StyleVariable.PropertyValue<StylePropertyValue>("tab-container-horizontal-padding")

    val tabDividerColor = StyleVariable.PropertyValue<StylePropertyValue>("tab-divider-color")

    val tabDividerThickness = StyleVariable.PropertyValue<StylePropertyValue>("tab-divider-thickness")

    val tabIndicatorColor = StyleVariable.PropertyValue<StylePropertyValue>("tab-indicator-color")

    val tabIndicatorHeight = StyleVariable.PropertyValue<StylePropertyValue>("tab-indicator-height")

    val tabIndicatorMinWidth = StyleVariable.PropertyValue<StylePropertyValue>("tab-indicator-min-width")

    val tabPaddingLeft = StyleVariable.PropertyValue<StylePropertyValue>("tab-padding-left")

    val tabPaddingRight = StyleVariable.PropertyValue<StylePropertyValue>("tab-padding-right")

    val tabContentColor = StyleVariable.PropertyValue<StylePropertyValue>("tab-content-color")

    val appBarContainerColor = StyleVariable.PropertyValue<StylePropertyValue>("appbar-container-color")

}