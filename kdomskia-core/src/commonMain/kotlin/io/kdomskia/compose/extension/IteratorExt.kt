package io.kdomskia.compose.extension

fun <T> Iterator<T>.nextOrNull(): T? {
    return if (hasNext())
        next()
    else
        null
}