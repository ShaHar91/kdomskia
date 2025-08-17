package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.ui.modifiers.pointerEvents
import com.varabyte.kobweb.compose.ui.modifiers.position
import io.kdomskia.compose.css.TypeSafeClass
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.zIndex
import org.jetbrains.compose.web.css.Position

@Composable
actual fun ViewportContainer(
    modifier: Modifier,
    contentAlignment: Alignment,
    zIndex: Float,
    content: @Composable (BoxScope.() -> Unit)
) {
    Box(
        modifier = modifier
            .unwrap {
                position(Position.Fixed)
                    .pointerEvents(PointerEvents.None)
            }
            .fillMaxSize()
            .zIndex(zIndex)
    ) {
        Box(
            modifier = modifier
                .unwrap {
                    typeSafeClasses(ViewportContainer)
                }
                .fillMaxSize(),
            contentAlignment = contentAlignment
        ) {
            content(this)
        }
    }
}

val ViewportContainer = TypeSafeClass("viewport-container")