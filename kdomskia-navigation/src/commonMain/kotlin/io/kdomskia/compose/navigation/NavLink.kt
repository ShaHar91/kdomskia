package io.kdomskia.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.navigation.NavController
import io.kdomskia.compose.foundation.clickable
import io.kdomskia.compose.helper.getComposable
import io.kdomskia.compose.helper.skiaOnly
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.domOnly

@Composable
fun NavLink(
    modifier: Modifier = Modifier,
    navController: NavController,
    route: Any,
    content: @Composable NavLinkScope.() -> Unit
) {
    val scope = remember(navController, route) {
        NavLinkScope(
            navController = navController,
            route = route
        )
    }
    NavComposable(
        modifier = modifier.domOnly {
            clickable {
                scope.onNavigate?.invoke()
            }
        },
        navController = navController,
        route = route
    ) {
        content(scope)
    }
}


@Composable
fun NavExternalLink(
    modifier: Modifier = Modifier,
    uri: String,
    content: @Composable NavExternalLinkScope.() -> Unit
) {
    val uriHandler = getComposable(
        dom = { null },
        skia = { LocalUriHandler.current }
    )
    val scope = remember(uriHandler, uri) {
        NavExternalLinkScope(
            uriHandler = uriHandler,
            uri = uri
        )
    }
    NavExternalComposable(
        modifier = modifier.domOnly {
            clickable {
                scope.onNavigate?.invoke()
            }
        },
        uri = uri
    ) {
        content(scope)
    }
}

class NavLinkScope internal constructor(
    private val navController: NavController,
    private val route: Any
) {

    internal var onNavigate: (() -> Unit)? = null

    fun navigate(): () -> Unit = navigateThen { }

    fun navigateThen(
        action: () -> Unit
    ): () -> Unit = {
        skiaOnly {
            navController.navigate(route = route)
        }
        action()
    }.also {
        onNavigate = it
    }

}

class NavExternalLinkScope internal constructor(
    private val uriHandler: UriHandler?,
    private val uri: String
) {

    internal var onNavigate: (() -> Unit)? = null

    fun navigate(): () -> Unit = navigateThen { }

    fun navigateThen(
        action: () -> Unit
    ): () -> Unit = {
        skiaOnly {
            uriHandler?.openUri(uri)
        }
        action()
    }.also {
        onNavigate = it
    }

}

@Composable
internal expect fun NavComposable(
    modifier: Modifier,
    navController: NavController,
    route: Any,
    content: @Composable () -> Unit
)

@Composable
internal expect fun NavExternalComposable(
    modifier: Modifier,
    uri: String,
    content: @Composable () -> Unit
)