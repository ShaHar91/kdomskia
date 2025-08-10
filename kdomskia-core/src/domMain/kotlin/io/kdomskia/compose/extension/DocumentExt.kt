package io.kdomskia.compose.extension

import org.w3c.dom.Document
import org.w3c.dom.HTMLElement

val Document.bodyOrThrow: HTMLElement
    get() = this.body ?: throw IllegalStateException("Document body is not set.")

fun Document.onDomContentLoaded(block: () -> Unit) {
    var called = false
    addEventListener(
        type = "DOMContentLoaded",
        callback = {
            if (called.not()) {
                called = true
                block()
            }
        }
    )
}