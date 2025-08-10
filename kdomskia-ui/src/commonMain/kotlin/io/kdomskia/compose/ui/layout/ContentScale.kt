package io.kdomskia.compose.ui.layout

import androidx.compose.runtime.Stable
import androidx.compose.ui.layout.ContentScale as SkiaContentScale

@Stable
interface ContentScale {

    companion object {

        @Stable
        val Crop: ContentScale = ContentScaleImpl(SkiaContentScale.Crop)

        @Stable
        val Fit: ContentScale = ContentScaleImpl(SkiaContentScale.Fit)

        @Stable
        val FillHeight: ContentScale = ContentScaleImpl(SkiaContentScale.FillHeight)

        @Stable
        val FillWidth: ContentScale = ContentScaleImpl(SkiaContentScale.FillWidth)

        @Stable
        val Inside: ContentScale = ContentScaleImpl(SkiaContentScale.Inside)

        @Stable
        val None: ContentScale = ContentScaleImpl(SkiaContentScale.None)

        @Stable
        val FillBounds: ContentScale = ContentScaleImpl(SkiaContentScale.FillBounds)
    }

}

internal class ContentScaleImpl(
    val _skia: SkiaContentScale
) : ContentScale

internal val ContentScale.commonSkia: SkiaContentScale
    get() = (this as ContentScaleImpl)._skia