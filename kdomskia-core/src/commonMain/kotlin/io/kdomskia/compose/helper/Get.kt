package io.kdomskia.compose.helper

expect fun <T> get(
    dom: () -> T,
    skia: () -> T
): T