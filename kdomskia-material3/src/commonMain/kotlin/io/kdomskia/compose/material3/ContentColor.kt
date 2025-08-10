package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import androidx.compose.material3.LocalContentColor as SkiaLocalContentColor

object LocalContentColor {

    inline val current: Color
        @ReadOnlyComposable
        @Composable
        get() = SkiaLocalContentColor.current

}

@Composable
fun ProvideContentColor(
    color: Color,
    content: @Composable () -> Unit
) {
    CheckKdomskiaInitialization()
    CompositionLocalProvider(
        SkiaLocalContentColor provides color,
        content = content
    )
}