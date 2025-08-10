package io.kdomskia.compose.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

expect class PlatformContext

@Composable
internal expect fun providePlatformContext(): PlatformContext

val LocalPlatformContext = compositionLocalOf<PlatformContext> {
    throw IllegalStateException("No PlatformContext was provided.")
}