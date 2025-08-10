package io.kdomskia.compose.extension

import io.kdomskia.compose.core.loader.ComposableServiceLoaderTarget
import io.kdomskia.compose.core.loader.KdomskiaServiceLoaderComponentRegistry

val KdomskiaServiceLoaderComponentRegistry.orderedComposables: Iterator<ComposableServiceLoaderTarget>
    get() = composables.sortedByDescending { it.priority }.iterator()
