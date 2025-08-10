package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.varabyte.kobweb.compose.css.BackgroundClip
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import io.kdomskia.compose.foundation.layout.Spacer
import io.kdomskia.compose.foundation.layout.fillMaxHeight
import io.kdomskia.compose.foundation.layout.fillMaxWidth
import io.kdomskia.compose.foundation.layout.height
import io.kdomskia.compose.foundation.layout.width
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.graphics.dom

@Composable
actual fun HorizontalDivider(
    modifier: Modifier,
    thickness: Dp,
    color: Color
) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
            .unwrap {
                divider(color)
            }
    )
}

@Composable
actual fun VerticalDivider(
    modifier: Modifier,
    thickness: Dp,
    color: Color
) {
    Spacer(
        modifier = modifier
            .fillMaxHeight()
            .width(thickness)
            .unwrap {
                divider(color)
            }
    )
}

private fun DomModifier.divider(color: Color) = background {
    color(color.dom)
    clip(BackgroundClip.ContentBox)
}.boxSizing(BoxSizing.ContentBox)