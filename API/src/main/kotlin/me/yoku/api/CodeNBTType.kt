package me.yoku.api

abstract class CodeNBTType {

    companion object {

        fun toNMS(type: NBTType): Byte {

            return when (type) {

                NBTType.BYTE -> 1
                NBTType.SHORT -> 2
                NBTType.INTEGER -> 3
                NBTType.LONG -> 4
                NBTType.FLOAT -> 5
                NBTType.DOUBLE -> 6
                NBTType.BYTE_ARRAY -> 7
                NBTType.STRING -> 8
                NBTType.LIST -> 9
                NBTType.COMPOUND -> 10
                NBTType.INTEGER_ARRAY -> 11
                NBTType.LONG_ARRAY -> 12

                else -> -1
            }

        }

        fun fromNMS(type: Int) : NBTType {

            return when (type) {

                1 -> NBTType.BYTE
                2 -> NBTType.SHORT
                3 -> NBTType.INTEGER
                4 -> NBTType.LONG
                5 -> NBTType.FLOAT
                6 -> NBTType.DOUBLE
                7 -> NBTType.BYTE_ARRAY
                8 -> NBTType.STRING
                9 -> NBTType.LIST
                10 -> NBTType.COMPOUND
                11 -> NBTType.INTEGER_ARRAY
                12 -> NBTType.LONG_ARRAY

                else -> NBTType.UNKNOWN
            }

        }
    }

}