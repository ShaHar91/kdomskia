package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.foundation.layout.dom.DomFlexBasis
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Modifier
import androidx.compose.foundation.layout.Column as SkiaColumn
import androidx.compose.foundation.layout.ColumnScope as SkiaColumnScope

@Composable
actual fun Column(
    modifier: Modifier,
    verticalArrangement: Arrangement.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    content: @Composable ColumnScope.() -> Unit
) {
    CheckKdomskiaInitialization()
    SkiaColumn(
        modifier = modifier.skia,
        verticalArrangement = verticalArrangement.skia,
        horizontalAlignment = horizontalAlignment.skia
    ) {
        content(ColumnScope(this))
    }
}

@Immutable
actual class ColumnScope(
    private val skiaScope: SkiaColumnScope
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
    actual fun Modifier.align(alignment: Alignment.Horizontal): Modifier = unwrap {
        skiaScope.run {
            skia.align(alignment.skia)
        }
    }

}