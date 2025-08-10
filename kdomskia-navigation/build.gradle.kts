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
    androidNamespace = "io.kdomskia.navigation"
)

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.kdomskiaUi)
            api(libs.androidx.navigation.common)
            api(libs.androidx.navigation.runtime)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.androidx.lifecycle.viewmodel.compose)
            implementation(libs.androidx.navigation.compose)
        }

        named("skiaMain").dependencies {
            implementation(compose.animation)
        }
    }
}