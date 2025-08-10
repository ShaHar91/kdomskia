package io.kdomskia.compose.navigation.settings

import androidx.compose.runtime.Composable
import io.kdomskia.compose.core.settings.KdomskiaSettingsScope
import io.kdomskia.compose.core.settings.ModuleSettings
import io.kdomskia.compose.core.settings.ModuleSettingsProvider

interface DomNavigationSettingsScope {

    var bindToWindow: Boolean

}

interface SkiaNavigationSettingsScope

interface NavigationSettingsScope : ModuleSettingsProvider {

    @Composable
    fun dom(
        settings: @Composable DomNavigationSettingsScope.() -> Unit
    )

    @Composable
    fun skia(
        settings: @Composable SkiaNavigationSettingsScope.() -> Unit
    )

}

@Composable
fun KdomskiaSettingsScope.Navigation(
    settings: @Composable NavigationSettingsScope.() -> Unit
) {
    ModuleSettings(
        createScope = { NavigationSettingsScopeImpl() },
        applySettings = settings
    )
}