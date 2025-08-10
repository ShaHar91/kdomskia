package io.kdomskia.compose.foundation.layout

import androidx.compose.runtime.Stable
import com.varabyte.kobweb.compose.css.Height
import com.varabyte.kobweb.compose.css.Width

data class DomIntrinsicSize(
    val width: Width,
    val height: Height
)

@Stable
val IntrinsicSize.dom: DomIntrinsicSize
    get() = when (this) {
        IntrinsicSize.Min -> DomIntrinsicSize(
            width = Width.MinContent,
            height = Height.MinContent
        )

        IntrinsicSize.Max -> DomIntrinsicSize(
            width = Width.MaxContent,
            height = Height.MaxContent
        )
    }