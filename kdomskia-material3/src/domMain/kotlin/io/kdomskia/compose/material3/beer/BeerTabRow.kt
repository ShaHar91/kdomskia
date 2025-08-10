package io.kdomskia.compose.material3.beer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.css.TypeSafeClass
import io.kdomskia.compose.foundation.layout.Row
import io.kdomskia.compose.foundation.layout.Spacer
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.material3.ProvideContentColor
import io.kdomskia.compose.material3.css.Variable
import io.kdomskia.compose.material3.css.beer.classes.BeerTabClass
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.graphics.dom
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Div

@Composable
fun BeerTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    isScrollable: Boolean,
    classes: List<TypeSafeClass> = emptyList(),
    containerColor: Color,
    contentColor: Color,
    indicatorColor: Color,
    indicatorHeight: Dp,
    dividerColor: Color,
    dividerThickness: Dp,
    containerHorizontalPadding: Dp,
    tabs: @Composable () -> Unit
) {
    Row(
        modifier = modifier
    ) {
        Div(
            attrs = DomModifier
                .thenIf(isScrollable.not()) {
                    DomModifier.minWidth(100.percent)
                }
                .typeSafeClasses(listOf(BeerTabClass.Tabs) + classes)
                .setVariable(Variable.tabContainerColor, containerColor.dom)
                .setVariable(Variable.tabContainerHorizontalPadding, containerHorizontalPadding.dom)
                .setVariable(Variable.tabIndicatorColor, indicatorColor.dom)
                .setVariable(Variable.tabIndicatorHeight, indicatorHeight.dom)
                .setVariable(Variable.tabDividerColor, dividerColor.dom)
                .setVariable(Variable.tabDividerThickness, dividerThickness.dom)
                .toAttrs()
        ) {
            CompositionLocalProvider(
                LocalTabContainerColor provides containerColor
            ) {
                ProvideContentColor(contentColor) {
                    tabs()
                }
            }
        }
        if (isScrollable)
            Spacer(modifier = Modifier.weight(1f))
    }
}

internal val LocalTabContainerColor = compositionLocalOf { Color.Unspecified }