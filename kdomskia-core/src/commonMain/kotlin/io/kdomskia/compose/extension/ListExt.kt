package io.kdomskia.compose.extension

fun <T> List<T>.addIf(predicate: Boolean, element: T): List<T> = if (predicate) this + element else this