package io.kdomskia.compose.foundation.scroll

import com.varabyte.kobweb.compose.attributes.SyntheticEventListener
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.events.SyntheticEvent
import io.kdomskia.compose.extension.getScroll
import io.kdomskia.compose.extension.htmlElements
import io.kdomskia.compose.extension.jsonParseOrNull
import io.kdomskia.compose.extension.jsonStringifyOrEmpty
import io.kdomskia.compose.extension.overflowProperty
import io.kdomskia.compose.extension.smoothScrollOptions
import io.kdomskia.compose.foundation.ScrollState
import io.kdomskia.compose.foundation.dom.nonExitingElements
import io.kdomskia.compose.foundation.gestures.Orientation
import io.kdomskia.compose.foundation.safeApplyScroll
import io.kdomskia.compose.foundation.scrollNotEquals
import io.kdomskia.compose.internal.attr.KdomskiaDataAttrHolder
import io.kdomskia.compose.internal.attr.get
import io.kdomskia.compose.internal.attr.querySelectorAllWithAttr
import io.kdomskia.compose.internal.dataAttr
import io.kdomskia.compose.ui.DomModifier
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.EventsListenerScope.Companion.SCROLL
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.EventTarget

private val windowVerticalListener = SyntheticEventListener<SyntheticEvent<EventTarget>>(SCROLL) {
    onWindowScroll(Orientation.Vertical)
}

private val windowHorizontalListener = SyntheticEventListener<SyntheticEvent<EventTarget>>(SCROLL) {
    onWindowScroll(Orientation.Horizontal)
}

private val Orientation.windowScrollListener: SyntheticEventListener<SyntheticEvent<EventTarget>>
    get() = when (this) {
        Orientation.Vertical -> windowVerticalListener
        Orientation.Horizontal -> windowHorizontalListener
    }

private val Orientation.windowDataAttr: KdomskiaDataAttrHolder
    get() = when (this) {
        Orientation.Vertical -> ScrollDataAttrs.WindowVerticalData
        Orientation.Horizontal -> ScrollDataAttrs.WindowHorizontalData
    }

private fun handleWindowScroll(orientation: Orientation) {
    val attr = orientation.windowDataAttr
    val listener = orientation.windowScrollListener
    val overflowProperty = orientation.overflowProperty
    val element = document
        .querySelectorAllWithAttr(attr)
        .htmlElements()
        .nonExitingElements()
        .firstOrNull()
    val data = element?.dataset?.get(attr).jsonParseOrNull()

    if (element == null || data == null) {
        window.removeEventListener(SCROLL, listener)
        return
    }

    (document.documentElement as? HTMLElement)?.style?.setProperty("height", "unset")
    document.body?.style?.setProperty("height", "unset")

    window.addEventListener(SCROLL, listener)

    val htmlElement = document.documentElement as? HTMLElement ?: return
    val currentOverflow = window.getComputedStyle(htmlElement).getPropertyValue(overflowProperty)
    val newOverflow = data.overflow

    if (currentOverflow != newOverflow) {
        htmlElement.style.setProperty(overflowProperty, newOverflow)
    }

    htmlElement.safeApplyScroll(orientation, data.value)
}

internal fun handleWindowScroll() {
    handleWindowScroll(Orientation.Vertical)
    handleWindowScroll(Orientation.Horizontal)
}

private fun onWindowScroll(orientation: Orientation) {
    val element = document
        .querySelectorAllWithAttr(orientation.windowDataAttr)
        .htmlElements()
        .nonExitingElements()
        .firstOrNull()
    val state: ScrollState? = document.documentElement.asDynamic().kdomskiaScrollState
    val documentElement = document.documentElement

    if (element != null && state != null && documentElement != null) {
        val newScroll = documentElement.getScroll(orientation)
        val currentScroll = state.doubleValue

        if (newScroll.scrollNotEquals(currentScroll)) {
            state.updateValue(newScroll)
        }
    }
}

internal fun DomModifier.windowScroll(
    state: ScrollState,
    orientation: Orientation,
    overflow: Overflow
): DomModifier {
    val scrollData = ScrollData(
        value = state.doubleValue,
        overflow = overflow.toString()
    )

    state.onUpdateSmoothScrollTo = {
        document.documentElement?.scrollTo(
            orientation.smoothScrollOptions(it.value.toDouble())
        )
    }

    document.documentElement.asDynamic()?.kdomskiaScrollState = state

    return dataAttr(orientation.windowDataAttr, scrollData.jsonStringifyOrEmpty())
}