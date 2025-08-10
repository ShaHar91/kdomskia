package io.kdomskia.compose.ui.layout

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.IntSize
import androidx.compose.web.events.SyntheticEvent
import com.varabyte.kobweb.compose.ui.attrsModifier
import io.kdomskia.compose.dom.ResizeObserver
import io.kdomskia.compose.extension.htmlElements
import io.kdomskia.compose.internal.attr.KdomskiaDataAttr
import io.kdomskia.compose.internal.attr.fullAttrName
import io.kdomskia.compose.internal.attr.get
import io.kdomskia.compose.internal.attr.querySelectorAllWithAttr
import io.kdomskia.compose.internal.attr.set
import io.kdomskia.compose.internal.dataAttr
import io.kdomskia.compose.ui.Modifier
import kotlinx.browser.document
import org.w3c.dom.CustomEvent
import org.w3c.dom.CustomEventInit
import org.w3c.dom.HTMLElement
import org.w3c.dom.MutationObserver
import org.w3c.dom.MutationObserverInit

@Stable
actual fun Modifier.onGloballyPositioned(
    onGloballyPositioned: (LayoutCoordinates) -> Unit
) = unwrap {
    dataAttr(enabledAttr, true.toString())
        .attrsModifier {
            addEventListener<SyntheticEvent<HTMLElement>>(
                eventName = eventName,
                listener = {
                    (it.nativeEvent as? CustomEvent)?.let { event ->
                        onGloballyPositioned(
                            LayoutCoordinatesImpl(
                                event.detail.unsafeCast<IntSize>()
                            )
                        )
                    }
                }
            )
        }
}

private const val eventName = "onGloballyPositioned"

private val enabledAttr = KdomskiaDataAttr("onGloballyPositioned", "enabled")

private val initializedAttr = KdomskiaDataAttr("onGloballyPositioned", "initialized")

internal fun addGlobalLayoutPositionedObserver() {
    MutationObserver { _, _ ->
        handleGlobalLayoutPositioned()
    }.observe(
        target = document,
        options = MutationObserverInit(
            subtree = true,
            childList = true,
            attributes = true,
            attributeFilter = arrayOf(enabledAttr.fullAttrName)
        )
    )
}

private fun handleGlobalLayoutPositioned() {
    document
        .querySelectorAllWithAttr(enabledAttr)
        .htmlElements()
        .forEach { it.setOnGlobalLayoutPositioned() }
}

private fun HTMLElement.setOnGlobalLayoutPositioned() {
    if (initialized) return

    dispatchEvent(this.toEvent())

    val resizeObserver = ResizeObserver { entries, observer ->
        entries.forEach {
            (it.target as? HTMLElement)?.let { resizedElement ->
                dispatchEvent(resizedElement.toEvent())
            }
        }
    }

    resizeObserver.observe(this)

    initialized = true
}

private var HTMLElement.initialized: Boolean
    set(value) {
        dataset.set(initializedAttr, value.toString())
    }
    get() = dataset.get(initializedAttr) == true.toString()

private fun HTMLElement.toEvent() = CustomEvent(
    type = eventName,
    eventInitDict = CustomEventInit(
        detail = IntSize(
            width = offsetWidth,
            height = offsetHeight
        )
    )
)