package io.kdomskia.compose.helper

actual fun <T> get(
    dom: () -> T,
    skia: () -> T
) = dom()