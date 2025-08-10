package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.foundation.layout.dom.DomFlexBasis
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.layout.Row as SkiaRow
import androidx.compose.foundation.layout.RowScope as SkiaRowScope

@Composable
actual inline fun Row(
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal,
    verticalAlignment: Alignment.Vertical,
    content: @Composable RowScope.() -> Unit
) {
    CheckKdomskiaInitialization()
    SkiaRow(
        modifier = modifier.skia,
        horizontalArrangement = horizontalArrangement.skia,
        verticalAlignment = verticalAlignment.skia,
        content = {
            content(RowScope(this))
        }
    )
}

@Immutable
actual class RowScope(
    private val skiaScope: SkiaRowScope
) {

    @Stable
    actual fun Modifier.weight(
        weight: Float,
        skiaFill: Boolean,
        domFlexBasis: DomFlexBasis?
    ): Modifier = unwrap {
        skiaScope.run {
            skia.weight(weight, skiaFill)
        }
    }

    @Stable
    actual fun Modifier.align(alignment: Alignment.Vertical): Modifier = unwrap {
        skiaScope.run {
            skia.align(alignment.skia)
        }
    }

}