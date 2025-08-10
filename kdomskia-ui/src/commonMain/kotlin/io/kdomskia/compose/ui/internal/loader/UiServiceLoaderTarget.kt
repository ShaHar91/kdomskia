package io.kdomskia.compose.ui.internal.loader

import androidx.compose.runtime.Composable
import io.kdomskia.compose.core.loader.ComposableServiceLoaderTarget

internal class UiServiceLoaderTarget : ComposableServiceLoaderTarget {

    override val priority = 2 // ui > material3 > navigation

    @Composable
    override fun LoadModule(
        content: @Composable () -> Unit
    ) = UiLoadModule(content)

    @Composable
    override fun AfterApplySettings(
        content: @Composable () -> Unit
    ) = UiAfterApplySettings(content)

}

@Composable
internal expect fun UiLoadModule(
    content: @Composable () -> Unit
)

@Composable
internal expect fun UiAfterApplySettings(
    content: @Composable () -> Unit
)