plugins {
    id("org.jetbrains.kotlin.jvm")
    id("com.github.johnrengelman.shadow")
    id("io.github.rancraftplayz.remapper")
}

dependencies {

    compileOnly(group = "org.spigotmc", name = "spigot", version = "1.19.2-R0.1-SNAPSHOT")

    remapLib("org.spigotmc:spigot:1.19.2-R0.1-SNAPSHOT:remapped-mojang")
    accessWidenerLib("org.spigotmc:spigot:1.19.2-SNAPSHOT:remapped-mojang")
}

spigot {
    version = "1.19.2"
}