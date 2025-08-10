package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.UiComposable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.varabyte.kobweb.compose.dom.refScope
import io.kdomskia.compose.dom.ResizeObserver
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import org.w3c.dom.HTMLElement
import com.varabyte.kobweb.compose.foundation.layout.Box as DomBox
import com.varabyte.kobweb.compose.foundation.layout.BoxScope as DomBoxScope

@Composable
@UiComposable
actual fun BoxWithConstraints(
    modifier: Modifier,
    contentAlignment: Alignment,
    propagateMinConstraints: Boolean,
    content: @Composable @UiComposable (BoxWithConstraintsScope.() -> Unit)
) {
    CheckKdomskiaInitialization()

    var constraints by remember {
        mutableStateOf(BoxConstraints())
    }

    DomBox(
        modifier = modifier.dom,
        contentAlignment = contentAlignment.dom,
        ref = refScope {
            disposableRef(Unit) { element ->
                val resizeObserver = ResizeObserver { entries, observer ->
                    entries.forEach {
                        (it.target as? HTMLElement)?.let { resizedElement ->
                            val resizedWidth = resizedElement.offsetWidth.dp
                            val resizedHeight = resizedElement.offsetHeight.dp

                            constraints = BoxConstraints(
                                minWidth = resizedWidth,
                                maxWidth = resizedWidth,
                                minHeight = resizedHeight,
                                maxHeight = resizedHeight
                            )
                        }
                    }
                }

                val resizedWidth = element.offsetWidth.dp
                val resizedHeight = element.offsetHeight.dp

                constraints = BoxConstraints(
                    minWidth = resizedWidth,
                    maxWidth = resizedWidth,
                    minHeight = resizedHeight,
                    maxHeight = resizedHeight
                )

                resizeObserver.observe(element)

                onDispose {
                    resizeObserver.disconnect()
                }
            }
        }
    ) {
        content(
            BoxWithConstraintsScope(
                domScope = this,
                constraints = constraints
            )
        )
    }
}

@Immutable
private data class BoxConstraints(
    val minWidth: Dp = 0.dp,
    val maxWidth: Dp = 0.dp,
    val minHeight: Dp = 0.dp,
    val maxHeight: Dp = 0.dp
)

private fun BoxWithConstraintsScope(
    domScope: DomBoxScope,
    constraints: BoxConstraints
): BoxWithConstraintsScope = object : BoxWithConstraintsScope {

    override val minWidth = constraints.minWidth

    override val maxWidth = constraints.maxWidth

    override val minHeight = constraints.minHeight

    override val maxHeight = constraints.maxHeight

    @Stable
    override fun Modifier.align(alignment: Alignment): Modifier = unwrap {
        domScope.run {
            dom.align(alignment.dom)
        }
    }

}