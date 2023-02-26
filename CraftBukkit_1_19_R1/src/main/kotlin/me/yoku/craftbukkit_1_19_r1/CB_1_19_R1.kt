package me.yoku.craftbukkit_1_19_r1

import net.minecraft.nbt.*
import org.bukkit.craftbukkit.v1_19_R1.inventory.CraftItemStack
import org.bukkit.inventory.ItemStack
import net.minecraft.world.item.ItemStack as NMSItemStack

@Suppress("ClassName", "unused")
class CB_1_19_R1 {

    fun asNMSCopy(item: ItemStack) : NMSItemStack { return CraftItemStack.asNMSCopy(item) }

    fun asBukkitCopy(item: NMSItemStack) : ItemStack { return CraftItemStack.asBukkitCopy(item) }

    fun toString(tag: CompoundTag) : String { return tag.asString }



}