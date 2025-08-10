package io.kdomskia.compose.ui

import androidx.compose.runtime.Stable
import com.varabyte.kobweb.compose.ui.Alignment as DomAlignment
import com.varabyte.kobweb.compose.ui.Alignment.Horizontal as DomHorizontal
import com.varabyte.kobweb.compose.ui.Alignment.Vertical as DomVertical

@Stable
actual interface Alignment {

    val dom: DomAlignment

    @Stable
    actual interface Horizontal {
        val dom: DomHorizontal
    }

    @Stable
    actual interface Vertical {
        val dom: DomVertical
    }

    actual companion object {

        @Stable
        actual val TopStart: Alignment = AlignmentImpl(DomAlignment.TopStart)

        @Stable
        actual val TopCenter: Alignment = AlignmentImpl(DomAlignment.TopCenter)

        @Stable
        actual val TopEnd: Alignment = AlignmentImpl(DomAlignment.TopEnd)

        @Stable
        actual val CenterStart: Alignment = AlignmentImpl(DomAlignment.CenterStart)

        @Stable
        actual val Center: Alignment = AlignmentImpl(DomAlignment.Center)

        @Stable
        actual val CenterEnd: Alignment = AlignmentImpl(DomAlignment.CenterEnd)

        @Stable
        actual val BottomStart: Alignment = AlignmentImpl(DomAlignment.BottomStart)

        @Stable
        actual val BottomCenter: Alignment = AlignmentImpl(DomAlignment.BottomCenter)

        @Stable
        actual val BottomEnd: Alignment = AlignmentImpl(DomAlignment.BottomEnd)

        @Stable
        actual val Top: Alignment.Vertical = VerticalImpl(DomAlignment.Top)

        @Stable
        actual val CenterVertically: Alignment.Vertical = VerticalImpl(DomAlignment.CenterVertically)

        @Stable
        actual val Bottom: Alignment.Vertical = VerticalImpl(DomAlignment.Bottom)

        @Stable
        actual val Start: Alignment.Horizontal = HorizontalImpl(DomAlignment.Start)

        @Stable
        actual val CenterHorizontally: Alignment.Horizontal = HorizontalImpl(DomAlignment.CenterHorizontally)

        @Stable
        actual val End: Alignment.Horizontal = HorizontalImpl(DomAlignment.End)

    }

}

internal class AlignmentImpl(
    override val dom: DomAlignment
) : Alignment

internal class HorizontalImpl(
    override val dom: DomHorizontal
) : Alignment.Horizontal

internal class VerticalImpl(
    override val dom: DomVertical
) : Alignment.Vertical