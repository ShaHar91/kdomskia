package io.kdomskia.compose.resource

import org.jetbrains.compose.resources.DrawableResource

internal actual fun DrawableResource.getUri(ref: DrawableResourcesRef): String {
    val reverseMap = ref.all.entries.associate { it.value to it.key }

    val key = reverseMap[this] ?: return ""
    var uri = ""

    for (s in supportedExtensions) {
        uri = runCatching {
            ref.onGetUri.invoke("drawable/${key}.$s")
        }.getOrNull().orEmpty()
        if (uri.isNotBlank()) break
    }

    return uri
}