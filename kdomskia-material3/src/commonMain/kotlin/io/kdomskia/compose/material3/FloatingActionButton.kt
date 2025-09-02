package io.kdomskia.compose.material3

import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import io.kdomskia.compose.ui.Modifier

internal typealias SkiaFloatingActionButtonDefaults = androidx.compose.material3.FloatingActionButtonDefaults

@Composable
expect fun FloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = FloatingActionButtonDefaults.shape,
    containerColor: Color = FloatingActionButtonDefaults.containerColor,
    contentColor: Color = contentColorFor(containerColor),
    content: @Composable () -> Unit
)

@Composable
expect fun ExtendedFloatingActionButton(
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = true,
    shape: Shape = FloatingActionButtonDefaults.extendedFabShape,
    containerColor: Color = FloatingActionButtonDefaults.containerColor,
    contentColor: Color = contentColorFor(containerColor)
)

object FloatingActionButtonDefaults {

    val shape: Shape
        @Composable get() = SkiaFloatingActionButtonDefaults.shape

    val extendedFabShape: Shape
        @Composable get() = SkiaFloatingActionButtonDefaults.extendedFabShape

    val containerColor: Color
        @Composable get() = SkiaFloatingActionButtonDefaults.containerColor

}