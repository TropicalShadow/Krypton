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
package org.kryptonmc.krypton.entity.animal

import net.kyori.adventure.key.Key
import org.kryptonmc.api.entity.EntityTypes
import org.kryptonmc.api.entity.animal.Mooshroom
import org.kryptonmc.api.entity.animal.type.MooshroomType
import org.kryptonmc.api.registry.Registries
import org.kryptonmc.krypton.entity.metadata.MetadataKeys
import org.kryptonmc.krypton.world.KryptonWorld
import org.kryptonmc.nbt.CompoundTag

class KryptonMooshroom(world: KryptonWorld) : KryptonCow(world, EntityTypes.MOOSHROOM), Mooshroom {

    override var mooshroomType: MooshroomType
        get() = Registries.MOOSHROOM_TYPES[Key.key(data[MetadataKeys.MOOSHROOM.TYPE])]!!
        set(value) = data.set(MetadataKeys.MOOSHROOM.TYPE, value.key().value())

    init {
        data.add(MetadataKeys.MOOSHROOM.TYPE)
    }

    override fun load(tag: CompoundTag) {
        super.load(tag)
        if (tag.contains("Type")) data[MetadataKeys.MOOSHROOM.TYPE] = tag.getString("Type")
    }

    override fun save(): CompoundTag.Builder = super.save().apply {
        string("Type", data[MetadataKeys.MOOSHROOM.TYPE])
    }
}
