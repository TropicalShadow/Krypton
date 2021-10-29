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
package org.kryptonmc.krypton.world.scoreboard

import net.kyori.adventure.key.Key
import net.kyori.adventure.text.format.NamedTextColor
import org.kryptonmc.api.scoreboard.DisplaySlot

@JvmRecord
data class KryptonDisplaySlot(
    private val key: Key,
    override val teamColor: NamedTextColor?
) : DisplaySlot {

    override fun key(): Key = key

    object Factory : DisplaySlot.Factory {

        private val BY_TEXT_COLOR = mutableMapOf<NamedTextColor, DisplaySlot>()

        override fun of(key: Key, color: NamedTextColor?): DisplaySlot = KryptonDisplaySlot(key, color).apply {
            if (color != null && !BY_TEXT_COLOR.containsKey(color)) BY_TEXT_COLOR[color] = this
        }

        override fun get(color: NamedTextColor): DisplaySlot? = BY_TEXT_COLOR[color]
    }
}