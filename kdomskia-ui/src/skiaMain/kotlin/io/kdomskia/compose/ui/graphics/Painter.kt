package io.kdomskia.compose.ui.graphics

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import coil3.compose.rememberAsyncImagePainter
import io.kdomskia.compose.ui.resource.ImageResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun rememberPainter(
    img: ImageResource
): Painter {
    return when (img) {
        is ImageResource.Local -> {
            if (img.uri.endsWith(".svg")) {
                if (supportsNativeSvg()) {
                    painterResource(img.resource)
                } else {
                    rememberAsyncImagePainter(img.uri)
                }
            } else {
                painterResource(img.resource)
            }
        }

        is ImageResource.Remote -> {
            rememberAsyncImagePainter(img.uri)
        }
    }
}