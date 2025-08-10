package io.kdomskia.navigation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestinationBuilder
import androidx.navigation.NavDestinationDsl
import androidx.navigation.NavType
import kotlin.reflect.KClass
import kotlin.reflect.KType

@NavDestinationDsl
class DomComposeNavigatorDestinationBuilder :
    NavDestinationBuilder<DomComposeNavigator.Destination> {

    private val composeNavigator: DomComposeNavigator
    private val content: @Composable (NavBackStackEntry) -> Unit

    constructor(
        navigator: DomComposeNavigator,
        route: String,
        content: @Composable (NavBackStackEntry) -> Unit
    ) : super(navigator, route) {
        this.composeNavigator = navigator
        this.content = content
    }

    constructor(
        navigator: DomComposeNavigator,
        route: KClass<*>,
        typeMap: Map<KType, NavType<*>>,
        content: @Composable (NavBackStackEntry) -> Unit
    ) : super(navigator, route, typeMap) {
        this.composeNavigator = navigator
        this.content = content
    }

    override fun instantiateDestination(): DomComposeNavigator.Destination {
        return DomComposeNavigator.Destination(composeNavigator, content)
    }

    override fun build(): DomComposeNavigator.Destination {
        return super.build()
    }

}