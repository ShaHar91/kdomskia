package io.kdomskia.compose.material3.internal.loader

import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.varabyte.kobweb.compose.css.setVariable
import com.varabyte.kobweb.compose.ui.styleModifier
import io.kdomskia.annotation.InternalKdomskiaApi
import io.kdomskia.compose.core.loader.KdomskiaServiceLoaderComponentRegistry
import io.kdomskia.compose.foundation.ClickableModifierHolder
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.js.import
import io.kdomskia.compose.material3.css.Material3StyleSheet
import io.kdomskia.compose.material3.css.Variable
import io.kdomskia.compose.material3.css.beer.classes.BeerCommonClass
import io.kdomskia.compose.material3.orDefault
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.graphics.dom
import kotlinx.browser.document
import kotlinx.dom.addClass
import kotlinx.dom.createElement
import kotlinx.dom.removeClass
import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element

private val loaded = mutableStateOf(false)

private val onLoad = {
    document.head?.insertAdjacentElement(
        "beforeend",
        document.createElement("style") {
            innerHTML = Material3StyleSheet
        }
    )
    loaded.value = true
}

@Suppress("DEPRECATION")
@OptIn(ExperimentalStdlibApi::class, ExperimentalJsExport::class)
@EagerInitialization
@JsExport
@InternalKdomskiaApi
@Deprecated("", level = DeprecationLevel.HIDDEN)
val m3ServiceInitHook: Any = Unit.apply {
    import("beercss/dist/cdn/beer.scoped.min.css").then {
        onLoad()
    }
    KdomskiaServiceLoaderComponentRegistry.register(Material3ServiceLoaderTarget())
}


@Composable
actual fun LoadMaterial3(
    content: @Composable () -> Unit
) {
    val loadedState by loaded

    SetupBeerCss()

    if (loadedState) {
        content()
    }
}

private const val rootTag = "kdomskia-m3-root"

@Composable
private fun SetupBeerCss() {
    SetClickableModifier()

    TagElement(
        tagName = rootTag,
        applyAttrs = null
    ) {
        SetParentElementClass()
    }
}

@Composable
private fun SetClickableModifier() {
    val ripple = LocalRippleConfiguration.current.orDefault()

    LaunchedEffect(ripple) {
        ClickableModifierHolder.modifier = DomModifier
            .typeSafeClasses(BeerCommonClass.Wave)
            .styleModifier {
                val alpha = ripple.rippleAlpha.orDefault().pressedAlpha
                setVariable(Variable.rippleColor, ripple.color.copy(alpha = 1f).dom)
                setVariable(Variable.rippleOpacity, StylePropertyValue(alpha))
            }
    }
}

@Composable
private fun ElementScope<Element>.SetParentElementClass() {
    DisposableEffect(Unit) {
        val parent = scopeElement.parentElement
        parent?.addClass("beer", "light")
        onDispose {
            parent?.removeClass("beer", "light")
        }
    }
}