package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.ui.Modifier
import org.jetbrains.compose.web.dom.Div

@Composable
@NonRestartableComposable
actual fun Spacer(modifier: Modifier) {
    Div(
        attrs = modifier.dom.toAttrs()
    )
}