package me.yoku.craftbukkit_1_17_r1.nbt

import me.yoku.api.INBTItem
import net.minecraft.nbt.CompoundTag
import org.bukkit.inventory.ItemStack

interface NBTItem : INBTItem {

    fun getItem() : ItemStack

    fun getCompoundTag() : CompoundTag

}