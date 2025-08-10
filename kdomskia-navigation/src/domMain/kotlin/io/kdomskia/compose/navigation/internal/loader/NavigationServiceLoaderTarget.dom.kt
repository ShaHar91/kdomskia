package io.kdomskia.compose.navigation.internal.loader

import io.kdomskia.annotation.InternalKdomskiaApi
import io.kdomskia.compose.core.loader.KdomskiaServiceLoaderComponentRegistry

@Suppress("DEPRECATION")
@OptIn(ExperimentalStdlibApi::class, ExperimentalJsExport::class)
@EagerInitialization
@JsExport
@InternalKdomskiaApi
@Deprecated("", level = DeprecationLevel.HIDDEN)
val navServiceInitHook: Any = KdomskiaServiceLoaderComponentRegistry.register(NavigationServiceLoaderTarget())