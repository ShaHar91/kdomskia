package io.kdomskia.compose.ui.draw

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Shape
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import io.kdomskia.compose.dom.ResizeObserver
import io.kdomskia.compose.extension.htmlElements
import io.kdomskia.compose.extension.nextOrNull
import io.kdomskia.compose.foundation.shape.CornerBasedShape
import io.kdomskia.compose.foundation.shape.commonSkia
import io.kdomskia.compose.foundation.shape.dom
import io.kdomskia.compose.internal.attr.KdomskiaDataAttr
import io.kdomskia.compose.internal.attr.get
import io.kdomskia.compose.internal.attr.querySelectorAllWithAttr
import io.kdomskia.compose.internal.dataAttr
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import kotlin.math.max
import kotlin.math.min
import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import org.w3c.dom.MutationObserver
import org.w3c.dom.MutationObserverInit
import androidx.compose.foundation.shape.CornerBasedShape as SkiaCornerBasedShape

private val attr = KdomskiaDataAttr("clipShape", "borderRadius")

private val resizeObserver = ResizeObserver { entries, observer ->
    entries.forEach { element ->
        (element.target as? HTMLElement)?.updateBorderRadius()
    }
}

internal fun addClipObserver() {
    MutationObserver { _, _ ->
        handleClip()
    }.observe(
        target = document,
        options = MutationObserverInit(
            subtree = true,
            childList = true,
            attributes = true
        )
    )
}

private fun handleClip() {
    document
        .querySelectorAllWithAttr(attr)
        .htmlElements()
        .forEach { it.updateBorderRadius() }
}

private fun HTMLElement.updateBorderRadius() {
    resizeObserver.observe(this)

    val element = this
    val cornerSizes = element.dataset.get(attr).orEmpty().split(" ")

    if (cornerSizes.isEmpty()) return

    val iterator = cornerSizes.iterator()
    val style = element.style

    val values = listOf(
        element.compute(iterator.nextOrNull().orEmpty()),
        element.compute(iterator.nextOrNull().orEmpty()),
        element.compute(iterator.nextOrNull().orEmpty()),
        element.compute(iterator.nextOrNull().orEmpty())
    )

    val horizontal = values.joinToString(separator = " ") { it.second }
    val vertical = values.joinToString(separator = " ") { it.first }

    style.setProperty("border-radius", "$vertical / $horizontal", "important")
}

private fun Element.compute(value: String): Pair<String, String> {
    if (value.contains("px")) return value to value

    val percentage = value.replace("%", "").toFloatOrNull() ?: 0f

    if (percentage == 0f) return "0%" to "0%"

    val dynamicElement = this.asDynamic()
    val width = ((dynamicElement.offsetWidth as? Int) ?: 0).toFloat()
    val height = ((dynamicElement.offsetHeight as? Int) ?: 0).toFloat()

    if (width == 0f || height == 0f) return "0%" to "0%"

    val higherDimension = max(width, height)
    val smallerDimension = min(width, height)
    val ratio = smallerDimension / higherDimension
    val computed = percentage * ratio
    val isWider = width > height

    return if (isWider)
        "$computed%" to "$percentage%"
    else
        "$percentage%" to "$computed%"
}

private val Shape.cornerSizes: String
    get() = when (this) {
        is CornerBasedShape -> {
            "${commonSkia.topStart.dom} ${commonSkia.topEnd.dom} ${commonSkia.bottomEnd.dom} ${commonSkia.bottomStart.dom}"
        }

        is SkiaCornerBasedShape -> {
            "${topStart.dom} ${topEnd.dom} ${bottomEnd.dom} ${bottomStart.dom}"
        }

        else -> fallback
    }

private val fallback = "0px 0px 0px 0px"

@Stable
actual fun Modifier.clipToBounds() = unwrap { overflow(Overflow.Hidden) }

@Stable
actual fun Modifier.clip(shape: Shape) = unwrap { clip(shape) }

@Stable
fun DomModifier.clip(shape: Shape): DomModifier {
    return dataAttr(attr, shape.cornerSizes)
        .overflow(Overflow.Hidden)
}