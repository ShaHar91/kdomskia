package io.kdomskia.compose.material3

import androidx.compose.material3.contentColorFor
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import androidx.compose.material3.LocalTonalElevationEnabled as SkiaLocalTonalElevationEnabled
import androidx.compose.material3.contentColorFor as skiaContentColorFor
import androidx.compose.material3.darkColorScheme as skiaDarkColorScheme
import androidx.compose.material3.lightColorScheme as skiaLightColorScheme

internal typealias SkiaColorScheme = androidx.compose.material3.ColorScheme

internal val SkiaColorScheme.kdomskia: ColorScheme
    get() = ColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceBright = surfaceBright,
        surfaceDim = surfaceDim,
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainerHigh,
        surfaceContainerHighest = surfaceContainerHighest,
        surfaceContainerLow = surfaceContainerLow,
        surfaceContainerLowest = surfaceContainerLowest,
        primaryFixed = primaryFixed,
        primaryFixedDim = primaryFixedDim,
        onPrimaryFixed = onPrimaryFixed,
        onPrimaryFixedVariant = onPrimaryFixedVariant,
        secondaryFixed = secondaryFixed,
        secondaryFixedDim = secondaryFixedDim,
        onSecondaryFixed = onSecondaryFixed,
        onSecondaryFixedVariant = onSecondaryFixedVariant,
        tertiaryFixed = tertiaryFixed,
        tertiaryFixedDim = tertiaryFixedDim,
        onTertiaryFixed = onTertiaryFixed,
        onTertiaryFixedVariant = onTertiaryFixedVariant
    )

@Immutable
class ColorScheme(
    primary: Color,
    onPrimary: Color,
    primaryContainer: Color,
    onPrimaryContainer: Color,
    inversePrimary: Color,
    secondary: Color,
    onSecondary: Color,
    secondaryContainer: Color,
    onSecondaryContainer: Color,
    tertiary: Color,
    onTertiary: Color,
    tertiaryContainer: Color,
    onTertiaryContainer: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    surfaceVariant: Color,
    onSurfaceVariant: Color,
    surfaceTint: Color,
    inverseSurface: Color,
    inverseOnSurface: Color,
    error: Color,
    onError: Color,
    errorContainer: Color,
    onErrorContainer: Color,
    outline: Color,
    outlineVariant: Color,
    scrim: Color,
    surfaceBright: Color,
    surfaceDim: Color,
    surfaceContainer: Color,
    surfaceContainerHigh: Color,
    surfaceContainerHighest: Color,
    surfaceContainerLow: Color,
    surfaceContainerLowest: Color,
    primaryFixed: Color,
    primaryFixedDim: Color,
    onPrimaryFixed: Color,
    onPrimaryFixedVariant: Color,
    secondaryFixed: Color,
    secondaryFixedDim: Color,
    onSecondaryFixed: Color,
    onSecondaryFixedVariant: Color,
    tertiaryFixed: Color,
    tertiaryFixedDim: Color,
    onTertiaryFixed: Color,
    onTertiaryFixedVariant: Color
) {

    internal val _skia = SkiaColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceBright = surfaceBright,
        surfaceDim = surfaceDim,
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainerHigh,
        surfaceContainerHighest = surfaceContainerHighest,
        surfaceContainerLow = surfaceContainerLow,
        surfaceContainerLowest = surfaceContainerLowest,
        primaryFixed = primaryFixed,
        primaryFixedDim = primaryFixedDim,
        onPrimaryFixed = onPrimaryFixed,
        onPrimaryFixedVariant = onPrimaryFixedVariant,
        secondaryFixed = secondaryFixed,
        secondaryFixedDim = secondaryFixedDim,
        onSecondaryFixed = onSecondaryFixed,
        onSecondaryFixedVariant = onSecondaryFixedVariant,
        tertiaryFixed = tertiaryFixed,
        tertiaryFixedDim = tertiaryFixedDim,
        onTertiaryFixed = onTertiaryFixed,
        onTertiaryFixedVariant = onTertiaryFixedVariant
    )

    val primary: Color
        get() = _skia.primary

    val onPrimary: Color
        get() = _skia.onPrimary

    val primaryContainer: Color
        get() = _skia.primaryContainer

    val onPrimaryContainer: Color
        get() = _skia.onPrimaryContainer

    val inversePrimary: Color
        get() = _skia.inversePrimary

    val secondary: Color
        get() = _skia.secondary

    val onSecondary: Color
        get() = _skia.onSecondary

    val secondaryContainer: Color
        get() = _skia.secondaryContainer

    val onSecondaryContainer: Color
        get() = _skia.onSecondaryContainer

    val tertiary: Color
        get() = _skia.tertiary

    val onTertiary: Color
        get() = _skia.onTertiary

    val tertiaryContainer: Color
        get() = _skia.tertiaryContainer

    val onTertiaryContainer: Color
        get() = _skia.onTertiaryContainer

    val background: Color
        get() = _skia.background

    val onBackground: Color
        get() = _skia.onBackground

    val surface: Color
        get() = _skia.surface

    val onSurface: Color
        get() = _skia.onSurface

    val surfaceVariant: Color
        get() = _skia.surfaceVariant

    val onSurfaceVariant: Color
        get() = _skia.onSurfaceVariant

    val surfaceTint: Color
        get() = _skia.surfaceTint

    val inverseSurface: Color
        get() = _skia.inverseSurface

    val inverseOnSurface: Color
        get() = _skia.inverseOnSurface

    val error: Color
        get() = _skia.error

    val onError: Color
        get() = _skia.onError

    val errorContainer: Color
        get() = _skia.errorContainer

    val onErrorContainer: Color
        get() = _skia.onErrorContainer

    val outline: Color
        get() = _skia.outline

    val outlineVariant: Color
        get() = _skia.outlineVariant

    val scrim: Color
        get() = _skia.scrim

    val surfaceBright: Color
        get() = _skia.surfaceBright

    val surfaceDim: Color
        get() = _skia.surfaceDim

    val surfaceContainer: Color
        get() = _skia.surfaceContainer

    val surfaceContainerHigh: Color
        get() = _skia.surfaceContainerHigh

    val surfaceContainerHighest: Color
        get() = _skia.surfaceContainerHighest

    val surfaceContainerLow: Color
        get() = _skia.surfaceContainerLow

    val surfaceContainerLowest: Color
        get() = _skia.surfaceContainerLowest

    val primaryFixed: Color
        get() = _skia.primaryFixed

    val primaryFixedDim: Color
        get() = _skia.primaryFixedDim

    val onPrimaryFixed: Color
        get() = _skia.onPrimaryFixed

    val onPrimaryFixedVariant: Color
        get() = _skia.onPrimaryFixedVariant

    val secondaryFixed: Color
        get() = _skia.secondaryFixed

    val secondaryFixedDim: Color
        get() = _skia.secondaryFixedDim

    val onSecondaryFixed: Color
        get() = _skia.onSecondaryFixed

    val onSecondaryFixedVariant: Color
        get() = _skia.onSecondaryFixedVariant

    val tertiaryFixed: Color
        get() = _skia.tertiaryFixed

    val tertiaryFixedDim: Color
        get() = _skia.tertiaryFixedDim

    val onTertiaryFixed: Color
        get() = _skia.onTertiaryFixed

    val onTertiaryFixedVariant: Color
        get() = _skia.onTertiaryFixedVariant

    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryContainer: Color = this.primaryContainer,
        onPrimaryContainer: Color = this.onPrimaryContainer,
        inversePrimary: Color = this.inversePrimary,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        secondaryContainer: Color = this.secondaryContainer,
        onSecondaryContainer: Color = this.onSecondaryContainer,
        tertiary: Color = this.tertiary,
        onTertiary: Color = this.onTertiary,
        tertiaryContainer: Color = this.tertiaryContainer,
        onTertiaryContainer: Color = this.onTertiaryContainer,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        surfaceVariant: Color = this.surfaceVariant,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        surfaceTint: Color = this.surfaceTint,
        inverseSurface: Color = this.inverseSurface,
        inverseOnSurface: Color = this.inverseOnSurface,
        error: Color = this.error,
        onError: Color = this.onError,
        errorContainer: Color = this.errorContainer,
        onErrorContainer: Color = this.onErrorContainer,
        outline: Color = this.outline,
        outlineVariant: Color = this.outlineVariant,
        scrim: Color = this.scrim,
        surfaceBright: Color = this.surfaceBright,
        surfaceDim: Color = this.surfaceDim,
        surfaceContainer: Color = this.surfaceContainer,
        surfaceContainerHigh: Color = this.surfaceContainerHigh,
        surfaceContainerHighest: Color = this.surfaceContainerHighest,
        surfaceContainerLow: Color = this.surfaceContainerLow,
        surfaceContainerLowest: Color = this.surfaceContainerLowest,
        primaryFixed: Color = this.primaryFixed,
        primaryFixedDim: Color = this.primaryFixedDim,
        onPrimaryFixed: Color = this.onPrimaryFixed,
        onPrimaryFixedVariant: Color = this.onPrimaryFixedVariant,
        secondaryFixed: Color = this.secondaryFixed,
        secondaryFixedDim: Color = this.secondaryFixedDim,
        onSecondaryFixed: Color = this.onSecondaryFixed,
        onSecondaryFixedVariant: Color = this.onSecondaryFixedVariant,
        tertiaryFixed: Color = this.tertiaryFixed,
        tertiaryFixedDim: Color = this.tertiaryFixedDim,
        onTertiaryFixed: Color = this.onTertiaryFixed,
        onTertiaryFixedVariant: Color = this.onTertiaryFixedVariant
    ): ColorScheme = ColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceBright = surfaceBright,
        surfaceDim = surfaceDim,
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainerHigh,
        surfaceContainerHighest = surfaceContainerHighest,
        surfaceContainerLow = surfaceContainerLow,
        surfaceContainerLowest = surfaceContainerLowest,
        primaryFixed = primaryFixed,
        primaryFixedDim = primaryFixedDim,
        onPrimaryFixed = onPrimaryFixed,
        onPrimaryFixedVariant = onPrimaryFixedVariant,
        secondaryFixed = secondaryFixed,
        secondaryFixedDim = secondaryFixedDim,
        onSecondaryFixed = onSecondaryFixed,
        onSecondaryFixedVariant = onSecondaryFixedVariant,
        tertiaryFixed = tertiaryFixed,
        tertiaryFixedDim = tertiaryFixedDim,
        onTertiaryFixed = onTertiaryFixed,
        onTertiaryFixedVariant = onTertiaryFixedVariant
    )

    override fun toString() = _skia.toString()

}

private val defaultSkiaLightScheme: SkiaColorScheme by lazy {
    skiaLightColorScheme()
}

private val defaultSkiaDarkScheme: SkiaColorScheme by lazy {
    skiaDarkColorScheme()
}

fun lightColorScheme(
    primary: Color = defaultSkiaLightScheme.primary,
    onPrimary: Color = defaultSkiaLightScheme.onPrimary,
    primaryContainer: Color = defaultSkiaLightScheme.primaryContainer,
    onPrimaryContainer: Color = defaultSkiaLightScheme.onPrimaryContainer,
    inversePrimary: Color = defaultSkiaLightScheme.inversePrimary,
    secondary: Color = defaultSkiaLightScheme.secondary,
    onSecondary: Color = defaultSkiaLightScheme.onSecondary,
    secondaryContainer: Color = defaultSkiaLightScheme.secondaryContainer,
    onSecondaryContainer: Color = defaultSkiaLightScheme.onSecondaryContainer,
    tertiary: Color = defaultSkiaLightScheme.tertiary,
    onTertiary: Color = defaultSkiaLightScheme.onTertiary,
    tertiaryContainer: Color = defaultSkiaLightScheme.tertiaryContainer,
    onTertiaryContainer: Color = defaultSkiaLightScheme.onTertiaryContainer,
    background: Color = defaultSkiaLightScheme.background,
    onBackground: Color = defaultSkiaLightScheme.onBackground,
    surface: Color = defaultSkiaLightScheme.surface,
    onSurface: Color = defaultSkiaLightScheme.onSurface,
    surfaceVariant: Color = defaultSkiaLightScheme.surfaceVariant,
    onSurfaceVariant: Color = defaultSkiaLightScheme.onSurfaceVariant,
    surfaceTint: Color = defaultSkiaLightScheme.surfaceTint,
    inverseSurface: Color = defaultSkiaLightScheme.inverseSurface,
    inverseOnSurface: Color = defaultSkiaLightScheme.inverseOnSurface,
    error: Color = defaultSkiaLightScheme.error,
    onError: Color = defaultSkiaLightScheme.onError,
    errorContainer: Color = defaultSkiaLightScheme.errorContainer,
    onErrorContainer: Color = defaultSkiaLightScheme.onErrorContainer,
    outline: Color = defaultSkiaLightScheme.outline,
    outlineVariant: Color = defaultSkiaLightScheme.outlineVariant,
    scrim: Color = defaultSkiaLightScheme.scrim,
    surfaceBright: Color = defaultSkiaLightScheme.surfaceBright,
    surfaceDim: Color = defaultSkiaLightScheme.surfaceDim,
    surfaceContainer: Color = defaultSkiaLightScheme.surfaceContainer,
    surfaceContainerHigh: Color = defaultSkiaLightScheme.surfaceContainerHigh,
    surfaceContainerHighest: Color = defaultSkiaLightScheme.surfaceContainerHighest,
    surfaceContainerLow: Color = defaultSkiaLightScheme.surfaceContainerLow,
    surfaceContainerLowest: Color = defaultSkiaLightScheme.surfaceContainerLowest,
    primaryFixed: Color = defaultSkiaLightScheme.primaryFixed,
    primaryFixedDim: Color = defaultSkiaLightScheme.primaryFixedDim,
    onPrimaryFixed: Color = defaultSkiaLightScheme.onPrimaryFixed,
    onPrimaryFixedVariant: Color = defaultSkiaLightScheme.onPrimaryFixedVariant,
    secondaryFixed: Color = defaultSkiaLightScheme.secondaryFixed,
    secondaryFixedDim: Color = defaultSkiaLightScheme.secondaryFixedDim,
    onSecondaryFixed: Color = defaultSkiaLightScheme.onSecondaryFixed,
    onSecondaryFixedVariant: Color = defaultSkiaLightScheme.onSecondaryFixedVariant,
    tertiaryFixed: Color = defaultSkiaLightScheme.tertiaryFixed,
    tertiaryFixedDim: Color = defaultSkiaLightScheme.tertiaryFixedDim,
    onTertiaryFixed: Color = defaultSkiaLightScheme.onTertiaryFixed,
    onTertiaryFixedVariant: Color = defaultSkiaLightScheme.onTertiaryFixedVariant
): ColorScheme = ColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    inversePrimary = inversePrimary,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,
    surfaceTint = surfaceTint,
    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,
    outline = outline,
    outlineVariant = outlineVariant,
    scrim = scrim,
    surfaceBright = surfaceBright,
    surfaceDim = surfaceDim,
    surfaceContainer = surfaceContainer,
    surfaceContainerHigh = surfaceContainerHigh,
    surfaceContainerHighest = surfaceContainerHighest,
    surfaceContainerLow = surfaceContainerLow,
    surfaceContainerLowest = surfaceContainerLowest,
    primaryFixed = primaryFixed,
    primaryFixedDim = primaryFixedDim,
    onPrimaryFixed = onPrimaryFixed,
    onPrimaryFixedVariant = onPrimaryFixedVariant,
    secondaryFixed = secondaryFixed,
    secondaryFixedDim = secondaryFixedDim,
    onSecondaryFixed = onSecondaryFixed,
    onSecondaryFixedVariant = onSecondaryFixedVariant,
    tertiaryFixed = tertiaryFixed,
    tertiaryFixedDim = tertiaryFixedDim,
    onTertiaryFixed = onTertiaryFixed,
    onTertiaryFixedVariant = onTertiaryFixedVariant
)

fun darkColorScheme(
    primary: Color = defaultSkiaDarkScheme.primary,
    onPrimary: Color = defaultSkiaDarkScheme.onPrimary,
    primaryContainer: Color = defaultSkiaDarkScheme.primaryContainer,
    onPrimaryContainer: Color = defaultSkiaDarkScheme.onPrimaryContainer,
    inversePrimary: Color = defaultSkiaDarkScheme.inversePrimary,
    secondary: Color = defaultSkiaDarkScheme.secondary,
    onSecondary: Color = defaultSkiaDarkScheme.onSecondary,
    secondaryContainer: Color = defaultSkiaDarkScheme.secondaryContainer,
    onSecondaryContainer: Color = defaultSkiaDarkScheme.onSecondaryContainer,
    tertiary: Color = defaultSkiaDarkScheme.tertiary,
    onTertiary: Color = defaultSkiaDarkScheme.onTertiary,
    tertiaryContainer: Color = defaultSkiaDarkScheme.tertiaryContainer,
    onTertiaryContainer: Color = defaultSkiaDarkScheme.onTertiaryContainer,
    background: Color = defaultSkiaDarkScheme.background,
    onBackground: Color = defaultSkiaDarkScheme.onBackground,
    surface: Color = defaultSkiaDarkScheme.surface,
    onSurface: Color = defaultSkiaDarkScheme.onSurface,
    surfaceVariant: Color = defaultSkiaDarkScheme.surfaceVariant,
    onSurfaceVariant: Color = defaultSkiaDarkScheme.onSurfaceVariant,
    surfaceTint: Color = defaultSkiaDarkScheme.surfaceTint,
    inverseSurface: Color = defaultSkiaDarkScheme.inverseSurface,
    inverseOnSurface: Color = defaultSkiaDarkScheme.inverseOnSurface,
    error: Color = defaultSkiaDarkScheme.error,
    onError: Color = defaultSkiaDarkScheme.onError,
    errorContainer: Color = defaultSkiaDarkScheme.errorContainer,
    onErrorContainer: Color = defaultSkiaDarkScheme.onErrorContainer,
    outline: Color = defaultSkiaDarkScheme.outline,
    outlineVariant: Color = defaultSkiaDarkScheme.outlineVariant,
    scrim: Color = defaultSkiaDarkScheme.scrim,
    surfaceBright: Color = defaultSkiaDarkScheme.surfaceBright,
    surfaceDim: Color = defaultSkiaDarkScheme.surfaceDim,
    surfaceContainer: Color = defaultSkiaDarkScheme.surfaceContainer,
    surfaceContainerHigh: Color = defaultSkiaDarkScheme.surfaceContainerHigh,
    surfaceContainerHighest: Color = defaultSkiaDarkScheme.surfaceContainerHighest,
    surfaceContainerLow: Color = defaultSkiaDarkScheme.surfaceContainerLow,
    surfaceContainerLowest: Color = defaultSkiaDarkScheme.surfaceContainerLowest,
    primaryFixed: Color = defaultSkiaDarkScheme.primaryFixed,
    primaryFixedDim: Color = defaultSkiaDarkScheme.primaryFixedDim,
    onPrimaryFixed: Color = defaultSkiaDarkScheme.onPrimaryFixed,
    onPrimaryFixedVariant: Color = defaultSkiaDarkScheme.onPrimaryFixedVariant,
    secondaryFixed: Color = defaultSkiaDarkScheme.secondaryFixed,
    secondaryFixedDim: Color = defaultSkiaDarkScheme.secondaryFixedDim,
    onSecondaryFixed: Color = defaultSkiaDarkScheme.onSecondaryFixed,
    onSecondaryFixedVariant: Color = defaultSkiaDarkScheme.onSecondaryFixedVariant,
    tertiaryFixed: Color = defaultSkiaDarkScheme.tertiaryFixed,
    tertiaryFixedDim: Color = defaultSkiaDarkScheme.tertiaryFixedDim,
    onTertiaryFixed: Color = defaultSkiaDarkScheme.onTertiaryFixed,
    onTertiaryFixedVariant: Color = defaultSkiaDarkScheme.onTertiaryFixedVariant
): ColorScheme = ColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    inversePrimary = inversePrimary,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,
    surfaceTint = surfaceTint,
    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,
    outline = outline,
    outlineVariant = outlineVariant,
    scrim = scrim,
    surfaceBright = surfaceBright,
    surfaceDim = surfaceDim,
    surfaceContainer = surfaceContainer,
    surfaceContainerHigh = surfaceContainerHigh,
    surfaceContainerHighest = surfaceContainerHighest,
    surfaceContainerLow = surfaceContainerLow,
    surfaceContainerLowest = surfaceContainerLowest,
    primaryFixed = primaryFixed,
    primaryFixedDim = primaryFixedDim,
    onPrimaryFixed = onPrimaryFixed,
    onPrimaryFixedVariant = onPrimaryFixedVariant,
    secondaryFixed = secondaryFixed,
    secondaryFixedDim = secondaryFixedDim,
    onSecondaryFixed = onSecondaryFixed,
    onSecondaryFixedVariant = onSecondaryFixedVariant,
    tertiaryFixed = tertiaryFixed,
    tertiaryFixedDim = tertiaryFixedDim,
    onTertiaryFixed = onTertiaryFixed,
    onTertiaryFixedVariant = onTertiaryFixedVariant
)

@Stable
fun ColorScheme.contentColorFor(backgroundColor: Color): Color = _skia.contentColorFor(backgroundColor)

@Composable
@ReadOnlyComposable
fun contentColorFor(backgroundColor: Color) = skiaContentColorFor(backgroundColor)

@Stable
fun ColorScheme.surfaceColorAtElevation(
    elevation: Dp,
): Color = _skia.surfaceColorAtElevation(elevation)

@Composable
@ReadOnlyComposable
internal fun ColorScheme.applyTonalElevation(backgroundColor: Color, elevation: Dp): Color {
    val tonalElevationEnabled = LocalTonalElevationEnabled.current
    return if (backgroundColor == surface && tonalElevationEnabled) {
        surfaceColorAtElevation(elevation)
    } else {
        backgroundColor
    }
}

object LocalTonalElevationEnabled {

    inline val current: Boolean
        @ReadOnlyComposable
        @Composable
        get() = SkiaLocalTonalElevationEnabled.current

}

@Composable
fun ProvideTonalElevationEnabled(
    enabled: Boolean,
    content: @Composable () -> Unit
) {
    CheckKdomskiaInitialization()
    CompositionLocalProvider(
        SkiaLocalTonalElevationEnabled provides enabled,
        content = content
    )
}