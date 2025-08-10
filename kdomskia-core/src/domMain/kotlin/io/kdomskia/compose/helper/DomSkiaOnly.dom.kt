package io.kdomskia.compose.helper

actual fun domOnly(block: () -> Unit) {
    block()
}

actual fun skiaOnly(block: () -> Unit) {
}