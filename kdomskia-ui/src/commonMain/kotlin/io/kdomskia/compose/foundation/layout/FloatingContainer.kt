package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
expect fun BoxScope.FloatingContainer(
    horizontalPlacement: Placement.Horizontal,
    verticalPlacement: Placement.Vertical,
    content: @Composable () -> Unit
)

sealed interface Placement {

    sealed class Horizontal(
        val paddingStart: Dp,
        val paddingEnd: Dp
    ) : Placement {

        class AlignStart(
            paddingStart: Dp = 0.dp,
            paddingEnd: Dp = 0.dp
        ) : Horizontal(
            paddingStart,
            paddingEnd
        )

        class AlignEnd(
            paddingStart: Dp = 0.dp,
            paddingEnd: Dp = 0.dp
        ) : Horizontal(
            paddingStart,
            paddingEnd
        )

        class AlignCenter(
            paddingStart: Dp = 0.dp,
            paddingEnd: Dp = 0.dp
        ) : Horizontal(
            paddingStart,
            paddingEnd
        )

        class Fill(
            paddingStart: Dp = 0.dp,
            paddingEnd: Dp = 0.dp
        ) : Horizontal(
            paddingStart,
            paddingEnd
        )

    }

    sealed class Vertical(
        val paddingTop: Dp,
        val paddingBottom: Dp
    ) : Placement {

        class AlignTop(
            paddingTop: Dp = 0.dp,
            paddingBottom: Dp = 0.dp
        ) : Vertical(
            paddingTop,
            paddingBottom
        )

        class AlignBottom(
            paddingTop: Dp = 0.dp,
            paddingBottom: Dp = 0.dp
        ) : Vertical(
            paddingTop,
            paddingBottom
        )

        class AlignCenter(
            paddingTop: Dp = 0.dp,
            paddingBottom: Dp = 0.dp
        ) : Vertical(
            paddingTop,
            paddingBottom
        )

        class Fill(
            paddingTop: Dp = 0.dp,
            paddingBottom: Dp = 0.dp
        ) : Vertical(
            paddingTop,
            paddingBottom
        )

    }

}