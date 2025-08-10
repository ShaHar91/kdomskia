package io.kdomskia.compose.css

interface TypeSafeClass {
    val className: String
}

fun TypeSafeClass(className: String) = object : TypeSafeClass {

    override val className = className

}