package io.kdomskia.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.bindToBrowserNavigation
import io.kdomskia.compose.navigation.settings.LocalNavigationSettings
import androidx.navigation.compose.rememberNavController as rememberSkiaNavController

@Composable
actual fun rememberNavController(
    vararg navigators: Navigator<out NavDestination>
): NavHostController {
    val navigatorArray = remember {
        (listOf(DomComposeNavigator()) + navigators).toTypedArray()
    }
    val navController = rememberSkiaNavController(*navigatorArray)

    if (LocalNavigationSettings.current.bindToWindow) {
        LaunchedEffect(Unit) {
            @OptIn(ExperimentalBrowserHistoryApi::class)
            navController.bindToBrowserNavigation()
        }
    }

    return navController
}