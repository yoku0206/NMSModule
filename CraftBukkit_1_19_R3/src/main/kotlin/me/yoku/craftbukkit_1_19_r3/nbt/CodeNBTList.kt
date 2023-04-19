package me.yoku.craftbukkit_1_19_r3.nbt

import me.yoku.api.CodeNBTType
import me.yoku.api.NBTIterator
import me.yoku.api.NBTList
import me.yoku.api.NBTType
import net.minecraft.nbt.ListTag

@Suppress("unused", "UNCHECKED_CAST")
open class CodeNBTList<T> : NBTList<T> {

    private var tag: ListTag

    constructor() {
        this.tag = ListTag()
    }

    constructor(tag: ListTag) {
        this.tag = tag
    }

    fun getNMSTag() : ListTag { return this.tag }

    override val size: Int
        get() = nbtSize()

    override fun get(index: Int) : T { return CodeNBT.getData(tag[index]) as T }

    override fun getType() : NBTType { return CodeNBTType.fromNMS(this.tag.id.toInt()) }

    override fun nbtSize() : Int { return this.tag.size }

    override fun getOwnType() : NBTType { return CodeNBTType.fromNMS(this.tag.elementType.toInt()) }

    override fun clone() : NBTList<T> { return CodeNBTList(tag.copy()) }

    override fun add(index: Int, value: Any) { getNMSTag()[index] = CodeNBT.toTag(value) }

    override fun add(value: T) : Boolean { return getNMSTag().add(CodeNBT.toTag(value)) }

    override fun set(index: Int, value: Any) : T { return CodeNBT.getData(getNMSTag().set(index, CodeNBT.toTag(value))) as T }

    override fun remove(index: Int) : T { return CodeNBT.getData(getNMSTag().removeAt(index)) as T }

    override fun clear() { getNMSTag().clear() }

    override fun isEmpty(): Boolean { return this.tag.isEmpty() }

    override fun toList(): List<T> {

        val list = mutableListOf<T>()

        for (i in 0 until nbtSize()) list.add(i, get(i))

        return list
    }

    override fun contains(element: T): Boolean {

        val m = CodeNBT.toTag(element) ?: false

        for (i in 0 until nbtSize()) if (get(i)?.equals(m) == true) return true

        return false
    }

    override fun iterator(): Iterator<T> {
        return NBTIterator(this)
    }

    override fun toArray(): Array<Any?> {
        return arrayOf(toList())
    }

    inline fun <reified C> toTypeArray() : Array<C> {
        return (toList() as List<C>).toTypedArray()
    }

    override fun toString() : String { return tag.asString }

    override fun hashCode(): Int { return getNMSTag().hashCode() }

    override fun equals(other: Any?): Boolean { return other is NBTList<*> && getNMSTag() == (other as CodeNBTList<*>).getNMSTag() }

}