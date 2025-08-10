package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.foundation.layout.dom.DomFlexBasis
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.flexBasis
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.thenIfNotNull
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import org.jetbrains.compose.web.css.px
import com.varabyte.kobweb.compose.foundation.layout.Column as DomColumn
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope as DomColumnScope

@Composable
actual fun Column(
    modifier: Modifier,
    verticalArrangement: Arrangement.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    content: @Composable ColumnScope.() -> Unit
) {
    CheckKdomskiaInitialization()
    DomColumn(
        modifier = modifier.dom,
        verticalArrangement = verticalArrangement.dom,
        horizontalAlignment = horizontalAlignment.dom
    ) {
        content(ColumnScope(this))
    }
}

@Immutable
actual class ColumnScope(
    private val domScope: DomColumnScope
) {

    @Stable
    actual fun Modifier.weight(
        weight: Float,
        skiaFill: Boolean,
        domFlexBasis: DomFlexBasis?
    ): Modifier = unwrap {
        domScope.run {
            dom.weight(weight)
                .height(0.px)
                .thenIfNotNull(domFlexBasis) {
                    dom.flexBasis(it.dom)
                }
        }
    }

    @Stable
    actual fun Modifier.align(alignment: Alignment.Horizontal): Modifier = unwrap {
        domScope.run {
            dom.align(alignment.dom)
        }
    }

}