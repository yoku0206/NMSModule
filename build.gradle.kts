@file:Suppress("SpellCheckingInspection")

import java.io.FileInputStream
import java.util.Properties

plugins {
    idea
    java
    kotlin("jvm") version "1.8.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.github.rancraftplayz.remapper") version "1.0.2"
    id("maven-publish")
}

group = "me.yoku"
version = "2.0"

val mcVersion = "1.17"
val github = Properties().apply { load(FileInputStream(File("${System.getenv("USERPROFILE")}/.m2/", "github.properties"))) }

allprojects {

    repositories {

        mavenCentral()
        mavenLocal()

        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://oss.sonatype.org/content/repositories/snapshots")

    }

}

subprojects {

    apply {

        plugin("org.jetbrains.kotlin.jvm")
        plugin("com.github.johnrengelman.shadow")
        plugin("io.github.rancraftplayz.remapper")

    }

    group = parent?.group ?: "me.yoku"
    version = parent?.version ?: "2.0"

    tasks.compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }

}

repositories {
    mavenCentral()
}

dependencies {

    implementation(project(":API", configuration = "shadow"))
    implementation(project(":Core", configuration = "shadow"))

//    implementation(project(":CraftBukkit_1_17_R1", configuration = "shadow"))
    implementation(project(":CraftBukkit_1_19_R1", configuration = "shadow"))
//    implementation(project(":CraftBukkit_1_19_R2", configuration = "shadow"))

}

tasks {

    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }

    artifacts {

        archives(shadowJar)

    }

    processResources {

        val placeholder = mapOf(
            "name" to rootProject.name,
            "version" to version,
            "apiVersion" to mcVersion,
            "kotlinVersion" to project.properties["kotlinVersion"]
        )

        filesMatching("plugin.yml") { expand(placeholder) }

    }

    shadowJar {

        archiveBaseName.set("${project.name}-${project.version}")
        archiveClassifier.set("")
        archiveVersion.set("")

        minimize() {
            exclude(project("API"))
            exclude(project(":Core"))
            exclude(project(":CraftBukkit_1_17_R1"))
            exclude(project(":CraftBukkit_1_19_R1"))
            exclude(project(":CraftBukkit_1_19_R2"))
        }

//        finalizedBy(remapJar)
    }

    remapJar {

        dependsOn(shadowJar)

    }

    build {
//        dependsOn(remapJar)
        dependsOn(shadowJar)
    }
}

artifacts {
    archives(tasks["shadowJar"])
}

publishing {

    publications {

        register<MavenPublication>("gpr") {

            groupId = rootProject.group as String
            artifactId = "nmsmodule"
            version = rootProject.version as String

//            from(components["java"])
//            artifact(tasks["shadowJar"])

            shadow.component(this)

            pom.withXml {

                val s = asString().toString()

                asString().clear().append(s.replace("<dependencies/>", ""))

            }
        }
    }

    repositories {

        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/yoku0206/NMSModule")
            credentials {
                username = github["gpr.user"] as String
                password = github["gpr.key"] as String
            }
        }
    }
}