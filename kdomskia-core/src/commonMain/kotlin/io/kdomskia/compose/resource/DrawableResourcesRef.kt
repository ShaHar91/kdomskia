package io.kdomskia.compose.resource

import androidx.compose.runtime.compositionLocalOf
import org.jetbrains.compose.resources.DrawableResource

data class DrawableResourcesRef(
    val all: Map<String, DrawableResource>,
    val onGetUri: (String) -> String
)

internal val LocalDrawableResourcesRef = compositionLocalOf {
    DrawableResourcesRef(
        all = emptyMap(),
        onGetUri = { "" }
    )
}

class UnspecifiedDrawableResourcesResolverError : IllegalStateException(
    "Kdomskia: DrawableResourcesRef must be properly provided in order to use ImageResource."
)