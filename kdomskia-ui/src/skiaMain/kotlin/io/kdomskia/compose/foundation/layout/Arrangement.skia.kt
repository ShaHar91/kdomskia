package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement.spacedBy as skiaSpacedBy

typealias SkiaArrangement = androidx.compose.foundation.layout.Arrangement
typealias SkiaHorizontal = androidx.compose.foundation.layout.Arrangement.Horizontal
typealias SkiaVertical = androidx.compose.foundation.layout.Arrangement.Vertical
typealias SkiaHorizontalOrVertical = androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical

@Immutable
actual object Arrangement {

    @Stable
    actual interface Horizontal {
        val skia: SkiaHorizontal
    }

    @Stable
    actual interface Vertical {
        val skia: SkiaVertical
    }

    @Stable
    actual interface HorizontalOrVertical : Horizontal, Vertical {
        override val skia: SkiaHorizontalOrVertical
    }

    @Stable
    actual val Start: Horizontal = HorizontalImpl(SkiaArrangement.Start)

    @Stable
    actual val End: Horizontal = HorizontalImpl(SkiaArrangement.End)

    @Stable
    actual val Top: Vertical = VerticalImpl(SkiaArrangement.Top)

    @Stable
    actual val Bottom: Vertical = VerticalImpl(SkiaArrangement.Bottom)

    @Stable
    actual val Center: HorizontalOrVertical = HorizontalOrVerticalImpl(SkiaArrangement.Center)

    @Stable
    actual val SpaceEvenly: HorizontalOrVertical = HorizontalOrVerticalImpl(SkiaArrangement.SpaceEvenly)

    @Stable
    actual val SpaceBetween: HorizontalOrVertical = HorizontalOrVerticalImpl(SkiaArrangement.SpaceBetween)

    @Stable
    actual val SpaceAround: HorizontalOrVertical = HorizontalOrVerticalImpl(SkiaArrangement.SpaceAround)

    @Stable
    actual fun spacedBy(
        space: Dp
    ): HorizontalOrVertical = HorizontalOrVerticalImpl(skiaSpacedBy(space))

    @Stable
    actual fun spacedBy(
        space: Dp, alignment: Alignment.Horizontal
    ): Horizontal = HorizontalImpl(skiaSpacedBy(space, alignment.skia))

    @Stable
    actual fun spacedBy(
        space: Dp, alignment: Alignment.Vertical
    ): Vertical = VerticalImpl(skiaSpacedBy(space, alignment.skia))

}

internal class HorizontalImpl(
    override val skia: SkiaHorizontal
) : Arrangement.Horizontal

internal class VerticalImpl(
    override val skia: SkiaVertical
) : Arrangement.Vertical

internal class HorizontalOrVerticalImpl(
    override val skia: SkiaHorizontalOrVertical
) : Arrangement.HorizontalOrVertical