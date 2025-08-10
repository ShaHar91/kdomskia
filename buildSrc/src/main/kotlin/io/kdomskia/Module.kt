package io.kdomskia

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.setupModule(
    androidNamespace: String
) {
    setupKotlinOptions()
    setupTargets()
    setupHierarchy()
    setupAndroid(androidNamespace)
}

private fun Project.setupKotlinOptions() {
    plugins.withId("org.jetbrains.kotlin.multiplatform") {
        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.configureEach {
                languageSettings {
                    optIn("io.kdomskia.annotation.InternalKdomskiaApi")
                }
            }
            targets.configureEach {
                compilations.configureEach {
                    // https://youtrack.jetbrains.com/issue/KT-61573#focus=Comments-27-9822729.0-0
                    @Suppress("DEPRECATION")
                    compilerOptions.configure {
                        val arguments = listOf(
                            // https://kotlinlang.org/docs/compiler-reference.html#progressive
                            "-progressive",
                            // https://youtrack.jetbrains.com/issue/KT-61573
                            "-Xexpect-actual-classes",
                        )
                        freeCompilerArgs.addAll(arguments)
                    }
                }
            }
        }
    }
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            val arguments = mutableListOf<String>()

            // https://kotlinlang.org/docs/compiler-reference.html#progressive
            arguments += "-progressive"

            // Enable Java default method generation.
            arguments += "-Xjvm-default=all"

            // Generate smaller bytecode by not generating runtime not-null assertions.
            arguments += "-Xno-call-assertions0"

            arguments += "-Xno-param-assertions"
            arguments += "-Xno-receiver-assertions"

            arguments += "-opt-in=io.kdomskia.annotation.InternalKdomskiaApi"

            freeCompilerArgs.addAll(arguments)
        }
    }
}

private fun Project.setupTargets() {
    plugins.withId("org.jetbrains.kotlin.multiplatform") {
        extensions.configure<KotlinMultiplatformExtension> {
            jvm()

            androidTarget {
                publishLibraryVariants("release")
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }

            iosX64()
            iosArm64()
            iosSimulatorArm64()

            js {
                useEsModules()
                compilerOptions {
                    target.set("es2015")
                }
                browser()
                nodejs()
            }
        }
    }
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
private fun Project.setupHierarchy() {
    plugins.withId("org.jetbrains.kotlin.multiplatform") {
        extensions.configure<KotlinMultiplatformExtension> {
            applyHierarchyTemplate {
                withSourceSetTree(
                    KotlinSourceSetTree.main,
                    KotlinSourceSetTree.test,
                )

                common {
                    group("dom") {
                        withJs()
                    }
                    group("skia") {
                        withJvm()
                        withAndroidTarget()
                        group("apple") {
                            withApple()
                        }
                    }
                    group("jvmCommon") {
                        withJvm()
                        withAndroidTarget()
                    }
                    group("nonJvmCommon") {
                        withJs()
                        withApple()
                    }
                }
            }
        }
    }
}

private fun Project.setupAndroid(
    androidNamespace: String
) {
    extensions.configure<LibraryExtension> {
        namespace = androidNamespace

        compileSdk = (properties["compileSdk"] as String).toInt()
        defaultConfig {
            minSdk = (properties["minSdk"] as String).toInt()
        }
        sourceSets["main"].resources {
            srcDirs(
                "src/commonMain/resources",
                "src/jvmCommonMain/resources"
            )
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }
}