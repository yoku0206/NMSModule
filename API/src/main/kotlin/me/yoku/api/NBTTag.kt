package me.yoku.api

interface NBTTag {

    fun copy() : NBTTag

    fun getId() : Byte

    fun getType(key: String) : Byte

    override fun toString() : String

}