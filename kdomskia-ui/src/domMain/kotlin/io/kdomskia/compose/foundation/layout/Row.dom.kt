package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.modifiers.flexBasis
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.thenIfNotNull
import io.kdomskia.compose.foundation.layout.dom.DomFlexBasis
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Modifier
import org.jetbrains.compose.web.css.px
import com.varabyte.kobweb.compose.foundation.layout.Row as DomRow
import com.varabyte.kobweb.compose.foundation.layout.RowScope as DomRowScope

@Composable
actual fun Row(
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal,
    verticalAlignment: Alignment.Vertical,
    content: @Composable RowScope.() -> Unit
) {
    CheckKdomskiaInitialization()
    DomRow(
        modifier = modifier.dom,
        horizontalArrangement = horizontalArrangement.dom,
        verticalAlignment = verticalAlignment.dom
    ) {
        content(RowScope(this))
    }
}

@Immutable
actual class RowScope(
    private val domScope: DomRowScope
) {

    @Stable
    actual fun Modifier.weight(
        weight: Float,
        skiaFill: Boolean,
        domFlexBasis: DomFlexBasis?
    ): Modifier = unwrap {
        domScope.run {
            dom.weight(weight)
                .width(0.px)
                .thenIfNotNull(domFlexBasis) {
                    dom.flexBasis(it.dom)
                }
        }
    }

    @Stable
    actual fun Modifier.align(alignment: Alignment.Vertical): Modifier = unwrap {
        domScope.run {
            dom.align(alignment.dom)
        }
    }

}