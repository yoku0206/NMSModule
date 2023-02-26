package me.yoku.craftbukkit_1_19_r2.nbt

import me.yoku.api.NBTCompound
import me.yoku.api.NBTList
import me.yoku.api.NBTType
import net.minecraft.nbt.CompoundTag
import org.bukkit.inventory.ItemStack
import java.util.*

interface NBTItem {

    fun getItem() : ItemStack

    fun set(key: String, value: Any) : NBTItem

    fun setBoolean(key: String, value: Boolean) : NBTItem

    fun setByte(key: String, value: Byte) : NBTItem

    fun setByteArray(key: String, value: ByteArray) : NBTItem

    fun setCompound(key: String, value: NBTCompound) : NBTItem

    fun setDouble(key: String, value: Double) : NBTItem

    fun setFloat(key: String, value: Float) : NBTItem

    fun setInt(key: String, value: Int) : NBTItem

    fun setIntArray(key: String, value: IntArray) : NBTItem

    fun setLong(key: String, value: Long) : NBTItem

    fun setLongArray(key: String, value: LongArray) : NBTItem

    fun setShort(key: String, value: Short) : NBTItem

    fun setString(key: String, value: String) : NBTItem

    fun setUUID(key: String, value: UUID) : NBTItem

    fun get(key: String) : Any?

    fun getBoolean(key: String) : Boolean

    fun getByte(key: String) : Byte

    fun getByteArray(key: String) : ByteArray

    fun getCompound(key: String) : NBTCompound

    fun getDouble(key: String) : Double

    fun getFloat(key: String) : Float

    fun getInt(key: String) : Int

    fun getIntArray(key: String) : IntArray

    fun getKeys() : Set<String>

    fun hasKey(key: String) : Boolean

    fun hasKeyOfType(key: String, type: NBTType) : Boolean

    fun hasUUID(key: String) : Boolean

    fun getListByte(key: String) : NBTList<Byte>

    fun getListShort(key: String) : NBTList<Short>

    fun getListInt(key: String) : NBTList<Int>

    fun getListLong(key: String) : NBTList<Long>

    fun getListFloat(key: String) : NBTList<Float>

    fun getListDouble(key: String) : NBTList<Double>

    fun getListByteArray(key: String) : NBTList<ByteArray>

    fun getListString(key: String) : NBTList<String>

    fun getListCompound(key: String) : NBTList<NBTCompound>

    fun getListIntArray(key: String) : NBTList<IntArray>

    fun getListLongArray(key: String) : NBTList<LongArray>

    fun getLong(key: String) : Long

    fun getLongArray(key: String) : LongArray

    fun getShort(key: String) : Short

    fun getString(key: String) : String

    fun getUUID(key: String) : UUID

    fun remove(key: String)

    fun toNMSTagString() : String

    fun getCompoundTag() : CompoundTag

    fun merge(compound: NBTCompound) : NBTItem

}