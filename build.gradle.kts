plugins {
    kotlin("jvm") version "1.6.21"
    jacoco
    id("io.gitlab.arturbosch.detekt")
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
}

subprojects {

    apply<JacocoPlugin>()
    apply<JavaPlugin>()
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "io.gitlab.arturbosch.detekt")


    detekt {
        autoCorrect = true
        buildUponDefaultConfig = true // preconfigure defaults
        allRules = false // activate all available (even unstable) rules.
    }


    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        systemProperty("cucumber.junit-platform.naming-strategy", "long")
    }

    tasks.jacocoTestReport {
        // Give jacoco the file generated with the cucumber tests for the coverage.
        executionData(files("$buildDir/jacoco/test.exec", "$buildDir/results/jacoco/cucumber.exec"))
        reports {
            xml.required.set(true)
        }
    }

    dependencies{
        testImplementation("org.hamcrest:hamcrest-all:1.3")
    }


}
