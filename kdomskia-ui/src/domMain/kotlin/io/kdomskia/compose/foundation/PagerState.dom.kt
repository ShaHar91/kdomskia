package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable

@Stable
actual class PagerState internal constructor(
    currentPage: Int = 0,
    pageCount: () -> Int,
    any: Any //Only to avoid function overload conflict
) {

    private var _currentPageState = mutableStateOf(currentPage)

    private var _pageCountState = mutableStateOf(pageCount)

    private var _transitionDirectionState = mutableStateOf<PagerTransitionDirection?>(null)

    actual val currentPage: Int
        get() = _currentPageState.value

    actual val pageCount: Int
        get() = _pageCountState.value.invoke()

    internal val transitionDirection: PagerTransitionDirection?
        get() = _transitionDirectionState.value

    actual suspend fun animateScrollToPage(
        page: Int
    ) {
        val leavingPage = _currentPageState.value
        _currentPageState.value = page
        _transitionDirectionState.value = if (leavingPage > page)
            PagerTransitionDirection.LeftToRight
        else
            PagerTransitionDirection.RightToLeft
    }

    companion object {

        val Saver: Saver<PagerState, *> = Saver(
            save = {
                listOf(
                    it.currentPage,
                    it.pageCount
                )
            },
            restore = {
                PagerState(
                    currentPage = it[0],
                    pageCount = { it[1] }
                )
            }
        )

    }

}

internal enum class PagerTransitionDirection {

    LeftToRight,

    RightToLeft

}

@Composable
actual fun rememberPagerState(
    initialPage: Int,
    pageCount: () -> Int
): PagerState {
    return rememberSaveable(saver = PagerState.Saver) {
        PagerState(initialPage, pageCount)
    }
}

actual fun PagerState(
    currentPage: Int,
    pageCount: () -> Int
): PagerState {
    return PagerState(
        currentPage = currentPage,
        pageCount = pageCount,
        any = Any()
    )
}