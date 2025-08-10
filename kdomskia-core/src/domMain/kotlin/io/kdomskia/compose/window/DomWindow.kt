package io.kdomskia.compose.window

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.WindowInfo
import androidx.compose.ui.unit.IntSize
import kotlinx.browser.window
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import org.w3c.dom.AddEventListenerOptions
import org.w3c.dom.Element
import org.w3c.dom.MediaQueryListEvent
import org.w3c.dom.events.Event
import org.w3c.dom.events.EventTarget

private external interface AbortSignal

private external class AbortController {
    val signal: AbortSignal
    fun abort()
}

internal val actualDensity = 1.0

private fun withSignal(signal: AbortSignal): AddEventListenerOptions = js("({signal: signal})")

internal class EventTargetListener(private val eventTarget: EventTarget) {
    private val abortController = AbortController()

    fun addDisposableEvent(eventName: String, handler: (Event) -> Unit) {
        eventTarget.addEventListener(eventName, handler, withSignal(abortController.signal))
    }

    fun dispose() {
        abortController.abort()
    }
}

internal interface ComposeWindowState {
    fun init() {}
    fun sizeFlow(): Flow<IntSize>

    val globalEvents: EventTargetListener

    fun dispose() {
        globalEvents.dispose()
    }
}

internal class DefaultWindowState(private val viewportContainer: Element) : ComposeWindowState {
    private val channel = Channel<IntSize>(CONFLATED)

    override val globalEvents = EventTargetListener(window)

    override fun init() {

        globalEvents.addDisposableEvent("resize") {
            channel.trySend(getParentContainerBox())
        }

        initMediaEventListener {
            channel.trySend(getParentContainerBox())
        }

        channel.trySend(getParentContainerBox())
    }

    private fun getParentContainerBox(): IntSize {
        return IntSize(viewportContainer.clientWidth, viewportContainer.clientHeight)
    }

    private fun initMediaEventListener(handler: (Double) -> Unit) {
        val contentScale = actualDensity
        window.matchMedia("(resolution: ${contentScale}dppx)")
            .addEventListener("change", { evt ->
                evt as MediaQueryListEvent
                if (!evt.matches) {
                    handler(contentScale)
                }
                initMediaEventListener(handler)
            }, AddEventListenerOptions(capture = true, once = true))
    }

    override fun sizeFlow() = channel.receiveAsFlow()
}

internal class WindowInfoImpl : WindowInfo {

    private val _containerSize = mutableStateOf(IntSize.Zero)

    override var isWindowFocused: Boolean by mutableStateOf(false)

    override var containerSize: IntSize
        get() = _containerSize.value
        set(value) {
            _containerSize.value = value
        }

}