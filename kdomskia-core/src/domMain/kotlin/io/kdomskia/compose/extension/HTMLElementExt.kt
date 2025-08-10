package io.kdomskia.compose.extension

import org.w3c.dom.HTMLElement

fun HTMLElement?.hasChildren(): Boolean = (this?.childElementCount ?: 0) > 0

fun List<HTMLElement>.withChildren(): List<HTMLElement> = filter { it.hasChildren() }

val HTMLElement.allParents: List<HTMLElement>
    get() {
        val parents = mutableListOf<HTMLElement>()
        var current = parentElement
        while (current != null) {
            if (current is HTMLElement)
                parents.add(current)
            current = current.parentElement
        }
        return parents
    }