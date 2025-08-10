package io.kdomskia.compose.core.loader

import androidx.compose.runtime.Composable
import io.kdomskia.annotation.InternalKdomskiaApi

@InternalKdomskiaApi
expect object KdomskiaServiceLoaderComponentRegistry {

    val composables: List<ComposableServiceLoaderTarget>

    fun register(composable: ComposableServiceLoaderTarget)

}

@InternalKdomskiaApi
interface ComposableServiceLoaderTarget {

    val priority: Int

    @Composable
    fun LoadModule(
        content: @Composable () -> Unit
    )

    @Composable
    fun AfterApplySettings(
        content: @Composable () -> Unit
    ) {
        content()
    }

}