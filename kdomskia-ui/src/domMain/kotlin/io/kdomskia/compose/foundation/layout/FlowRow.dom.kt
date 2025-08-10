package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import org.jetbrains.compose.web.css.FlexWrap
import com.varabyte.kobweb.compose.foundation.layout.Row as DomRow

@Composable
actual fun FlowRow(
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal,
    itemVerticalAlignment: Alignment.Vertical,
    content: @Composable (FlowRowScope.() -> Unit)
) {
    CheckKdomskiaInitialization()
    DomRow(
        modifier = modifier
            .dom
            .flexWrap(FlexWrap.Wrap),
        horizontalArrangement = horizontalArrangement.dom,
        verticalAlignment = itemVerticalAlignment.dom
    ) {
        FlowRowScope.content()
    }
}