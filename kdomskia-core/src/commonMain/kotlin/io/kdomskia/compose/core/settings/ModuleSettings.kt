package io.kdomskia.compose.core.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import io.kdomskia.annotation.InternalKdomskiaApi

@InternalKdomskiaApi
@Composable
fun <T> KdomskiaSettingsScope.ModuleSettings(
    createScope: () -> T,
    applySettings: @Composable T.() -> Unit
) where T : ModuleSettingsProvider {
    val currentCreateScope by rememberUpdatedState(createScope)
    val currentApplySettings by rememberUpdatedState(applySettings)
    val moduleScope = remember(currentApplySettings, currentCreateScope) {
        currentCreateScope()
    }
    val libScope = remember(this, moduleScope) {
        val scopeImpl = this as KdomskiaSettingsScopeImpl
        scopeImpl.registerProvider(moduleScope)
        scopeImpl
    }

    moduleScope.currentApplySettings()

    DisposableEffect(moduleScope) {
        onDispose {
            libScope.unregisterProvider(moduleScope)
        }
    }
}