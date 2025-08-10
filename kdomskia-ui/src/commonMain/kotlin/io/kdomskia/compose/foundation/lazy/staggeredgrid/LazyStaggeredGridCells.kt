package io.kdomskia.compose.foundation.lazy.staggeredgrid

import androidx.compose.runtime.Stable

@Stable
interface StaggeredGridCells {

    class Fixed(
        internal val count: Int
    ) : StaggeredGridCells

}

internal val StaggeredGridCells.columnCount: Int
    get() = (this as StaggeredGridCells.Fixed).count