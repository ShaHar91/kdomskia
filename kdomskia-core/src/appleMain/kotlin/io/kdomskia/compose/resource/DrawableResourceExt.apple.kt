package io.kdomskia.compose.resource

import okio.FileSystem
import okio.Path.Companion.toPath
import org.jetbrains.compose.resources.DrawableResource

internal actual fun DrawableResource.getUri(ref: DrawableResourcesRef): String {
    val reverseMap = ref.all.entries.associate { it.value to it.key }

    val key = reverseMap[this] ?: return ""
    var uri = ""

    for (s in supportedExtensions) {
        uri = runCatching {
            val pathUri = ref.onGetUri.invoke("drawable/${key}.$s")

            if (FileSystem.SYSTEM.exists(pathUri.replace("file://", "").toPath()))
                pathUri
            else
                ""
        }.getOrNull().orEmpty()
        if (uri.isNotBlank()) break
    }

    return uri
}