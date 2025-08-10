package io.kdomskia.compose.extension

fun String.camelToSnakeCase(): String {
    return "([a-z])([A-Z])".toRegex().replace(this, "$1_$2").lowercase()
}

fun String?.jsonParseOrNull(): dynamic? = try {
    takeIf { it?.isNotBlank() ?: false }
        ?.let { JSON.parse<Any>(it).asDynamic() }
} catch (e: Throwable) {
    null
}