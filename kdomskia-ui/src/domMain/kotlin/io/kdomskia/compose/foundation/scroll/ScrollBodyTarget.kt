package io.kdomskia.compose.foundation.scroll

import com.varabyte.kobweb.compose.attributes.SyntheticEventListener
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.events.SyntheticEvent
import io.kdomskia.compose.extension.getScroll
import io.kdomskia.compose.extension.hasChildren
import io.kdomskia.compose.extension.htmlElements
import io.kdomskia.compose.extension.jsonParseOrNull
import io.kdomskia.compose.extension.jsonStringifyOrEmpty
import io.kdomskia.compose.extension.overflowProperty
import io.kdomskia.compose.extension.setScroll
import io.kdomskia.compose.extension.smoothScrollOptions
import io.kdomskia.compose.foundation.ScrollState
import io.kdomskia.compose.foundation.gestures.Orientation
import io.kdomskia.compose.foundation.safeApplyScroll
import io.kdomskia.compose.foundation.scrollNotEquals
import io.kdomskia.compose.internal.attr.KdomskiaDataAttr
import io.kdomskia.compose.internal.attr.KdomskiaDataAttrHolder
import io.kdomskia.compose.internal.attr.get
import io.kdomskia.compose.internal.attr.querySelectorAllWithAttr
import io.kdomskia.compose.internal.attr.set
import io.kdomskia.compose.internal.dataAttr
import io.kdomskia.compose.ui.DomModifier
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.EventsListenerScope.Companion.SCROLL
import org.w3c.dom.asList
import org.w3c.dom.events.EventTarget

private val bodyVerticalListener = SyntheticEventListener<SyntheticEvent<EventTarget>>(SCROLL) {
    onBodyScroll(Orientation.Vertical)
}

private val bodyHorizontalListener = SyntheticEventListener<SyntheticEvent<EventTarget>>(SCROLL) {
    onBodyScroll(Orientation.Horizontal)
}

private val Orientation.bodyScrollListener: SyntheticEventListener<SyntheticEvent<EventTarget>>
    get() = when (this) {
        Orientation.Vertical -> bodyVerticalListener
        Orientation.Horizontal -> bodyHorizontalListener
    }

private val Orientation.bodyDataAttr: KdomskiaDataAttrHolder
    get() = when (this) {
        Orientation.Vertical -> ScrollDataAttrs.BodyVerticalData
        Orientation.Horizontal -> ScrollDataAttrs.BodyHorizontalData
    }

private val Orientation.bodyEnabledDataAttr: KdomskiaDataAttr
    get() = when (this) {
        Orientation.Vertical -> BodyVerticalScrollEnabledDataAttr
        Orientation.Horizontal -> BodyHorizontalScrollEnabledDataAttr
    }

private fun handleBodyScroll(orientation: Orientation) {
    val attr = orientation.bodyDataAttr
    val enabledAttr = orientation.bodyEnabledDataAttr
    val listener = orientation.bodyScrollListener
    val overflowProperty = orientation.overflowProperty
    val element = document.querySelectorAllWithAttr(attr).htmlElements().firstOrNull()
    val data = element?.dataset?.get(attr).jsonParseOrNull()
    val body = document.body ?: return

    if (element == null || data == null) {
        body.dataset.set(enabledAttr, false.toString())
        body.removeEventListener(SCROLL, listener)
        return
    }

    body.dataset.set(enabledAttr, true.toString())
    body.addEventListener(SCROLL, listener)

    val currentOverflow = window.getComputedStyle(body).getPropertyValue(overflowProperty)
    val newOverflow = data.overflow

    if (currentOverflow != newOverflow) {
        body.style.setProperty(overflowProperty, newOverflow)
    }

    if (body.hasChildren()) {
        val currentScroll = body.getScroll(orientation)
        val newScroll: Double = data.value

        if (newScroll.scrollNotEquals(currentScroll)) {
            body.setScroll(orientation, newScroll)
        }
    }
}

internal fun handleBodyScroll() {
    handleBodyScroll(Orientation.Vertical)
    handleBodyScroll(Orientation.Horizontal)
}

private fun onBodyScroll(orientation: Orientation) {
    val body = document.body ?: return
    val element = document.querySelectorAllWithAttr(orientation.bodyDataAttr).asList().firstOrNull()
    val state: ScrollState? = body.asDynamic().kdomskiaScrollState

    if (element != null && state != null) {
        body.safeApplyScroll(orientation, state.doubleValue)
    }
}

internal fun DomModifier.bodyScroll(
    state: ScrollState,
    orientation: Orientation,
    overflow: Overflow
): DomModifier {
    val scrollData = ScrollData(
        value = state.doubleValue,
        overflow = overflow.toString()
    )

    state.onUpdateSmoothScrollTo = {
        document.body?.scrollTo(
            orientation.smoothScrollOptions(it.value.toDouble())
        )
    }

    document.body?.asDynamic()?.kdomskiaScrollState = state

    return dataAttr(orientation.bodyDataAttr, scrollData.jsonStringifyOrEmpty())
}