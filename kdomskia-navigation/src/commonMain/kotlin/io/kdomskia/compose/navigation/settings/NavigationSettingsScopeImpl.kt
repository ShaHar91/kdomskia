package io.kdomskia.compose.navigation.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue

internal class DomNavigationSettingsScopeImpl(
    val getSettings: () -> NavigationSettings,
    val setSettings: (NavigationSettings) -> Unit
) : DomNavigationSettingsScope {

    override var bindToWindow: Boolean
        get() = getSettings().bindToWindow
        set(value) {
            setSettings(
                getSettings().copy(
                    bindToWindow = value
                )
            )
        }

}

internal class SkiaNavigationSettingsScopeImpl : SkiaNavigationSettingsScope

internal class NavigationSettingsScopeImpl : NavigationSettingsScope {

    private var settings = NavigationSettings()

    val domScope = DomNavigationSettingsScopeImpl(
        getSettings = { settings },
        setSettings = { settings = it }
    )

    val skiaScope = SkiaNavigationSettingsScopeImpl()

    override val providedValue: ProvidedValue<*>
        get() = LocalNavigationSettings provides settings

    @Composable
    override fun dom(
        settings: @Composable DomNavigationSettingsScope.() -> Unit
    ) {
        domScope.settings()
    }

    @Composable
    override fun skia(
        settings: @Composable SkiaNavigationSettingsScope.() -> Unit
    ) {
        skiaScope.settings()
    }

}