package io.kdomskia.compose.material3.beer

import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.dom.ResizeObserver
import io.kdomskia.compose.foundation.layout.Row
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.material3.MaterialTheme
import io.kdomskia.compose.material3.ProvideContentColor
import io.kdomskia.compose.material3.contentColorFor
import io.kdomskia.compose.material3.css.Variable
import io.kdomskia.compose.material3.css.beer.classes.BeerTabClass
import io.kdomskia.compose.material3.orDefault
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.graphics.dom
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.w3c.dom.HTMLElement

@Composable
fun BeerTab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    text: @Composable (() -> Unit)?,
    icon: @Composable (() -> Unit)?,
    selectedContentColor: Color,
    unselectedContentColor: Color
) {
    val color = if (selected) selectedContentColor else unselectedContentColor
    val containerColor = LocalTabContainerColor.current
    val ripple = LocalRippleConfiguration.current.orDefault()
    val rippleColor = contentColorFor(containerColor)
    val rippleAlpha = ripple.rippleAlpha.orDefault().pressedAlpha
    var tabWidth by remember { mutableStateOf<CSSSizeValue<out CSSUnit>>(0.px) }

    A(
        attrs = modifier
            .dom
            .thenIf(selected) {
                DomModifier.typeSafeClasses(BeerTabClass.Active)
            }
            .setVariable(Variable.tabIndicatorMinWidth, tabWidth)
            .setVariable(Variable.tabPaddingLeft, HorizontalTabPadding.dom)
            .setVariable(Variable.tabPaddingRight, HorizontalTabPadding.dom)
            .setVariable(Variable.tabContentColor, color.dom)
            .setVariable(Variable.rippleColor, rippleColor.copy(alpha = 1f).dom)
            .setVariable(Variable.rippleOpacity, StylePropertyValue(rippleAlpha))
            .onClick {
                if (enabled)
                    onClick()
            }
            .toAttrs()
    ) {
        Row {
            DisposableEffect(Unit) {
                val element = scopeElement.firstElementChild as? HTMLElement
                val width = element?.offsetWidth?.px ?: 100.percent

                tabWidth = width

                val resizeObserver = ResizeObserver { entries, observer ->
                    entries.forEach {
                        (it.target as? HTMLElement)?.let { resizedElement ->
                            val resizedWidth = resizedElement.offsetWidth.px
                            tabWidth = resizedWidth
                        }
                    }
                }

                if (element != null)
                    resizeObserver.observe(element)

                onDispose {
                    resizeObserver.disconnect()
                }
            }
            ProvideContentColor(color) {
                if (text != null) {
                    ProvideTextStyle(MaterialTheme.typography.titleSmall) {
                        text()
                    }
                }
                if (icon != null) {
                    icon()
                }
            }
        }
    }
}

internal val HorizontalTabPadding = 28.dp