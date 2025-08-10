package io.kdomskia.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import io.kdomskia.compose.ui.Alignment
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.bindToNavigation
import androidx.navigation.compose.LocalOwnersProvider
import androidx.navigation.createGraph
import io.kdomskia.compose.foundation.layout.Box
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.navigation.settings.LocalNavigationSettings
import io.kdomskia.compose.ui.Modifier
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlinx.browser.window

@Composable
actual fun NavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier,
    contentAlignment: Alignment,
    route: String?,
    builder: NavGraphBuilder.() -> Unit
) {
    CheckKdomskiaInitialization()
    NavHost(
        navController = navController,
        graph = remember(route, startDestination, builder) {
            navController.createGraph(startDestination, route, builder)
        },
        modifier = modifier,
        contentAlignment = contentAlignment
    )
}

@Composable
actual fun NavHost(
    navController: NavHostController,
    startDestination: KClass<*>,
    modifier: Modifier,
    contentAlignment: Alignment,
    route: KClass<*>?,
    typeMap: Map<KType, NavType<*>>,
    builder: NavGraphBuilder.() -> Unit
) {
    CheckKdomskiaInitialization()
    NavHost(
        navController = navController,
        graph = remember(route, startDestination, builder) {
            navController.createGraph(startDestination, route, typeMap, builder)
        },
        modifier = modifier,
        contentAlignment = contentAlignment
    )
}

@Composable
actual fun NavHost(
    navController: NavHostController,
    startDestination: Any,
    modifier: Modifier,
    contentAlignment: Alignment,
    route: KClass<*>?,
    typeMap: Map<KType, NavType<*>>,
    builder: NavGraphBuilder.() -> Unit
) {
    CheckKdomskiaInitialization()
    NavHost(
        navController = navController,
        graph = remember(route, startDestination, builder) {
            navController.createGraph(startDestination, route, typeMap, builder)
        },
        modifier = modifier,
        contentAlignment = contentAlignment
    )
}

@Composable
actual fun NavHost(
    navController: NavHostController,
    graph: NavGraph,
    modifier: Modifier,
    contentAlignment: Alignment
) {
    CheckKdomskiaInitialization()

    val lifecycleOwner = LocalLifecycleOwner.current
    val viewModelStoreOwner =
        checkNotNull(LocalViewModelStoreOwner.current) {
            "NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner"
        }

    navController.setViewModelStore(viewModelStoreOwner.viewModelStore)

    navController.graph = graph

    DisposableEffect(lifecycleOwner) {
        navController.setLifecycleOwner(lifecycleOwner)
        onDispose {}
    }

    val saveableStateHolder = rememberSaveableStateHolder()

    val allVisibleEntries by navController.visibleEntries.collectAsState()

    val visibleEntries by remember {
        derivedStateOf {
            allVisibleEntries.filter { entry ->
                entry.destination.navigatorName == DomComposeNavigator.NAME
            }
        }
    }

    val backStackEntry: NavBackStackEntry? = visibleEntries.lastOrNull()

    if (backStackEntry != null) {
        Box(
            modifier = modifier,
            contentAlignment = contentAlignment
        ) {
            val currentEntry = visibleEntries.lastOrNull { entry -> backStackEntry == entry }

            currentEntry?.LocalOwnersProvider(saveableStateHolder) {
                (currentEntry.destination as DomComposeNavigator.Destination).content(currentEntry)
            }
        }
    }
}