package io.kdomskia.compose.extension

import com.varabyte.kobweb.compose.css.StyleVariable
import io.kdomskia.compose.css.TypeSafeClass
import io.kdomskia.compose.css.Variable
import io.kdomskia.compose.css.toMs
import io.kdomskia.compose.foundation.gestures.Orientation
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

internal fun Element.getScroll(orientation: Orientation): Double {
    return when (orientation) {
        Orientation.Vertical -> scrollTop
        Orientation.Horizontal -> scrollLeft
    }
}

internal fun Element.setScroll(orientation: Orientation, value: Double) {
    when (orientation) {
        Orientation.Vertical -> {
            scrollTop = value
        }

        Orientation.Horizontal -> {
            scrollLeft = value
        }
    }
}

val Element?.parentHtmlElement: HTMLElement?
    get() = this?.parentElement as? HTMLElement

fun Element.query(typeSafeClass: TypeSafeClass): Element? = querySelector("." + typeSafeClass.className)

suspend fun Element.await(timeVariable: StyleVariable<*, *>) {
    window
        .getComputedStyle(this)
        .getPropertyValue(timeVariable.nameWithPrefix)
        .toMs()
        ?.let { delay(it) }
}

suspend fun Element.awaitSpeed2() = await(Variable.speed2)