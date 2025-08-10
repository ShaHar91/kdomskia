package io.kdomskia.compose.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import io.kdomskia.compose.owner.DomOwner

@Composable
actual fun PlatformApp(
    content: @Composable () -> Unit
) {
    val owner = remember { DomOwner() }

    LaunchedEffect(owner) {
        owner.init()
    }

    DisposableEffect(owner) {
        onDispose {
            owner.dispose()
        }
    }

    CompositionLocalProvider(
        LocalViewModelStoreOwner provides owner,
        LocalLifecycleOwner provides owner,
        LocalWindowInfo provides owner.windowInfo,
        LocalDensity provides owner.density,
        LocalLayoutDirection provides owner.layoutDirection
    ) {
        content()
    }
}