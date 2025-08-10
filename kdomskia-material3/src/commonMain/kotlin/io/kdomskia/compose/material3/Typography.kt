package io.kdomskia.compose.material3

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

internal typealias SkiaTypography = androidx.compose.material3.Typography

private val skiaDefaultTypography by lazy {
    SkiaTypography()
}

val SkiaTypography.kdomskia: Typography
    get() = Typography(
        displayLarge = displayLarge,
        displayMedium = displayMedium,
        displaySmall = displaySmall,
        headlineLarge = headlineLarge,
        headlineMedium = headlineMedium,
        headlineSmall = headlineSmall,
        titleLarge = titleLarge,
        titleMedium = titleMedium,
        titleSmall = titleSmall,
        bodyLarge = bodyLarge,
        bodyMedium = bodyMedium,
        bodySmall = bodySmall,
        labelLarge = labelLarge,
        labelMedium = labelMedium,
        labelSmall = labelSmall
    )

@Immutable
class Typography(
    val displayLarge: TextStyle = skiaDefaultTypography.displayLarge,
    val displayMedium: TextStyle = skiaDefaultTypography.displayMedium,
    val displaySmall: TextStyle = skiaDefaultTypography.displaySmall,
    val headlineLarge: TextStyle = skiaDefaultTypography.headlineLarge,
    val headlineMedium: TextStyle = skiaDefaultTypography.headlineMedium,
    val headlineSmall: TextStyle = skiaDefaultTypography.headlineSmall,
    val titleLarge: TextStyle = skiaDefaultTypography.titleLarge,
    val titleMedium: TextStyle = skiaDefaultTypography.titleMedium,
    val titleSmall: TextStyle = skiaDefaultTypography.titleSmall,
    val bodyLarge: TextStyle = skiaDefaultTypography.bodyLarge,
    val bodyMedium: TextStyle = skiaDefaultTypography.bodyMedium,
    val bodySmall: TextStyle = skiaDefaultTypography.bodySmall,
    val labelLarge: TextStyle = skiaDefaultTypography.labelLarge,
    val labelMedium: TextStyle = skiaDefaultTypography.labelMedium,
    val labelSmall: TextStyle = skiaDefaultTypography.labelSmall,
) {

    internal val _skia = SkiaTypography(
        displayLarge = displayLarge,
        displayMedium = displayMedium,
        displaySmall = displaySmall,
        headlineLarge = headlineLarge,
        headlineMedium = headlineMedium,
        headlineSmall = headlineSmall,
        titleLarge = titleLarge,
        titleMedium = titleMedium,
        titleSmall = titleSmall,
        bodyLarge = bodyLarge,
        bodyMedium = bodyMedium,
        bodySmall = bodySmall,
        labelLarge = labelLarge,
        labelMedium = labelMedium,
        labelSmall = labelSmall
    )

    fun copy(
        displayLarge: TextStyle = this.displayLarge,
        displayMedium: TextStyle = this.displayMedium,
        displaySmall: TextStyle = this.displaySmall,
        headlineLarge: TextStyle = this.headlineLarge,
        headlineMedium: TextStyle = this.headlineMedium,
        headlineSmall: TextStyle = this.headlineSmall,
        titleLarge: TextStyle = this.titleLarge,
        titleMedium: TextStyle = this.titleMedium,
        titleSmall: TextStyle = this.titleSmall,
        bodyLarge: TextStyle = this.bodyLarge,
        bodyMedium: TextStyle = this.bodyMedium,
        bodySmall: TextStyle = this.bodySmall,
        labelLarge: TextStyle = this.labelLarge,
        labelMedium: TextStyle = this.labelMedium,
        labelSmall: TextStyle = this.labelSmall
    ): Typography = Typography(
        displayLarge = displayLarge,
        displayMedium = displayMedium,
        displaySmall = displaySmall,
        headlineLarge = headlineLarge,
        headlineMedium = headlineMedium,
        headlineSmall = headlineSmall,
        titleLarge = titleLarge,
        titleMedium = titleMedium,
        titleSmall = titleSmall,
        bodyLarge = bodyLarge,
        bodyMedium = bodyMedium,
        bodySmall = bodySmall,
        labelLarge = labelLarge,
        labelMedium = labelMedium,
        labelSmall = labelSmall
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Typography) return false

        return this._skia == other._skia
    }

    override fun hashCode() = _skia.hashCode()

    override fun toString() = _skia.toString()

}