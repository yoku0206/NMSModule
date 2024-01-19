package me.yoku.craftbukkit_1_19_r3.nbt

import me.yoku.api.*
import net.minecraft.nbt.CompoundTag
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_19_R3.inventory.CraftItemStack
import org.bukkit.inventory.ItemStack
import java.util.*

@Suppress("unused")
open class CodeNBTItem : INBTItem<CompoundTag, ItemStack> {

    private var item: ItemStack
    private var nmsItem: net.minecraft.world.item.ItemStack
    private val tag: CompoundTag

    constructor(item: ItemStack) {

        this.item = item

        this.nmsItem = CraftItemStack.asNMSCopy(item)

        this.tag = this.nmsItem.tag ?: CompoundTag()
    }

    constructor(material: Material) {

        this.item = ItemStack(material)

        this.nmsItem = CraftItemStack.asNMSCopy(this.item)

        this.tag = this.nmsItem.tag ?: CompoundTag()
    }

    override fun getItem(): ItemStack {

        this.nmsItem.tag = tag

        return CraftItemStack.asBukkitCopy(this.nmsItem)
    }

    override fun set(key: String, value: Any): INBTItem<CompoundTag, ItemStack> {

        this.tag.merge(CodeNBTCompound().set(key, value).getNMSTag())

        return this
    }

    override fun setBoolean(key: String, value: Boolean): INBTItem<CompoundTag, ItemStack> {

        this.tag.putBoolean(key, value)

        return this
    }

    override fun setByte(key: String, value: Byte): INBTItem<CompoundTag, ItemStack> {

        this.tag.putByte(key, value)

        return this
    }

    override fun setByteArray(key: String, value: ByteArray): INBTItem<CompoundTag, ItemStack> {

        this.tag.putByteArray(key, value)

        return this
    }

    override fun setCompound(key: String, value: NBTCompound<CompoundTag>): INBTItem<CompoundTag, ItemStack> {

        this.tag.merge((value as CodeNBTCompound).getNMSTag())

        return this
    }

    override fun setDouble(key: String, value: Double): INBTItem<CompoundTag, ItemStack> {

        this.tag.putDouble(key, value)

        return this
    }

    override fun setFloat(key: String, value: Float): INBTItem<CompoundTag, ItemStack> {

        this.tag.putFloat(key, value)

        return this
    }

    override fun setInt(key: String, value: Int): INBTItem<CompoundTag, ItemStack> {

        this.tag.putInt(key, value)

        return this
    }

    override fun setIntArray(key: String, value: IntArray): INBTItem<CompoundTag, ItemStack> {

        this.tag.putIntArray(key, value)

        return this
    }

    override fun setLong(key: String, value: Long): INBTItem<CompoundTag, ItemStack> {

        this.tag.putLong(key, value)

        return this
    }

    override fun setLongArray(key: String, value: LongArray): INBTItem<CompoundTag, ItemStack> {

        this.tag.putLongArray(key, value)

        return this
    }

    override fun setShort(key: String, value: Short): INBTItem<CompoundTag, ItemStack> {

        this.tag.putShort(key, value)

        return this
    }

    override fun setString(key: String, value: String): INBTItem<CompoundTag, ItemStack> {

        this.tag.putString(key, value)

        return this
    }

    override fun setUUID(key: String, value: UUID): INBTItem<CompoundTag, ItemStack> {

        this.tag.putUUID(key, value)

        return this
    }

    override fun get(key: String): Any? { return CodeNBT.getData(this.tag.get(key)) }

    override fun getBoolean(key: String): Boolean { return this.tag.getBoolean(key) }

    override fun getByte(key: String): Byte { return this.tag.getByte(key) }

    override fun getByteArray(key: String): ByteArray { return this.tag.getByteArray(key) }

    override fun getCompound(key: String): NBTCompound<CompoundTag> { return CodeNBTCompound(this.tag.getCompound(key)) }

    override fun getDouble(key: String): Double { return this.tag.getDouble(key) }

    override fun getFloat(key: String): Float { return this.tag.getFloat(key) }

    override fun getInt(key: String): Int { return this.tag.getInt(key) }

    override fun getIntArray(key: String): IntArray { return this.tag.getIntArray(key) }

    override fun getKeys(): Set<String> { return this.tag.allKeys }

    override fun hasKey(key: String): Boolean { return this.tag.contains(key) }

    override fun hasKeyOfType(key: String, type: NBTType): Boolean { return this.tag.contains(key, CodeNBTType.toNMS(type).toInt()) }

    override fun hasUUID(key: String): Boolean { return this.tag.hasUUID(key) }

    private fun <T> getList(key: String, type: NBTType) : CodeNBTList<T> { return CodeNBTList(this.tag.getList(key, CodeNBTType.toNMS(type).toInt())) }

    override fun getListByte(key: String): NBTList<Byte> { return getList(key, NBTType.BYTE) }

    override fun getListShort(key: String): NBTList<Short> { return getList(key, NBTType.SHORT) }

    override fun getListInt(key: String): NBTList<Int> { return getList(key, NBTType.INTEGER) }

    override fun getListLong(key: String): NBTList<Long> { return getList(key, NBTType.LONG) }

    override fun getListFloat(key: String): NBTList<Float> { return getList(key, NBTType.FLOAT) }

    override fun getListDouble(key: String): NBTList<Double> { return getList(key, NBTType.DOUBLE) }

    override fun getListByteArray(key: String): NBTList<ByteArray> { return getList(key, NBTType.BYTE_ARRAY) }

    override fun getListString(key: String): NBTList<String> { return getList(key, NBTType.STRING) }

    override fun getListCompound(key: String): NBTList<NBTCompound<CompoundTag>> { return getList(key, NBTType.COMPOUND) }

    override fun getListIntArray(key: String): NBTList<IntArray> { return getList(key, NBTType.INTEGER_ARRAY) }

    override fun getListLongArray(key: String): NBTList<LongArray> { return getList(key, NBTType.LONG_ARRAY) }

    override fun getLong(key: String): Long { return this.tag.getLong(key) }

    override fun getLongArray(key: String): LongArray { return this.tag.getLongArray(key) }

    override fun getShort(key: String): Short { return this.tag.getShort(key) }

    override fun getString(key: String): String { return this.tag.getString(key) }

    override fun getUUID(key: String): UUID { return this.tag.getUUID(key) }

    override fun remove(key: String) { this.tag.remove(key) }

    override fun toNMSTagString() : String { return "{Count: ${this.item.amount}, id: ${this.item.type}, tag: ${this.tag.asString}}" }

    override fun getCompoundTag() : CompoundTag { return this.tag }

    override fun merge(compound: NBTCompound<CompoundTag>) : INBTItem<CompoundTag, ItemStack> {

        this.tag.merge((compound as CodeNBTCompound).getNMSTag())

        return this
    }

    companion object {

        fun convertStringToNBTItem(item: String) : INBTItem<CompoundTag, ItemStack>? {

            if (item.isEmpty()) return null

            val tag = CodeNBT.parseTag(item)

            val material = tag.getString("id").replace("minecraft:", "", true)

            if (material.isEmpty() || Material.values().find { it.toString().equals(material, true) } == null) return null

            var count = tag.getInt("Count")

            if (count == 0) count = 1

            val itemStack = CodeNBTItem(ItemStack(Material.valueOf(material.uppercase()), count))

            itemStack.getCompoundTag().merge((CodeNBT.parseTag(tag.get("tag").toString()) as CodeNBTCompound).getNMSTag())

            return itemStack
        }

    }

}