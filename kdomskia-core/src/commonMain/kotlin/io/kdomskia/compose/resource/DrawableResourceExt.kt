package io.kdomskia.compose.resource

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.DrawableResource

internal val supportedExtensions = listOf(
    "xml",
    "png",
    "webp",
    "jpg",
    "jpeg",
    "svg"
)

@Composable
fun DrawableResource.getUri(): String {
    val ref = LocalDrawableResourcesRef.current

    if (ref.all.isEmpty()) {
        throw UnspecifiedDrawableResourcesResolverError()
    }

    return getUri(ref)
}

internal expect fun DrawableResource.getUri(ref: DrawableResourcesRef): String