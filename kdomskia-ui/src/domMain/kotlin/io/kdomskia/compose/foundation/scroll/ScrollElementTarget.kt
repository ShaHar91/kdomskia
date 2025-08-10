package io.kdomskia.compose.foundation.scroll

import androidx.compose.web.events.SyntheticEvent
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.styleModifier
import io.kdomskia.compose.extension.getScroll
import io.kdomskia.compose.extension.htmlElements
import io.kdomskia.compose.extension.jsonParseOrNull
import io.kdomskia.compose.extension.jsonStringifyOrEmpty
import io.kdomskia.compose.extension.overflowProperty
import io.kdomskia.compose.extension.smoothScrollOptions
import io.kdomskia.compose.extension.withChildren
import io.kdomskia.compose.foundation.ScrollState
import io.kdomskia.compose.foundation.gestures.Orientation
import io.kdomskia.compose.foundation.safeApplyScroll
import io.kdomskia.compose.internal.attr.KdomskiaDataAttrHolder
import io.kdomskia.compose.internal.attr.get
import io.kdomskia.compose.internal.attr.querySelectorAllWithAttr
import io.kdomskia.compose.internal.dataAttr
import io.kdomskia.compose.ui.DomModifier
import kotlinx.browser.document
import org.jetbrains.compose.web.attributes.EventsListenerScope.Companion.SCROLL
import org.w3c.dom.HTMLElement

private val processedUuids = mutableListOf<String>()

private val Orientation.elementValueAttr: KdomskiaDataAttrHolder
    get() = when (this) {
        Orientation.Vertical -> ScrollDataAttrs.ElementVerticalValue
        Orientation.Horizontal -> ScrollDataAttrs.ElementHorizontalValue
    }

private val Orientation.elementSmoothToAttr: KdomskiaDataAttrHolder
    get() = when (this) {
        Orientation.Vertical -> ScrollDataAttrs.ElementVerticalSmoothTo
        Orientation.Horizontal -> ScrollDataAttrs.ElementHorizontalSmoothTo
    }

internal fun handleElementScroll() {
    handleElementScroll(Orientation.Vertical)
    handleElementScroll(Orientation.Horizontal)
}

private fun handleElementScroll(orientation: Orientation) {
    handleElementScrollValue(orientation)
    handleElementScrollSmoothTo(orientation)
}

private fun handleElementScrollValue(orientation: Orientation) {
    val attr = orientation.elementValueAttr

    document
        .querySelectorAllWithAttr(attr)
        .htmlElements()
        .withChildren()
        .forEach { element ->
            element.dataset.get(attr)?.toDoubleOrNull()?.let { scroll ->
                element.safeApplyScroll(orientation, scroll)
            }
        }
}

private fun handleElementScrollSmoothTo(orientation: Orientation) {
    val attr = orientation.elementSmoothToAttr

    document
        .querySelectorAllWithAttr(attr)
        .htmlElements()
        .forEach { element ->
            val smoothTo = element.dataset.get(attr).jsonParseOrNull()

            if (smoothTo != null) {
                val currentUuid: String = smoothTo.uuid

                if (currentUuid !in processedUuids) {
                    processedUuids.add(currentUuid)

                    val intValue: Int = smoothTo.value
                    element.scrollTo(orientation.smoothScrollOptions(intValue.toDouble()))
                }
            }
        }
}

internal fun DomModifier.elementScroll(
    state: ScrollState,
    orientation: Orientation,
    overflow: Overflow,
    enabled: Boolean
): DomModifier = styleModifier { property(orientation.overflowProperty, overflow) }
    .dataAttr(orientation.elementValueAttr, state.doubleValue.toString())
    .dataAttr(orientation.elementSmoothToAttr, state.smoothScrollTo.jsonStringifyOrEmpty())
    .onElementScroll(orientation) { newValue ->
        if (enabled) {
            val currentValue = state.doubleValue

            if (newValue != currentValue) {
                state.updateValue(newValue)
            }
        }
    }

private fun DomModifier.onElementScroll(
    orientation: Orientation,
    listener: (Double) -> Unit
): DomModifier = attrsModifier {
    addEventListener<SyntheticEvent<HTMLElement>>(
        eventName = SCROLL,
        listener = { listener(it.target.getScroll(orientation)) }
    )
}