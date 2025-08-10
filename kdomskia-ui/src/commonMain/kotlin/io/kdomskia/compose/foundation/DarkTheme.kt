package io.kdomskia.compose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import androidx.compose.foundation.isSystemInDarkTheme as skiaIsSystemInDarkTheme

@Composable
@ReadOnlyComposable
fun isSystemInDarkTheme(): Boolean {
    CheckKdomskiaInitialization()
    return skiaIsSystemInDarkTheme()
}