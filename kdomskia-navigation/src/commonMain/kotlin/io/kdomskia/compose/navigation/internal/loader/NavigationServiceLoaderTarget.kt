package io.kdomskia.compose.navigation.internal.loader

import androidx.compose.runtime.Composable
import io.kdomskia.compose.core.loader.ComposableServiceLoaderTarget

internal class NavigationServiceLoaderTarget : ComposableServiceLoaderTarget {

    override val priority = 0 // ui > material3 > navigation

    @Composable
    override fun LoadModule(
        content: @Composable () -> Unit
    ) {
        content()
    }

}