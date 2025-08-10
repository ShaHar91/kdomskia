package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import io.kdomskia.compose.foundation.layout.Arrangement
import io.kdomskia.compose.foundation.layout.Box
import io.kdomskia.compose.foundation.layout.Row
import io.kdomskia.compose.foundation.layout.Spacer
import io.kdomskia.compose.foundation.layout.defaultMinSize
import io.kdomskia.compose.foundation.layout.padding
import io.kdomskia.compose.foundation.layout.sizeIn
import io.kdomskia.compose.foundation.layout.width
import io.kdomskia.compose.material3.beer.BeerButton
import io.kdomskia.compose.material3.css.beer.BeerVariable
import io.kdomskia.compose.material3.css.beer.classes.BeerButtonElevateClass
import io.kdomskia.compose.material3.internal.ProvideContentColorTextStyle
import io.kdomskia.compose.material3.tokens.FabBaselineTokens
import io.kdomskia.compose.ui.Modifier
import org.jetbrains.compose.web.css.StylePropertyValue

private val ExtendedFabStartIconPadding = 16.dp

private val ExtendedFabEndIconPadding = 12.dp

private val ExtendedFabTextPadding = 20.dp

private val ExtendedFabMinimumWidth = 80.dp

@Composable
actual fun FloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier,
    shape: Shape,
    containerColor: Color,
    contentColor: Color,
    content: @Composable () -> Unit
) {
    BeerButton(
        onClick = onClick,
        modifier = modifier.unwrap {
            setVariable(BeerVariable.size, StylePropertyValue("unset"))
        },
        enabled = true,
        containerColor = containerColor,
        contentColor = contentColor,
        buttonElevate = BeerButtonElevateClass.Medium,
        shape = shape,
        textStyle = MaterialTheme.typography.labelLarge,
        content = {
            ProvideContentColorTextStyle(
                contentColor = contentColor,
                textStyle = LocalTextStyle.current
            ) {
                Box(
                    modifier = Modifier.defaultMinSize(
                        minWidth = FabBaselineTokens.ContainerWidth,
                        minHeight = FabBaselineTokens.ContainerHeight,
                    ),
                    contentAlignment = Alignment.Center
                ) {
                    content()
                }
            }
        }
    )
}

@Composable
actual fun ExtendedFloatingActionButton(
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier,
    expanded: Boolean,
    shape: Shape,
    containerColor: Color,
    contentColor: Color
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor
    ) {
        val startPadding = if (expanded) ExtendedFabStartIconPadding else 0.dp
        val endPadding = if (expanded) ExtendedFabTextPadding else 0.dp

        Row(
            modifier = Modifier
                .sizeIn(
                    minWidth =
                        if (expanded) {
                            ExtendedFabMinimumWidth
                        } else {
                            FabBaselineTokens.ContainerWidth
                        }
                )
                .padding(start = startPadding, end = endPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (expanded) Arrangement.Start else Arrangement.Center
        ) {
            icon()
            if (expanded) {
                Row {
                    Spacer(Modifier.width(ExtendedFabEndIconPadding))
                    text()
                }
            }
        }
    }
}