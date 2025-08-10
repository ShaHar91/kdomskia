package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.Tab as SkiaTab

@Composable
actual fun Tab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    text: @Composable (() -> Unit)?,
    icon: @Composable (() -> Unit)?,
    selectedContentColor: Color,
    unselectedContentColor: Color
) {
    SkiaTab(
        selected = selected,
        onClick = onClick,
        modifier = modifier.skia,
        enabled = enabled,
        text = text,
        icon = icon,
        selectedContentColor = selectedContentColor,
        unselectedContentColor = unselectedContentColor
    )
}