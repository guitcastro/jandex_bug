pluginManagement {
    val quarkusPluginId: String by settings
    val quarkusPluginVersion: String by settings
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id(quarkusPluginId).version(quarkusPluginVersion) apply false
        kotlin("jvm") version "1.6.21" apply false
        jacoco apply false
        id("io.gitlab.arturbosch.detekt").version("1.20.0-RC1") apply false
    }
}


rootProject.name = "quarkus_template"
include("app")
include("domain")
include("data")
