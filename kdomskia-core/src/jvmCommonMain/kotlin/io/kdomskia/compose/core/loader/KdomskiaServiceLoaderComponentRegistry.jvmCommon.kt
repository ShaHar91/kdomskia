package io.kdomskia.compose.core.loader

import java.util.ServiceLoader
import kotlinx.collections.immutable.toImmutableList

actual object KdomskiaServiceLoaderComponentRegistry {

    actual val composables: List<ComposableServiceLoaderTarget> by lazy {
        ServiceLoader.load(
            ComposableServiceLoaderTarget::class.java,
            ComposableServiceLoaderTarget::class.java.classLoader,
        ).iterator().asSequence().toImmutableList()
    }

    actual fun register(composable: ComposableServiceLoaderTarget) {
        throw UnsupportedOperationException()
    }

}