package io.kdomskia.compose.material3.internal.loader

import androidx.compose.runtime.Composable
import io.kdomskia.compose.core.loader.ComposableServiceLoaderTarget

internal class Material3ServiceLoaderTarget : ComposableServiceLoaderTarget {

    override val priority = 1 // ui > material3 > navigation

    @Composable
    override fun LoadModule(
        content: @Composable () -> Unit
    ) {
        LoadMaterial3 {
            content()
        }
    }

}

@Composable
internal expect fun LoadMaterial3(
    content: @Composable () -> Unit
)