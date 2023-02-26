package me.yoku.api

class NBTIterator<T>(private val list: NBTList<T>) : Iterator<T> {

    private var read: Int = 0

    override fun hasNext(): Boolean { return read < list.nbtSize() }

    override fun next(): T { return list[read++] }
}