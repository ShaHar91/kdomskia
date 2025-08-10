package io.kdomskia.compose.core.loader

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import io.kdomskia.compose.extension.orderedComposables

@Composable
internal fun WithModulesLoader(
    content: @Composable () -> Unit
) {
    val composables = remember {
        KdomskiaServiceLoaderComponentRegistry.orderedComposables
    }

    composables.WithAll {
        content()
    }
}

@Composable
private fun Iterator<ComposableServiceLoaderTarget>.WithAll(
    content: @Composable () -> Unit
) {
    if (hasNext()) {
        next().LoadModule {
            WithAll(
                content = content
            )
        }
    } else {
        content()
    }
}