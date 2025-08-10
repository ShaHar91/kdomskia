package io.kdomskia.compose.foundation.lazy.staggeredgrid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.dom.ResizeObserver
import io.kdomskia.compose.foundation.dom.DomScrollOptions
import io.kdomskia.compose.foundation.layout.Arrangement
import io.kdomskia.compose.foundation.layout.Box
import io.kdomskia.compose.foundation.layout.Column
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.foundation.layout.Row
import io.kdomskia.compose.foundation.layout.dom.domId
import io.kdomskia.compose.foundation.layout.padding
import io.kdomskia.compose.foundation.rememberScrollState
import io.kdomskia.compose.foundation.verticalScroll
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.util.generateUuid
import kotlinx.browser.document
import org.w3c.dom.HTMLElement

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
    val items: List<@Composable () -> Unit> = remember {
        val items = mutableListOf<@Composable () -> Unit>()
        LazyStaggeredGridScopeImpl(items).content()
        items
    }
    val columnCount = (columns as StaggeredGridCells.Fixed).count
    var assignments by remember { mutableStateOf(IntArray(items.size) { 0 }) }
    val containerId = remember { "lazy-staggered-grid-${generateUuid()}" }

    Row(
        modifier = modifier
            .verticalScroll(
                state = rememberScrollState(),
                domOptions = domScrollOptions
            )
            .padding(contentPadding)
            .domId(containerId),
        horizontalArrangement = horizontalArrangement
    ) {
        for (column in 0 until columnCount) {
            Column(
                modifier = Modifier.weight(1f / columnCount),
                verticalArrangement = Arrangement.spacedBy(verticalItemSpacing)
            ) {
                items.forEachIndexed { index, itemContent ->
                    if (assignments.getOrNull(index) == column) {
                        Box(
                            modifier = Modifier.domId("grid-item-$index")
                        ) {
                            itemContent()
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(items.size, columnCount) {
        assignments = recalcDistribution(items, columnCount)
    }

    DisposableEffect(containerId, columnCount) {
        val container = document.getElementById(containerId)
        val observer = ResizeObserver { _, _ ->
            assignments = recalcDistribution(items, columnCount)
        }
        container?.let {
            observer.observe(container)
        }
        onDispose { observer.disconnect() }
    }
}

private fun recalcDistribution(
    items: List<@Composable () -> Unit>,
    columnCount: Int
): IntArray {
    val heights = DoubleArray(items.size) {
        (document.getElementById("grid-item-$it") as? HTMLElement)
            ?.getBoundingClientRect()?.height ?: 0.0
    }
    val colHeights = DoubleArray(columnCount)
    val assignments = IntArray(items.size)

    for (i in heights.indices) {
        val colMin = colHeights.withIndex().minByOrNull { it.value }!!.index
        assignments[i] = colMin
        colHeights[colMin] += heights[i]
    }

    return assignments
}

private class LazyStaggeredGridScopeImpl(
    val items: MutableList<@Composable () -> Unit>
) : LazyStaggeredGridScope {

    override fun item(content: @Composable () -> Unit) {
        items += content
    }

    override fun items(count: Int, itemContent: @Composable (index: Int) -> Unit) {
        repeat(count) {
            items += {
                itemContent(it)
            }
        }
    }

}