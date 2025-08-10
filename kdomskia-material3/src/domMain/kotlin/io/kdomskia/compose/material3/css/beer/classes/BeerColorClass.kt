package io.kdomskia.compose.material3.css.beer.classes

import io.kdomskia.compose.css.TypeSafeClass

enum class BeerColorClass(
    override val className: String
) : TypeSafeClass {

    Fill("fill"),

    Primary("primary"),

    PrimaryContainer("primary-container"),

    Secondary("secondary"),

    Tertiary("tertiary")

}