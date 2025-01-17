/*
 * This file is part of the Krypton API, licensed under the MIT license.
 *
 * Copyright (C) 2021 KryptonMC and the contributors to the Krypton project.
 *
 * This project is licensed under the terms of the MIT license.
 * For more details, please reference the LICENSE file in the api top-level directory.
 */
package org.kryptonmc.api.entity.hanging

import org.kryptonmc.api.entity.Entity
import org.kryptonmc.api.util.Direction

/**
 * An entity that hangs from something, usually on one of the horizontal faces
 * of a block.
 */
@Suppress("INAPPLICABLE_JVM_NAME")
public interface HangingEntity : Entity {

    /**
     * The direction this hanging entity is facing.
     */
    @get:JvmName("direction")
    public val direction: Direction
}
