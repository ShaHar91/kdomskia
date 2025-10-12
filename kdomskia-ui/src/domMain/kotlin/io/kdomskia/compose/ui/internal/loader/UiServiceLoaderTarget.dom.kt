package io.kdomskia.compose.ui.internal.loader

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.KobwebComposeStyles
import com.varabyte.kobweb.core.KobwebApp
import io.kdomskia.annotation.InternalKdomskiaApi
import io.kdomskia.compose.core.loader.KdomskiaServiceLoaderComponentRegistry
import io.kdomskia.compose.css.BeerStyleSheet
import io.kdomskia.compose.css.UiRawStyleSheet
import io.kdomskia.compose.css.UiStyleSheet
import io.kdomskia.compose.extension.htmlElements
import io.kdomskia.compose.extension.parentHtmlElement
import io.kdomskia.compose.foundation.scroll.BodyVerticalScrollEnabledDataAttr
import io.kdomskia.compose.internal.attr.get
import kotlinx.browser.document
import kotlinx.dom.createElement
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import org.w3c.dom.MutationObserver
import org.w3c.dom.MutationObserverInit

@Suppress("DEPRECATION")
@OptIn(ExperimentalStdlibApi::class, ExperimentalJsExport::class)
@EagerInitialization
@JsExport
@InternalKdomskiaApi
@Deprecated("", level = DeprecationLevel.HIDDEN)
val uiServiceInitHook: Any = KdomskiaServiceLoaderComponentRegistry.register(UiServiceLoaderTarget())

@Composable
internal actual fun UiLoadModule(
    content: @Composable () -> Unit
) {
    KobwebApp {
        KobwebComposeStyles()
        Style(UiStyleSheet)
        SetupRawStyle()
        SetupHeight()
        Style(BeerStyleSheet)
        content()
    }
}

@Composable
internal actual fun UiAfterApplySettings(
    content: @Composable () -> Unit
) {
    content()
}

private const val rootTag = "kdomskia-ui-root"

@Composable
private fun SetupRawStyle() {
    LaunchedEffect(Unit) {
        document.head?.insertAdjacentElement(
            "beforeend",
            document.createElement("style") {
                innerHTML = UiRawStyleSheet
            }
        )
    }
}

@Composable
private fun SetupHeight() {
    TagElement(
        tagName = rootTag,
        applyAttrs = null
    ) {
        SetChildrenHeight()
    }
}

@Composable
private fun ElementScope<Element>.SetChildrenHeight() {
    DisposableEffect(Unit) {
        val parent = scopeElement.parentHtmlElement
        val observer: MutationObserver?
        val observers = mutableListOf<MutationObserver>()

        if (parent != null) {
            observer = MutationObserver { _, _ ->
                val elements = parent.childNodes
                    .htmlElements()
                    .filter { it.tagName.lowercase() !in listOf(rootTag, "style") }

                if (parent.dataset.get(BodyVerticalScrollEnabledDataAttr) != true.toString()) {
                    observers.forEach {
                        it.disconnect()
                    }
                    observers.clear()
                    elements.undoCustomElementsHeight()
                } else {
                    observers.addAll(elements.applyCustomElementsHeight())
                }
            }

            observer.observe(
                target = parent,
                options = MutationObserverInit(
                    subtree = false,
                    childList = true,
                    attributes = true
                )
            )
        } else {
            observer = null
        }

        onDispose {
            observer?.disconnect()
            observers.forEach {
                it.disconnect()
            }
        }
    }
}

private fun List<HTMLElement>.applyCustomElementsHeight(): List<MutationObserver> {
    return map { element ->
        element.applyCustomElementHeight()

        val observer = MutationObserver { _, _ ->
            element.applyCustomElementHeight()
        }
        observer.observe(
            target = element,
            options = MutationObserverInit(
                subtree = false,
                childList = false,
                attributes = true
            )
        )
        observer
    }
}

private fun HTMLElement.applyCustomElementHeight() {
    style.removeProperty("height")
    style.setProperty("min-height", "100%")
}

private fun List<HTMLElement>.undoCustomElementsHeight() {
    forEach { element ->
        element.style.removeProperty("min-height")
        element.style.setProperty("height", "100%")
    }
}