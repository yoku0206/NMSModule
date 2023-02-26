package me.yoku.api

abstract class NBTList<T> : AbstractList<T>(), NBTAbstract {

    abstract fun getOwnType() : NBTType

    abstract fun clone() : NBTList<T>

    abstract fun add(index: Int, value: Any)

    abstract fun add(value: T) : Boolean

    abstract fun set(index: Int, value: Any) : T

    abstract fun remove(index: Int) : T

    abstract fun clear()

    abstract fun toList() : List<T>

}