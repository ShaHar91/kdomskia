package io.kdomskia.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.serialization.generateHashCode
import androidx.navigation.serialization.generateRouteWithArgs
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.navigation.compose.currentBackStackEntryAsState
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer
import org.jetbrains.compose.web.dom.A

@Composable
internal actual fun NavComposable(
    modifier: Modifier,
    navController: NavController,
    route: Any,
    content: @Composable () -> Unit
) {
    val entry by navController.currentBackStackEntryAsState()
    val route = remember(navController, entry, route) {
        navController.getUrlOrNull(route)
    }
    A(
        href = route,
        attrs = modifier.dom.toAttrs()
    ) {
        content()
    }
}

@Composable
internal actual fun NavExternalComposable(
    modifier: Modifier,
    uri: String,
    content: @Composable (() -> Unit)
) {
    A(
        href = uri,
        attrs = modifier
            .dom
            .attrsModifier {
                attr("target", "_blank")
            }
            .toAttrs()
    ) {
        content()
    }
}

private fun NavController.getUrlOrNull(route: Any): String? {
    return try {
        "#" + generateRouteFilled(route)
    } catch (e: Throwable) {
        ""
    }
}

//TODO: Functions bellow are extracted from Compose codebase
//      Need to open a YouTrack request to make them public
@OptIn(InternalSerializationApi::class)
private fun <T : Any> NavController.generateRouteFilled(route: T): String {
    val id = route::class.serializer().generateHashCode()
    val destination = findDestinationComprehensive(graph, id, true)
    requireNotNull(destination) {
        "Destination with route ${route::class.simpleName} cannot be found " +
                "in navigation graph $graph"
    }
    return generateRouteWithArgs(
        route = route,
        typeMap = destination.arguments.mapValues { it.value.type }
    )
}

private fun findDestinationComprehensive(
    destination: NavDestination,
    destinationId: Int,
    searchChildren: Boolean,
    matchingDest: NavDestination? = null,
): NavDestination? {
    if (destination.id == destinationId) {
        when {
            matchingDest != null ->
                if (destination == matchingDest && destination.parent == matchingDest.parent)
                    return destination

            else -> return destination
        }
    }
    val currentGraph = destination as? NavGraph ?: destination.parent!!
    return currentGraph.findNodeComprehensive(
        destinationId,
        currentGraph,
        searchChildren,
        matchingDest
    )
}