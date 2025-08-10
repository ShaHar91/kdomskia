package io.kdomskia.compose.helper

actual fun domOnly(block: () -> Unit) {
}

actual fun skiaOnly(block: () -> Unit) {
    block()
}