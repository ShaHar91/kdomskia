package io.kdomskia.navigation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.get
import kotlin.reflect.KClass
import kotlin.reflect.KType

actual fun NavGraphBuilder.composable(
    route: String,
    arguments: List<NamedNavArgument>,
    deepLinks: List<NavDeepLink>,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    destination(
        DomComposeNavigatorDestinationBuilder(
            provider[DomComposeNavigator::class],
            route,
            content
        )
            .apply {
                arguments.forEach { (argumentName, argument) ->
                    argument(argumentName, argument)
                }
                deepLinks.forEach { deepLink -> deepLink(deepLink) }
            }
    )
}

actual inline fun <reified T : Any> NavGraphBuilder.composable(
    typeMap: Map<KType, NavType<*>>,
    deepLinks: List<NavDeepLink>,
    noinline content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        T::class,
        typeMap,
        deepLinks,
        content
    )
}

actual fun <T : Any> NavGraphBuilder.composable(
    route: KClass<T>,
    typeMap: Map<KType, NavType<*>>,
    deepLinks: List<NavDeepLink>,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    destination(
        DomComposeNavigatorDestinationBuilder(
            provider[DomComposeNavigator::class],
            route,
            typeMap,
            content
        )
            .apply {
                deepLinks.forEach { deepLink -> deepLink(deepLink) }
            }
    )
}