package io.kdomskia.compose.js

import kotlin.js.Promise

external fun import(module: String): Promise<Unit>

@JsName("Array")
external object ExternalJsArray {

    fun isArray(obj: dynamic): Boolean

}

external object Object {

    fun keys(obj: dynamic): Array<String>

}