package io.kdomskia.compose.internal

import io.kdomskia.annotation.InternalKdomskiaApi
import io.kdomskia.compose.foundation.addScrollObserver
import io.kdomskia.compose.ui.draw.addClipObserver
import io.kdomskia.compose.ui.layout.addGlobalLayoutPositionedObserver

@Suppress("DEPRECATION")
@OptIn(ExperimentalStdlibApi::class, ExperimentalJsExport::class)
@EagerInitialization
@JsExport
@InternalKdomskiaApi
@Deprecated("", level = DeprecationLevel.HIDDEN)
val uiObserversInitHook: Any = addUiModuleObservers()

private fun addUiModuleObservers() {
    addScrollObserver()
    addClipObserver()
    addGlobalLayoutPositionedObserver()
}