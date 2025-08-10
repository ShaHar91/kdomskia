package io.kdomskia.compose.foundation.lazy.staggeredgrid

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.kdomskia.compose.foundation.dom.DomScrollOptions
import io.kdomskia.compose.foundation.layout.Arrangement
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.ui.Modifier

@Composable
expect fun LazyVerticalStaggeredGrid(
    columns: StaggeredGridCells,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    verticalItemSpacing: Dp = 0.dp,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(0.dp),
    domScrollOptions: DomScrollOptions,
    content: LazyStaggeredGridScope.() -> Unit,
)

@DslMarker
internal annotation class LazyStaggeredGridScopeMarker

@LazyStaggeredGridScopeMarker
interface LazyStaggeredGridScope {

    fun item(
        content: @Composable () -> Unit,
    )

    fun items(
        count: Int,
        itemContent: @Composable (index: Int) -> Unit,
    )

}

inline fun <T> LazyStaggeredGridScope.items(
    items: List<T>,
    crossinline itemContent: @Composable (item: T) -> Unit,
) {
    items(
        count = items.size,
        itemContent = { index -> itemContent(items[index]) },
    )
}

inline fun <T> LazyStaggeredGridScope.itemsIndexed(
    items: List<T>,
    crossinline itemContent: @Composable (index: Int, item: T) -> Unit,
) {
    items(
        count = items.size,
        itemContent = { index -> itemContent(index, items[index]) },
    )
}

inline fun <T> LazyStaggeredGridScope.items(
    items: Array<T>,
    crossinline itemContent: @Composable (item: T) -> Unit,
) {
    items(
        count = items.size,
        itemContent = { index -> itemContent(items[index]) },
    )
}

inline fun <T> LazyStaggeredGridScope.itemsIndexed(
    items: Array<T>,
    crossinline itemContent: @Composable (index: Int, item: T) -> Unit,
) {
    items(
        count = items.size,
        itemContent = { index -> itemContent(index, items[index]) },
    )
}