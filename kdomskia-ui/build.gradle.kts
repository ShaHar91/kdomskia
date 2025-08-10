import io.kdomskia.setupModule

plugins {
    id("com.android.library")
    id("kotlin-multiplatform")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

group = "io.kdomskia"
version = "1.0.0"

setupModule(
    androidNamespace = "io.kdomskia.ui"
)

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.kdomskiaCore)
            api(compose.runtimeSaveable)
            api(libs.compose.ui.unit)
            api(libs.compose.ui.graphics)
            api(libs.compose.ui.geometry)
            api(libs.compose.ui.text)
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.components.resources)
        }

        named("domMain").dependencies {
            api(compose.html.core)
            api(libs.kotlin.css)
            api(libs.kobweb.core)
            api(libs.kobweb.compose.js)
        }

        named("skiaMain").dependencies {
            api(libs.coil.compose)
            api(libs.coil.svg)
        }
    }
}