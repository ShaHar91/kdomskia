package io.kdomskia.compose.extension

import org.w3c.dom.Window

fun Window.runAtFrame(
    count: Int,
    callback: () -> Unit
) {
    var frame = 0

    fun step() {
        if (frame >= count) {
            callback()
        } else {
            frame++
            requestAnimationFrame { step() }
        }
    }

    requestAnimationFrame { step() }
}