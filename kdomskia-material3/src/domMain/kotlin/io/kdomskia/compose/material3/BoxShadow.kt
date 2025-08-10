package io.kdomskia.compose.material3

import androidx.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.graphics.dom
import org.jetbrains.compose.web.css.px

fun BoxShadow.Companion.from(
    shadowElevation: Float
): BoxShadow = BoxShadow.of(
    offsetX = (-0.4f).px,
    offsetY = 0.4f.px,
    blurRadius = (2 + shadowElevation).px,
    spreadRadius = 0f.px,
    color = Color.Black.copy(alpha = 0.4f).dom,
    inset = false
)

fun DomModifier.boxShadow(
    shadowElevation: Float
): DomModifier = boxShadow(BoxShadow.from(shadowElevation))