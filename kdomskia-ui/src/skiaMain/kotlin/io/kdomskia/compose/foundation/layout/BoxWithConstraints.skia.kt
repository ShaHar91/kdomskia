package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.UiComposable
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.layout.BoxWithConstraints as SkiaBoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope as SkiaBoxWithConstraintsScope

@Composable
@UiComposable
actual fun BoxWithConstraints(
    modifier: Modifier,
    contentAlignment: Alignment,
    propagateMinConstraints: Boolean,
    content: @Composable @UiComposable (BoxWithConstraintsScope.() -> Unit)
) {
    CheckKdomskiaInitialization()
    SkiaBoxWithConstraints(
        modifier = modifier.skia,
        contentAlignment = contentAlignment.skia,
        propagateMinConstraints = propagateMinConstraints
    ) {
        content(BoxWithConstraintsScope(this))
    }
}

fun BoxWithConstraintsScope(
    skiaScope: SkiaBoxWithConstraintsScope
): BoxWithConstraintsScope = object : BoxWithConstraintsScope {

    override val minWidth: Dp
        get() = skiaScope.minWidth

    override val maxWidth: Dp
        get() = skiaScope.maxWidth

    override val minHeight: Dp
        get() = skiaScope.minHeight

    override val maxHeight: Dp
        get() = skiaScope.maxHeight

    override fun Modifier.align(alignment: Alignment) = unwrap {
        skiaScope.run {
            skia.align(alignment.skia)
        }
    }

}