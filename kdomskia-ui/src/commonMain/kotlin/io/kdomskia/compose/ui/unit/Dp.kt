package io.kdomskia.compose.ui.unit

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Density
import io.kdomskia.compose.ui.platform.LocalDensity

@Composable
fun Float.pxToDp() = pxToDp(LocalDensity.current)

fun Float.pxToDp(density: Density) = with(density) { this@pxToDp.toDp() }

@Composable
fun Int.pxToDp() = pxToDp(LocalDensity.current)

fun Int.pxToDp(density: Density) = with(density) { this@pxToDp.toDp() }