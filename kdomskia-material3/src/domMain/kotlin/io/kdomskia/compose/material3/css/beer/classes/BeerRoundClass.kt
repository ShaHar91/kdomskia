package io.kdomskia.compose.material3.css.beer.classes

import io.kdomskia.compose.css.TypeSafeClass

enum class BeerRoundClass(
    override val className: String
) : TypeSafeClass {

    Round("round"),

    NoRound("no-round"),

    LeftRound("left-round"),

    RightRound("right-round"),

    TopRound("top-round"),

    BottomRound("bottom-round")

}