package io.kdomskia.compose.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

actual class PlatformContext

@Composable
internal actual fun providePlatformContext() = remember { PlatformContext() }