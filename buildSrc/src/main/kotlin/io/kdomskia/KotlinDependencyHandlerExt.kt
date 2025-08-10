package io.kdomskia

import org.gradle.api.artifacts.Dependency
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.npm(
    name: String,
    version: Provider<String>
): Dependency = npm(
    name = name,
    version = version.get()
)

fun KotlinDependencyHandler.devNpm(
    name: String,
    version: Provider<String>
): Dependency = devNpm(
    name = name,
    version = version.get()
)