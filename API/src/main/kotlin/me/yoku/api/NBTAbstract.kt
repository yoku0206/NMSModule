package me.yoku.api

interface NBTAbstract {

    fun getType() : NBTType

    fun nbtSize() : Int

    override fun toString() : String

}