import io.kdomskia.setupModule

plugins {
    id("com.android.library")
    id("kotlin-multiplatform")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlinx.atomicfu")
}

group = "io.kdomskia"
version = "1.0.0"

setupModule(
    androidNamespace = "io.kdomskia.core"
)

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(compose.runtime)
            implementation(compose.components.resources)
            implementation(compose.ui)
            implementation(compose.runtimeSaveable)
            implementation(libs.kotlinx.collections.immutable)
            implementation(libs.androidx.lifecycle.viewmodel.compose)
            implementation(libs.androidx.lifecycle.runtime.compose)
        }

        named("appleMain").dependencies {
            implementation(libs.okio)
        }
    }
}