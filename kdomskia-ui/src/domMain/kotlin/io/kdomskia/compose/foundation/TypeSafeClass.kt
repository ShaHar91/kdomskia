package io.kdomskia.compose.foundation

import com.varabyte.kobweb.compose.ui.modifiers.classNames
import io.kdomskia.compose.css.TypeSafeClass
import io.kdomskia.compose.ui.DomModifier
import kotlinx.dom.addClass
import kotlinx.dom.removeClass
import org.w3c.dom.Element

fun DomModifier.typeSafeClasses(
    classes: List<TypeSafeClass>
): DomModifier = classNames(
    classes.map { it.className }
)

fun DomModifier.typeSafeClasses(
    vararg classes: TypeSafeClass
): DomModifier = typeSafeClasses(classes.toList())

fun Element.addClass(vararg typeSafeClasses: TypeSafeClass) {
    addClass(*typeSafeClasses.map { it.className }.toTypedArray())
}

fun Element.removeClass(vararg typeSafeClasses: TypeSafeClass) {
    removeClass(*typeSafeClasses.map { it.className }.toTypedArray())
}