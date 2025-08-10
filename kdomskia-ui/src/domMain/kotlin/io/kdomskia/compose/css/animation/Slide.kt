package io.kdomskia.compose.css.animation

import androidx.compose.runtime.Stable
import io.kdomskia.compose.css.TypeSafeClass
import io.kdomskia.compose.extension.awaitSpeed2
import io.kdomskia.compose.foundation.addClass
import io.kdomskia.compose.foundation.removeClass
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.ui.DomModifier
import org.w3c.dom.Element

sealed interface Slide : TypeSafeClass {

    companion object {

        val entries: List<TypeSafeClass> = SlideLeftToRight.entries + SlideRightToLeft.entries

    }

}

enum class SlideLeftToRight(
    override val className: String
) : Slide {

    In("slide-left-right-in"),

    Out("slide-left-right-out")

}

enum class SlideRightToLeft(
    override val className: String
) : Slide {

    In("slide-right-left-in"),

    Out("slide-right-left-out")

}

@Stable
fun DomModifier.slide(
    direction: Slide
) = typeSafeClasses(direction)

fun Element.slide(
    direction: Slide
) {
    removeClass(*Slide.entries.toTypedArray())
    addClass(direction)
}

suspend fun Element.slideAwaitingCompletion(
    direction: Slide
) {
    slide(direction)
    awaitSpeed2()
}

fun Slide.reverse(): Slide = when (this) {
    SlideLeftToRight.In -> SlideLeftToRight.Out
    SlideLeftToRight.Out -> SlideLeftToRight.In
    SlideRightToLeft.In -> SlideRightToLeft.Out
    SlideRightToLeft.Out -> SlideRightToLeft.In
}