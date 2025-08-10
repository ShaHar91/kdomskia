package io.kdomskia.compose.foundation.dom

import io.kdomskia.compose.extension.allParents
import io.kdomskia.compose.internal.attr.KdomskiaDataAttr
import io.kdomskia.compose.internal.attr.get
import io.kdomskia.compose.internal.dataAttr
import io.kdomskia.compose.ui.DomModifier
import org.w3c.dom.HTMLElement

val exitingDataAttr = KdomskiaDataAttr(
    namespace = "elementState",
    property = "exiting"
)

val HTMLElement.isExiting: Boolean
    get() = dataset.get(exitingDataAttr) == true.toString()

fun DomModifier.exiting() = dataAttr(exitingDataAttr, true.toString())

var HTMLElement.isApplyingScroll: Boolean
    get() = (this.asDynamic().dynamicIsApplyingScroll as? Boolean) ?: false
    set(value) {
        this.asDynamic().dynamicIsApplyingScroll = value
    }

fun List<HTMLElement>.nonExitingElements(): List<HTMLElement> = filter {
    it.isExiting.not() && it.allParents.all { parent ->
        parent.isExiting.not()
    }
}