package io.kdomskia.compose.ui.graphics

internal expect fun supportsNativeSvg(): Boolean

actual fun supportsVectorDrawable(): Boolean = true