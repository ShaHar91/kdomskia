package io.kdomskia.compose.foundation.lazy.staggeredgrid

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.foundation.dom.DomScrollOptions
import io.kdomskia.compose.foundation.layout.Arrangement
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.foundation.layout.skia
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope as SkiaLazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid as SkiaLazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells as SkiaStaggeredGridCells

@Composable
actual fun LazyVerticalStaggeredGrid(
    columns: StaggeredGridCells,
    modifier: Modifier,
    contentPadding: PaddingValues,
    verticalItemSpacing: Dp,
    horizontalArrangement: Arrangement.Horizontal,
    domScrollOptions: DomScrollOptions,
    content: LazyStaggeredGridScope.() -> Unit
) {
    CheckKdomskiaInitialization()
    SkiaLazyVerticalStaggeredGrid(
        columns = SkiaStaggeredGridCells.Fixed(columns.columnCount),
        modifier = modifier.skia,
        contentPadding = contentPadding.skia,
        verticalItemSpacing = verticalItemSpacing,
        horizontalArrangement = horizontalArrangement.skia,
        content = {
            content(
                LazyStaggeredGridScopeImpl(this)
            )
        }
    )
}

private class LazyStaggeredGridScopeImpl(
    val skia: SkiaLazyStaggeredGridScope
) : LazyStaggeredGridScope {

    override fun item(
        content: @Composable () -> Unit
    ) {
        items(
            count = 1,
            itemContent = { content() }
        )
    }

    override fun items(
        count: Int,
        itemContent: @Composable (Int) -> Unit
    ) {
        skia.items(
            count = count,
            itemContent = { itemContent(it) }
        )
    }

}