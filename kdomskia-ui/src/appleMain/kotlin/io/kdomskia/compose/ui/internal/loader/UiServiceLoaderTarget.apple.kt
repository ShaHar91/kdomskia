package io.kdomskia.compose.ui.internal.loader

import io.kdomskia.annotation.InternalKdomskiaApi
import io.kdomskia.compose.core.loader.KdomskiaServiceLoaderComponentRegistry

@Suppress("DEPRECATION")
@OptIn(ExperimentalStdlibApi::class)
@EagerInitialization
@InternalKdomskiaApi
@Deprecated("", level = DeprecationLevel.HIDDEN)
val uiServiceInitHook: Any = KdomskiaServiceLoaderComponentRegistry.register(UiServiceLoaderTarget())