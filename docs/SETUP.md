# Setup Guide

This guide covers project setup, dependencies, and Gradle configuration for Kdomskia.

## Gradle Dependencies

Add the core modules to your `commonMain` dependencies:

```kotlin
implementation("io.kdomskia:kdomskia-ui:0.1.0")
implementation("io.kdomskia:kdomskia-material3:0.1.0")
implementation("io.kdomskia:kdomskia-navigation:0.1.0")
```

Some dependencies of your project may add artifacts that will not work on `commonMain`, such as `androidx.foundation`, `androidx.ui`, `androidx.material3` and `androidx.navigation`.

Add the following script to `build.gradle.kts` at project root level to remove these artifacts from `commonMain`:

```kotlin
allprojects {
    afterEvaluate {
        configurations
            .flatMap { config ->
                config.hierarchy
                    .filter { it.name.startsWith("commonMain") }
                    .flatMap { it.dependencies.filterIsInstance<ModuleDependency>() }
            }
            .distinct()
            .forEach {
                it.exclude(group = "org.jetbrains.compose.foundation")
                it.exclude(group = "org.jetbrains.compose.material3")
                it.exclude(
                    group = "org.jetbrains.compose.ui",
                    module = "ui"
                )
                it.exclude(
                    group = "org.jetbrains.androidx.navigation",
                    module = "navigation-compose"
                )
            }
    }
}
```

Don't forget to add it again on specific source sets.

The module source sets may look like this:

```kotlin
commonMain.dependencies {
    implementation("io.kdomskia:kdomskia-ui:0.1.0")
    implementation("io.kdomskia:kdomskia-material3:0.1.0")
    implementation("io.kdomskia:kdomskia-navigation:0.1.0")
}

val domMain by creating {
    dependsOn(commonMain.get())
    dependencies {
        //Re-adding Kdomskia dependencies to restore previously removed AndroidX artifacts in root build.gradle.kts
        implementation("io.kdomskia:kdomskia-ui:0.1.0")
        implementation("io.kdomskia:kdomskia-material3:0.1.0")
        implementation("io.kdomskia:kdomskia-navigation:0.1.0")
    }
}

val skiaMain by creating {
    dependsOn(commonMain.get())
    dependencies {
        //Re-adding Kdomskia dependencies to restore previously removed AndroidX artifacts in root build.gradle.kts
        implementation("io.kdomskia:kdomskia-ui:0.1.0")
        implementation("io.kdomskia:kdomskia-material3:0.1.0")
        implementation("io.kdomskia:kdomskia-navigation:0.1.0")
    }
}
```