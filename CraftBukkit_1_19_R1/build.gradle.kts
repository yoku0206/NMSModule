plugins {
    id("org.jetbrains.kotlin.jvm")
    id("com.github.johnrengelman.shadow")
    id("io.github.rancraftplayz.remapper")
}

dependencies {

    compileOnly(group = "org.spigotmc", name = "spigot", version = "1.19.2-R0.1-SNAPSHOT", classifier = "remapped-mojang")

    implementation(project(":API"))

    remapLib("org.spigotmc:spigot:1.19.2-R0.1-SNAPSHOT:remapped-mojang")
    accessWidenerLib("org.spigotmc:spigot:1.19.2-R0.1-SNAPSHOT:remapped-mojang")
}

spigot {
    version = "1.19.2"
}

tasks {

    shadowJar {

        archiveBaseName.set("${project.name}-${project.version}")
        archiveClassifier.set("")
        archiveVersion.set("")

    }

    remapJar {

        dependsOn(shadowJar)

    }

    build {

        dependsOn(remapJar)

    }

}