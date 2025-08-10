package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Modifier

@Composable
expect fun HorizontalPager(
    state: PagerState,
    modifier: Modifier = Modifier,
    pageContent: @Composable PagerScope.(page: Int) -> Unit
)

object PagerScope