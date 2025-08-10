package io.kdomskia.compose.ui

expect interface Modifier {

    infix fun then(other: Modifier): Modifier

    companion object : Modifier {

        override infix fun then(other: Modifier): Modifier

    }

}

expect fun Modifier.domOnly(block: Modifier.() -> Modifier): Modifier

expect fun Modifier.skiaOnly(block: Modifier.() -> Modifier): Modifier

expect fun Modifier.then(
    dom: Modifier.() -> Modifier,
    skia: Modifier.() -> Modifier
): Modifier

// Providing Kobweb Modifier utilities, taken from:
// https://github.com/varabyte/kobweb/blob/main/frontend/kobweb-compose/src/jsMain/kotlin/com/varabyte/kobweb/compose/ui/Modifier.kt

fun Modifier.thenIf(condition: Boolean, other: Modifier): Modifier {
    return this.thenIf(condition) { other }
}

fun Modifier.thenUnless(condition: Boolean, other: Modifier): Modifier {
    return this.thenUnless(condition) { other }
}

inline fun Modifier.thenIf(condition: Boolean, lazyProduce: () -> Modifier): Modifier {
    return this.then(if (condition) lazyProduce() else Modifier)
}

inline fun <T> Modifier.thenIfNotNull(value: T?, consume: (T) -> Modifier): Modifier {
    return this.thenIf(value != null) { consume(value!!) }
}

inline fun Modifier.thenUnless(condition: Boolean, lazyProduce: () -> Modifier): Modifier {
    return this.thenIf(!condition, lazyProduce)
}