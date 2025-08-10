import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    `kotlin-dsl-base`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.plugin.android)
    implementation(libs.plugin.kotlin.multiplatform)
    implementation(libs.plugin.kotlin.compose.multiplatform)
    implementation(libs.plugin.kotlin.compose.compiler)
    implementation(libs.plugin.kotlin.atomicfu)
}

tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}

tasks.withType<KotlinJvmCompile>().configureEach {
    compilerOptions.jvmTarget = JvmTarget.JVM_17
}