package io.kdomskia.compose.foundation.scroll

internal data class ScrollData(
    @JsName("value")
    val value: Double,
    @JsName("overflow")
    val overflow: String
)