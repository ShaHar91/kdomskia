package io.kdomskia.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.thenIfNotNull
import io.kdomskia.compose.foundation.background
import io.kdomskia.compose.foundation.border
import io.kdomskia.compose.foundation.clickable
import io.kdomskia.compose.foundation.layout.Box
import io.kdomskia.compose.foundation.selection.selectable
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.draw.clip
import io.kdomskia.compose.ui.platform.LocalDensity
import io.kdomskia.compose.ui.semantics.Role

@Composable
@NonRestartableComposable
actual fun Surface(
    modifier: Modifier,
    shape: Shape,
    color: Color,
    contentColor: Color,
    tonalElevation: Dp,
    shadowElevation: Dp,
    border: BorderStroke?,
    content: @Composable () -> Unit
) {
    val absoluteElevation = LocalAbsoluteTonalElevation.current + tonalElevation

    ProvideContentColor(contentColor) {
        ProvideAbsoluteTonalElevation(absoluteElevation) {
            Box(
                modifier = modifier.surface(
                    shape = shape,
                    backgroundColor = surfaceColorAtElevation(color = color, elevation = absoluteElevation),
                    border = border,
                    shadowElevation = with(LocalDensity.current) { shadowElevation.toPx() }
                ),
                propagateMinConstraints = true
            ) {
                content()
            }
        }
    }
}

@Composable
@NonRestartableComposable
actual fun Surface(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    color: Color,
    contentColor: Color,
    tonalElevation: Dp,
    shadowElevation: Dp,
    border: BorderStroke?,
    content: @Composable (() -> Unit)
) {
    val absoluteElevation = LocalAbsoluteTonalElevation.current + tonalElevation

    ProvideContentColor(contentColor) {
        ProvideAbsoluteTonalElevation(absoluteElevation) {
            Box(
                modifier = modifier
                    .surface(
                        shape = shape,
                        backgroundColor = surfaceColorAtElevation(color = color, elevation = absoluteElevation),
                        border = border,
                        shadowElevation = with(LocalDensity.current) { shadowElevation.toPx() }
                    )
                    .unwrap {
                        clickable(
                            enabled = enabled,
                            role = Role.Button,
                            cursor = Cursor.Pointer,
                            onClick = onClick
                        )
                    },
                propagateMinConstraints = true
            ) {
                content()
            }
        }
    }
}

@Composable
@NonRestartableComposable
actual fun Surface(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    color: Color,
    contentColor: Color,
    tonalElevation: Dp,
    shadowElevation: Dp,
    border: BorderStroke?,
    content: @Composable (() -> Unit)
) {
    val absoluteElevation = LocalAbsoluteTonalElevation.current + tonalElevation

    ProvideContentColor(contentColor) {
        ProvideAbsoluteTonalElevation(absoluteElevation) {
            Box(
                modifier = modifier
                    .surface(
                        shape = shape,
                        backgroundColor = surfaceColorAtElevation(color = color, elevation = absoluteElevation),
                        border = border,
                        shadowElevation = with(LocalDensity.current) { shadowElevation.toPx() }
                    )
                    .unwrap {
                        selectable(
                            selected = selected,
                            enabled = enabled,
                            role = Role.Button,
                            cursor = Cursor.Pointer,
                            disableUserSelect = false,
                            onClick = onClick
                        )
                    },
                propagateMinConstraints = true
            ) {
                content()
            }
        }
    }
}

@Stable
private fun Modifier.surface(
    shape: Shape,
    backgroundColor: Color,
    border: BorderStroke?,
    shadowElevation: Float,
) = unwrap {
    thenIf(shadowElevation > 0f) {
        boxShadow(shadowElevation = shadowElevation)
    }.thenIfNotNull(border) {
        border(border = it)
    }
}
    .background(backgroundColor)
    .clip(shape)

@Composable
private fun surfaceColorAtElevation(color: Color, elevation: Dp): Color =
    MaterialTheme.colorScheme.applyTonalElevation(color, elevation)