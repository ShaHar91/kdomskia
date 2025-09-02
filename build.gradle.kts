import kotlinx.validation.ApiValidationExtension
import kotlinx.validation.ExperimentalBCVApi

plugins {
    alias(libs.plugins.binaryCompatibility)
}

extensions.configure<ApiValidationExtension> {
    nonPublicMarkers += "io/kdomskia/annotation/InternalKdomskiaApi"
    ignoredProjects += listOf("kdomskia-core")
    @OptIn(ExperimentalBCVApi::class)
    klib {
        enabled = true
    }
}