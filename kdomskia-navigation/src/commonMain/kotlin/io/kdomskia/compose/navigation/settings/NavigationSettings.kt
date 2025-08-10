package io.kdomskia.compose.navigation.settings

import androidx.compose.runtime.staticCompositionLocalOf

internal data class NavigationSettings(
    val bindToWindow: Boolean = true
)

internal val LocalNavigationSettings = staticCompositionLocalOf { NavigationSettings() }