package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.foundation.pager.PagerState as SkiaPagerState
import androidx.compose.foundation.pager.rememberPagerState as skiaRememberPagerState

@Stable
actual class PagerState(
    val skia: SkiaPagerState
) {

    actual val currentPage: Int
        get() = skia.currentPage

    actual val pageCount: Int
        get() = skia.pageCount

    actual suspend fun animateScrollToPage(page: Int) {
        skia.animateScrollToPage(page)
    }

}

@Composable
actual fun rememberPagerState(
    initialPage: Int,
    pageCount: () -> Int
): PagerState {
    val skia = skiaRememberPagerState(initialPage = initialPage, pageCount = pageCount)
    return remember(skia) {
        PagerState(skia)
    }
}

actual fun PagerState(currentPage: Int, pageCount: () -> Int) = PagerState(
    SkiaPagerState(
        currentPage = currentPage,
        pageCount = pageCount
    )
)