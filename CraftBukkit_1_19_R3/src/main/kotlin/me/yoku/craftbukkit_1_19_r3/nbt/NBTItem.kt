package me.yoku.craftbukkit_1_19_r3.nbt

import me.yoku.api.INBTItem
import net.minecraft.nbt.CompoundTag
import org.bukkit.inventory.ItemStack

interface NBTItem : INBTItem {

    fun getItem() : ItemStack

    fun getCompoundTag() : CompoundTag

}