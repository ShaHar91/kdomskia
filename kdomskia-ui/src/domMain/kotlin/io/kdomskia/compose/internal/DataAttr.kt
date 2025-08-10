package io.kdomskia.compose.internal

import io.kdomskia.compose.internal.attr.KdomskiaDataAttr
import io.kdomskia.compose.internal.attr.KdomskiaDataAttrHolder
import io.kdomskia.compose.internal.attr.dataSetName
import io.kdomskia.compose.ui.DomModifier
import com.varabyte.kobweb.compose.ui.modifiers.dataAttr

internal fun DomModifier.dataAttr(
    attr: KdomskiaDataAttr,
    value: String
) = dataAttr(name = attr.dataSetName, value = value)

internal fun DomModifier.dataAttr(
    attr: KdomskiaDataAttrHolder,
    value: String
) = dataAttr(name = attr.dataSetName, value = value)