package io.kdomskia.navigation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import kotlin.jvm.JvmSuppressWildcards
import kotlin.reflect.KClass
import kotlin.reflect.KType
import androidx.navigation.compose.composable as skiaComposable

actual fun NavGraphBuilder.composable(
    route: String,
    arguments: List<NamedNavArgument>,
    deepLinks: List<NavDeepLink>,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    skiaComposable(
        route = route,
        arguments = arguments,
        deepLinks = deepLinks,
        content = { content(it) }
    )
}

actual inline fun <reified T : Any> NavGraphBuilder.composable(
    typeMap: Map<KType, NavType<*>>,
    deepLinks: List<NavDeepLink>,
    noinline content: @Composable (NavBackStackEntry) -> Unit
) {
    skiaComposable<T>(
        typeMap = typeMap,
        deepLinks = deepLinks,
        content = { content(it) }
    )
}

actual fun <T : Any> NavGraphBuilder.composable(
    route: KClass<T>,
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>>,
    deepLinks: List<NavDeepLink>,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    skiaComposable(
        route = route,
        typeMap = typeMap,
        deepLinks = deepLinks,
        content = { content(it) }
    )
}