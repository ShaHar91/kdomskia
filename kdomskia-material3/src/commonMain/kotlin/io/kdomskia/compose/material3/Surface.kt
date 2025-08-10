package io.kdomskia.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.LocalAbsoluteTonalElevation as SkiaLocalAbsoluteTonalElevation

@Composable
@NonRestartableComposable
expect fun Surface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(color),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    content: @Composable () -> Unit
)

@Composable
@NonRestartableComposable
expect fun Surface(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    color: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(color),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    content: @Composable () -> Unit
)

@Composable
@NonRestartableComposable
expect fun Surface(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    color: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(color),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    content: @Composable () -> Unit,
)

object LocalAbsoluteTonalElevation {

    inline val current: Dp
        @ReadOnlyComposable
        @Composable
        get() = SkiaLocalAbsoluteTonalElevation.current

}

@Composable
fun ProvideAbsoluteTonalElevation(
    elevation: Dp,
    content: @Composable () -> Unit
) {
    CheckKdomskiaInitialization()
    CompositionLocalProvider(
        SkiaLocalAbsoluteTonalElevation provides elevation,
        content = content
    )
}
