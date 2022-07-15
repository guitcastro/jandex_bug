plugins {
    id("org.jetbrains.kotlin.plugin.allopen").version("1.6.21")
    id ("org.kordamp.gradle.jandex") version "0.12.0"
    id("io.quarkus")
}


repositories {
    mavenCentral()
}

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.persistence.Entity")
}

dependencies {
    implementation(project(":domain"))
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    val quarkusPlatformGroupId: String by project
    val quarkusPlatformArtifactId: String by project
    val quarkusPlatformVersion: String by project
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-hibernate-orm-panache-kotlin")
    implementation("io.quarkus:quarkus-hibernate-orm-panache")
}
