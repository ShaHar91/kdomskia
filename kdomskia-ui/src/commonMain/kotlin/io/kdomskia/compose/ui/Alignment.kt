package io.kdomskia.compose.ui

import androidx.compose.runtime.Stable

@Stable
expect interface Alignment {

    @Stable
    interface Horizontal

    @Stable
    interface Vertical

    companion object {

        @Stable
        val TopStart: Alignment

        @Stable
        val TopCenter: Alignment

        @Stable
        val TopEnd: Alignment

        @Stable
        val CenterStart: Alignment

        @Stable
        val Center: Alignment

        @Stable
        val CenterEnd: Alignment

        @Stable
        val BottomStart: Alignment

        @Stable
        val BottomCenter: Alignment

        @Stable
        val BottomEnd: Alignment

        @Stable
        val Top: Vertical

        @Stable
        val CenterVertically: Vertical

        @Stable
        val Bottom: Vertical

        @Stable
        val Start: Horizontal

        @Stable
        val CenterHorizontally: Horizontal

        @Stable
        val End: Horizontal

    }

}