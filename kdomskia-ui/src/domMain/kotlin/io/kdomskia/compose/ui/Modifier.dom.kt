package io.kdomskia.compose.ui

typealias DomModifier = com.varabyte.kobweb.compose.ui.Modifier

actual interface Modifier {

    val dom: DomModifier

    fun unwrap(block: DomModifier.() -> DomModifier): Modifier

    actual infix fun then(other: Modifier): Modifier

    actual companion object : Modifier by ModifierImpl(DomModifier)

}

private class ModifierImpl(
    override val dom: DomModifier
) : Modifier {

    override fun unwrap(block: DomModifier.() -> DomModifier) = ModifierImpl(block(dom))

    override infix fun then(other: Modifier): Modifier = unwrap { dom.then(other.dom) }

}

actual fun Modifier.domOnly(block: Modifier.() -> Modifier) = this then block()

actual fun Modifier.skiaOnly(block: Modifier.() -> Modifier) = this

actual fun Modifier.then(
    dom: Modifier.() -> Modifier,
    skia: Modifier.() -> Modifier
) = this then dom()