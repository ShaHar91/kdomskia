package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.resource.ImageResource

@Composable
expect fun Icon(
    img: ImageResource,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
)