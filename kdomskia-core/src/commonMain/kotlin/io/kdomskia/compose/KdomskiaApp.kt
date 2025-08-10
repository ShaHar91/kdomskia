package io.kdomskia.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import io.kdomskia.compose.core.loader.WithModulesAfterApplySettings
import io.kdomskia.compose.core.loader.WithModulesLoader
import io.kdomskia.compose.core.settings.KdomskiaSettingsScope
import io.kdomskia.compose.core.settings.WithSettings
import io.kdomskia.compose.internal.LocalInitState
import io.kdomskia.compose.internal.PlatformApp
import io.kdomskia.compose.platform.LocalPlatformContext
import io.kdomskia.compose.platform.providePlatformContext
import io.kdomskia.compose.resource.DrawableResourcesRef
import io.kdomskia.compose.resource.LocalDrawableResourcesRef

@Composable
fun KdomskiaApp(
    drawableResources: DrawableResourcesRef,
    settings: @Composable KdomskiaSettingsScope.() -> Unit = { },
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalInitState provides true,
        LocalPlatformContext provides providePlatformContext(),
        LocalDrawableResourcesRef provides drawableResources
    ) {
        PlatformApp {
            WithModulesLoader {
                WithSettings(
                    settings = settings
                ) {
                    WithModulesAfterApplySettings {
                        content()
                    }
                }
            }
        }
    }
}