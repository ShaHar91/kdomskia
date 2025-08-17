package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.ui.modifiers.pointerEvents
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.styleModifier
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
    val bottomInsetPadding = "env(safe-area-inset-bottom, 0px)"
    Box(
        modifier = modifier
            .unwrap {
                typeSafeClasses(ViewportContainer)
                    .position(Position.Fixed)
                    .pointerEvents(PointerEvents.None)
                    .styleModifier {
                        when (contentAlignment) {
                            Alignment.TopStart, Alignment.TopCenter, Alignment.TopEnd -> {
                                property("top", bottomInsetPadding)
                            }

                            Alignment.BottomStart, Alignment.BottomCenter, Alignment.BottomEnd -> {
                                property("bottom", bottomInsetPadding)
                            }
                        }
                    }
            }
            .fillMaxWidth()
            .fillViewportHeight()
            .zIndex(zIndex),
        contentAlignment = contentAlignment
    ) {
        content(this)
    }
}

val ViewportContainer = TypeSafeClass("viewport-container")