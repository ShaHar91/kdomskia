package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.ui.unit.dom
import com.varabyte.kobweb.compose.foundation.layout.Arrangement as DomArrangement
import com.varabyte.kobweb.compose.foundation.layout.Arrangement.Horizontal as DomHorizontal
import com.varabyte.kobweb.compose.foundation.layout.Arrangement.HorizontalOrVertical as DomHorizontalOrVertical
import com.varabyte.kobweb.compose.foundation.layout.Arrangement.Vertical as DomVertical
import com.varabyte.kobweb.compose.foundation.layout.Arrangement.spacedBy as domSpacedBy

@Immutable
actual object Arrangement {

    @Stable
    actual interface Horizontal {
        val dom: DomHorizontal
    }

    @Stable
    actual interface Vertical {
        val dom: DomVertical
    }

    @Stable
    actual interface HorizontalOrVertical : Horizontal, Vertical {
        override val dom: DomHorizontalOrVertical
    }

    @Stable
    actual val Start: Horizontal = HorizontalImpl(DomArrangement.Start)

    @Stable
    actual val End: Horizontal = HorizontalImpl(DomArrangement.End)

    @Stable
    actual val Top: Vertical = VerticalImpl(DomArrangement.Top)

    @Stable
    actual val Bottom: Vertical = VerticalImpl(DomArrangement.Bottom)

    @Stable
    actual val Center: HorizontalOrVertical = HorizontalOrVerticalImpl(DomArrangement.Center)

    @Stable
    actual val SpaceEvenly: HorizontalOrVertical = HorizontalOrVerticalImpl(DomArrangement.SpaceEvenly)

    @Stable
    actual val SpaceBetween: HorizontalOrVertical = HorizontalOrVerticalImpl(DomArrangement.SpaceBetween)

    @Stable
    actual val SpaceAround: HorizontalOrVertical = HorizontalOrVerticalImpl(DomArrangement.SpaceAround)

    @Stable
    actual fun spacedBy(
        space: Dp
    ): HorizontalOrVertical = HorizontalOrVerticalImpl(domSpacedBy(space.dom))

    @Stable
    actual fun spacedBy(
        space: Dp, alignment: Alignment.Horizontal
    ): Horizontal = HorizontalImpl(domSpacedBy(space.dom, alignment.dom))

    @Stable
    actual fun spacedBy(
        space: Dp, alignment: Alignment.Vertical
    ): Vertical = VerticalImpl(domSpacedBy(space.dom, alignment.dom))

}

internal class HorizontalImpl(
    override val dom: DomHorizontal
) : Arrangement.Horizontal

internal class VerticalImpl(
    override val dom: DomVertical
) : Arrangement.Vertical

internal class HorizontalOrVerticalImpl(
    override val dom: DomHorizontalOrVertical
) : Arrangement.HorizontalOrVertical