package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.layout.ContentScale
import io.kdomskia.compose.ui.layout.dom
import io.kdomskia.compose.ui.resource.ImageResource
import org.jetbrains.compose.web.dom.Img as DomImage

@Composable
actual fun Image(
    img: ImageResource,
    contentDescription: String?,
    modifier: Modifier,
    contentScale: ContentScale
) {
    DomImage(
        src = img.uri,
        alt = contentDescription.orEmpty(),
        attrs = modifier
            .dom
            .objectFit(contentScale.dom)
            .toAttrs()
    )
}