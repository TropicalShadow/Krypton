/*
 * This file is part of the Krypton project, licensed under the GNU General Public License v3.0
 *
 * Copyright (C) 2021 KryptonMC and the contributors of the Krypton project
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.kryptonmc.krypton.packet.out.play

import io.netty.buffer.ByteBuf
import net.kyori.adventure.sound.Sound
import org.kryptonmc.api.effect.sound.SoundEvent
import org.kryptonmc.api.registry.Registries
import org.kryptonmc.krypton.packet.EntityPacket
import org.kryptonmc.krypton.util.writeEnum
import org.kryptonmc.krypton.util.writeVarInt

@JvmRecord
data class PacketOutEntitySoundEffect(
    val event: SoundEvent,
    val source: Sound.Source,
    override val entityId: Int,
    val volume: Float,
    val pitch: Float
) : EntityPacket {

    override fun write(buf: ByteBuf) {
        buf.writeVarInt(Registries.SOUND_EVENT.idOf(event))
        buf.writeEnum(source)
        buf.writeVarInt(entityId)
        buf.writeFloat(volume)
        buf.writeFloat(pitch)
    }
}
