package me.yoku.api

import java.util.*

interface NBTCompound : NBTAbstract {

    fun clone() : NBTCompound

    fun getType(key: String) : NBTType

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

    fun getList(key: String) : NBTList<Any>

    fun getListByte(key: String) : NBTList<Byte>

    fun getListShort(key: String) : NBTList<Short>

    fun getListInt(key: String) : NBTList<Int>

    fun getListLong(key: String) : NBTList<Long>

    fun getListFloat(key: String) : NBTList<Float>

    fun getListDouble(key: String) : NBTList<Double>

    fun getListByteArray(key: String) : NBTList<Array<Byte>>

    fun getListString(key: String) : NBTList<String>

    fun getListList(key: String) : NBTList<NBTList<Any>>

    fun getListCompound(key: String) : NBTList<NBTCompound>

    fun getListIntArray(key: String) : NBTList<Array<Int>>

    fun getListLongArray(key: String): NBTList<Array<Long>>

    fun getLong(key: String) : Long

    fun getLongArray(key: String) : LongArray

    fun getShort(key: String) : Short

    fun getString(key: String) : String

    fun getUUID(key: String) : UUID

    fun remove(key: String)

    fun set(key: String, value: Any) : NBTCompound

    fun setBoolean(key: String, value: Boolean) : NBTCompound

    fun setByte(key: String, value: Byte) : NBTCompound

    fun setByteArray(key: String, value: ByteArray) : NBTCompound

    fun setCompound(key: String, value: NBTCompound) : NBTCompound

    fun setDouble(key: String, value: Double) : NBTCompound

    fun setFloat(key: String, value: Float) : NBTCompound

    fun setInt(key: String, value: Int) : NBTCompound

    fun setIntArray(key: String, value: IntArray) : NBTCompound

    fun <T> setList(key: String, value: NBTList<T>) : NBTCompound

    fun setLong(key: String, value: Long) : NBTCompound

    fun setLongArray(key: String, value: LongArray) : NBTCompound

    fun setShort(key: String, value: Short) : NBTCompound

    fun setString(key: String, value: String) : NBTCompound

    fun setUUID(key: String, value: UUID) : NBTCompound

}