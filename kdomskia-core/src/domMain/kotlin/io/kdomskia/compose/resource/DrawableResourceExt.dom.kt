package io.kdomskia.compose.resource

import io.kdomskia.compose.extension.isArray
import io.kdomskia.compose.extension.isObject
import io.kdomskia.compose.extension.isString
import io.kdomskia.compose.js.Object
import org.jetbrains.compose.resources.DrawableResource

internal actual fun DrawableResource.getUri(ref: DrawableResourcesRef): String {
    return findDrawablePath(this.asDynamic()).orEmpty()
}

private fun findDrawablePath(obj: dynamic): String? {
    val keys = Object.keys(obj)

    for (key in keys) {
        val value: Any? = obj[key]
        when {
            value.isObject() || value.isArray() -> {
                val result = findDrawablePath(value)

                val str = result.drawablePathIfPresent()

                if (str != null)
                    return str
            }

            value.isString() -> {
                val str = value.drawablePathIfPresent()

                if (str != null)
                    return str
            }
        }
    }

    return null
}

private fun Any?.drawablePathIfPresent(): String? {
    val value = this

    return if (value.isString()) {
        val str = (value as? String?).orEmpty()

        if (str.contains("/drawable/")) {
            str
        } else {
            null
        }
    } else {
        null
    }
}