package io.kdomskia.compose.core.settings

import androidx.compose.runtime.ProvidedValue
import io.kdomskia.annotation.InternalKdomskiaApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

sealed interface KdomskiaSettingsScope

@InternalKdomskiaApi
interface ModuleSettingsProvider {

    val providedValue: ProvidedValue<*>

}

internal class KdomskiaSettingsScopeImpl : KdomskiaSettingsScope {

    private val _modulesProvider = MutableStateFlow(listOf<ModuleSettingsProvider>())

    val modulesProvider = _modulesProvider.asStateFlow()

    fun registerProvider(provider: ModuleSettingsProvider) {
        _modulesProvider.update { it + provider }
    }

    fun unregisterProvider(provider: ModuleSettingsProvider) {
        _modulesProvider.update { it - provider }
    }

}