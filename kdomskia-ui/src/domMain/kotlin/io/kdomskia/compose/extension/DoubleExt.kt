package io.kdomskia.compose.extension

import kotlin.math.abs

fun Double.equalsDelta(other: Double, delta: Double): Boolean {
    return abs(this - other) < delta
}