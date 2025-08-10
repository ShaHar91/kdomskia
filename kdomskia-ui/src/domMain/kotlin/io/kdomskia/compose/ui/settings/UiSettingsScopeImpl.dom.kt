package io.kdomskia.compose.ui.settings

internal actual class SkiaUiSettingsScopeImpl actual constructor(
    actual val getSettings: () -> UiSettings,
    actual val setSettings: (UiSettings) -> Unit
) : SkiaUiSettingsScope