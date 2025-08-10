package io.kdomskia.navigation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.compose.rememberNavController as rememberSkiaNavController

@Composable
actual fun rememberNavController(
    vararg navigators: Navigator<out NavDestination>
): NavHostController = rememberSkiaNavController(*navigators)