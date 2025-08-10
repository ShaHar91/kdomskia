package io.kdomskia.compose.ui.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue

internal class DomUiSettingsScopeImpl : DomUiSettingsScope

internal expect class SkiaUiSettingsScopeImpl(
    getSettings: () -> UiSettings,
    setSettings: (UiSettings) -> Unit
) : SkiaUiSettingsScope {
    val getSettings: () -> UiSettings
    val setSettings: (UiSettings) -> Unit
}

internal class UiSettingsScopeImpl : UiSettingsScope {

    private var settings = UiSettings()

    val domScope = DomUiSettingsScopeImpl()

    val skiaScope = SkiaUiSettingsScopeImpl(
        getSettings = { settings },
        setSettings = { settings = it }
    )

    override val providedValue: ProvidedValue<*>
        get() = LocalUiSettings provides settings

    @Composable
    override fun dom(
        settings: @Composable DomUiSettingsScope.() -> Unit
    ) {
        domScope.settings()
    }

    @Composable
    override fun skia(
        settings: @Composable SkiaUiSettingsScope.() -> Unit
    ) {
        skiaScope.settings()
    }

}