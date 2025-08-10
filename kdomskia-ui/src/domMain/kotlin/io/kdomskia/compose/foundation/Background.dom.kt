package io.kdomskia.compose.foundation

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.varabyte.kobweb.compose.css.BackgroundClip
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.repeatingLinearGradient
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.graphics.dom
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.css.px

@Stable
actual fun Modifier.background(color: Color) = unwrap { background(color.dom) }

@Stable
actual fun Modifier.dottedShapeBackground(
    color: Color,
    size: Dp,
    spacing: Dp
) = unwrap {
    backgroundImage(
        repeatingLinearGradient(LinearGradient.Direction.ToRight) {
            add(color.dom, 0.px)
            add(color.dom, size.dom)
            add(Color.Transparent.dom, size.dom)
            add(Color.Transparent.dom, spacing.dom)
        }
    )
        .background { clip(BackgroundClip.ContentBox) }
        .boxSizing(BoxSizing.ContentBox)
}