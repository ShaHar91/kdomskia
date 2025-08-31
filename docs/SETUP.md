# Setup Guide

This guide covers project setup, dependencies, and Gradle configuration for Kdomskia.

If you’re not yet familiar with the Kotlin Multiplatform project structure, take a look at the [official docs](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-discover-project.html).

## Compatibility

Ensure your project uses the same Compose Multiplatform version as Kdomskia (`1.9.0-beta01`) to maintain compatibility.

## Gradle Dependencies

Add the core modules to your `commonMain` dependencies:

```kotlin
implementation("io.kdomskia:kdomskia-ui:0.1.0")
implementation("io.kdomskia:kdomskia-material3:0.1.0")
implementation("io.kdomskia:kdomskia-navigation:0.1.0")
```

It’s recommended to create dedicated `dom` and `skia` source sets to better organize platform-specific dependencies and logic.

In a multiplatform project setup:

- `js` should depend on `dom`
- `ios`, `android`, and `desktop` should depend on `skia`

```kotlin
/*
 Apply the usual plugins for a Compose Multiplatform project, such as:
 - Kotlin Multiplatform
 - Compose Multiplatform
 - Compose Compiler
 - Android Application
 
 Don’t forget to include the required configuration blocks as well, such as:
 android { ... } and compose.resources { ... } 
 */

kotlin {
    //Configure supported targets here like ios, android, jvm (desktop) and js

    applyDefaultHierarchyTemplate()

    sourceSets {
        val domMain by creating {
            dependsOn(commonMain.get())
        }

        val skiaMain by creating {
            dependsOn(commonMain.get())
        }

        androidMain {
            dependsOn(skiaMain)
        }

        named("desktopMain") {
            dependsOn(skiaMain)
        }

        iosMain {
            dependsOn(skiaMain)
        }

        jsMain {
            dependsOn(domMain)
        }
    }
}
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

Don't forget to add it again on specific source sets:

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