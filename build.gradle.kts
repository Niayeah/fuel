plugins {
    kotlin("multiplatform") version "1.8.21" apply false
    id("org.jetbrains.kotlinx.kover") version "0.7.0" apply false
}

val isReleaseBuild: Boolean
    get() = properties.containsKey("release")

allprojects {
    repositories {
        mavenCentral()
    }
    val artifactPublishVersion: String by project
    val artifactGroupId: String by project
    group = artifactGroupId
    version = if (isReleaseBuild) artifactPublishVersion else "main-SNAPSHOT"
}
