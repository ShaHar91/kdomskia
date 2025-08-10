package io.kdomskia.compose.css

fun String?.toMs(): Long? {
    val value = this.orEmpty()
    if (value.isEmpty()) return null

    return when {
        value.contains("ms") -> {
            value.replace("ms", "").toLongOrNull()
        }

        value.contains("s") -> {
            value.replace("s", "").toFloatOrNull()?.let {
                (it * 1000f).toLong()
            }
        }

        else -> null
    }
}