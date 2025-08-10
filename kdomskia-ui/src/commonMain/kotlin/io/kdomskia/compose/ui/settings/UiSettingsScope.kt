package io.kdomskia.compose.ui.settings

import androidx.compose.runtime.Composable
import io.kdomskia.compose.core.settings.KdomskiaSettingsScope
import io.kdomskia.compose.core.settings.ModuleSettings
import io.kdomskia.compose.core.settings.ModuleSettingsProvider

interface DomUiSettingsScope

expect interface SkiaUiSettingsScope

interface UiSettingsScope : ModuleSettingsProvider {

    @Composable
    fun dom(
        settings: @Composable DomUiSettingsScope.() -> Unit
    )

    @Composable
    fun skia(
        settings: @Composable SkiaUiSettingsScope.() -> Unit
    )

}

@Composable
fun KdomskiaSettingsScope.Ui(
    settings: @Composable UiSettingsScope.() -> Unit
) {
    ModuleSettings(
        createScope = { UiSettingsScopeImpl() },
        applySettings = settings
    )
}