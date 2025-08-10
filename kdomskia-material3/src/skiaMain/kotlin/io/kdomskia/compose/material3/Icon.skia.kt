package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.graphics.rememberPainter
import io.kdomskia.compose.ui.resource.ImageResource
import androidx.compose.material3.Icon as SkiaIcon

@Composable
actual fun Icon(
    img: ImageResource,
    contentDescription: String?,
    modifier: Modifier,
    tint: Color
) {
    SkiaIcon(
        painter = rememberPainter(img),
        contentDescription = contentDescription,
        modifier = modifier.skia,
        tint = tint
    )
}