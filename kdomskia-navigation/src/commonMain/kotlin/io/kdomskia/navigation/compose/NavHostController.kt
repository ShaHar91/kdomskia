package io.kdomskia.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.compose.currentBackStackEntryAsState as skiaCurrentBackStackEntryAsState

@Composable
fun NavController.currentBackStackEntryAsState(): State<NavBackStackEntry?> = skiaCurrentBackStackEntryAsState()

@Composable
expect fun rememberNavController(
    vararg navigators: Navigator<out NavDestination>
): NavHostController