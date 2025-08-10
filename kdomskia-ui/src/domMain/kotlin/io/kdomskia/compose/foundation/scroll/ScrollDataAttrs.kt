package io.kdomskia.compose.foundation.scroll

import io.kdomskia.compose.internal.attr.KdomskiaDataAttr
import io.kdomskia.compose.internal.attr.KdomskiaDataAttrHolder
import io.kdomskia.compose.internal.attr.fullAttrName

internal enum class ScrollDataAttrs(
    override val attr: KdomskiaDataAttr
) : KdomskiaDataAttrHolder {

    WindowVerticalData(
        KdomskiaDataAttr(
            namespace = "scrollWindowVertical",
            property = "data"
        )
    ),

    WindowHorizontalData(
        KdomskiaDataAttr(
            namespace = "scrollWindowHorizontal",
            property = "data"
        )
    ),

    BodyVerticalData(
        KdomskiaDataAttr(
            namespace = "scrollBodyVertical",
            property = "data"
        )
    ),

    BodyHorizontalData(
        KdomskiaDataAttr(
            namespace = "scrollBodyHorizontal",
            property = "data"
        )
    ),

    ElementVerticalValue(
        KdomskiaDataAttr(
            namespace = "scrollElementVertical",
            property = "value"
        )
    ),

    ElementVerticalSmoothTo(
        KdomskiaDataAttr(
            namespace = "scrollElementVertical",
            property = "smoothTo"
        )
    ),

    ElementHorizontalValue(
        KdomskiaDataAttr(
            namespace = "scrollElementHorizontal",
            property = "value"
        )
    ),

    ElementHorizontalSmoothTo(
        KdomskiaDataAttr(
            namespace = "scrollElementHorizontal",
            property = "smoothTo"
        )
    );

    companion object {

        fun attrNames(): Array<String> = entries.map { it.fullAttrName }.toTypedArray()

    }

}

val BodyVerticalScrollEnabledDataAttr = KdomskiaDataAttr(
    namespace = "scrollBodyVertical",
    property = "enabled"
)

val BodyHorizontalScrollEnabledDataAttr = KdomskiaDataAttr(
    namespace = "scrollBodyHorizontal",
    property = "enabled"
)