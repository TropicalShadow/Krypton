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
package org.kryptonmc.krypton.util.converter.versions

import org.kryptonmc.krypton.util.converter.MCVersions
import org.kryptonmc.krypton.util.converter.correctKeyOrNull
import org.kryptonmc.krypton.util.converter.types.MCTypeRegistry
import org.kryptonmc.krypton.util.converter.walkers.ItemListsDataWalker

object V1920 {

    private const val VERSION = MCVersions.V18W50A + 1

    fun register() {
        MCTypeRegistry.CHUNK.addStructureConverter(VERSION) { data, _, _ ->
            val level = data.getMap<String>("Level") ?: return@addStructureConverter null
            val structures = level.getMap<String>("Structures") ?: return@addStructureConverter null

            structures.getMap<String>("Starts")?.let {
                val village = it.getMap<String>("New_Village")
                if (village != null) {
                    it.remove("New_Village")
                    it.setMap("Village", village)
                } else {
                    it.remove("Village")
                }
            }

            structures.getMap<String>("References")?.let {
                val newVillage = it.getMap<String>("New_Village")
                if (newVillage == null) {
                    it.remove("Village")
                } else {
                    it.remove("New_Village")
                    it.setMap("Village", newVillage)
                }
            }
            null
        }

        MCTypeRegistry.STRUCTURE_FEATURE.addStructureConverter(VERSION) { data, _, _ ->
            val id = data.getString("id")
            if (id.correctKeyOrNull() == "minecraft:new_village") data.setString("id", "minecraft:village")
            null
        }

        MCTypeRegistry.ENTITY.addWalker(VERSION, "minecraft:campfire", ItemListsDataWalker("Items"))
    }
}