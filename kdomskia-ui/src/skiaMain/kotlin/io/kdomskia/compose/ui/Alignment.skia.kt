package io.kdomskia.compose.ui

import androidx.compose.runtime.Stable

typealias SkiaAlignment = androidx.compose.ui.Alignment
typealias SkiaHorizontal = androidx.compose.ui.Alignment.Horizontal
typealias SkiaVertical = androidx.compose.ui.Alignment.Vertical

@Stable
actual interface Alignment {

    val skia: SkiaAlignment

    @Stable
    actual interface Horizontal {
        val skia: SkiaHorizontal
    }

    @Stable
    actual interface Vertical {
        val skia: SkiaVertical
    }

    actual companion object {

        @Stable
        actual val TopStart: Alignment = AlignmentImpl(SkiaAlignment.TopStart)

        @Stable
        actual val TopCenter: Alignment = AlignmentImpl(SkiaAlignment.TopCenter)

        @Stable
        actual val TopEnd: Alignment = AlignmentImpl(SkiaAlignment.TopEnd)

        @Stable
        actual val CenterStart: Alignment = AlignmentImpl(SkiaAlignment.CenterStart)

        @Stable
        actual val Center: Alignment = AlignmentImpl(SkiaAlignment.Center)

        @Stable
        actual val CenterEnd: Alignment = AlignmentImpl(SkiaAlignment.CenterEnd)

        @Stable
        actual val BottomStart: Alignment = AlignmentImpl(SkiaAlignment.BottomStart)

        @Stable
        actual val BottomCenter: Alignment = AlignmentImpl(SkiaAlignment.BottomCenter)

        @Stable
        actual val BottomEnd: Alignment = AlignmentImpl(SkiaAlignment.BottomEnd)

        @Stable
        actual val Top: Alignment.Vertical = VerticalImpl(SkiaAlignment.Top)

        @Stable
        actual val CenterVertically: Alignment.Vertical = VerticalImpl(SkiaAlignment.CenterVertically)

        @Stable
        actual val Bottom: Alignment.Vertical = VerticalImpl(SkiaAlignment.Bottom)

        @Stable
        actual val Start: Alignment.Horizontal = HorizontalImpl(SkiaAlignment.Start)

        @Stable
        actual val CenterHorizontally: Alignment.Horizontal = HorizontalImpl(SkiaAlignment.CenterHorizontally)

        @Stable
        actual val End: Alignment.Horizontal = HorizontalImpl(SkiaAlignment.End)

    }

}

internal class AlignmentImpl(
    override val skia: SkiaAlignment
) : Alignment

internal class HorizontalImpl(
    override val skia: SkiaHorizontal
) : Alignment.Horizontal

internal class VerticalImpl(
    override val skia: SkiaVertical
) : Alignment.Vertical