package io.kdomskia.compose.ui

typealias SkiaModifier = androidx.compose.ui.Modifier

actual interface Modifier {

    val skia: SkiaModifier

    fun unwrap(block: SkiaModifier.() -> SkiaModifier): Modifier

    actual infix fun then(other: Modifier): Modifier

    actual companion object : Modifier by ModifierImpl(SkiaModifier)

}

private class ModifierImpl(
    override val skia: SkiaModifier
) : Modifier {

    override fun unwrap(block: SkiaModifier.() -> SkiaModifier) = ModifierImpl(block(skia))

    override infix fun then(other: Modifier) = unwrap { skia.then(other.skia) }

}

actual fun Modifier.domOnly(block: Modifier.() -> Modifier) = this

actual fun Modifier.skiaOnly(block: Modifier.() -> Modifier) = this then block()

actual fun Modifier.then(
    dom: Modifier.() -> Modifier,
    skia: Modifier.() -> Modifier
) = this then skia()