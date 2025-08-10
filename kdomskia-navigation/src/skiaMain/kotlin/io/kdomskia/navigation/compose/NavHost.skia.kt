package io.kdomskia.navigation.compose

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Alignment
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Modifier
import kotlin.reflect.KClass
import kotlin.reflect.KType
import androidx.navigation.compose.NavHost as SkiaNavHost

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
    SkiaNavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.skia,
        contentAlignment = contentAlignment.skia,
        route = route,
        builder = builder
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
    SkiaNavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.skia,
        contentAlignment = contentAlignment.skia,
        route = route,
        typeMap = typeMap,
        builder = builder
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
    SkiaNavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.skia,
        contentAlignment = contentAlignment.skia,
        route = route,
        typeMap = typeMap,
        builder = builder
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
    SkiaNavHost(
        navController = navController,
        graph = graph,
        modifier = modifier.skia,
        contentAlignment = contentAlignment.skia
    )
}