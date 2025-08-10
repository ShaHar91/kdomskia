package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.graphics.rememberPainter
import io.kdomskia.compose.ui.layout.ContentScale
import io.kdomskia.compose.ui.layout.skia
import io.kdomskia.compose.ui.resource.ImageResource
import androidx.compose.foundation.Image as SkiaImage

@Composable
actual fun Image(
    img: ImageResource,
    contentDescription: String?,
    modifier: Modifier,
    contentScale: ContentScale
) {
    SkiaImage(
        painter = rememberPainter(img),
        contentDescription = contentDescription,
        modifier = modifier.skia,
        contentScale = contentScale.skia
    )
}