package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.layout.ContentScale
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.resource.ImageResource

@Composable
expect fun Image(
    img: ImageResource,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
)