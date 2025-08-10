package io.kdomskia.compose.ui.settings

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.PlatformContext

internal actual class SkiaUiSettingsScopeImpl actual constructor(
    actual val getSettings: () -> UiSettings,
    actual val setSettings: (UiSettings) -> Unit
) : SkiaUiSettingsScope {

    @Composable
    override fun coilImageLoader(
        builder: (PlatformContext) -> ImageLoader
    ) {
        setSettings(
            getSettings().update(builder)
        )
    }

}