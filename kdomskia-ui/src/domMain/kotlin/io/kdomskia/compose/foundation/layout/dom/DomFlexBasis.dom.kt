package io.kdomskia.compose.foundation.layout.dom

import com.varabyte.kobweb.compose.css.FlexBasis

actual enum class DomFlexBasis(
    val dom: FlexBasis
) {

    Auto(FlexBasis.Auto),

    MaxContent(FlexBasis.MaxContent),

    MinContent(FlexBasis.MinContent),

    FitContent(FlexBasis.MinContent),

    Content(FlexBasis.Content)

}