package io.kdomskia.compose.owner

import androidx.compose.ui.platform.WindowInfo
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import io.kdomskia.compose.window.DefaultWindowState
import io.kdomskia.compose.window.WindowInfoImpl
import io.kdomskia.compose.window.actualDensity
import kotlinx.browser.document

internal class DomOwner : LifecycleOwner, ViewModelStoreOwner {

    override val viewModelStore: ViewModelStore = ViewModelStore()

    override val lifecycle = LifecycleRegistry(this)

    private val windowState = DefaultWindowState(document.documentElement!!)

    private val _windowInfo = WindowInfoImpl().apply {
        isWindowFocused = true
    }

    val windowInfo: WindowInfo = _windowInfo

    val density: Density
        get() = Density(actualDensity.toFloat())

    val layoutDirection = LayoutDirection.Ltr

    init {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START)
        windowState.init()
    }

    suspend fun init() {
        windowState.sizeFlow().collect { size ->
            this@DomOwner.resize(size)
        }
    }

    fun resize(boxSize: IntSize) {
        _windowInfo.containerSize = boxSize
    }

    fun dispose() {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        viewModelStore.clear()
        windowState.dispose()
    }

}