package com.hbm.blocks;

import com.hbm.blocks.bomb.*;
import com.hbm.blocks.fluids.RadLiquidBlock;
import com.hbm.blocks.fluids.VolcanicLiquidBlock;
import com.hbm.blocks.gas.*;
import com.hbm.blocks.generic.*;
import com.hbm.blocks.machine.*;
import com.hbm.blocks.machine.heater.*;
import com.hbm.blocks.network.*;
import com.hbm.fluids.NtmFluids;
import com.hbm.items.NtmItems;
import com.hbm.items.block.BlastInfoBlockItem;
import com.hbm.items.block.BlockItemBase;
import com.hbm.items.block.LoreBlockItem;
import com.hbm.main.NuclearTechMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NtmBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NuclearTechMod.MODID);

    // Ores
    public static final DeferredBlock<Block> ORE_OIL = register("ore_oil", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F).explosionResistance(10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_OIL_EMPTY = register("ore_oil_empty", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F).explosionResistance(10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_OIL_SAND = register("ore_oil_sand", () -> new Block(BlockBehaviour.Properties.of().strength(5.0F).explosionResistance(10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_BEDROCK_OIL = registerBlastInfoBlock("ore_bedrock_oil", () -> new Block(BlockBehaviour.Properties.of().strength(-1.0F, 2160000.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_URANIUM = register("ore_uranium", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_URANIUM_DEEPSLATE = register("ore_uranium_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_URANIUM_SCORCHED = register("ore_uranium_scorched", () -> new Block(BlockBehaviour.Properties.of().strength(5.0F).explosionResistance(10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_BERYLLIUM = register("ore_beryllium", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_BERYLLIUM_DEEPSLATE = register("ore_beryllium_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_TUNGSTEN = register("ore_tungsten", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_TUNGSTEN_DEEPSLATE = register("ore_tungsten_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_TITANIUM = register("ore_titanium", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F, 6F).mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> ORE_TITANIUM_DEEPSLATE = register("ore_titanium_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F, 8F).sound(SoundType.DEEPSLATE).mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> ORE_LEAD = register("ore_lead", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_LEAD_DEEPSLATE = register("ore_lead_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_ALUMINIUM = register("ore_aluminium", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_ALUMINIUM_DEEPSLATE = register("ore_aluminium_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_ASBESTOS = register("ore_asbestos", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_ASBESTOS_DEEPSLATE = register("ore_asbestos_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_THORIUM = register("ore_thorium", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_THORIUM_DEEPSLATE = register("ore_thorium_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_NITER = register("ore_niter", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_NITER_DEEPSLATE = register("ore_niter_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_COBALT = register("ore_cobalt", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_COBALT_DEEPSLATE = register("ore_cobalt_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_CINNABAR = register("ore_cinnabar", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_CINNABAR_DEEPSLATE = register("ore_cinnabar_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_FLUORITE = register("ore_fluorite", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_FLUORITE_DEEPSLATE = register("ore_fluorite_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_METEOR_IRON = register("ore_meteor_iron", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.STONE).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> ORE_METEOR_COBALT = register("ore_meteor_cobalt", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.STONE).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> ORE_METEOR_COPPER = register("ore_meteor_copper", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.STONE).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> ORE_METEOR_ALUMINIUM = register("ore_meteor_aluminium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.STONE).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> ORE_METEOR_RARE = register("ore_meteor_rare", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.STONE).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> ORE_RARE = register("ore_rare", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_RARE_DEEPSLATE = register("ore_rare_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_SULFUR = register("ore_sulfur", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_SULFUR_DEEPSLATE = register("ore_sulfur_deepslate", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).explosionResistance(8.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ORE_LIGNITE = register("ore_lignite", () -> new Block(BlockBehaviour.Properties.of().strength(3F, 3F).mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> ORE_DEEPSLATE_LIGNITE = register("ore_deepslate_lignite", () -> new Block(BlockBehaviour.Properties.of().strength(4.5F, 3F).sound(SoundType.DEEPSLATE).mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> ORE_SCHRABIDIUM = register("ore_schrabidium", () -> new Block(BlockBehaviour.Properties.of().strength(15.0F).explosionResistance(600.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_NETHER_URANIUM = register("ore_nether_uranium", () -> new Block(BlockBehaviour.Properties.of().strength(0.4F).explosionResistance(10.0F).sound(SoundType.NETHER_ORE)));
    public static final DeferredBlock<Block> ORE_NETHER_URANIUM_SCORCHED = register("ore_nether_uranium_scorched", () -> new Block(BlockBehaviour.Properties.of().strength(0.4F).explosionResistance(10.0F).sound(SoundType.NETHER_ORE)));
    public static final DeferredBlock<Block> ORE_NETHER_PLUTONIUM = register("ore_nether_plutonium", () -> new Block(BlockBehaviour.Properties.of().strength(0.4F).explosionResistance(10.0F).sound(SoundType.NETHER_ORE)));
    public static final DeferredBlock<Block> ORE_NETHER_SCHRABIDIUM = register("ore_nether_schrabidium", () -> new Block(BlockBehaviour.Properties.of().strength(15.0F).explosionResistance(600.0F).sound(SoundType.NETHER_ORE)));
    public static final DeferredBlock<Block> ORE_TIKITE = register("ore_tikite", () -> new Block(BlockBehaviour.Properties.of().strength(5.0F).explosionResistance(10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_GNEISS_URANIUM = register("ore_gneiss_uranium", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).explosionResistance(10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_GNEISS_URANIUM_SCORCHED = register("ore_gneiss_uranium_scorched", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).explosionResistance(10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ORE_GNEISS_SCHRABIDIUM = register("ore_gneiss_schrabidium", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).explosionResistance(10.0F).sound(SoundType.STONE)));

    //Resource stones
    public static final DeferredBlock<Block> RESOURCE_LIMESTONE = register("resource_limestone", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.NETHERRACK)));
    public static final DeferredBlock<Block> RESOURCE_BAUXITE = register("resource_bauxite", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.NETHERRACK)));
    public static final DeferredBlock<Block> RESOURCE_HEMATITE = register("resource_hematite", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.NETHERRACK)));
    public static final DeferredBlock<Block> RESOURCE_MALACHITE = register("resource_malachite", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.NETHERRACK)));
    public static final DeferredBlock<Block> RESOURCE_CHRYSOTILE = register("resource_chrysotile", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.NETHERRACK)));
    public static final DeferredBlock<Block> RESOURCE_SULFUROUS_STONE = register("resource_sulfurous_stone", () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.NETHERRACK)));

    // Basalt ores
    public static final DeferredBlock<Block> ORE_BASALT = registerNew("ore_basalt", () -> new OreBasaltBlock(BlockBehaviour.Properties.of().strength(5F, 10F).sound(SoundType.BASALT).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM)));

    // Stone Variants
    public static final DeferredBlock<RotatedPillarBlock> BASALT = register("basalt",          () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(5F, 10F).sound(SoundType.BASALT).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> BASALT_SMOOTH =       register("basalt_smooth",   () -> new Block(BlockBehaviour.Properties.of().strength(5F, 10F).sound(SoundType.BASALT).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> BASALT_BRICK =        register("basalt_brick",    () -> new Block(BlockBehaviour.Properties.of().strength(5F, 10F).sound(SoundType.BASALT).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> BASALT_POLISHED =     register("basalt_polished", () -> new Block(BlockBehaviour.Properties.of().strength(5F, 10F).sound(SoundType.BASALT).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> BASALT_TILES =        register("basalt_tiles",    () -> new Block(BlockBehaviour.Properties.of().strength(5F, 10F).sound(SoundType.BASALT).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> STONE_CRACKED =       register("stone_cracked",   () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DIRT_OILY =           register("dirt_oily",       () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<Block> SAND_OILY =           register("sand_oily",       () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> SAND_RED_OILY =       register("sand_oily_red",   () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> DIRT_DEAD =           register("dirt_dead",       () -> new Block(BlockBehaviour.Properties.of().strength(0.7F).explosionResistance(5.0F).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<Block> OIL_SPILL =           register("oil_spill",       () -> new OilSpillBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.SLIME_BLOCK).noOcclusion().isValidSpawn(Blocks::never).isSuffocating(NtmBlocks::never).isViewBlocking(NtmBlocks::never).pushReaction(PushReaction.DESTROY).isRedstoneConductor(NtmBlocks::never)));

    // Blocks
    public static final DeferredBlock<Block> BLOCK_SCRAP = register("block_scrap", () -> new ColoredFallingBlock(new ColorRGBA(-8356741), BlockBehaviour.Properties.of().strength(2.5F, 5.0F).sound(SoundType.GRAVEL)));


    public static final DeferredBlock<Block> BLOCK_ACTINIUM = register("block_actinium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_STEEL = register("block_steel", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_ALUMINIUM = register("block_aluminium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_ASBESTOS = register("block_asbestos", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_AUSTRALIUM = register("block_australium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_BERYLLIUM = register("block_beryllium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_BISMUTH = register("block_bismuth", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_CADMIUM = register("block_cadmium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_CDALLOY = register("block_cdalloy", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_COLTAN = register("block_coltan", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_COMBINE_STEEL = register("block_combine_steel", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_COPPER = register("block_copper", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_DESH = register("block_desh", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_DINEUTRONIUM = register("block_dineutronium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_DURA_STEEL = register("block_dura_steel", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_EUPHEMIUM = register("block_euphemium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_FOAM = register("block_foam", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_LANTHANIUM = register("block_lanthanium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_LEAD = register("block_lead", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_LITHIUM = register("block_lithium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_MAGNETIZED_TUNGSTEN = register("block_magnetized_tungsten", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_METEOR = register("block_meteor", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_METEOR_MOLTEN = register("block_meteor_molten", () -> new MoltenMeteorBlock(BlockBehaviour.Properties.of().strength(15.0F, 360.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).lightLevel(state -> 12).randomTicks()));
    public static final DeferredBlock<Block> BLOCK_METEOR_COBBLE = register("block_meteor_cobble", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_METEOR_BROKEN = register("block_meteor_broken", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_METEOR_TREASURE = register("block_meteor_treasure", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_MOX_FUEL = register("block_mox_fuel", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_NEPTUNIUM = register("block_neptunium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_NIOBIUM = register("block_niobium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_NITER = register("block_niter", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_PLUTONIUM = register("block_plutonium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_PLUTONIUM_FUEL = register("block_plutonium_fuel", () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_POLONIUM = register("block_polonium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_PU238 = register("block_pu238", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_PU239 = register("block_pu239", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_PU240 = register("block_pu240", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_PU_MIX = register("block_pu_mix", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_RA226 = register("block_ra226", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_RED_COPPER = register("block_red_copper", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_SATURNITE = register("block_saturnite", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_SCHRABIDATE = register("block_schrabidate", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_SCHRABIDIUM = register("block_schrabidium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_SCHRABIDIUM_FUEL = register("block_schrabidium_fuel", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_SCHRARANIUM = register("block_schraranium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_SMORE = register("block_smore", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_SOLINIUM = register("block_solinium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_SULFUR = register("block_sulfur", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_TANTALIUM = register("block_tantalium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_TCALLOY = register("block_tcalloy", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_THORIUM = register("block_thorium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_THORIUM_FUEL = register("block_thorium_fuel", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_TITANIUM = register("block_titanium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_TUNGSTEN = register("block_tungsten", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_U233 = register("block_u233", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_U235 = register("block_u235", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_U238 = register("block_u238", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_URANIUM = register("block_uranium", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_URANIUM_FUEL = register("block_uranium_fuel", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_WASTE = register("block_waste", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_WASTE_PAINTED = register("block_waste_painted", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_WASTE_VITRIFIED = register("block_waste_vitrified", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_YELLOWCAKE = register("block_yellowcake", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_FIBERGLASS = register("block_fiberglass", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> REINFORCED_LAMINATE = registerNew("reinforced_laminate", () -> new Block(BlockBehaviour.Properties.of().strength(0.3F, 3.0F).sound(SoundType.GLASS).noOcclusion().mapColor(MapColor.NONE)));
    public static final DeferredBlock<Block> BLOCK_INSULATOR = register("block_insulator", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> BLOCK_SLAG = register("block_slag", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));

    // Deco Blocks
    public static final DeferredBlock<Block> BOBBLEHEAD = registerNew("bobblehead", () -> new BobbleBlock(BlockBehaviour.Properties.of().noOcclusion().instabreak().mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> PLUSHIE = registerNew("plushie", () -> new PlushieBlock(BlockBehaviour.Properties.of().noOcclusion().instabreak().sound(SoundType.WOOL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> PLANT_FLOWER = registerNew("plant_flower", () -> new Block(BlockBehaviour.Properties.of().noOcclusion().instabreak().sound(SoundType.GRASS).mapColor(DyeColor.GREEN)));
    public static final DeferredBlock<Block> GLASS_QUARTZ = register("glass_quartz", () -> new Block(BlockBehaviour.Properties.of().noOcclusion().strength(1.0F, 10.0F).sound(SoundType.GLASS).mapColor(MapColor.METAL)));

    // Gravel
    public static final DeferredBlock<Block> GRAVEL_OBSIDIAN = registerBlastInfoBlock("gravel_obsidian", () -> new ColoredFallingBlock(new ColorRGBA(-8356741), BlockBehaviour.Properties.of().strength(5.0F, 240.0F).sound(SoundType.GRAVEL).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> GRAVEL_DIAMOND = register("gravel_diamond", () -> new ColoredFallingBlock(new ColorRGBA(-8356741), BlockBehaviour.Properties.of().strength(0.6F).sound(SoundType.GRAVEL).mapColor(MapColor.STONE)), LoreBlockItem.class, new Properties().rarity(Rarity.RARE));
    public static final DeferredBlock<Block> MOON_TURF = register("moon_turf", () -> new ColoredFallingBlock(new ColorRGBA(-176741), BlockBehaviour.Properties.of().strength(0.6F).sound(SoundType.SAND).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> SAND_QUARTZ = register("sand_quartz", () -> new ColoredFallingBlock(new ColorRGBA(-845741), BlockBehaviour.Properties.of().strength(0.6F).sound(SoundType.SAND).mapColor(MapColor.SNOW)));

    // Reinforced Blocks
    public static final DeferredBlock<Block> ASPHALT =       registerBlastInfoBlock("asphalt",       () -> new SpeedyBlock(1.5, BlockBehaviour.Properties.of().strength(15.0F, 120.0F)                                  .mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredBlock<Block> ASPHALT_LIGHT = registerBlastInfoBlock("asphalt_light", () -> new SpeedyBlock(1.5, BlockBehaviour.Properties.of().strength(15.0F, 120.0F).lightLevel(state -> 15).mapColor(MapColor.SAND)));
    public static final DeferredBlock<Block> STEEL_SCAFFOLD = register("steel_scaffold", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));

    // Bricks
    public static final DeferredBlock<Block> BRICK_CONCRETE =         registerBlastInfoBlock("brick_concrete",         () -> new NoSpawnBlock(BlockBehaviour.Properties.of().strength(15.0F, 160.0F).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> BRICK_CONCRETE_MOSSY =   registerBlastInfoBlock("brick_concrete_mossy",   () -> new Block(BlockBehaviour.Properties.of().strength(15.0F, 160.0F).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> BRICK_CONCRETE_CRACKED = registerBlastInfoBlock("brick_concrete_cracked", () -> new Block(BlockBehaviour.Properties.of().strength(15.0F, 60.0F).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> BRICK_CONCRETE_BROKEN =  registerBlastInfoBlock("brick_concrete_broken",  () -> new Block(BlockBehaviour.Properties.of().strength(15.0F, 45.0F).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> BRICK_CONCRETE_MARKED =  registerBlastInfoBlock("brick_concrete_marked",  () -> new WritingBlock(BlockBehaviour.Properties.of().strength(15.0F, 160.0F ).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> BRICK_OBSIDIAN =         registerBlastInfoBlock("brick_obsidian",         () -> new Block(BlockBehaviour.Properties.of().strength(15.0F, 120.0F).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final DeferredBlock<Block> BRICK_LIGHT =            registerBlastInfoBlock("brick_light",            () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 20.0F).mapColor(MapColor.SAND)));
    public static final DeferredBlock<Block> BRICK_ASBESTOS =         register(              "brick_asbestos",         () -> new OutgasBlock(true, true, BlockBehaviour.Properties.of().strength(5.0F, 1000.0F).mapColor(MapColor.SNOW)));
    public static final DeferredBlock<Block> BRICK_FIRE =             registerBlastInfoBlock("brick_fire",             () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 35.0F).mapColor(MapColor.FIRE)));
    public static final DeferredBlock<Block> CONCRETE =               registerBlastInfoBlock("concrete",             () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 84.0F).mapColor(MapColor.SNOW)));
    public static final DeferredBlock<Block> CONCRETE_SMOOTH =        registerBlastInfoBlock("concrete_smooth",             () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 84.0F).mapColor(MapColor.SNOW)));
    public static final DeferredBlock<Block> CONCRETE_ASBESTOS =      registerBlastInfoBlock("concrete_asbestos",             () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 900.0F).mapColor(MapColor.SNOW)));
    public static final DeferredBlock<Block> DUCRETE =                registerBlastInfoBlock("ducrete",             () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 300.0F).mapColor(MapColor.DEEPSLATE)));
    public static final DeferredBlock<Block> DUCRETE_SMOOTH =         registerBlastInfoBlock("ducrete_smooth",             () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 300.0F).mapColor(MapColor.DEEPSLATE)));
    public static final DeferredBlock<Block> DUCRETE_REINFORCED =     registerBlastInfoBlock("ducrete_reinforced",             () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 600.0F).mapColor(MapColor.DEEPSLATE)));
    public static final DeferredBlock<Block> DUCRETE_BRICK =          registerBlastInfoBlock("ducrete_brick",             () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 450.0F).mapColor(MapColor.DEEPSLATE)));

    public static final DeferredBlock<SlabBlock> BRICK_CONCRETE_SLAB =         register("brick_concrete_slab",         () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(BRICK_CONCRETE.get())));
    public static final DeferredBlock<SlabBlock> BRICK_CONCRETE_MOSSY_SLAB =   register("brick_concrete_mossy_slab",   () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(BRICK_CONCRETE.get())));
    public static final DeferredBlock<SlabBlock> BRICK_CONCRETE_CRACKED_SLAB = register("brick_concrete_cracked_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(BRICK_CONCRETE.get())));
    public static final DeferredBlock<SlabBlock> BRICK_CONCRETE_BROKEN_SLAB =  register("brick_concrete_broken_slab",  () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(BRICK_CONCRETE.get())));

    public static final DeferredBlock<StairBlock> BRICK_CONCRETE_STAIRS =         register("brick_concrete_stairs",         () -> new StairBlock(BRICK_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BRICK_CONCRETE.get())));
    public static final DeferredBlock<StairBlock> BRICK_CONCRETE_MOSSY_STAIRS =   register("brick_concrete_mossy_stairs",   () -> new StairBlock(BRICK_CONCRETE_MOSSY.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BRICK_CONCRETE.get())));
    public static final DeferredBlock<StairBlock> BRICK_CONCRETE_CRACKED_STAIRS = register("brick_concrete_cracked_stairs", () -> new StairBlock(BRICK_CONCRETE_CRACKED.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BRICK_CONCRETE.get())));
    public static final DeferredBlock<StairBlock> BRICK_CONCRETE_BROKEN_STAIRS =  register("brick_concrete_broken_stairs",  () -> new StairBlock(BRICK_CONCRETE_BROKEN.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BRICK_CONCRETE.get())));

    // Other defensive stuff
    public static final DeferredBlock<Block> BARBED_WIRE = registerNew("barbed_wire", () -> new BarbedWireBlock(BlockBehaviour.Properties.of().strength(5.0F, 10.0F).noCollission()));
    public static final DeferredBlock<Block> SPIKES = register("spikes", () -> new SpikesBlock(BlockBehaviour.Properties.of().strength(2.5F, 5.0F).noCollission()));

    // Waste
    public static final DeferredBlock<Block> WASTE_EARTH =         register("waste_earth",         () -> new Block(               BlockBehaviour.Properties.of().strength(0.6F).sound(SoundType.GRASS).mapColor(MapColor.DIRT)));
    public static final DeferredBlock<Block> WASTE_MYCELIUM =      register("waste_mycelium",      () -> new WasteMyceliumBlock(  BlockBehaviour.Properties.of().strength(0.6F).lightLevel(value -> 10).sound(SoundType.GRASS).mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final DeferredBlock<Block> WASTE_TRINITITE =     register("waste_trinitite",     () -> new WasteTrinititeBlock( BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.SAND).mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE)));
    public static final DeferredBlock<Block> WASTE_TRINITITE_RED = register("waste_trinitite_red", () -> new WasteTrinititeBlock( BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.SAND).mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.SNARE)));
    public static final DeferredBlock<RotatedPillarBlock> WASTE_LOG = register("waste_log",    () -> new RotatedPillarBlock( BlockBehaviour.Properties.of().strength(5.0F, 2.5F).sound(SoundType.WOOD).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredBlock<Block> WASTE_LEAVES =           register("waste_leaves", () -> new WasteLeavesBlock(   BlockBehaviour.Properties.of().strength(0.2F).randomTicks().mapColor(MapColor.COLOR_BROWN).sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::never).isSuffocating(NtmBlocks::never).isViewBlocking(NtmBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(NtmBlocks::never)));
    public static final DeferredBlock<Block> WASTE_PLANKS =           register("waste_planks", () -> new Block(              BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.WOOD).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredBlock<Block> FROZEN_DIRT =             register("frozen_dirt",   () -> new FrozenBlock(        BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.GLASS).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> FROZEN_GRASS =            register("frozen_grass",  () -> new FrozenBlock(        BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.GLASS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<RotatedPillarBlock> FROZEN_LOG = register("frozen_log",    () -> new RotatedPillarBlock( BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.GLASS).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> FROZEN_PLANKS =           register("frozen_planks", () -> new Block(              BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.GLASS).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> LEAVES_LAYER = register("leaves_layer", () -> new LayeringBlock(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().mapColor(MapColor.COLOR_BROWN).sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::never).isSuffocating(NtmBlocks::never).isViewBlocking(NtmBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(NtmBlocks::never)));
    public static final DeferredBlock<Block> FALLOUT = register("fallout", () -> new FalloutBlock(BlockBehaviour.Properties.of().replaceable().strength(0.1F).sound(SoundType.GRAVEL).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> SELLAFIELD_SLAKED = register("sellafield_slaked", () -> new SellafieldSlakedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).isValidSpawn(Blocks::never).requiresCorrectToolForDrops().strength(3.0F, 10.0F)));
    public static final DeferredBlock<Block> ORE_SELLAFIELD_DIAMOND = register("ore_sellafield_diamond", () -> new SellafieldSlakedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).isValidSpawn(Blocks::never).requiresCorrectToolForDrops().strength(3.0F, 10.0F)));
    public static final DeferredBlock<Block> ORE_SELLAFIELD_EMERALD = register("ore_sellafield_emerald", () -> new SellafieldSlakedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).isValidSpawn(Blocks::never).requiresCorrectToolForDrops().strength(3.0F, 10.0F)));
    public static final DeferredBlock<Block> SELLAFIELD_BEDROCK = register("sellafield_bedrock", () -> new SellafieldSlakedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).isValidSpawn(Blocks::never).noLootTable().strength(-1.0F, 6000000.0F).instrument(NoteBlockInstrument.BASEDRUM)));

    // Nukes
    public static final DeferredBlock<Block> NUKE_GADGET =     register("nuke_gadget",     () -> new NukeGadgetBlock(    BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 200.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> NUKE_LITTLE_BOY = register("nuke_little_boy", () -> new NukeLittleBoyBlock( BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 200.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> NUKE_FAT_MAN =    register("nuke_fat_man",    () -> new NukeFatManBlock(    BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 200.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> NUKE_IVY_MIKE =   register("nuke_ivy_mike",   () -> new NukeIvyMikeBlock(   BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 200.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> NUKE_TSAR_BOMBA = register("nuke_tsar_bomba", () -> new NukeTsarBombaBlock( BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 200.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> NUKE_PROTOTYPE =  register("nuke_prototype",  () -> new NukePrototypeBlock( BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 200.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> NUKE_FLEIJA =     register("nuke_fleija",     () -> new NukeFleijaBlock(    BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 200.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> NUKE_SOLINIUM =   register("nuke_solinium",   () -> new NukeSoliniumBlock(  BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 200.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> NUKE_N2 =         register("nuke_n2",         () -> new NukeN2Block(        BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 200.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> NUKE_FSTBMB =     register("nuke_fstbmb",     () -> new NukeBalefireBlock(  BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 200.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));

    // Generic Bombs
    // todo add bomb_multi
    public static final DeferredBlock<Block> CRASHED_BOMB = registerNew("crashed_bomb", () -> new CrashedBombBlock(BlockBehaviour.Properties.of().noLootTable().noOcclusion().strength(6000.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> DYNAMITE = register("dynamite", () -> new DynamiteBlock( BlockBehaviour.Properties.of().instabreak().ignitedByLava().isRedstoneConductor(NtmBlocks::never).sound(SoundType.GRASS).mapColor(MapColor.FIRE)));
    public static final DeferredBlock<Block> TNT =      register("tnt",      () -> new TNTBlock(      BlockBehaviour.Properties.of().instabreak().ignitedByLava().isRedstoneConductor(NtmBlocks::never).sound(SoundType.GRASS).mapColor(MapColor.FIRE)));
    public static final DeferredBlock<Block> SEMTEX =   register("semtex",   () -> new SemtexBlock(   BlockBehaviour.Properties.of().instabreak().ignitedByLava().isRedstoneConductor(NtmBlocks::never).sound(SoundType.GRASS).mapColor(MapColor.FIRE)));
    public static final DeferredBlock<Block> C4 =       register("c4",       () -> new C4Block(       BlockBehaviour.Properties.of().instabreak().ignitedByLava().isRedstoneConductor(NtmBlocks::never).sound(SoundType.GRASS).mapColor(MapColor.FIRE)));
    public static final DeferredBlock<Block> FISSURE_BOMB = register("fissure_bomb", () -> new FissureBombBlock(BlockBehaviour.Properties.of().instabreak().ignitedByLava().isRedstoneConductor(NtmBlocks::never).sound(SoundType.GRASS).mapColor(MapColor.FIRE)));

    // Mines
    public static final DeferredBlock<Block> MINE_AP =    register("mine_ap",    () -> new LandmineBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0F, 0.0F).sound(SoundType.METAL).mapColor(MapColor.METAL), 1.5D, 1D));
    public static final DeferredBlock<Block> MINE_HE =    register("mine_he",    () -> new LandmineBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0F, 0.0F).sound(SoundType.METAL).mapColor(MapColor.METAL), 2D, 5D));
    public static final DeferredBlock<Block> MINE_SHRAP = register("mine_shrap", () -> new LandmineBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0F, 0.0F).sound(SoundType.METAL).mapColor(MapColor.METAL), 1.5D, 1D));
    public static final DeferredBlock<Block> MINE_FAT =   register("mine_fat",   () -> new LandmineBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0F, 0.0F).sound(SoundType.METAL).mapColor(MapColor.METAL), 2.5D, 1D));
    public static final DeferredBlock<Block> MINE_NAVAL = register("mine_naval", () -> new LandmineBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0F, 0.0F).sound(SoundType.METAL).mapColor(MapColor.METAL), 2.5D, 1D));

    // Anvil construction placeholders
    public static final DeferredBlock<Block> DECO_ALUMINIUM = register("deco_aluminium", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> DECO_BERYLLIUM = register("deco_beryllium", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> DECO_LEAD = register("deco_lead", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> DECO_RED_COPPER = register("deco_red_copper", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> DECO_STEEL = register("deco_steel", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> DECO_RUSTY_STEEL = register("deco_rusty_steel", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> DECO_TITANIUM = register("deco_titanium", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> DECO_TUNGSTEN = register("deco_tungsten", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> DECO_ASBESTOS = register("deco_asbestos", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.METAL).mapColor(MapColor.METAL)));

    // Block Bombs
    public static final DeferredBlock<Block> DET_CHARGE =  register("det_charge",  () -> new ExplosiveChargeBlock(BlockBehaviour.Properties.of().strength(0.1F, 0.0F).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> DET_CORD =    register("det_cord",    () -> new DetCordBlock(BlockBehaviour.Properties.of().strength(0.1F, 0.0F).noOcclusion().isSuffocating(NtmBlocks::never).isViewBlocking(NtmBlocks::never).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> DET_NUKE =    register("det_nuke",    () -> new ExplosiveChargeBlock(BlockBehaviour.Properties.of().strength(0.1F, 0.0F).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> DET_MINER =   register("det_miner",   () -> new ExplosiveChargeBlock(BlockBehaviour.Properties.of().strength(0.1F, 0.0F).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> BARREL_RED =   register("barrel_red",   () -> new RedBarrelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1F, 2.5F).sound(SoundType.METAL), true));
    public static final DeferredBlock<Block> BARREL_PINK =  register("barrel_pink",  () -> new RedBarrelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1F, 2.5F).sound(SoundType.METAL), true));
    public static final DeferredBlock<Block> BARREL_LOX =   register("barrel_lox",   () -> new RedBarrelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1F, 2.5F).sound(SoundType.METAL), false));
    public static final DeferredBlock<Block> BARREL_TAINT = register("barrel_taint", () -> new RedBarrelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1F, 2.5F).sound(SoundType.METAL), false));

    // Geiger Counter
    public static final DeferredBlock<Block> GEIGER = register("geiger", () -> new GeigerCounterBlock(BlockBehaviour.Properties.of().strength(15.0F, 0.25F).sound(SoundType.METAL).mapColor(MapColor.COLOR_YELLOW)));

    // Machines
    public static final DeferredBlock<Block> ANVIL = registerNew("anvil", () -> new NTMAnvilBlock(BlockBehaviour.Properties.of().strength(0.6F, 100.0F).sound(SoundType.ANVIL).mapColor(MapColor.METAL).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<Block> PRESS_PREHEATER = register("press_preheater", () -> new Block(BlockBehaviour.Properties.of().strength(0.6F, 10.0F).mapColor(MapColor.FIRE)));
    public static final DeferredBlock<Block> MACHINE_PRESS = register("machine_press", () -> new MachinePressBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));

    public static final DeferredBlock<Block> HEAT_BOILER = register("heat_boiler", () -> new MachineHeatBoiler(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MACHINE_INDUSTRIAL_BOILER = register("machine_industrial_boiler", () -> new MachineIndustrialBoiler(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> HEATER_FIREBOX = register("heater_firebox", () -> new HeaterFireboxBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> HEATER_OVEN = register("heater_oven", () -> new HeaterOvenBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> HEATER_OILBURNER = register("heater_oilburner", () -> new HeaterOilburnerBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> HEATER_ELECTRIC = register("heater_electric", () -> new HeaterElectricBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> HEATER_HEATEX = register("heater_heatex", () -> new HeaterHeatexBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MACHINE_SHREDDER = register("machine_shredder", () -> new MachineShredderBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 100.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MACHINE_SOLDERING_STATION = register("machine_soldering_station", () -> new MachineSolderingStationBlock(BlockBehaviour.Properties.of().strength(0.6F, 100.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<Block> MACHINE_ARC_WELDER = register("machine_arc_welder", () -> new MachineArcWelderBlock(BlockBehaviour.Properties.of().strength(0.6F, 10F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<Block> MACHINE_WELL = registerNew("machine_well", () -> new MachineOilWellBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> MACHINE_PUMPJACK = registerNew("machine_pumpjack", () -> new MachinePumpjackBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> MACHINE_FRACKING_TOWER = registerNew("machine_fracking_tower", () -> new MachineFrackingTowerBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 10F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> MACHINE_REFINERY = register("machine_refinery", () -> new MachineRefineryBlock(BlockBehaviour.Properties.of().strength(0.6F, 10F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<Block> FURNACE_COMBINATION = register("furnace_combination", () -> new MachineFurnaceCombinationBlock(BlockBehaviour.Properties.of().strength(0.6F, 100.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<Block> MACHINE_BLAST_FURNACE = register("machine_blast_furnace", () -> new MachineBlastFurnaceBlock(BlockBehaviour.Properties.of().strength(0.6F, 100.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<Block> MACHINE_WOOD_BURNER = register("machine_wood_burner", () -> new MachineWoodBurnerBlock(BlockBehaviour.Properties.of().strength(0.6F, 100.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<Block> MACHINE_CENTRIFUGE = register("machine_centrifuge", () -> new MachineCentrifugeBlock(BlockBehaviour.Properties.of().strength(0.6F, 100.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> MACHINE_CHEMICAL_PLANT = register("machine_chemical_plant", () -> new MachineChemicalPlantBlock(BlockBehaviour.Properties.of().strength(0.6F, 100.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<Block> CRATE_IRON = registerNew("crate_iron", () -> new CrateBlock(BlockBehaviour.Properties.of().strength(0.6F, 6.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops(), CrateBlock.Type.IRON));
    public static final DeferredBlock<Block> CRATE_TUNGSTEN = registerNew("crate_tungsten", () -> new CrateBlock(BlockBehaviour.Properties.of().strength(0.6F, 6.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops(), CrateBlock.Type.TUNGSTEN));
    public static final DeferredBlock<Block> CRATE_STEEL = registerNew("crate_steel", () -> new CrateBlock(BlockBehaviour.Properties.of().strength(0.6F, 6.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops(), CrateBlock.Type.STEEL));
    public static final DeferredBlock<Block> CRATE_DESH = registerNew("crate_desh", () -> new CrateBlock(BlockBehaviour.Properties.of().strength(0.6F, 6.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops(), CrateBlock.Type.DESH));
    public static final DeferredBlock<Block> CRATE_TEMPLATE = registerNew("crate_template", () -> new CrateBlock(BlockBehaviour.Properties.of().strength(0.6F, 6.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops(), CrateBlock.Type.TEMPLATE));
    public static final DeferredBlock<Block> BARREL_PLASTIC = registerNew("barrel_plastic", () -> new com.hbm.blocks.machine.BarrelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F, 2.5F).sound(SoundType.METAL), 12_000, false));
    public static final DeferredBlock<Block> EMP_BOMB = register("emp_bomb", () -> new Block(BlockBehaviour.Properties.of().strength(3.0F, 30.0F).sound(SoundType.METAL).mapColor(MapColor.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BARREL_STEEL = registerNew("barrel_steel", () -> new com.hbm.blocks.machine.BarrelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F, 2.5F).sound(SoundType.METAL), 16_000, false));
    public static final DeferredBlock<Block> BARREL_CORRODED = registerNew("barrel_corroded", () -> new com.hbm.blocks.machine.BarrelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F, 2.5F).sound(SoundType.METAL), 6_000, true));
    public static final DeferredBlock<Block> BARREL_TCALLOY = registerNew("barrel_tcalloy", () -> new com.hbm.blocks.machine.BarrelBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F, 2.5F).sound(SoundType.METAL), 24_000, false));
    public static final DeferredBlock<Block> TRANSFORMER = register("transformer", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.METAL).mapColor(MapColor.METAL)));

    public static final DeferredBlock<Block> REACTOR_ZIRNOX = register("machine_zirnox", () -> new ReactorZirnoxBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 100F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> ZIRNOX_DESTROYED = register("zirnox_destroyed", () -> new ZirnoxDestroyedBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.6F, 100F).sound(SoundType.METAL).mapColor(MapColor.METAL)));

    public static final DeferredBlock<Block> RED_CABLE = register("red_cable", () -> new CableBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.5F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.COLOR_BLACK)));

    public static final DeferredBlock<Block> FLUID_DUCT_NEO = registerNew("fluid_duct_neo", () -> new FluidDuctStandardBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0F, 10.0F).sound(ModSoundTypes.PIPE).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> RADIO_TORCH_SENDER = register("radio_torch_sender", () -> new RadioTorchSenderBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0F, 10.0F).sound(ModSoundTypes.PIPE).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> RADIO_TORCH_RECEIVER  = register("radio_torch_receiver", () -> new RadioTorchReceiverBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0F, 10.0F).sound(ModSoundTypes.PIPE).mapColor(MapColor.METAL)));

    public static final DeferredBlock<Block> MACHINE_BATTERY_SOCKET = register("machine_battery_socket", () -> new MachineBatterySocketBlock(BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> MACHINE_BATTERY_REDD = register("machine_battery_redd", () -> new MachineBatteryREDDBlock(BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> MACHINE_ASSEMBLY_MACHINE = register("machine_assembly_machine", () -> new MachineAssemblyMachineBlock(BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 30.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> MACHINE_FLUID_TANK = register("machine_fluid_tank", () -> new MachineFluidTankBlock(BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 20.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> MACHINE_CHUNGUS = register("machine_chungus", () -> new MachineChungusBlock(BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 20.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));

    public static final DeferredBlock<Block> MACHINE_SATLINKER = register("machine_satlinker", () -> new MachineSatLinkerBlock(BlockBehaviour.Properties.of().strength(5.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.METAL)));

    // Absorbers
    public static final DeferredBlock<Block> DECONTAMINATOR = register("decontaminator", () -> new DecontaminatorBlock(BlockBehaviour.Properties.of().strength(5.0F, 10.0F).sound(SoundType.METAL).mapColor(MapColor.TERRACOTTA_GREEN)));

    // PWR
    public static final DeferredBlock<Block> PWR_CONTROLLER = register("pwr_controller", () -> new Block(BlockBehaviour.Properties.of()));
    
    // E
    public static final DeferredBlock<Block> BALEFIRE =     BLOCKS.register("balefire",     () -> new BalefireBlock(     BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).replaceable().noCollission().noOcclusion().strength(0F).lightLevel(state -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> FIRE_DIGAMMA = BLOCKS.register("fire_digamma", () -> new DigammaFlameBlock( BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).replaceable().noCollission().noOcclusion().strength(0F, 150F).lightLevel(state -> 10).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> VOLCANO_CORE =     registerNew("volcano_core",     () -> new VolcanoBlock(BlockBehaviour.Properties.of().strength(-1.0F, 10000.0F).mapColor(MapColor.NETHER)));
    public static final DeferredBlock<Block> VOLCANO_RAD_CORE = registerNew("volcano_rad_core", () -> new VolcanoBlock(BlockBehaviour.Properties.of().strength(-1.0F, 10000.0F).mapColor(DyeColor.GREEN)));

    // Missile Blocks
    public static final DeferredBlock<Block> LAUNCH_PAD = register("launch_pad", () -> new LaunchPadBlock(BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 10.0F).mapColor(MapColor.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> LAUNCH_PAD_LARGE = register("launch_pad_large", () -> new LaunchPadLargeBlock(BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 10.0F).mapColor(MapColor.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> SOYUZ_LAUNCHER = register("soyuz_launcher", () -> new SoyuzLauncherBlock(BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 10.0F).mapColor(MapColor.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> MACHINE_RADAR = register("machine_radar", () -> new MachineRadarBlock(BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 10.0F).mapColor(MapColor.METAL).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> MACHINE_RADAR_LARGE = register("machine_radar_large", () -> new MachineRadarBlock(BlockBehaviour.Properties.of().noOcclusion().strength(5.0F, 10.0F).mapColor(MapColor.METAL).mapColor(MapColor.METAL)));

    // Fluids
    public static final DeferredBlock<LiquidBlock> VOLCANIC_LAVA = BLOCKS.register("volcanic_lava", () -> new VolcanicLiquidBlock(NtmFluids.VOLCANIC_LAVA.get(), BlockBehaviour.Properties.of().randomTicks().noCollission().replaceable().strength(500F).lightLevel(state -> 15).pushReaction(PushReaction.DESTROY).noLootTable().liquid().sound(SoundType.EMPTY)));
    public static final DeferredBlock<LiquidBlock> RAD_LAVA = BLOCKS.register("rad_lava", () -> new RadLiquidBlock(NtmFluids.RAD_LAVA.get(), BlockBehaviour.Properties.of().randomTicks().noCollission().replaceable().strength(500F).lightLevel(state -> 15).pushReaction(PushReaction.DESTROY).noLootTable().liquid().sound(SoundType.EMPTY)));

    // Other Technical Blocks
    public static final DeferredBlock<Block> GAS_RADON =       register("gas_radon",       () -> new GasRadonBlock(      BlockBehaviour.Properties.of().replaceable().noCollission().noOcclusion().noLootTable()));
    public static final DeferredBlock<Block> GAS_RADON_DENSE = register("gas_radon_dense", () -> new GasRadonDenseBlock( BlockBehaviour.Properties.of().replaceable().noCollission().noOcclusion().noLootTable()));
    public static final DeferredBlock<Block> GAS_RADON_TOMB =  register("gas_radon_tomb",  () -> new GasRadonTombBlock(  BlockBehaviour.Properties.of().replaceable().noCollission().noOcclusion().noLootTable()));
    public static final DeferredBlock<Block> GAS_MELTDOWN =    register("gas_meltdown",    () -> new GasMeltdownBlock(   BlockBehaviour.Properties.of().replaceable().noCollission().noOcclusion().noLootTable()));
    public static final DeferredBlock<Block> GAS_MONOXIDE =    register("gas_monoxide",    () -> new GasMonoxideBlock(   BlockBehaviour.Properties.of().replaceable().noCollission().noOcclusion().noLootTable()));
    public static final DeferredBlock<Block> GAS_ASBESTOS =    register("gas_asbestos",    () -> new GasAsbestosBlock(   BlockBehaviour.Properties.of().replaceable().noCollission().noOcclusion().noLootTable()));
    public static final DeferredBlock<Block> GAS_COAL =        register("gas_coal",        () -> new GasCoalBlock(       BlockBehaviour.Properties.of().replaceable().noCollission().noOcclusion().noLootTable()));
    public static final DeferredBlock<Block> GAS_FLAMMABLE =   register("gas_flammable",   () -> new GasFlammableBlock(  BlockBehaviour.Properties.of().replaceable().noCollission().noOcclusion().noLootTable()));
    public static final DeferredBlock<Block> GAS_EXPLOSIVE =   register("gas_explosive",   () -> new GasExplosiveBlock(  BlockBehaviour.Properties.of().replaceable().noCollission().noOcclusion().noLootTable()));
    public static final DeferredBlock<Block> OIL_PIPE =        register("oil_pipe",        () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).noLootTable().sound(SoundType.METAL).mapColor(MapColor.METAL)));

    // ???
    public static final DeferredBlock<Block> TAINT = register("taint", () -> new TaintBlock(BlockBehaviour.Properties.of().randomTicks().strength(15.0F, 10.0F).noLootTable().mapColor(DyeColor.GRAY)));

    public static boolean always(BlockState state, BlockGetter blockGetter, BlockPos pos) { return true; }
    public static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) { return false; }
    public static boolean noSpawn(BlockState var1, BlockGetter var2, BlockPos var3, EntityType<?> var4) { return false; }

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        DeferredBlock<T> defBlock = BLOCKS.register(name, block);
        NtmItems.ITEMS.register(name, () -> new BlockItem(defBlock.get(), new Properties()));
        return defBlock;
    }

    private static <T extends Block> DeferredBlock<T> registerNew(String name, Supplier<T> block) {
        DeferredBlock<T> defBlock = BLOCKS.register(name, block);
        NtmItems.ITEMS.register(name, () -> new BlockItemBase(defBlock.get(), new Properties()));
        return defBlock;
    }

    private static <T extends Block> DeferredBlock<T> registerBlastInfoBlock(String name, Supplier<T> block) {
        DeferredBlock<T> defBlock = BLOCKS.register(name, block);
        NtmItems.ITEMS.register(name, () -> new BlastInfoBlockItem(defBlock.get(), new Properties()));
        return defBlock;
    }

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block, Class<? extends BlockItem> clazz, Properties properties) {
        DeferredBlock<T> defBlock = BLOCKS.register(name, block);
        NtmItems.ITEMS.register(name, () -> {
            try {
                return clazz.getConstructor(Block.class, Properties.class).newInstance(defBlock.get(), properties);
            } catch(Exception ignored) {}
            return null;
        });
        return defBlock;
    }

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block, Class<? extends BlockItem> clazz) { return register(name, block, clazz, new Properties()); }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
