package io.kdomskia.compose.foundation

import io.kdomskia.compose.extension.equalsDelta
import io.kdomskia.compose.extension.getScroll
import io.kdomskia.compose.extension.hasChildren
import io.kdomskia.compose.extension.runAtFrame
import io.kdomskia.compose.extension.setScroll
import io.kdomskia.compose.foundation.dom.DomScrollOptions
import io.kdomskia.compose.foundation.dom.DomScrollTarget
import io.kdomskia.compose.foundation.dom.isApplyingScroll
import io.kdomskia.compose.foundation.gestures.Orientation
import io.kdomskia.compose.foundation.scroll.ScrollDataAttrs
import io.kdomskia.compose.foundation.scroll.bodyScroll
import io.kdomskia.compose.foundation.scroll.elementScroll
import io.kdomskia.compose.foundation.scroll.handleBodyScroll
import io.kdomskia.compose.foundation.scroll.handleElementScroll
import io.kdomskia.compose.foundation.scroll.handleWindowScroll
import io.kdomskia.compose.foundation.scroll.windowScroll
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.thenIf
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement
import org.w3c.dom.MutationObserver
import org.w3c.dom.MutationObserverInit

private const val SCROLL_DELTA = 0.5

internal fun addScrollObserver() {
    MutationObserver { _, _ ->
        handleScrollChanges()
    }.observe(
        target = document,
        options = MutationObserverInit(
            subtree = true,
            childList = true,
            attributes = true,
            attributeFilter = ScrollDataAttrs.attrNames()
        )
    )
}

private fun handleScrollChanges() {
    handleWindowScroll()
    handleBodyScroll()
    handleElementScroll()
}

internal fun Double.scrollNotEquals(other: Double): Boolean {
    return equalsDelta(other = other, delta = SCROLL_DELTA).not()
}

internal fun Modifier.scroll(
    state: ScrollState,
    orientation: Orientation,
    domOptions: DomScrollOptions,
    enabled: Boolean
): Modifier = thenIf(enabled) {
    unwrap {
        when (domOptions.target) {
            DomScrollTarget.Window -> {
                windowScroll(
                    state = state,
                    orientation = orientation,
                    overflow = domOptions.overflow.dom
                )
            }

            DomScrollTarget.Body -> {
                bodyScroll(
                    state = state,
                    orientation = orientation,
                    overflow = domOptions.overflow.dom
                )
            }

            DomScrollTarget.Element -> {
                elementScroll(
                    state = state,
                    orientation = orientation,
                    overflow = domOptions.overflow.dom,
                    enabled = enabled
                )
            }
        }
    }
}

fun HTMLElement.safeApplyScroll(orientation: Orientation, scroll: Double) {
    if (document.body.hasChildren()) {
        val currentScroll = this.getScroll(orientation)

        if (scroll.scrollNotEquals(currentScroll)) {
            if (isApplyingScroll.not()) {
                isApplyingScroll = true
                window.runAtFrame(
                    count = 5
                ) {
                    setScroll(orientation, scroll)
                    isApplyingScroll = false
                }
            }
        }
    }
}