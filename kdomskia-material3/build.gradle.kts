import io.kdomskia.npm
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
    androidNamespace = "io.kdomskia.material3"
)

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.kdomskiaUi)
            implementation(libs.compose.material3)
        }

        named("domMain").dependencies {
            api(npm("beercss", libs.versions.beercss))
        }
    }
}