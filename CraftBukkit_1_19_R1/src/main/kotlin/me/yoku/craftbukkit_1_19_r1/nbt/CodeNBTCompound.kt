package me.yoku.craftbukkit_1_19_r1.nbt

import me.yoku.api.CodeNBTType
import me.yoku.api.NBTCompound
import me.yoku.api.NBTList
import me.yoku.api.NBTType
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.ListTag
import java.util.*

@Suppress("unused", "MemberVisibilityCanBePrivate")
open class CodeNBTCompound : NBTCompound {

    private var tag: CompoundTag

    constructor() {

        this.tag = CompoundTag()

    }

    constructor(tag: CompoundTag) {

        this.tag = tag

    }

    fun getNMSTag() : CompoundTag { return this.tag }

    fun setNMSTag(tag: CompoundTag) : CodeNBTCompound {

        this.tag = tag

        return this
    }

    override fun getType() : NBTType {
        return CodeNBTType.fromNMS(this.tag.id.toInt())
    }

    override fun clone(): CodeNBTCompound {
        return CodeNBTCompound(this.tag.copy())
    }

    override fun getType(key: String): NBTType {
        return CodeNBTType.fromNMS(this.tag.getTagType(key).toInt())
    }

    override fun hasKeyOfType(key: String, type: NBTType) : Boolean {
        return getNMSTag().contains(key, CodeNBTType.toNMS(type).toInt())
    }

    override fun hasUUID(key: String) : Boolean {
        return getNMSTag().hasUUID(key)
    }

    override fun getList(key: String) : NBTList<Any> {

        var nbtTagList = getNMSTag().get(key) as ListTag?

        if (nbtTagList.isNullOrEmpty()) {

            nbtTagList = ListTag()

            getNMSTag().put(key, nbtTagList)

        }

        return CodeNBTList(nbtTagList)

    }

    fun <T> getList(key: String, type: NBTType) : NBTList<T> {

        var nbtTagList = getNMSTag().getList(key, CodeNBTType.toNMS(type).toInt())

        if (nbtTagList.size == 0) {

            nbtTagList = ListTag()
            getNMSTag().put(key, nbtTagList)

        }

        return CodeNBTList(nbtTagList)

    }

    override fun getListByte(key: String) : NBTList<Byte> {
        return getList(key, NBTType.BYTE)
    }

    override fun getListShort(key: String) : NBTList<Short> {
        return getList(key, NBTType.SHORT)
    }

    override fun getListInt(key: String) : NBTList<Int> {
        return getList(key, NBTType.INTEGER)
    }

    override fun getListLong(key: String) : NBTList<Long> {
        return getList(key, NBTType.LONG)
    }

    override fun getListFloat(key: String) : NBTList<Float> {
        return getList(key, NBTType.FLOAT)
    }

    override fun getListDouble(key: String) : NBTList<Double> {
        return getList(key, NBTType.DOUBLE)
    }

    override fun getListByteArray(key: String) : NBTList<Array<Byte>> {
        return getList(key, NBTType.BYTE_ARRAY)
    }

    override fun getListString(key: String) : NBTList<String> {
        return getList(key, NBTType.STRING)
    }

    override fun getListList(key: String) : NBTList<NBTList<Any>> {
        return getList(key, NBTType.LIST)
    }

    override fun getListCompound(key: String) : NBTList<NBTCompound> {
        return getList(key, NBTType.COMPOUND)
    }

    override fun getListIntArray(key: String) : NBTList<Array<Int>> {
        return getList(key, NBTType.INTEGER_ARRAY)
    }

    override fun getListLongArray(key: String) : NBTList<Array<Long>> {
        return getList(key, NBTType.LONG_ARRAY)
    }

    override fun getLong(key: String) : Long {
        return getNMSTag().getLong(key)
    }

    override fun getLongArray(key: String) : LongArray {
        return getNMSTag().getLongArray(key)
    }

    override fun getShort(key: String) : Short {
        return getNMSTag().getShort(key)
    }

    override fun getString(key: String) : String {
        return getNMSTag().getString(key)
    }

    override fun getUUID(key: String) : UUID {
        return getNMSTag().getUUID(key)
    }

    override fun remove(key: String) {
        getNMSTag().remove(key)
    }

    override fun set(key: String, value: Any) : CodeNBTCompound {
        tag.put(key, CodeNBT.toTag(value))

        return this
    }

    override fun setBoolean(key: String, value: Boolean) : CodeNBTCompound {
        getNMSTag().putBoolean(key, value)

        return this
    }

    override fun setByte(key: String, value: Byte) : CodeNBTCompound {
        getNMSTag().putByte(key, value)

        return this
    }

    override fun setByteArray(key: String, value: ByteArray) : CodeNBTCompound {
        getNMSTag().putByteArray(key, value)

        return this
    }

    override fun setCompound(key: String, value: NBTCompound) : CodeNBTCompound {
        getNMSTag().put(key, (value as CodeNBTCompound).getNMSTag())

        return this
    }

    override fun setDouble(key: String, value: Double) : CodeNBTCompound {
        getNMSTag().putDouble(key, value)

        return this
    }

    override fun setFloat(key: String, value: Float) : CodeNBTCompound {
        getNMSTag().putFloat(key, value)

        return this
    }

    override fun setInt(key: String, value: Int) : CodeNBTCompound {
        getNMSTag().putInt(key, value)

        return this
    }

    override fun setIntArray(key: String, value: IntArray) : CodeNBTCompound {
        getNMSTag().putIntArray(key, value)

        return this
    }

    override fun <T> setList(key: String, value: NBTList<T>) : CodeNBTCompound {
        getNMSTag().put(key, (value as CodeNBTList<*>).getNMSTag())

        return this
    }

    override fun setLong(key: String, value: Long) : CodeNBTCompound {
        getNMSTag().putLong(key, value)

        return this
    }

    override fun setLongArray(key: String, value: LongArray) : CodeNBTCompound {
        getNMSTag().putLongArray(key, value)

        return this
    }

    override fun setShort(key: String, value: Short) : CodeNBTCompound {
        getNMSTag().putShort(key, value)

        return this
    }

    override fun setString(key: String, value: String) : CodeNBTCompound {
        getNMSTag().putString(key, value)

        return this
    }

    override fun setUUID(key: String, value: UUID) : CodeNBTCompound {
        getNMSTag().putUUID(key, value)

        return this
    }

    override fun nbtSize(): Int {
        return getNMSTag().size()
    }

    override fun toString(): String {
        return this.tag.asString
    }

    override fun get(key: String): Any? {
        return CodeNBT.getData(getNMSTag().get(key))
    }

    override fun getBoolean(key: String): Boolean {
        return getNMSTag().getBoolean(key)
    }

    override fun getByte(key: String): Byte {
        return getNMSTag().getByte(key)
    }

    override fun getByteArray(key: String): ByteArray {
        return getNMSTag().getByteArray(key)
    }

    override fun getCompound(key: String): NBTCompound {

        var compound = getNMSTag().getCompound(key)

        if (compound.isEmpty) {

            compound = CompoundTag()

            getNMSTag().put(key, compound)
        }

        return CodeNBTCompound(compound)
    }

    override fun getDouble(key: String): Double {
        return getNMSTag().getDouble(key)
    }

    override fun getFloat(key: String): Float {
        return getNMSTag().getFloat(key)
    }

    override fun getInt(key: String): Int {
        return getNMSTag().getInt(key)
    }

    override fun getIntArray(key: String): IntArray {
        return getNMSTag().getIntArray(key)
    }

    override fun getKeys(): Set<String> {
        return getNMSTag().allKeys
    }

    override fun hasKey(key: String): Boolean {
        return getNMSTag().contains(key)
    }

}