import io.kdomskia.devNpm
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    id("kotlin-multiplatform")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.plugin.serialization") version libs.versions.kotlin
    id("org.jetbrains.compose.hot-reload") version libs.versions.hotReload
}

val appId = "io.kdomskia.playground"

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    jvm("desktop") {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        mainRun {
            mainClass = "$appId.MainKt"
        }
    }

    js {
        useEsModules()
        browser {
            val outputFile = "app.js"
            runTask {
                mainOutputFileName = outputFile
            }
            commonWebpackConfig {
                cssSupport {
                    enabled = true
                }
                outputFileName = outputFile
            }
        }
        binaries.executable()
        compilerOptions {
            target.set("es2015")
        }
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            implementation(projects.kdomskiaUi)
            implementation(projects.kdomskiaMaterial3)
            implementation(projects.kdomskiaNavigation)
            implementation(compose.components.resources)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.material3.adaptive)
        }

        val domMain by creating {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.kotlinx.coroutines.js)
                implementation(devNpm("compression-webpack-plugin", libs.versions.compressionWebpackPlugin))
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.androidx.navigation.compose)
            }
        }

        val skiaMain by creating {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.coil.network.ktor3)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.androidx.navigation.compose)
            }
        }

        androidMain {
            dependsOn(skiaMain)
            dependencies {
                implementation(libs.androidx.activity.compose)
                implementation(libs.ktor.android)
            }
        }

        named("desktopMain") {
            dependsOn(skiaMain)
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(libs.kotlinx.coroutines.swing)
                implementation(libs.ktor.java)
            }
        }

        appleMain {
            dependsOn(skiaMain)
            dependencies {
                implementation(libs.ktor.darwin)
            }
        }

        jsMain {
            dependsOn(domMain)
        }
    }
}

android {
    namespace = appId
    compileSdk = (properties["compileSdk"] as String).toInt()

    defaultConfig {
        applicationId = appId
        minSdk = (properties["minSdk"] as String).toInt()
        targetSdk = (properties["targetSdk"] as String).toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

compose {
    resources {
        packageOfResClass = appId
    }

    desktop {
        application {
            mainClass = "$appId.MainKt"

            nativeDistributions {
                targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                packageName = appId
                packageVersion = "1.0.0"
            }
        }
    }
}