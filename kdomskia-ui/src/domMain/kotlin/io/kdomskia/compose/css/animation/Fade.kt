package io.kdomskia.compose.css.animation

import androidx.compose.runtime.Stable
import io.kdomskia.compose.css.TypeSafeClass
import io.kdomskia.compose.extension.awaitSpeed2
import io.kdomskia.compose.foundation.addClass
import io.kdomskia.compose.foundation.removeClass
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.ui.DomModifier
import org.w3c.dom.Element

enum class FadeTarget(
    override val className: String
) : TypeSafeClass {

    In("fade-in"),

    Out("fade-out")

}

fun FadeTarget.reverse() = when (this) {
    FadeTarget.In -> FadeTarget.Out
    FadeTarget.Out -> FadeTarget.In
}

@Stable
fun DomModifier.fade(
    target: FadeTarget
) = typeSafeClasses(target)

fun Element.fade(
    target: FadeTarget
) {
    addClass(target)
    removeClass(target.reverse())
}

fun Element.fadeIn() {
    fade(FadeTarget.In)
}

fun Element.fadeOut() {
    fade(FadeTarget.Out)
}

suspend fun Element.fadeAwaitingCompletion(
    target: FadeTarget
) {
    fade(target)
    awaitSpeed2()
}