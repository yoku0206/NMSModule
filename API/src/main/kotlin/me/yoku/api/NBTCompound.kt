package me.yoku.api

import java.util.*

interface NBTCompound<T> : NBTAbstract {

    fun getNMSTag() : T

    fun setNMSTag(tag: T) : NBTCompound<T>

    fun clone() : NBTCompound<T>

    fun getType(key: String) : NBTType

    fun get(key: String) : Any?

    fun getBoolean(key: String) : Boolean

    fun getByte(key: String) : Byte

    fun getByteArray(key: String) : ByteArray

    fun getCompound(key: String) : NBTCompound<T>

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

    fun getListCompound(key: String) : NBTList<NBTCompound<T>>

    fun getListIntArray(key: String) : NBTList<Array<Int>>

    fun getListLongArray(key: String): NBTList<Array<Long>>

    fun getLong(key: String) : Long

    fun getLongArray(key: String) : LongArray

    fun getShort(key: String) : Short

    fun getString(key: String) : String

    fun getUUID(key: String) : UUID

    fun remove(key: String)

    fun set(key: String, value: Any) : NBTCompound<T>

    fun setBoolean(key: String, value: Boolean) : NBTCompound<T>

    fun setByte(key: String, value: Byte) : NBTCompound<T>

    fun setByteArray(key: String, value: ByteArray) : NBTCompound<T>

    fun setCompound(key: String, value: NBTCompound<T>) : NBTCompound<T>

    fun setDouble(key: String, value: Double) : NBTCompound<T>

    fun setFloat(key: String, value: Float) : NBTCompound<T>

    fun setInt(key: String, value: Int) : NBTCompound<T>

    fun setIntArray(key: String, value: IntArray) : NBTCompound<T>

    fun <R> setList(key: String, value: NBTList<R>) : NBTCompound<T>

    fun setLong(key: String, value: Long) : NBTCompound<T>

    fun setLongArray(key: String, value: LongArray) : NBTCompound<T>

    fun setShort(key: String, value: Short) : NBTCompound<T>

    fun setString(key: String, value: String) : NBTCompound<T>

    fun setUUID(key: String, value: UUID) : NBTCompound<T>

}