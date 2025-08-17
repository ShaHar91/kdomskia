package io.kdomskia.compose.material3.beer

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.varabyte.kobweb.compose.ui.modifiers.disabled
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.thenIfNotNull
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.extension.addIf
import io.kdomskia.compose.foundation.border
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.foundation.layout.Row
import io.kdomskia.compose.foundation.layout.RowScope
import io.kdomskia.compose.foundation.layout.padding
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.material3.LocalTextStyle
import io.kdomskia.compose.material3.contentColorFor
import io.kdomskia.compose.material3.css.Variable
import io.kdomskia.compose.material3.css.beer.BeerVariable
import io.kdomskia.compose.material3.css.beer.classes.BeerButtonElevateClass
import io.kdomskia.compose.material3.css.beer.classes.BeerButtonSizeClass
import io.kdomskia.compose.material3.css.beer.classes.BeerColorClass
import io.kdomskia.compose.material3.css.beer.classes.BeerCommonClass
import io.kdomskia.compose.material3.internal.ProvideContentColorTextStyle
import io.kdomskia.compose.material3.orDefault
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.draw.clip
import io.kdomskia.compose.ui.graphics.dom
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.dom.Button as DomButton

@Composable
fun BeerButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    containerColor: Color,
    contentColor: Color,
    shape: Shape,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    buttonSize: BeerButtonSizeClass? = BeerButtonSizeClass.Medium,
    buttonElevate: BeerButtonElevateClass? = null,
    textStyle: TextStyle = LocalTextStyle.current,
    content: @Composable RowScope.() -> Unit
) {
    val ripple = LocalRippleConfiguration.current.orDefault()
    val color = contentColorFor(containerColor)
    val alpha = ripple.rippleAlpha.orDefault().pressedAlpha

    DomButton(
        attrs = modifier
            .padding(contentPadding)
            .clip(shape)
            .unwrap {
                val classes = listOf(BeerColorClass.Primary, buttonSize, buttonElevate)
                    .addIf(containerColor == Color.Transparent, BeerCommonClass.Transparent)
                    .addIf(border != null, BeerCommonClass.Border)
                    .filterNotNull()

                typeSafeClasses(classes)
                    .margin(
                        top = 4.dp.dom,
                        bottom = 4.dp.dom
                    )
                    .thenIfNotNull(border) {
                        DomModifier.border(it)
                    }
                    .disabled(enabled.not())
                    .setVariable(BeerVariable.size, StylePropertyValue("inherit"))
                    .setVariable(Variable.buttonColor, containerColor.dom)
                    .setVariable(Variable.rippleColor, color.copy(alpha = 1f).dom)
                    .setVariable(Variable.rippleOpacity, StylePropertyValue(alpha))
                    .onClick { onClick() }
            }
            .dom
            .toAttrs()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProvideContentColorTextStyle(contentColor, textStyle) {
                content()
            }
        }
    }
}