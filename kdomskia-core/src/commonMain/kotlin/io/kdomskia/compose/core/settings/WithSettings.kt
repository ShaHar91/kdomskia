package io.kdomskia.compose.core.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState

@Composable
internal fun WithSettings(
    settings: @Composable KdomskiaSettingsScope.() -> Unit,
    content: @Composable () -> Unit
) {
    val clientSettings by rememberUpdatedState(settings)
    val scope = remember(clientSettings) {
        KdomskiaSettingsScopeImpl()
    }

    scope.settings()

    val modulesProvider by scope.modulesProvider.collectAsState()

    CompositionLocalProvider(
        *modulesProvider.map { it.providedValue }.toTypedArray()
    ) {
        content()
    }
}