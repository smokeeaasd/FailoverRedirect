plugins {
    alias(libs.plugins.kotlin.jvm)

    kotlin("kapt") version "2.2.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"

    application
}

repositories {
    mavenCentral()

    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    compileOnly("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
    kapt("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "com.smokeeaasd.failoverredirect.FailoverRedirectPlugin"
}

tasks {
    shadowJar {
        archiveFileName.set("FailoverRedirect.jar")
    }
}