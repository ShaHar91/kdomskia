package io.kdomskia.compose.material3.css.beer.classes

import io.kdomskia.compose.css.TypeSafeClass

enum class BeerCommonClass(
    override val className: String
) : TypeSafeClass {

    Border("border"),

    Transparent("transparent"),

    Active("active"),

    Scroll("scroll"),

    Wave("wave")

}