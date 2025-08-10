package io.kdomskia.compose.ui.settings

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.PlatformContext

actual interface SkiaUiSettingsScope {

    @Composable
    fun coilImageLoader(builder: (PlatformContext) -> ImageLoader)

}