package me.yoku.cb_1_20_r3.nbt

import com.mojang.brigadier.exceptions.CommandSyntaxException
import me.yoku.api.NBTAbstract
import me.yoku.api.NBTCompound
import me.yoku.api.NBTList
import net.minecraft.nbt.*

abstract class CodeNBT : NBTAbstract {

    companion object {

        fun getData(tag: Tag?) : Any? {
            return when (tag) {
                is ByteTag -> tag.asByte
                is ByteArrayTag -> tag.asByteArray
                is CompoundTag -> CodeNBTCompound(tag)
                is DoubleTag -> tag.asDouble
                is FloatTag -> tag.asFloat
                is IntArrayTag -> tag.asIntArray
                is IntTag -> tag.asInt
                is ListTag -> CodeNBTList<Any>(tag)
                is LongArrayTag -> tag.asLongArray
                is LongTag -> tag.asLong
                is ShortTag -> tag.asShort
                is StringTag -> tag.asString
                else -> null
            }
        }

        fun toTag(data: Any?) : Tag? {
            return when (data) {
                is ByteArray -> ByteArrayTag(data)
                is Byte -> ByteTag.valueOf(data)
                is NBTCompound -> (data as CodeNBTCompound).getNMSTag()
                is Double -> DoubleTag.valueOf(data)
                is Float -> FloatTag.valueOf(data)
                is IntArray -> IntArrayTag(data)
                is Int -> IntTag.valueOf(data)
                is NBTList<*> -> (data as CodeNBTList<*>).getNMSTag()
                is LongArray -> LongArrayTag(data)
                is Long -> LongTag.valueOf(data)
                is Short -> ShortTag.valueOf(data)
                is String -> StringTag.valueOf(data)
                else -> null
            }
        }

        fun parseTag(nbt: String) : NBTCompound {

            val tag: CompoundTag

            try {

                tag = TagParser.parseTag(nbt)

            } catch (e: CommandSyntaxException) {

                return CodeNBTCompound()

            }

            return CodeNBTCompound(tag)

        }

    }

}