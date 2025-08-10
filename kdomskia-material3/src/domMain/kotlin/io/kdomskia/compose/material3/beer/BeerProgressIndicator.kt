package io.kdomskia.compose.material3.beer

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.material3.css.beer.classes.BeerProgressClass
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.graphics.dom
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.dom.Progress

@Composable
fun BeerProgressIndicator(
    modifier: DomModifier,
    color: Color,
    strokeWidth: Dp
) {
    Progress(
        attrs = modifier
            .border {
                color(color.dom)
                width(strokeWidth.dom)
            }
            .typeSafeClasses(BeerProgressClass.Circle)
            .toAttrs()
    ) {

    }
}