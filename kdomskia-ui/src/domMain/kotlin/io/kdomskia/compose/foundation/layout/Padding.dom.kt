package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.kdomskia.compose.extension.nextOrNull
import io.kdomskia.compose.js.Object
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.unit.dom
import com.varabyte.kobweb.compose.ui.modifiers.padding as domPadding

@Stable
class DomPaddingValues(
    val left: Dp,
    val top: Dp,
    val right: Dp,
    val bottom: Dp
)

val PaddingValues.dom: DomPaddingValues
    get() {
        val skiaDynamic = this.commonSkia.asDynamic()
        val keys = Object.keys(skiaDynamic)
        val values = mutableListOf<Float>()

        for (key in keys) {
            val value = skiaDynamic[key]
            if (jsTypeOf(value) == "number") {
                (value as? Float)?.let {
                    values.add(it)
                }
            }
        }

        val iterator = values.iterator()

        return DomPaddingValues(
            left = (iterator.nextOrNull() ?: 0f).dp,
            top = (iterator.nextOrNull() ?: 0f).dp,
            right = (iterator.nextOrNull() ?: 0f).dp,
            bottom = (iterator.nextOrNull() ?: 0f).dp
        )
    }

@Stable
actual fun Modifier.padding(
    start: Dp,
    top: Dp,
    end: Dp,
    bottom: Dp
): Modifier = unwrap {
    domPadding(
        top = top.dom,
        right = end.dom,
        bottom = bottom.dom,
        left = start.dom
    )
}

@Stable
actual fun Modifier.padding(
    horizontal: Dp,
    vertical: Dp
) = unwrap {
    domPadding(
        topBottom = vertical.dom,
        leftRight = horizontal.dom
    )
}

@Stable
actual fun Modifier.padding(all: Dp): Modifier = unwrap {
    domPadding(
        all = all.dom
    )
}

@Stable
actual fun Modifier.padding(paddingValues: PaddingValues) = unwrap {
    val domPadding = paddingValues.dom

    domPadding(
        top = domPadding.top.dom,
        right = domPadding.right.dom,
        bottom = domPadding.bottom.dom,
        left = domPadding.left.dom
    )
}