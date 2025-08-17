group = "io.kdomskia"
version = "0.1.0"

allprojects {
    if (name in listOf("playground")) {
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
}