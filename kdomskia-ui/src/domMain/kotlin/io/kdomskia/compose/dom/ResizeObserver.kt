package io.kdomskia.compose.dom

import kotlin.js.Json
import org.w3c.dom.DOMRectReadOnly
import org.w3c.dom.Element

external class ResizeObserverSize {

    val blockSize: Double
    val inlineSize: Double

}

external class ResizeObserverEntry {

    val borderBoxSize: Array<ResizeObserverSize>
    val contentBoxSize: Array<ResizeObserverSize>
    val contentRect: DOMRectReadOnly
    val devicePixelContentBoxSize: Array<ResizeObserverSize>
    val target: Element

}

external class ResizeObserver(
    callback: (Array<ResizeObserverEntry>, ResizeObserver) -> Unit
) {

    fun observe(element: Element, options: Json = definedExternally)
    fun unobserve(element: Element)
    fun disconnect()

}