package io.kdomskia.compose.material3

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.RippleConfiguration
import androidx.compose.ui.graphics.Color

private val defaultRippleAlpha = RippleAlpha(
    draggedAlpha = 0.5f,
    focusedAlpha = 0.5f,
    hoveredAlpha = 0.5f,
    pressedAlpha = 0.5f,
)

private val defaultRippleConfiguration = RippleConfiguration(
    color = Color.Black,
    rippleAlpha = defaultRippleAlpha
)

internal fun RippleConfiguration?.orDefault(): RippleConfiguration = this ?: defaultRippleConfiguration

internal fun RippleAlpha?.orDefault(): RippleAlpha = this ?: defaultRippleAlpha