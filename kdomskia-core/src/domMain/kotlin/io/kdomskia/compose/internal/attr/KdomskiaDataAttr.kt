package io.kdomskia.compose.internal.attr

import io.kdomskia.annotation.InternalKdomskiaApi
import io.kdomskia.compose.extension.camelToSnakeCase
import org.w3c.dom.DOMStringMap
import org.w3c.dom.NodeList
import org.w3c.dom.ParentNode
import org.w3c.dom.css.CSS
import org.w3c.dom.get
import org.w3c.dom.set

private const val PREFIX = "kdomskia"

@InternalKdomskiaApi
data class KdomskiaDataAttr(
    val namespace: String,
    val property: String
)

@InternalKdomskiaApi
interface KdomskiaDataAttrHolder {
    val attr: KdomskiaDataAttr
}

@InternalKdomskiaApi
fun ParentNode.querySelectorAllWithAttr(
    dataAttr: KdomskiaDataAttr
): NodeList = querySelectorAll("[${dataAttr.fullEscapedAttrName}]")

@InternalKdomskiaApi
fun ParentNode.querySelectorAllWithAttr(
    dataAttr: KdomskiaDataAttrHolder
): NodeList = querySelectorAllWithAttr(dataAttr.attr)

@InternalKdomskiaApi
val KdomskiaDataAttrHolder.fullAttrName: String
    get() = attr.fullAttrName

@InternalKdomskiaApi
val KdomskiaDataAttrHolder.fullEscapedAttrName: String
    get() = attr.fullEscapedAttrName

@InternalKdomskiaApi
val KdomskiaDataAttrHolder.dataSetName: String
    get() = attr.dataSetName

@InternalKdomskiaApi
val KdomskiaDataAttr.fullAttrName: String
    get() = "data-$dataSetName"

@InternalKdomskiaApi
val KdomskiaDataAttr.fullEscapedAttrName: String
    get() = CSS.escape(fullAttrName)

@InternalKdomskiaApi
val KdomskiaDataAttr.dataSetName: String
    get() = "$PREFIX.$namespace.$property".camelToSnakeCase()

@InternalKdomskiaApi
fun DOMStringMap.get(
    attr: KdomskiaDataAttr
) = get(attr.dataSetName)

@InternalKdomskiaApi
fun DOMStringMap.get(
    attr: KdomskiaDataAttrHolder
) = get(attr.dataSetName)

@InternalKdomskiaApi
fun DOMStringMap.set(
    attr: KdomskiaDataAttr,
    value: String
) = set(attr.dataSetName, value)

@InternalKdomskiaApi
fun DOMStringMap.set(
    attr: KdomskiaDataAttrHolder,
    value: String
) = set(attr.dataSetName, value)