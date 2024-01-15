rootProject.name = "NMSModule"

include("CraftBukkit_1_19_R1")
include("Core")
include("API")
include("CraftBukkit_1_17_R1")
include("CraftBukkit_1_19_R2")
include("CraftBukkit_1_19_R3")
include("CraftBukkit_1_20_R1")
include("CraftBukkit_1_20_R2")
include("CraftBukkit_1_20_R3")

setOf("API", "Core",
    "CraftBukkit_1_17_R1",
    "CraftBukkit_1_19_R1", "CraftBukkit_1_19_R2", "CraftBukkit_1_19_R3",
    "CraftBukkit_1_20_R1", "CraftBukkit_1_20_R2", "CraftBukkit_1_20_R3"
).forEach { project(":$it").projectDir = file(it) }
