package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.ui.Alignment
import androidx.compose.ui.unit.Dp

@Immutable
expect object Arrangement {

    @Stable
    interface Horizontal

    @Stable
    interface Vertical

    @Stable
    interface HorizontalOrVertical : Horizontal, Vertical

    @Stable
    val Start: Horizontal

    @Stable
    val End: Horizontal

    @Stable
    val Top: Vertical

    @Stable
    val Bottom: Vertical

    @Stable
    val Center: HorizontalOrVertical

    @Stable
    val SpaceEvenly: HorizontalOrVertical

    @Stable
    val SpaceBetween: HorizontalOrVertical

    @Stable
    val SpaceAround: HorizontalOrVertical

    @Stable
    fun spacedBy(space: Dp): HorizontalOrVertical

    @Stable
    fun spacedBy(space: Dp, alignment: Alignment.Horizontal): Horizontal

    @Stable
    fun spacedBy(space: Dp, alignment: Alignment.Vertical): Vertical

}