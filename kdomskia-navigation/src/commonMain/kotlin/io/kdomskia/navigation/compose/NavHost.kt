@file:JvmName("NavHostKt")
@file:JvmMultifileClass

package io.kdomskia.navigation.compose

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Alignment
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import io.kdomskia.compose.ui.Modifier
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlin.reflect.KClass
import kotlin.reflect.KType

@Composable
expect fun NavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    route: String? = null,
    builder: NavGraphBuilder.() -> Unit
)

@Composable
expect fun NavHost(
    navController: NavHostController,
    startDestination: KClass<*>,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    route: KClass<*>? = null,
    typeMap: Map<KType, NavType<*>> = emptyMap(),
    builder: NavGraphBuilder.() -> Unit
)

@Composable
expect fun NavHost(
    navController: NavHostController,
    startDestination: Any,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    route: KClass<*>? = null,
    typeMap: Map<KType, NavType<*>> = emptyMap(),
    builder: NavGraphBuilder.() -> Unit
)

@Composable
expect fun NavHost(
    navController: NavHostController,
    graph: NavGraph,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart
)