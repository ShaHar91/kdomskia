package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
import io.kdomskia.annotation.InternalKdomskiaApi
import io.kdomskia.compose.css.animation.SlideLeftToRight
import io.kdomskia.compose.css.animation.SlideRightToLeft
import io.kdomskia.compose.css.animation.slide
import io.kdomskia.compose.extension.awaitSpeed2
import io.kdomskia.compose.foundation.dom.exiting
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.util.generateUuid
import kotlinx.browser.document
import kotlinx.coroutines.launch
import com.varabyte.kobweb.compose.foundation.layout.Box as DomBox

@OptIn(InternalKdomskiaApi::class)
@Composable
actual fun HorizontalPager(
    state: PagerState,
    modifier: Modifier,
    pageContent: @Composable PagerScope.(page: Int) -> Unit
) {
    val stateHolder = rememberSaveableStateHolder()
    val scope = rememberCoroutineScope()
    val pageCount = remember(state.pageCount) {
        state.pageCount
    }
    val exitingContainerId = remember { "horizontal-pager-exiting-${generateUuid()}" }
    var exitingIndex by remember {
        mutableStateOf<Int?>(null)
    }
    var lastIndex by remember {
        mutableStateOf(-1)
    }
    val currentIndex = remember(state.currentPage, lastIndex) {
        if (lastIndex !in listOf(-1, state.currentPage)) {
            exitingIndex = lastIndex
        }
        lastIndex = state.currentPage
        state.currentPage
    }

    LaunchedEffect(exitingIndex) {
        if (exitingIndex != null) {
            val element = document.getElementById(exitingContainerId)

            if (element == null) {
                exitingIndex = null
            } else {
                scope.launch {
                    element.awaitSpeed2()
                    exitingIndex = null
                }
            }
        }
    }

    for (index in 0 until pageCount) {
        if (index in listOf(currentIndex, exitingIndex)) {
            val isExiting = index == exitingIndex
            stateHolder.SaveableStateProvider(index) {
                DomBox(
                    modifier = modifier
                        .dom
                        .slide(
                            itemIndex = index,
                            currentIndex = currentIndex,
                            exitingIndex = exitingIndex
                        )
                        .thenIf(isExiting) {
                            DomModifier
                                .id(exitingContainerId)
                                .exiting()
                        }
                ) {
                    PagerScope.pageContent(index)
                }
            }
        }
    }
}

private fun DomModifier.slide(
    itemIndex: Int,
    currentIndex: Int,
    exitingIndex: Int?
): DomModifier {
    if (exitingIndex == null) return this

    return when (itemIndex) {
        currentIndex -> {
            this.slide(
                if (currentIndex > exitingIndex)
                    SlideRightToLeft.In
                else
                    SlideLeftToRight.In
            )
        }

        exitingIndex -> {
            this.slide(
                if (exitingIndex > currentIndex)
                    SlideLeftToRight.Out
                else
                    SlideRightToLeft.Out
            )
        }

        else -> {
            this
        }
    }
}