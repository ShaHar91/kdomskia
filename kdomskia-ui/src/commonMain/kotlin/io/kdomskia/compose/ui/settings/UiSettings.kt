package io.kdomskia.compose.ui.settings

import androidx.compose.runtime.staticCompositionLocalOf

internal expect class UiSettings()

internal val LocalUiSettings = staticCompositionLocalOf { UiSettings() }