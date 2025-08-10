package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Modifier
import com.varabyte.kobweb.compose.foundation.layout.Box as DomBox
import com.varabyte.kobweb.compose.foundation.layout.BoxScope as DomBoxScope

@Composable
actual fun Box(
    modifier: Modifier,
    contentAlignment: Alignment,
    propagateMinConstraints: Boolean,
    content: @Composable BoxScope.() -> Unit
) {
    CheckKdomskiaInitialization()
    DomBox(
        modifier = modifier.dom,
        contentAlignment = contentAlignment.dom
    ) {
        content(BoxScope(this))
    }
}

fun BoxScope(domScope: DomBoxScope): BoxScope = object : BoxScope {

    @Stable
    override fun Modifier.align(alignment: Alignment): Modifier = unwrap {
        domScope.run {
            dom.align(alignment.dom)
        }
    }

}