package me.yoku.api

import java.util.*

interface INBTItem<Tag, Item> {

    fun set(key: String, value: Any) : INBTItem<Tag, Item>

    fun setBoolean(key: String, value: Boolean) : INBTItem<Tag, Item>

    fun setByte(key: String, value: Byte) : INBTItem<Tag, Item>

    fun setByteArray(key: String, value: ByteArray) : INBTItem<Tag, Item>

    fun setCompound(key: String, value: NBTCompound<Tag>) : INBTItem<Tag, Item>

    fun setDouble(key: String, value: Double) : INBTItem<Tag, Item>

    fun setFloat(key: String, value: Float) : INBTItem<Tag, Item>

    fun setInt(key: String, value: Int) : INBTItem<Tag, Item>

    fun setIntArray(key: String, value: IntArray) : INBTItem<Tag, Item>

    fun setLong(key: String, value: Long) : INBTItem<Tag, Item>

    fun setLongArray(key: String, value: LongArray) : INBTItem<Tag, Item>

    fun setShort(key: String, value: Short) : INBTItem<Tag, Item>

    fun setString(key: String, value: String) : INBTItem<Tag, Item>

    fun setUUID(key: String, value: UUID) : INBTItem<Tag, Item>

    fun get(key: String) : Any?

    fun getBoolean(key: String) : Boolean

    fun getByte(key: String) : Byte

    fun getByteArray(key: String) : ByteArray

    fun getCompound(key: String) : NBTCompound<Tag>

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

    fun getListCompound(key: String) : NBTList<NBTCompound<Tag>>

    fun getListIntArray(key: String) : NBTList<IntArray>

    fun getListLongArray(key: String) : NBTList<LongArray>

    fun getLong(key: String) : Long

    fun getLongArray(key: String) : LongArray

    fun getShort(key: String) : Short

    fun getString(key: String) : String

    fun getUUID(key: String) : UUID

    fun remove(key: String)

    fun toNMSTagString() : String

    fun merge(compound: NBTCompound<Tag>) : INBTItem<Tag, Item>

    fun getItem() : Item

    fun getCompoundTag() : Tag

}