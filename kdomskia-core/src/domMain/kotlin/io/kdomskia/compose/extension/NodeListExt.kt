package io.kdomskia.compose.extension

import org.w3c.dom.HTMLElement
import org.w3c.dom.NodeList
import org.w3c.dom.asList

fun NodeList.htmlElements(): List<HTMLElement> = asList().filterIsInstance<HTMLElement>()