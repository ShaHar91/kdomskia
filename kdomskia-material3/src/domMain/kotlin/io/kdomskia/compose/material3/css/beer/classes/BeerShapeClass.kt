package io.kdomskia.compose.material3.css.beer.classes

import io.kdomskia.compose.css.TypeSafeClass

enum class BeerShapeClass(
    override val className: String
) : TypeSafeClass {

    Circle("circle"),

    Square("square")

}