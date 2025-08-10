package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
expect class PagerState {

    val currentPage: Int

    val pageCount: Int

    suspend fun animateScrollToPage(
        page: Int
    )

}

@Composable
expect fun rememberPagerState(
    initialPage: Int = 0,
    pageCount: () -> Int
): PagerState

expect fun PagerState(
    currentPage: Int = 0,
    pageCount: () -> Int,
): PagerState