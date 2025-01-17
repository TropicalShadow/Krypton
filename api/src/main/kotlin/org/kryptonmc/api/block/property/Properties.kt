/*
 * This file is part of the Krypton API, licensed under the MIT license.
 *
 * Copyright (C) 2021 KryptonMC and the contributors to the Krypton project.
 *
 * This project is licensed under the terms of the MIT license.
 * For more details, please reference the LICENSE file in the api top-level directory.
 */
package org.kryptonmc.api.block.property

import org.kryptonmc.api.block.Blocks
import org.kryptonmc.api.block.meta.AttachFace
import org.kryptonmc.api.block.meta.BambooLeaves
import org.kryptonmc.api.block.meta.BedPart
import org.kryptonmc.api.block.meta.BellAttachment
import org.kryptonmc.api.block.meta.ChestType
import org.kryptonmc.api.block.meta.ComparatorMode
import org.kryptonmc.api.block.meta.DoorHingeSide
import org.kryptonmc.api.block.meta.DoubleBlockHalf
import org.kryptonmc.api.block.meta.DripstoneThickness
import org.kryptonmc.api.block.meta.Half
import org.kryptonmc.api.block.meta.NoteBlockInstrument
import org.kryptonmc.api.block.meta.Orientation
import org.kryptonmc.api.block.meta.PistonType
import org.kryptonmc.api.block.meta.RailShape
import org.kryptonmc.api.block.meta.RedstoneSide
import org.kryptonmc.api.block.meta.SculkSensorPhase
import org.kryptonmc.api.block.meta.SlabType
import org.kryptonmc.api.block.meta.StairShape
import org.kryptonmc.api.block.meta.StructureMode
import org.kryptonmc.api.block.meta.Tilt
import org.kryptonmc.api.block.meta.WallSide
import org.kryptonmc.api.util.Direction
import org.kryptonmc.api.util.Catalogue

/**
 * All built-in block state properties.
 *
 * See [here](https://minecraft.fandom.com/wiki/Java_Edition_data_values#Block_states)
 * for information on what types of blocks each property is applicable to.
 */
@Catalogue(Property::class)
public object Properties {

    /**
     * The current age of the block this property is applied to. This is a
     * generic property for certain types of plants. This has a range of 0-1.
     *
     * This is applicable to:
     * - [Bamboo][Blocks.BAMBOO] - the age of it, if 1 it appears thicker
     */
    @JvmField
    public val AGE_1: Property<Int> = Property.forInt("age", 0..1)

    /**
     * The current age of the block this property is applied to. This is a
     * generic property for certain types of plants. This has a range of 0-2.
     *
     * This is applicable to
     * - [Cocoa][Blocks.COCOA] - the stage of the pod's growth, 2 is fully grown
     */
    @JvmField
    public val AGE_2: Property<Int> = Property.forInt("age", 0..2)

    /**
     * The current age of the block this property is applied to. This is a
     * generic property for certain types of plants. This has a range of 0-3.
     *
     * This is applicable to:
     * - [Beetroots][Blocks.BEETROOTS] - see [here](https://minecraft.fandom.com/wiki/Block_states#Beetroots)
     * - [Frosted Ice][Blocks.FROSTED_ICE] - see [here](https://minecraft.fandom.com/wiki/Block_states#Frosted_Ice)
     * - [Nether Wart][Blocks.NETHER_WART] - see [here](https://minecraft.fandom.com/wiki/Block_states#Nether_Wart)
     * - [Sweet Berry Bush][Blocks.SWEET_BERRY_BUSH] - see
     * [here](https://minecraft.fandom.com/wiki/Block_states#Sweet_Berry_Bush)
     */
    @JvmField
    public val AGE_3: Property<Int> = Property.forInt("age", 0..3)

    /**
     * The current age of the block this property is applied to. This is a
     * generic property for certain types of plants. This has a range of 0-5.
     *
     * This is applicable to:
     * - [Chorus flower][Blocks.CHORUS_FLOWER] - see [here](https://minecraft.fandom.com/wiki/Block_states#Chorus_Flower)
     */
    @JvmField
    public val AGE_5: Property<Int> = Property.forInt("age", 0..5)

    /**
     * The current age of the block this property is applied to. This is a
     * generic property for certain types of plants. This has a range of 0-7.
     *
     * This is applicable to:
     * - [Melon Stem][Blocks.MELON_STEM] - see [here](https://minecraft.fandom.com/wiki/Block_states#Melon_Stem)
     * - [Pumpkin Stem][Blocks.PUMPKIN_STEM] - see [here](https://minecraft.fandom.com/wiki/Block_states#Pumpkin_Stem)
     */
    @JvmField
    public val AGE_7: Property<Int> = Property.forInt("age", 0..7)

    /**
     * The current age of the block this property is applied to. This is a
     * generic property for certain types of plants. This has a range of 0-15.
     *
     * This is applicable to:
     * - [Cactus][Blocks.CACTUS] - see [here](https://minecraft.fandom.com/wiki/Block_states#Cactus)
     * - [Fire][Blocks.FIRE] - see [here](https://minecraft.fandom.com/wiki/Block_states#Fire)
     * - [Sugar Cane][Blocks.SUGAR_CANE] - see [here](https://minecraft.fandom.com/wiki/Block_states#Sugar_Cane)
     */
    @JvmField
    public val AGE_15: Property<Int> = Property.forInt("age", 0..15)

    /**
     * The current age of the block this property is applied to. This is a
     * generic property for certain types of plants. This has a range of 0-25.
     *
     * This is applicable to:
     * - [Kelp][Blocks.KELP] - see [here](https://minecraft.fandom.com/wiki/Block_states#Kelp)
     */
    @JvmField
    public val AGE_25: Property<Int> = Property.forInt("age", 0..25)

    /**
     * Whether the tripwire or tripwire hook this property is applied to is
     * attached to a valid tripwire circuit.
     *
     * This is applicable to:
     * - [Tripwire][Blocks.TRIPWIRE]
     * - [Tripwire hook][Blocks.TRIPWIRE_HOOK]
     */
    @JvmField
    public val ATTACHED: Property<Boolean> = Property.forBoolean("attached")

    /**
     * The face of the block which the button, grindstone, or lever this
     * property is applied to is attached to.
     *
     * This is applicable to all types of buttons, as well as the following
     * other blocks:
     * - [Grindstone][Blocks.GRINDSTONE]
     * - [Lever][Blocks.LEVER]
     */
    @JvmField
    public val ATTACH_FACE: Property<AttachFace> = Property.forEnum("face", AttachFace.values())

    /**
     * The axis of orientation of the block this property is applied to.
     *
     * This is applicable to all types of logs, stripped logs, wood, stripped
     * wood, stems, stripped stems, hyphae, stripped hyphae, as well as the
     * following other blocks:
     * - [Bone Block][Blocks.BONE_BLOCK] - see [here](https://minecraft.fandom.com/wiki/Block_states#Bone_Block)
     * - [Chain][Blocks.CHAIN] - see [here](https://minecraft.fandom.com/wiki/Block_states#Chain)
     * - [Hay Bale][Blocks.HAY_BLOCK] - see [here](https://minecraft.fandom.com/wiki/Block_states#Hay_Bale)
     * - [Basalt][Blocks.BASALT]
     * - [Polished Basalt][Blocks.POLISHED_BASALT]
     * - [Quartz Pillar][Blocks.QUARTZ_PILLAR]
     * - [Purpur Pillar][Blocks.PURPUR_PILLAR]
     * - [Deepslate][Blocks.DEEPSLATE]
     */
    @JvmField
    public val AXIS: Property<Direction.Axis> = Property.forEnum("axis", Direction.Axis.values())

    /**
     * The type of [Bamboo][Blocks.BAMBOO] leaves this property is applied to.
     */
    @JvmField
    public val BAMBOO_LEAVES: Property<BambooLeaves> = Property.forEnum("leaves", BambooLeaves.values())

    /**
     * The part of the bed this property is applied to. This is applicable to
     * all types of beds.
     */
    @JvmField
    public val BED_PART: Property<BedPart> = Property.forEnum("part", BedPart.values())

    /**
     * The attachment of the [Bell][Blocks.BELL] this property is applied to.
     */
    @JvmField
    public val BELL_ATTACHMENT: Property<BellAttachment> = Property.forEnum("attachment", BellAttachment.values())

    /**
     * Whether the cave vines this property is applied to have berries. This is
     * applicable to both cave vines and their plants.
     */
    @JvmField
    public val BERRIES: Property<Boolean> = Property.forBoolean("berries")

    /**
     * The number of bites that have been taken from the [Cake][Blocks.CAKE]
     * this property is applied to.
     */
    @JvmField
    public val BITES: Property<Int> = Property.forInt("bites", 0..6)

    /**
     * Whether the [Scaffolding][Blocks.SCAFFOLDING] block this property is
     * applied to is floating or is on the bottom.
     */
    @JvmField
    public val BOTTOM: Property<Boolean> = Property.forBoolean("bottom")

    /**
     * The amount of candles the candle block this property is applied to has.
     * This is applicable to all types of candles.
     */
    @JvmField
    public val CANDLES: Property<Int> = Property.forInt("candles", 1..4)

    /**
     * The level of the cauldron this property is applied to. This is
     * applicable to all types of cauldrons.
     */
    @JvmField
    public val CAULDRON_LEVEL: Property<Int> = Property.forInt("level", 0..3)

    /**
     * The amount of charges the [Respawn Anchor][Blocks.RESPAWN_ANCHOR] this
     * property is applied to has.
     */
    @JvmField
    public val CHARGES: Property<Int> = Property.forInt("charges", 0..4)

    /**
     * The type of the [Chest][Blocks.CHEST], [Trapped Chest][Blocks.TRAPPED_CHEST],
     * or [Ender Chest][Blocks.ENDER_CHEST] this property is applied to.
     */
    @JvmField
    public val CHEST_TYPE: Property<ChestType> = Property.forEnum("type", ChestType.values())

    /**
     * The mode of the [Comparator][Blocks.COMPARATOR] this property is applied
     * to.
     */
    @JvmField
    public val COMPARATOR_MODE: Property<ComparatorMode> = Property.forEnum("mode", ComparatorMode.values())

    /**
     * The fill level of the [Composter][Blocks.COMPOSTER] this property is
     * applied to.
     */
    @JvmField
    public val COMPOSTER_LEVEL: Property<Int> = Property.forInt("level", 0..8)

    /**
     * Whether the command block this property is applied to is conditional or
     * not. This is applicable to all types of command blocks.
     */
    @JvmField
    public val CONDITIONAL: Property<Boolean> = Property.forBoolean("conditional")

    /**
     * The delay that the [Repeater][Blocks.REPEATER] this property is applied
     * to has.
     */
    @JvmField
    public val DELAY: Property<Int> = Property.forInt("delay", 1..4)

    /**
     * Whether the [Tripwire][Blocks.TRIPWIRE] this property is applied to is
     * disarmed.
     */
    @JvmField
    public val DISARMED: Property<Boolean> = Property.forBoolean("disarmed")

    /**
     * The distance the leaves block this property is applied to is from its
     * closest respective wood type. This is applicable to all types of
     * leaves.
     */
    @JvmField
    public val DISTANCE: Property<Int> = Property.forInt("distance", 1..7)

    /**
     * The hinge of a door the door this property is applied to represents.
     * This is applicable to all types of doors.
     */
    @JvmField
    public val DOOR_HINGE: Property<DoorHingeSide> = Property.forEnum("hinge", DoorHingeSide.values())

    /**
     * The half of a double block the block this property is applied to
     * represents.
     *
     * This is applicable to all types of doors, as well as the following
     * flowers:
     * - [Tall Grass][Blocks.TALL_GRASS]
     * - [Large Fern][Blocks.LARGE_FERN]
     * - [Small Dripleaf][Blocks.SMALL_DRIPLEAF]
     * - [Sunflower][Blocks.SUNFLOWER]
     * - [Lilac][Blocks.LILAC]
     * - [Rose Bush][Blocks.ROSE_BUSH]
     * - [Peony][Blocks.PEONY]
     * - [Tall Seagrass][Blocks.TALL_SEAGRASS]
     */
    @JvmField
    public val DOUBLE_BLOCK_HALF: Property<DoubleBlockHalf> = Property.forEnum("half", DoubleBlockHalf.values())

    /**
     * Whether the [Chorus Plant][Blocks.CHORUS_PLANT] this property is applied
     * to extends down from the centre plant.
     */
    @JvmField
    public val DOWN: Property<Boolean> = Property.forBoolean("down")

    /**
     * Whether the [Bubble Column][Blocks.BUBBLE_COLUMN] this property is
     * applied to is upward or it is a whirlpool.
     */
    @JvmField
    public val DRAG: Property<Boolean> = Property.forBoolean("drag")

    /**
     * The thickness of the [Pointed Dripstone][Blocks.POINTED_DRIPSTONE] this
     * property is applied to
     */
    @JvmField
    public val DRIPSTONE_THICKNESS: Property<DripstoneThickness> = Property.forEnum(
        "thickness",
        DripstoneThickness.values()
    )

    /**
     * Whether the [Chorus Plant][Blocks.CHORUS_PLANT] this property is applied
     * to extends east from the centre plant.
     */
    @JvmField
    public val EAST: Property<Boolean> = Property.forBoolean("east")

    /**
     * The connection the [Redstone Wire][Blocks.REDSTONE_WIRE] this property
     * is applied to has on the east side.
     */
    @JvmField
    public val EAST_REDSTONE_SIDE: Property<RedstoneSide> = Property.forEnum("east", RedstoneSide.values())

    /**
     * The connection the wall this property is applied to has on the east
     * side. This is applicable to all types of walls.
     */
    @JvmField
    public val EAST_WALL_SIDE: Property<WallSide> = Property.forEnum("east", WallSide.values())

    /**
     * The amount of eggs the [Turtle Egg][Blocks.TURTLE_EGG] this property is
     * applied to has.
     */
    @JvmField
    public val EGGS: Property<Int> = Property.forInt("eggs", 1..4)

    /**
     * Whether the [Hopper][Blocks.HOPPER] this property is applied to can move
     * items to and from its inventory. When the hopper is powered by a
     * redstone current, this should be false.
     */
    @JvmField
    public val ENABLED: Property<Boolean> = Property.forBoolean("enabled")

    /**
     * Whether the piston **base** block this property is applied to is
     * extended or not. This is applicable to both pistons and sticky pistons.
     */
    @JvmField
    public val EXTENDED: Property<Boolean> = Property.forBoolean("extended")

    /**
     * Whether the [End Portal Frame][Blocks.END_PORTAL_FRAME] this property is
     * applied to has an eye in it or not.
     */
    @JvmField
    public val EYE: Property<Boolean> = Property.forBoolean("eye")

    /**
     * The direction the block this property is applied to is facing.
     *
     * This is applicable to:
     * - [Amethyst Cluster][Blocks.AMETHYST_CLUSTER]
     * - [Large Amethyst Bud][Blocks.LARGE_AMETHYST_BUD]
     * - [Medium Amethyst Bud][Blocks.MEDIUM_AMETHYST_BUD]
     * - [Small Amethyst Bud][Blocks.SMALL_AMETHYST_BUD]
     * - [Barrel][Blocks.BARREL]
     * - [End Rod][Blocks.END_ROD]
     * - [Lightning Rod][Blocks.LIGHTNING_ROD]
     * - [Observer][Blocks.OBSERVER]
     * - [Piston][Blocks.PISTON]
     * - [Sticky Piston][Blocks.STICKY_PISTON]
     * - [Piston Head][Blocks.PISTON_HEAD]
     */
    @JvmField
    public val FACING: Property<Direction> = Property.forEnum("facing", Direction.values())

    /**
     * Whether the flowing fluid this property is applied to is falling. This
     * is applicable to all flowing and source fluids.
     */
    @JvmField
    public val FALLING: Property<Boolean> = Property.forBoolean("falling")

    /**
     * The half of the block that the block this property is applied to
     * represents. This is applicable to all types of stairs and trapdoors.
     */
    @JvmField
    public val HALF: Property<Half> = Property.forEnum("half", Half.values())

    /**
     * Whether the [Lantern][Blocks.LANTERN] or [Soul Lantern][Blocks.SOUL_LANTERN]
     * this property is applied to is currently hanging or not.
     */
    @JvmField
    public val HANGING: Property<Boolean> = Property.forBoolean("hanging")

    /**
     * Whether the [Lectern][Blocks.LECTERN] this property is applied to
     * currently holds a book.
     */
    @JvmField
    public val HAS_BOOK: Property<Boolean> = Property.forBoolean("has_book")

    /**
     * Whether the [Brewing Stand][Blocks.BREWING_STAND] this property is
     * applied to has a bottle brewing in the leftmost slot.
     */
    @JvmField
    public val HAS_FIRST_BOTTLE: Property<Boolean> = Property.forBoolean("has_bottle_0")

    /**
     * Whether the [Brewing Stand][Blocks.BREWING_STAND] this property is
     * applied to has a bottle brewing in the central slot.
     */
    @JvmField
    public val HAS_SECOND_BOTTLE: Property<Boolean> = Property.forBoolean("has_bottle_1")

    /**
     * Whether the [Brewing Stand][Blocks.BREWING_STAND] this property is
     * applied to has a bottle brewing in the rightmost slot.
     */
    @JvmField
    public val HAS_THIRD_BOTTLE: Property<Boolean> = Property.forBoolean("has_bottle_2")

    /**
     * Whether the [Jukebox][Blocks.JUKEBOX] this property is applied to has a
     * record (music disc) currently playing in it.
     */
    @JvmField
    public val HAS_RECORD: Property<Boolean> = Property.forBoolean("has_record")

    /**
     * How close the [Turtle Egg][Blocks.TURTLE_EGG] this property is applied
     * to is to hatching. See [here](https://minecraft.fandom.com/wiki/Block_states#Turtle_Egg)
     * for more information.
     */
    @JvmField
    public val HATCH: Property<Int> = Property.forInt("hatch", 0..2)

    /**
     * The level of honey the [Beehive][Blocks.BEEHIVE] or [Bee Nest][Blocks.BEE_NEST]
     * this property is applied to has.
     */
    @JvmField
    public val HONEY_LEVEL: Property<Int> = Property.forInt("honey_level", 0..5)

    /**
     * The direction that the [Hopper][Blocks.HOPPER] this property is applied
     * to is facing.
     */
    @JvmField
    public val HOPPER_FACING: Property<Direction> = Property.forEnum(
        "facing",
        setOf(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.DOWN)
    )

    /**
     * The axis of rotation of the [Nether Portal][Blocks.NETHER_PORTAL] this
     * property is applied to.
     * This property only permits axes on the horizontal plane.
     */
    @JvmField
    public val HORIZONTAL_AXIS: Property<Direction.Axis> = Property.forEnum(
        "axis",
        setOf(Direction.Axis.X, Direction.Axis.Z)
    )

    /**
     * The direction that the block this property is applied to is facing.
     * This property only permits directions on the horizontal plane.
     *
     * This is applicable to all types of buttons, beds, fence gates, glazed
     * terracotta, and trapdoors, as well as the following:
     * - [Campfire][Blocks.CAMPFIRE]
     * - [Soul Campfire][Blocks.SOUL_CAMPFIRE]
     * - [Big Dripleaf][Blocks.BIG_DRIPLEAF]
     * - [Big Dripleaf Stem][Blocks.BIG_DRIPLEAF_STEM]
     * - [Small Dripleaf][Blocks.SMALL_DRIPLEAF]
     * - [Carved Pumpkin][Blocks.CARVED_PUMPKIN]
     * - [Jack o' Lantern][Blocks.JACK_O_LANTERN]
     * - [Cocoa][Blocks.COCOA]
     * - [Comparator][Blocks.COMPARATOR]
     * - [Repeater][Blocks.REPEATER]
     * - [Grindstone][Blocks.GRINDSTONE]
     * - [Lever][Blocks.LEVER]
     * - [Loom][Blocks.LOOM]
     */
    @JvmField
    public val HORIZONTAL_FACING: Property<Direction> = Property.forEnum(
        "facing",
        setOf(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST)
    )

    /**
     * The instrument that the [Note Block][Blocks.NOTE_BLOCK] this property is
     * applied to will play when attacked.
     */
    @JvmField
    public val INSTRUMENT: Property<NoteBlockInstrument> = Property.forEnum(
        "instrument",
        NoteBlockInstrument.values()
    )

    /**
     * Whether the [Daylight Detector][Blocks.DAYLIGHT_DETECTOR] this property
     * is applied to is inverted, meaning it activates in the absence of light
     * rather than in the presence of light (when it is dark rather than when
     * it is light).
     */
    @JvmField
    public val INVERTED: Property<Boolean> = Property.forBoolean("inverted")

    /**
     * Whether the fence gate this property is applied to is surrounded by
     * walls, causing the renderer to use a texture that is lowered by 3 pixels,
     * to allow for better attaching to walls.
     */
    @JvmField
    public val IN_WALL: Property<Boolean> = Property.forBoolean("in_wall")

    /**
     * The amount of layers the [Snow][Blocks.SNOW] block this property is
     * applied to represents.
     */
    @JvmField
    public val LAYERS: Property<Int> = Property.forInt("layers", 1..8)

    /**
     * The distance from a source block or level of light, depending on whether
     * the block is light or a liquid, that the block this property is applied
     * to represents.
     *
     * This is applicable to:
     * - [Light][Blocks.LIGHT]
     * - [Water][Blocks.WATER]
     * - [Lava][Blocks.LAVA]
     */
    @JvmField
    public val LEVEL: Property<Int> = Property.forInt("level", 0..15)

    /**
     * The level of liquid the flowing fluid this property is applied to
     * represents. This is applicable to all flowing and source fluids.
     */
    @JvmField
    public val LIQUID_LEVEL: Property<Int> = Property.forInt("level", 0..8)

    /**
     * Whether the block this property is applied to is lit or not.
     *
     * This is applicable to all candles and candle cakes, as well as the
     * following:
     * - [Furnace][Blocks.FURNACE]
     * - [Blast Furnace][Blocks.BLAST_FURNACE]
     * - [Smoker][Blocks.SMOKER]
     * - [Campfire][Blocks.CAMPFIRE]
     * - [Soul Campfire][Blocks.SOUL_CAMPFIRE]
     * - [Redstone Torch][Blocks.REDSTONE_TORCH]
     * - [Redstone Wall Torch][Blocks.REDSTONE_WALL_TORCH]
     */
    @JvmField
    public val LIT: Property<Boolean> = Property.forBoolean("lit")

    /**
     * Whether the [Repeater][Blocks.REPEATER] this property is applied to is
     * locked.
     */
    @JvmField
    public val LOCKED: Property<Boolean> = Property.forBoolean("locked")

    /**
     * The moisture level the [Farmland][Blocks.FARMLAND] this property is
     * applied to represents.
     */
    @JvmField
    public val MOISTURE: Property<Int> = Property.forInt("moisture", 0..7)

    /**
     * Whether the [Chorus Plant][Blocks.CHORUS_PLANT] this property is applied
     * to extends north from the centre plant.
     */
    @JvmField
    public val NORTH: Property<Boolean> = Property.forBoolean("north")

    /**
     * The connection the [Redstone Wire][Blocks.REDSTONE_WIRE] this property
     * is applied to has on the north side.
     */
    @JvmField
    public val NORTH_REDSTONE_SIDE: Property<RedstoneSide> = Property.forEnum("north", RedstoneSide.values())

    /**
     * The connection the wall this property is applied to has on the north
     * side. This is applicable to all types of walls.
     */
    @JvmField
    public val NORTH_WALL_SIDE: Property<WallSide> = Property.forEnum("north", WallSide.values())

    /**
     * The note that the [Note Block][Blocks.NOTE_BLOCK] this property is
     * applied to will play when attacked.
     */
    @JvmField
    public val NOTE: Property<Int> = Property.forInt("note", 0..24)

    /**
     * Whether the bed this property is applied to is occupied.
     */
    @JvmField
    public val OCCUPIED: Property<Boolean> = Property.forBoolean("occupied")

    /**
     * Whether the block this property is applied to is open.
     *
     * This is applicable to all types of doors, fence gates, and trapdoors, as
     * well as the following:
     * - [Barrel][Blocks.BARREL]
     */
    @JvmField
    public val OPEN: Property<Boolean> = Property.forBoolean("open")

    /**
     * The orientation of the [Jigsaw Block][Blocks.JIGSAW] this property is
     * applied to.
     */
    @JvmField
    public val ORIENTATION: Property<Orientation> = Property.forEnum("orientation", Orientation.values())

    /**
     * Whether the leaves block this property is applied to won't decay, even
     * if it has no appropriate wood blocks nearby.
     */
    @JvmField
    public val PERSISTENT: Property<Boolean> = Property.forBoolean("persistent")

    /**
     * The amount of pickles the [Sea Pickle][Blocks.SEA_PICKLE] this property
     * is applied to has.
     */
    @JvmField
    public val PICKLES: Property<Int> = Property.forInt("pickles", 1..4)

    /**
     * The type of the [Piston Head][Blocks.PISTON_HEAD] this property is
     * applied to. This is only applicable to piston heads due to pistons and
     * sticky pistons (the base blocks) being separate blocks.
     */
    @JvmField
    public val PISTON_TYPE: Property<PistonType> = Property.forEnum("type", PistonType.values())

    /**
     * The level of power that is either produced or is held by the block that
     * this property is applied to.
     *
     * This is applicable to:
     * - [Redstone Wire][Blocks.REDSTONE_WIRE] - the level of power running
     * through it
     * - [Daylight Detector][Blocks.DAYLIGHT_DETECTOR] - the level of power
     * that currently outputted by it
     * - Weighted Pressure Plates (both [light][Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE]
     * and [heavy][Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE]) - the level of
     * power outputted by it
     */
    @JvmField
    public val POWER: Property<Int> = Property.forInt("power", 0..15)

    /**
     * Whether the block this property is applied to is powered.
     *
     * This is applicable to all types of buttons, doors, fence gates, pressure
     * plates, and trapdoors, as well as the following:
     * - [Bell][Blocks.BELL]
     * - [Detector Rail][Blocks.DETECTOR_RAIL]
     * - [Lectern][Blocks.LECTERN]
     * - [Lever][Blocks.LEVER]
     * - [Lightning Rod][Blocks.LIGHTNING_ROD]
     * - [Note Block][Blocks.NOTE_BLOCK]
     * - [Observer][Blocks.OBSERVER]
     * - [Powered Rail][Blocks.POWERED_RAIL]
     * - [Tripwire][Blocks.TRIPWIRE]
     * - [Tripwire Hook][Blocks.TRIPWIRE_HOOK]
     */
    @JvmField
    public val POWERED: Property<Boolean> = Property.forBoolean("powered")

    /**
     * The shape of the [Rail][Blocks.RAIL] this property is applied to.
     */
    @JvmField
    public val RAIL_SHAPE: Property<RailShape> = Property.forEnum("shape", RailShape.values())

    /**
     * The rotation of the sign this property is applied to. This is applicable
     * to all types of signs.
     */
    @JvmField
    public val ROTATION: Property<Int> = Property.forInt("rotation", 0..15)

    /**
     * The horizontal distance from a centre [Scaffolding][Blocks.SCAFFOLDING]
     * block the [Scaffolding][Blocks.SCAFFOLDING] block this property is
     * applied to is.
     */
    @JvmField
    public val SCAFFOLD_DISTANCE: Property<Int> = Property.forInt("distance", 0..7)

    /**
     * The phase of the sculk sensor block this property is applied to
     * represents.
     */
    @JvmField
    public val SCULK_SENSOR_PHASE: Property<SculkSensorPhase> = Property.forEnum(
        "sculk_sensor_phase",
        SculkSensorPhase.values()
    )

    /**
     * Whether the [Piston Head][Blocks.PISTON_HEAD] this properti is applied
     * to is shorter by 4 pixels.
     */
    @JvmField
    public val SHORT: Property<Boolean> = Property.forBoolean("short")

    /**
     * Whether the [Campfire][Blocks.CAMPFIRE] or [Soul Campfire][Blocks.SOUL_CAMPFIRE]
     * this property is applied to has a hay bale below it, meaning it produces
     * a signal fire.
     */
    @JvmField
    public val SIGNAL_FIRE: Property<Boolean> = Property.forBoolean("signal_fire")

    /**
     * The type of the slab this property is applied to represents. This is
     * applicable to all types of stairs.
     */
    @JvmField
    public val SLAB_TYPE: Property<SlabType> = Property.forEnum("type", SlabType.values())

    /**
     * Whether the snowy dirt block this property is applied to is snowy.
     *
     * This is applicable to:
     * - [Podzol][Blocks.PODZOL]
     * - [Grass Block][Blocks.GRASS_BLOCK]
     * - [Mycelium][Blocks.MYCELIUM]
     */
    @JvmField
    public val SNOWY: Property<Boolean> = Property.forBoolean("snowy")

    /**
     * Whether the [Chorus Plant][Blocks.CHORUS_PLANT] this property is applied
     * to extends south from the centre plant.
     */
    @JvmField
    public val SOUTH: Property<Boolean> = Property.forBoolean("south")

    /**
     * The connection the [Redstone Wire][Blocks.REDSTONE_WIRE] this property
     * is applied to has on the south side.
     */
    @JvmField
    public val SOUTH_REDSTONE_SIDE: Property<RedstoneSide> = Property.forEnum("south", RedstoneSide.values())

    /**
     * The connection the wall this property is applied to has on the south
     * side. This is applicable to all types of walls.
     */
    @JvmField
    public val SOUTH_WALL_SIDE: Property<WallSide> = Property.forEnum("south", WallSide.values())

    /**
     * The current growth stage of the sapling this property is applied to.
     * This is applicable to all types of saplings.
     */
    @JvmField
    public val STAGE: Property<Int> = Property.forInt("stage", 0..1)

    /**
     * The shape of the stair this property is applied to represents. This is
     * applicable to all types of stairs.
     */
    @JvmField
    public val STAIR_SHAPE: Property<StairShape> = Property.forEnum("shape", StairShape.values())

    /**
     * The mode the [Structure Block][Blocks.STRUCTURE_BLOCK] this property is
     * applied to is currently in.
     */
    @JvmField
    public val STRUCTURE_MODE: Property<StructureMode> = Property.forEnum("mode", StructureMode.values())

    /**
     * The shape of the [Detector Rail][Blocks.DETECTOR_RAIL] or
     * [Powered Rail][Blocks.POWERED_RAIL] this property is applied to
     * represents.
     */
    @JvmField
    public val STRAIGHT_RAIL_SHAPE: Property<RailShape> = Property.forEnum(
        "shape",
        setOf(
            RailShape.ASCENDING_NORTH,
            RailShape.ASCENDING_SOUTH,
            RailShape.ASCENDING_EAST,
            RailShape.ASCENDING_WEST,
            RailShape.EAST_WEST,
            RailShape.NORTH_SOUTH
        )
    )

    /**
     * The tilt of the [Big Dripleaf][Blocks.BIG_DRIPLEAF] this property is
     * applied to.
     */
    @JvmField
    public val TILT: Property<Tilt> = Property.forEnum("tilt", Tilt.values())

    /**
     * Whether the [Dispenser][Blocks.DISPENSER] or [Dropper][Blocks.DROPPER]
     * this property is applied to is activated.
     */
    @JvmField
    public val TRIGGERED: Property<Boolean> = Property.forBoolean("triggered")

    /**
     * Whether the [TNT][Blocks.TNT] this property is applied to will explode
     * when hit as well as being able to be activated by a redstone signal
     * (just like the old days).
     */
    @JvmField
    public val UNSTABLE: Property<Boolean> = Property.forBoolean("unstable")

    /**
     * Whether the [Chorus Plant][Blocks.CHORUS_PLANT] this property is applied
     * to extends up from the centre plant.
     */
    @JvmField
    public val UP: Property<Boolean> = Property.forBoolean("up")

    /**
     * The direction on the vertical plane of the
     * [Pointed Dripstone][Blocks.POINTED_DRIPSTONE] this property is applied
     * to.
     */
    @JvmField
    public val VERTICAL_DIRECTION: Property<Direction> = Property.forEnum(
        "vertical_direction",
        setOf(Direction.UP, Direction.DOWN)
    )

    /**
     * This property is currently unused by the vanilla Minecraft server.
     */
    @JvmField
    public val VINE_END: Property<Boolean> = Property.forBoolean("vine_end")

    /**
     * Whether the block this property is applied to has water in it, such as
     * when water is placed inside a stair.
     *
     * This is applicable to all types of corals, dead corals, coral fans,
     * amethyst clusters, rails, dripleafs (big and small), fences,
     * glass panes, chests, signs, slabs, stairs, trapdoors, walls, candles,
     * and the following:
     * - [Iron Bars][Blocks.IRON_BARS]
     * - [Pointed Dripstone][Blocks.POINTED_DRIPSTONE]
     * - [Sculk Sensor][Blocks.SCULK_SENSOR]
     * - [Campfire][Blocks.CAMPFIRE]
     * - [Soul Campfire][Blocks.SOUL_CAMPFIRE]
     * - [Chain][Blocks.CHAIN]
     * - [Conduit][Blocks.CONDUIT]
     * - [Fire][Blocks.FIRE]
     * - [Glow Lichen][Blocks.GLOW_LICHEN]
     * - [Hanging Roots][Blocks.HANGING_ROOTS]
     * - [Ladder][Blocks.LADDER]
     * - [Lantern][Blocks.LANTERN]
     * - [Soul Lantern][Blocks.SOUL_LANTERN]
     * - [Light][Blocks.LIGHT]
     * - [Lightning Rod][Blocks.LIGHTNING_ROD]
     * - [Scaffolding][Blocks.SCAFFOLDING]
     * - [Sea Pickle][Blocks.SEA_PICKLE]
     */
    @JvmField
    public val WATERLOGGED: Property<Boolean> = Property.forBoolean("waterlogged")

    /**
     * Whether the [Chorus Plant][Blocks.CHORUS_PLANT] this property is applied
     * to extends west from the centre plant.
     */
    @JvmField
    public val WEST: Property<Boolean> = Property.forBoolean("west")

    /**
     * The connection the [Redstone Wire][Blocks.REDSTONE_WIRE] this property
     * is applied to has on the west side.
     */
    @JvmField
    public val WEST_REDSTONE_SIDE: Property<RedstoneSide> = Property.forEnum("west", RedstoneSide.values())

    /**
     * The connection the wall this property is applied to has on the west
     * side. This is applicable to all types of walls.
     */
    @JvmField
    public val WEST_WALL_SIDE: Property<WallSide> = Property.forEnum("west", WallSide.values())
}
