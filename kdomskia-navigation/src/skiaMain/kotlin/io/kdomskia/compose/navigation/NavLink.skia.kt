package io.kdomskia.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import io.kdomskia.compose.foundation.layout.Box
import io.kdomskia.compose.ui.Modifier

@Composable
internal actual fun NavComposable(
    modifier: Modifier,
    navController: NavController,
    route: Any,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        content()
    }
}

@Composable
internal actual fun NavExternalComposable(
    modifier: Modifier,
    uri: String,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        content()
    }
}