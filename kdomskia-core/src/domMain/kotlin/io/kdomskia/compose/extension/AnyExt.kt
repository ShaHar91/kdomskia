package io.kdomskia.compose.extension

import io.kdomskia.compose.js.ExternalJsArray

fun Any?.jsonStringifyOrEmpty(): String = this?.let { JSON.stringify(it) }.orEmpty()

fun Any?.isString(): Boolean = jsTypeOf(this) == "string" || this is String

fun Any?.isObject(): Boolean = jsTypeOf(this) == "object" && !ExternalJsArray.isArray(this) && this != null

fun Any?.isArray(): Boolean = ExternalJsArray.isArray(this)