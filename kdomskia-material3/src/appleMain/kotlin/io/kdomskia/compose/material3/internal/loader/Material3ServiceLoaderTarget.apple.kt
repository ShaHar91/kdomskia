package io.kdomskia.compose.material3.internal.loader

import io.kdomskia.annotation.InternalKdomskiaApi
import io.kdomskia.compose.core.loader.KdomskiaServiceLoaderComponentRegistry

@Suppress("DEPRECATION")
@OptIn(ExperimentalStdlibApi::class)
@EagerInitialization
@InternalKdomskiaApi
@Deprecated("", level = DeprecationLevel.HIDDEN)
val m3ServiceInitHook: Any = KdomskiaServiceLoaderComponentRegistry.register(Material3ServiceLoaderTarget())