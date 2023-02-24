package me.yoku.craftbukkit_1_19_r1

import org.bukkit.craftbukkit.v1_19_R1.inventory.CraftItemStack
import org.bukkit.inventory.ItemStack

@Suppress("ClassName", "unused")
class CB_1_19_R1 {

    fun asNMSCopy(item: ItemStack) : net.minecraft.world.item.ItemStack {
        return CraftItemStack.asNMSCopy(item)
    }

    fun asBukkitCopy(item: net.minecraft.world.item.ItemStack) : ItemStack {
        return CraftItemStack.asBukkitCopy(item)
    }

}