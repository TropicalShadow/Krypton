package org.kryptonmc.krypton.packet.out.play

import io.netty.buffer.ByteBuf
import net.kyori.adventure.nbt.CompoundBinaryTag
import org.kryptonmc.krypton.extension.*
import org.kryptonmc.krypton.packet.state.PlayPacket
import org.kryptonmc.krypton.world.block.palette.GlobalPalette
import org.kryptonmc.krypton.world.chunk.Chunk
import org.kryptonmc.krypton.world.chunk.ChunkSection

class PacketOutChunkData(private val chunk: Chunk) : PlayPacket(0x20) {

    override fun write(buf: ByteBuf) {
        buf.writeInt(chunk.position.x)
        buf.writeInt(chunk.position.z)
        buf.writeBoolean(true)
        buf.writeVarInt(calculateBitMask(chunk.level.sections))

        buf.writeNBTCompound(CompoundBinaryTag.builder()
            .put("", CompoundBinaryTag.builder()
                .put("MOTION_BLOCKING", chunk.level.heightmaps.motionBlocking)
                .put("WORLD_SURFACE", chunk.level.heightmaps.worldSurface)
                .build())
            .build())

        buf.writeVarInt(chunk.level.biomes.size)
        for (biome in chunk.level.biomes) buf.writeVarInt(biome.id)

        val sections = chunk.level.sections.filter { it.blockStates.isNotEmpty() }

        var bytesLength = 0
        for (section in sections) {
            bytesLength += 2
            bytesLength += 1

            val paletteSize = section.palette.size
            val bitsPerBlock = paletteSize.calculateBits()
            if (bitsPerBlock < 9) {
                bytesLength += section.palette.size.varIntSize()
                bytesLength += section.palette.sumBy { entry ->
                    GlobalPalette.PALETTE.getValue(entry.name).states.first { it.properties == entry.properties }.id.varIntSize()
                }
            }

            bytesLength += section.blockStates.size.varIntSize()
            bytesLength += section.blockStates.sumBy { Long.SIZE_BYTES }
        }
        buf.writeVarInt(bytesLength)

        for (section in sections) {
            buf.writeShort(section.blockStates.size)

            val paletteSize = section.palette.size
            val bitsPerBlock = paletteSize.calculateBits()
            buf.writeUByte(bitsPerBlock.toUByte())

            if (bitsPerBlock < 9) {
                buf.writeVarInt(paletteSize)
                for (block in section.palette) {
                    buf.writeVarInt(GlobalPalette.PALETTE.getValue(block.name).states.first { it.properties == block.properties }.id)
                }
            }

            buf.writeVarInt(section.blockStates.size)
            for (blockState in section.blockStates) {
                buf.writeLong(blockState)
            }
        }

        buf.writeVarInt(0)
    }

    private fun calculateBitMask(sections: List<ChunkSection>): Int {
        var result = 0
        for (i in 0..15) {
            if (sections.singleOrNull { it.y.toInt() == i && it.blockStates.isNotEmpty() } == null) continue
            result = result or (1 shl i)
        }
        return result
    }
}