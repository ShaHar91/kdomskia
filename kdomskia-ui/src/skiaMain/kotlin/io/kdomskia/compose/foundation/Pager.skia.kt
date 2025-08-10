package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.pager.HorizontalPager as SkiaHorizontalPager

@Composable
actual fun HorizontalPager(
    state: PagerState,
    modifier: Modifier,
    pageContent: @Composable PagerScope.(page: Int) -> Unit
) {
    SkiaHorizontalPager(
        state = state.skia,
        modifier = modifier.skia,
        pageContent = { PagerScope.pageContent(it) }
    )
}