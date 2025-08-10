package io.kdomskia.compose.core.loader

import kotlinx.atomicfu.locks.SynchronizedObject
import kotlinx.atomicfu.locks.synchronized
import kotlinx.collections.immutable.toImmutableList

actual object KdomskiaServiceLoaderComponentRegistry {

    private val lock = SynchronizedObject()

    private val _composables = mutableListOf<ComposableServiceLoaderTarget>()

    actual val composables: List<ComposableServiceLoaderTarget>
        get() = synchronized(lock) { _composables.toImmutableList() }

    actual fun register(composable: ComposableServiceLoaderTarget) {
        _composables += composable
    }

}