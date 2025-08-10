package io.kdomskia.compose.material3.css.beer.classes

import io.kdomskia.compose.css.TypeSafeClass

enum class BeerSizeClass(
    override val className: String
) : TypeSafeClass {

    Min("min"),

    Max("max")

}