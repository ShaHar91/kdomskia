package io.kdomskia.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

class DomComposeNavigator : Navigator<DomComposeNavigator.Destination>(NAME) {

    internal val isPop = mutableStateOf(false)

    override fun navigate(
        entries: List<NavBackStackEntry>,
        navOptions: NavOptions?,
        navigatorExtras: Extras?
    ) {
        entries.forEach { entry -> state.pushWithTransition(entry) }
        isPop.value = false
    }

    override fun createDestination(): Destination {
        return Destination(this) {}
    }

    override fun popBackStack(popUpTo: NavBackStackEntry, savedState: Boolean) {
        state.popWithTransition(popUpTo, savedState)
        isPop.value = true
    }

    @NavDestination.ClassType(Composable::class)
    class Destination : NavDestination {
        internal val content: @Composable (NavBackStackEntry) -> Unit

        constructor(navigator: DomComposeNavigator, content: @Composable (NavBackStackEntry) -> Unit) : super(navigator) {
            this.content = content
        }
    }

    internal companion object {

        internal const val NAME = "composable-js"

    }

}