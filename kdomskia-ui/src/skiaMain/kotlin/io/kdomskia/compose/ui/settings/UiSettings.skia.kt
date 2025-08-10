package io.kdomskia.compose.ui.settings

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.svg.SvgDecoder

internal actual class UiSettings actual constructor() {

    private var _coilImageLoader: ((PlatformContext) -> ImageLoader)? = null

    val coilImageLoader: (PlatformContext) -> ImageLoader
        get() = _coilImageLoader ?: defaultCoilImageLoader


    private constructor(
        coilImageLoader: (PlatformContext) -> ImageLoader
    ) : this() {
        this._coilImageLoader = coilImageLoader
    }

    fun update(coilImageLoader: (PlatformContext) -> ImageLoader) = UiSettings(
        coilImageLoader = coilImageLoader
    )

}

private val defaultCoilImageLoader: (PlatformContext) -> ImageLoader = { context ->
    ImageLoader.Builder(context)
        .components {
            add(
                SvgDecoder.Factory(
                    useViewBoundsAsIntrinsicSize = false,
                    renderToBitmap = true,
                    scaleToDensity = true
                )
            )
        }
        .build()
}