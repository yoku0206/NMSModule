plugins {
    id("org.jetbrains.kotlin.jvm")
    id("com.github.johnrengelman.shadow")
    id("io.github.patrick.remapper")
}

dependencies {

    compileOnly(group = "org.spigotmc", name = "spigot", version = "1.20.1-R0.1-SNAPSHOT", classifier = "remapped-mojang")

    implementation(project(":API")) { artifact { type = "jar" } }
    implementation(project(":API", configuration = "shadow"))
}

tasks {

    remap {

        version.set("1.20.1")

        dependsOn(shadowJar)
    }

    shadowJar {

        archiveBaseName.set("${project.name}-${project.version}")
        archiveClassifier.set("")
        archiveVersion.set("")

    }

    build {

        dependsOn(remap)

    }

}