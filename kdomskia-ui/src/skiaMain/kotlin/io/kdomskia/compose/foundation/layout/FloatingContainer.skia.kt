package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import io.kdomskia.compose.foundation.layout.Placement.Horizontal
import io.kdomskia.compose.foundation.layout.Placement.Vertical
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.thenIf

@Composable
actual fun BoxScope.FloatingContainer(
    horizontalPlacement: Horizontal,
    verticalPlacement: Vertical,
    content: @Composable (() -> Unit)
) {
    val alignment = when (horizontalPlacement) {
        is Horizontal.AlignStart -> when (verticalPlacement) {
            is Vertical.AlignTop -> Alignment.TopStart
            is Vertical.AlignBottom -> Alignment.BottomStart
            is Vertical.AlignCenter -> Alignment.CenterStart
            is Vertical.Fill -> Alignment.CenterStart
        }

        is Horizontal.AlignEnd -> when (verticalPlacement) {
            is Vertical.AlignTop -> Alignment.TopEnd
            is Vertical.AlignBottom -> Alignment.BottomEnd
            is Vertical.AlignCenter -> Alignment.CenterEnd
            is Vertical.Fill -> Alignment.CenterEnd
        }

        is Horizontal.AlignCenter -> when (verticalPlacement) {
            is Vertical.AlignTop -> Alignment.TopCenter
            is Vertical.AlignBottom -> Alignment.BottomCenter
            is Vertical.AlignCenter -> Alignment.Center
            is Vertical.Fill -> Alignment.Center
        }

        is Horizontal.Fill -> when (verticalPlacement) {
            is Vertical.AlignTop -> Alignment.TopCenter
            is Vertical.AlignBottom -> Alignment.BottomCenter
            is Vertical.AlignCenter -> Alignment.Center
            is Vertical.Fill -> Alignment.Center
        }
    }
    Box(
        modifier = Modifier
            .align(alignment)
            .thenIf(horizontalPlacement is Horizontal.Fill) {
                Modifier.fillMaxWidth()
            }
            .thenIf(verticalPlacement is Vertical.Fill) {
                Modifier.fillMaxHeight()
            }
            .padding(
                start = horizontalPlacement.paddingStart,
                top = verticalPlacement.paddingTop,
                end = horizontalPlacement.paddingEnd,
                bottom = verticalPlacement.paddingBottom
            )
    ) {
        content()
    }
}