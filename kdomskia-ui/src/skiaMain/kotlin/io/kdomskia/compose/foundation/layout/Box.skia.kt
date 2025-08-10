package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.layout.Box as SkiaBox
import androidx.compose.foundation.layout.BoxScope as SkiaBoxScope

@Composable
actual inline fun Box(
    modifier: Modifier,
    contentAlignment: Alignment,
    propagateMinConstraints: Boolean,
    content: @Composable BoxScope.() -> Unit
) {
    CheckKdomskiaInitialization()
    SkiaBox(
        modifier = modifier.skia,
        contentAlignment = contentAlignment.skia,
        propagateMinConstraints = propagateMinConstraints
    ) {
        content(BoxScope(this))
    }
}

fun BoxScope(skiaScope: SkiaBoxScope): BoxScope = object : BoxScope {

    @Stable
    override fun Modifier.align(alignment: Alignment): Modifier = unwrap {
        skiaScope.run {
            skia.align(alignment.skia)
        }
    }

}