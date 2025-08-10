package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.ElementRefScope
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import io.kdomskia.compose.foundation.layout.Placement.Horizontal
import io.kdomskia.compose.foundation.layout.Placement.Vertical
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.ZIndexLayer
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.css.CSSPercentageValue
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.w3c.dom.HTMLElement
import com.varabyte.kobweb.compose.foundation.layout.Box as DomBox

@Composable
actual fun BoxScope.FloatingContainer(
    horizontalPlacement: Horizontal,
    verticalPlacement: Vertical,
    content: @Composable () -> Unit
) {
    DomFloatingContainer(
        horizontalPosition = horizontalPlacement,
        verticalPosition = verticalPlacement,
        content = content
    )
}

@Composable
fun DomFloatingContainer(
    horizontalPosition: Horizontal,
    verticalPosition: Vertical,
    zIndex: Float = ZIndexLayer.layer3.start,
    ref: ElementRefScope<HTMLElement>? = null,
    content: @Composable () -> Unit
) {
    val translateX: CSSPercentageValue
    val translateY: CSSPercentageValue
    val horizontalModifier: DomModifier
    val verticalModifier: DomModifier
    val paddingStart = horizontalPosition.paddingStart
    val paddingEnd = horizontalPosition.paddingEnd
    val paddingTop = verticalPosition.paddingTop
    val paddingBottom = verticalPosition.paddingBottom

    when (horizontalPosition) {
        is Horizontal.AlignStart -> {
            horizontalModifier = DomModifier.styleModifier {
                property("left", "calc(${0.percent} + ${paddingStart.dom})")
            }
            translateX = 0.percent
        }

        is Horizontal.AlignEnd -> {
            horizontalModifier = DomModifier.styleModifier {
                property("right", "calc(${0.percent} + ${paddingEnd.dom})")
            }
            translateX = 0.percent
        }

        is Horizontal.AlignCenter -> {
            horizontalModifier = DomModifier.styleModifier {
                property("left", "calc(${50.percent} + ${(paddingStart / 2).dom} - ${(paddingEnd / 2).dom})")
            }
            translateX = (-50).percent
        }

        is Horizontal.Fill -> {
            horizontalModifier = DomModifier.styleModifier {
                property("left", "calc(${0.percent} + ${paddingStart.dom})")
                property("width", "calc(100% - ${(paddingStart + paddingEnd).dom})")
            }
            translateX = 0.percent
        }
    }
    when (verticalPosition) {
        is Vertical.AlignTop -> {
            verticalModifier = DomModifier.styleModifier {
                property("top", "calc(${0.percent} + ${paddingTop.dom})")
            }
            translateY = 0.percent
        }

        is Vertical.AlignBottom -> {
            verticalModifier = DomModifier.styleModifier {
                property("bottom", "calc(${0.percent} + ${paddingBottom.dom})")
            }
            translateY = 0.percent
        }

        is Vertical.AlignCenter -> {
            verticalModifier = DomModifier.styleModifier {
                property("top", "calc(${50.percent} + ${(paddingTop / 2).dom} - ${(paddingBottom / 2).dom})")
            }
            translateY = (-50).percent
        }

        is Vertical.Fill -> {
            verticalModifier = DomModifier.styleModifier {
                property("top", "calc(${0.percent} + ${paddingTop.dom})")
                property("height", "calc(100% - ${(paddingTop + paddingBottom).dom})")
            }
            translateY = 0.percent
        }
    }

    DomBox(
        modifier = DomModifier
            .position(Position.Fixed)
            .zIndex(zIndex)
            .then(horizontalModifier)
            .then(verticalModifier)
            .transform { translate(translateX, translateY) },
        ref = ref
    ) {
        content()
    }
}