package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import androidx.compose.material3.MaterialTheme as SkiaMaterialTheme

@Composable
fun MaterialTheme(
    colorScheme: ColorScheme = MaterialTheme.colorScheme,
    shapes: Shapes = MaterialTheme.shapes,
    typography: Typography = MaterialTheme.typography,
    content: @Composable () -> Unit
) {
    CheckKdomskiaInitialization()
    SkiaMaterialTheme(
        colorScheme = colorScheme._skia,
        shapes = shapes._skia,
        typography = typography._skia,
        content = {
            PlatformMaterialTheme()
            content()
        }
    )
}

object MaterialTheme {

    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() {
            CheckKdomskiaInitialization()
            return SkiaMaterialTheme.colorScheme.kdomskia
        }

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() {
            CheckKdomskiaInitialization()
            return SkiaMaterialTheme.typography.kdomskia
        }

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() {
            CheckKdomskiaInitialization()
            return SkiaMaterialTheme.shapes.kdomskia
        }

}

@Composable
internal expect fun PlatformMaterialTheme()