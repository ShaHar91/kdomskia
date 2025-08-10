package io.kdomskia.compose.material3.css.beer.classes

import io.kdomskia.compose.css.TypeSafeClass

enum class BeerButtonElevateClass(
    override val className: String
) : TypeSafeClass {

    Small("small-elevate"),

    Medium("medium-elevate"),

    Large("large-elevate")

}