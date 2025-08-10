package io.kdomskia.compose.ui.resource

import androidx.compose.runtime.Composable
import io.kdomskia.compose.resource.getUri
import org.jetbrains.compose.resources.DrawableResource

sealed class ImageResource {

    @get:Composable
    abstract val uri: String

    class Local(
        val resource: DrawableResource
    ) : ImageResource() {

        @get:Composable
        override val uri: String
            get() = resource.getUri()

    }

    class Remote(
        private val url: String
    ) : ImageResource() {

        @get:Composable
        override val uri: String
            get() = url

    }

}