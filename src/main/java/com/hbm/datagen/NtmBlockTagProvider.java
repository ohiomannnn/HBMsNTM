package com.hbm.datagen;

import com.hbm.blocks.NtmBlocks;
import com.hbm.main.NuclearTechMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static com.hbm.inventory.NtmTags.Blocks.*;
import static net.neoforged.neoforge.common.Tags.Blocks.PUMPKINS;

public class NtmBlockTagProvider extends BlockTagsProvider {

    public NtmBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NuclearTechMod.MODID, existingFileHelper);
    }

    @Override
    @SuppressWarnings("unchecked") // no
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(PLANTS)
                .addTags(
                        BlockTags.FLOWERS,
                        BlockTags.SAPLINGS,
                        BlockTags.CROPS,
                        PUMPKINS
                )
                .add(
                        Blocks.SHORT_GRASS,
                        Blocks.FERN,
                        Blocks.DEAD_BUSH,
                        Blocks.VINE,
                        Blocks.TALL_GRASS,
                        Blocks.LARGE_FERN
                );

        // im probably dumb but i dont know any tags like this
        tag(ACTUALLY_STONE)
                .add(Blocks.COAL_ORE)
                .add(Blocks.IRON_ORE)
                .add(Blocks.COPPER_ORE)
                .add(Blocks.LAPIS_ORE)
                .add(Blocks.DIAMOND_ORE)

                .add(Blocks.DEEPSLATE_COAL_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .add(Blocks.DEEPSLATE_COPPER_ORE)
                .add(Blocks.DEEPSLATE_LAPIS_ORE)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE)

                .add(Blocks.GRANITE)
                .add(Blocks.ANDESITE)
                .add(Blocks.DIORITE)
                .add(Blocks.DEEPSLATE)
                .add(Blocks.TUFF)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.SANDSTONE)

                .add(NtmBlocks.BRICK_CONCRETE.get())
                .add(NtmBlocks.BRICK_CONCRETE_CRACKED.get())
                .add(NtmBlocks.BRICK_CONCRETE_BROKEN.get())
                .add(NtmBlocks.BRICK_CONCRETE_MOSSY.get())
                .add(NtmBlocks.BRICK_CONCRETE_MARKED.get())
                .add(NtmBlocks.BRICK_LIGHT.get())

                .add(Blocks.STONE);

        tag(GROUND)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.MUD)
                .add(Blocks.MUDDY_MANGROVE_ROOTS)
                .add(Blocks.MANGROVE_ROOTS)
                .add(Blocks.GRAVEL)
                .add(Blocks.DIRT_PATH)
                .add(Blocks.MYCELIUM)
                .add(Blocks.SAND)
                .add(Blocks.DIRT);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        NtmBlocks.ORE_BASALT.get(),

                        NtmBlocks.ORE_OIL.get(),
                        NtmBlocks.ORE_OIL_EMPTY.get(),
                        NtmBlocks.ORE_OIL_SAND.get(),
                        NtmBlocks.ORE_BEDROCK_OIL.get(),
                        NtmBlocks.ORE_URANIUM.get(),
                        NtmBlocks.ORE_URANIUM_DEEPSLATE.get(),
                        NtmBlocks.ORE_URANIUM_SCORCHED.get(),
                        NtmBlocks.ORE_BERYLLIUM.get(),
                        NtmBlocks.ORE_BERYLLIUM_DEEPSLATE.get(),
                        NtmBlocks.ORE_TUNGSTEN.get(),
                        NtmBlocks.ORE_TUNGSTEN_DEEPSLATE.get(),
                        NtmBlocks.ORE_TITANIUM.get(),
                        NtmBlocks.ORE_TITANIUM_DEEPSLATE.get(),
                        NtmBlocks.ORE_LEAD.get(),
                        NtmBlocks.ORE_LEAD_DEEPSLATE.get(),
                        NtmBlocks.ORE_ALUMINIUM.get(),
                        NtmBlocks.ORE_ALUMINIUM_DEEPSLATE.get(),
                        NtmBlocks.ORE_ASBESTOS.get(),
                        NtmBlocks.ORE_ASBESTOS_DEEPSLATE.get(),
                        NtmBlocks.ORE_THORIUM.get(),
                        NtmBlocks.ORE_THORIUM_DEEPSLATE.get(),
                        NtmBlocks.ORE_NITER.get(),
                        NtmBlocks.ORE_NITER_DEEPSLATE.get(),
                        NtmBlocks.ORE_COBALT.get(),
                        NtmBlocks.ORE_COBALT_DEEPSLATE.get(),
                        NtmBlocks.ORE_CINNABAR.get(),
                        NtmBlocks.ORE_CINNABAR_DEEPSLATE.get(),
                        NtmBlocks.ORE_FLUORITE.get(),
                        NtmBlocks.ORE_FLUORITE_DEEPSLATE.get(),
                        NtmBlocks.ORE_METEOR_IRON.get(),
                        NtmBlocks.ORE_METEOR_COBALT.get(),
                        NtmBlocks.ORE_METEOR_ALUMINIUM.get(),
                        NtmBlocks.ORE_METEOR_COPPER.get(),
                        NtmBlocks.ORE_METEOR_RARE.get(),
                        NtmBlocks.ORE_RARE.get(),
                        NtmBlocks.ORE_RARE_DEEPSLATE.get(),
                        NtmBlocks.ORE_SULFUR.get(),
                        NtmBlocks.ORE_SULFUR_DEEPSLATE.get(),
                        NtmBlocks.ORE_LIGNITE.get(),
                        NtmBlocks.ORE_DEEPSLATE_LIGNITE.get(),
                        NtmBlocks.ORE_SCHRABIDIUM.get(),
                        NtmBlocks.ORE_NETHER_URANIUM.get(),
                        NtmBlocks.ORE_NETHER_URANIUM_SCORCHED.get(),
                        NtmBlocks.ORE_NETHER_PLUTONIUM.get(),
                        NtmBlocks.ORE_NETHER_SCHRABIDIUM.get(),
                        NtmBlocks.ORE_TIKITE.get(),
                        NtmBlocks.ORE_GNEISS_URANIUM.get(),
                        NtmBlocks.ORE_GNEISS_URANIUM_SCORCHED.get(),
                        NtmBlocks.ORE_GNEISS_SCHRABIDIUM.get(),
                        NtmBlocks.ORE_SELLAFIELD_EMERALD.get(),
                        NtmBlocks.ORE_SELLAFIELD_DIAMOND.get(),
                        NtmBlocks.DECO_RED_COPPER.get(),
                        NtmBlocks.DECO_ASBESTOS.get(),
                        NtmBlocks.DECO_ALUMINIUM.get(),
                        NtmBlocks.DECO_TUNGSTEN.get(),
                        NtmBlocks.DECO_TITANIUM.get(),
                        NtmBlocks.DECO_LEAD.get(),
                        NtmBlocks.DECO_RUSTY_STEEL.get(),
                        NtmBlocks.DECO_STEEL.get(),
                        NtmBlocks.DECO_BERYLLIUM.get(),
                        NtmBlocks.DECONTAMINATOR.get(),
                        NtmBlocks.BARREL_CORRODED.get(),
                        NtmBlocks.BARREL_STEEL.get(),
                        NtmBlocks.BARREL_PLASTIC.get(),
                        NtmBlocks.BARREL_TCALLOY.get(),
                        NtmBlocks.BLOCK_BERYLLIUM.get(),
                        NtmBlocks.BLOCK_ACTINIUM.get(),
                        NtmBlocks.BLOCK_STEEL.get(),
                        NtmBlocks.BLOCK_ALUMINIUM.get(),
                        NtmBlocks.BLOCK_ASBESTOS.get(),
                        NtmBlocks.BLOCK_AUSTRALIUM.get(),
                        NtmBlocks.BLOCK_BISMUTH.get(),
                        NtmBlocks.BLOCK_CADMIUM.get(),
                        NtmBlocks.BLOCK_CDALLOY.get(),
                        NtmBlocks.BLOCK_COLTAN.get(),
                        NtmBlocks.BLOCK_COMBINE_STEEL.get(),
                        NtmBlocks.BLOCK_COPPER.get(),
                        NtmBlocks.BLOCK_DESH.get(),
                        NtmBlocks.BLOCK_DINEUTRONIUM.get(),
                        NtmBlocks.BLOCK_DURA_STEEL.get(),
                        NtmBlocks.BLOCK_EUPHEMIUM.get(),
                        NtmBlocks.BLOCK_FOAM.get(),
                        NtmBlocks.BLOCK_LANTHANIUM.get(),
                        NtmBlocks.BLOCK_LEAD.get(),
                        NtmBlocks.BLOCK_LITHIUM.get(),
                        NtmBlocks.BLOCK_MAGNETIZED_TUNGSTEN.get(),
                        NtmBlocks.BLOCK_METEOR_MOLTEN.get(),
                        NtmBlocks.BLOCK_MOX_FUEL.get(),
                        NtmBlocks.BLOCK_NEPTUNIUM.get(),
                        NtmBlocks.BLOCK_NIOBIUM.get(),
                        NtmBlocks.BLOCK_NITER.get(),
                        NtmBlocks.BLOCK_PLUTONIUM.get(),
                        NtmBlocks.BLOCK_PLUTONIUM_FUEL.get(),
                        NtmBlocks.BLOCK_POLONIUM.get(),
                        NtmBlocks.BLOCK_PU238.get(),
                        NtmBlocks.BLOCK_PU239.get(),
                        NtmBlocks.BLOCK_PU240.get(),
                        NtmBlocks.BLOCK_PU_MIX.get(),
                        NtmBlocks.BLOCK_RA226.get(),
                        NtmBlocks.BLOCK_RED_COPPER.get(),
                        NtmBlocks.BLOCK_SATURNITE.get(),
                        NtmBlocks.BLOCK_SCHRABIDATE.get(),
                        NtmBlocks.BLOCK_SCHRABIDIUM.get(),
                        NtmBlocks.BLOCK_SCHRABIDIUM_FUEL.get(),
                        NtmBlocks.BLOCK_SCHRARANIUM.get(),
                        NtmBlocks.BLOCK_SMORE.get(),
                        NtmBlocks.BLOCK_SOLINIUM.get(),
                        NtmBlocks.BLOCK_SULFUR.get(),
                        NtmBlocks.BLOCK_TANTALIUM.get(),
                        NtmBlocks.BLOCK_TCALLOY.get(),
                        NtmBlocks.BLOCK_THORIUM.get(),
                        NtmBlocks.BLOCK_THORIUM_FUEL.get(),
                        NtmBlocks.BLOCK_TITANIUM.get(),
                        NtmBlocks.BLOCK_TUNGSTEN.get(),
                        NtmBlocks.BLOCK_U233.get(),
                        NtmBlocks.BLOCK_U235.get(),
                        NtmBlocks.BLOCK_U238.get(),
                        NtmBlocks.BLOCK_URANIUM.get(),
                        NtmBlocks.BLOCK_URANIUM_FUEL.get(),
                        NtmBlocks.BLOCK_WASTE.get(),
                        NtmBlocks.BLOCK_WASTE_PAINTED.get(),
                        NtmBlocks.BLOCK_WASTE_VITRIFIED.get(),
                        NtmBlocks.BLOCK_YELLOWCAKE.get(),
                        NtmBlocks.BLOCK_FIBERGLASS.get(),
                        NtmBlocks.BLOCK_INSULATOR.get(),
                        NtmBlocks.BLOCK_SLAG.get(),
                        NtmBlocks.BLOCK_METEOR.get(),
                        NtmBlocks.BLOCK_METEOR_MOLTEN.get(),
                        NtmBlocks.BLOCK_METEOR_BROKEN.get(),
                        NtmBlocks.BLOCK_METEOR_COBBLE.get(),
                        NtmBlocks.BLOCK_METEOR_TREASURE.get(),

                        NtmBlocks.BASALT.get(),
                        NtmBlocks.BASALT_SMOOTH.get(),
                        NtmBlocks.BASALT_BRICK.get(),
                        NtmBlocks.BASALT_POLISHED.get(),
                        NtmBlocks.BASALT_TILES.get(),

                        NtmBlocks.ASPHALT.get(),
                        NtmBlocks.ASPHALT_LIGHT.get(),

                        NtmBlocks.BRICK_CONCRETE.get(),
                        NtmBlocks.BRICK_CONCRETE_MOSSY.get(),
                        NtmBlocks.BRICK_CONCRETE_CRACKED.get(),
                        NtmBlocks.BRICK_CONCRETE_BROKEN.get(),
                        NtmBlocks.BRICK_CONCRETE_MARKED.get(),
                        NtmBlocks.BRICK_OBSIDIAN.get(),
                        NtmBlocks.BRICK_LIGHT.get(),
                        NtmBlocks.BRICK_ASBESTOS.get(),
                        NtmBlocks.BRICK_FIRE.get(),
                        NtmBlocks.REINFORCED_LAMINATE.get(),
                        NtmBlocks.CONCRETE.get(),
                        NtmBlocks.CONCRETE_SMOOTH.get(),
                        NtmBlocks.CONCRETE_ASBESTOS.get(),
                        NtmBlocks.DUCRETE.get(),
                        NtmBlocks.DUCRETE_SMOOTH.get(),
                        NtmBlocks.DUCRETE_REINFORCED.get(),
                        NtmBlocks.DUCRETE_BRICK.get(),
                        NtmBlocks.STEEL_SCAFFOLD.get(),
                        NtmBlocks.GLASS_QUARTZ.get(),
                        NtmBlocks.STEEL_SCAFFOLD.get(),

                        NtmBlocks.BARBED_WIRE.get(),
                        NtmBlocks.SPIKES.get(),

                        NtmBlocks.BRICK_CONCRETE_STAIRS.get(),
                        NtmBlocks.BRICK_CONCRETE_MOSSY_STAIRS.get(),
                        NtmBlocks.BRICK_CONCRETE_CRACKED_STAIRS.get(),
                        NtmBlocks.BRICK_CONCRETE_BROKEN_STAIRS.get(),

                        NtmBlocks.BRICK_CONCRETE_SLAB.get(),
                        NtmBlocks.BRICK_CONCRETE_MOSSY_SLAB.get(),
                        NtmBlocks.BRICK_CONCRETE_CRACKED_SLAB.get(),
                        NtmBlocks.BRICK_CONCRETE_BROKEN_SLAB.get(),

                        NtmBlocks.NUKE_GADGET.get(),
                        NtmBlocks.NUKE_LITTLE_BOY.get(),
                        NtmBlocks.NUKE_FAT_MAN.get(),
                        NtmBlocks.NUKE_IVY_MIKE.get(),
                        NtmBlocks.NUKE_TSAR_BOMBA.get(),
                        NtmBlocks.NUKE_PROTOTYPE.get(),
                        NtmBlocks.NUKE_FLEIJA.get(),
                        NtmBlocks.NUKE_SOLINIUM.get(),
                        NtmBlocks.NUKE_N2.get(),
                        NtmBlocks.NUKE_FSTBMB.get(),

                        NtmBlocks.SELLAFIELD_SLAKED.get(),
                        NtmBlocks.ORE_SELLAFIELD_EMERALD.get(),
                        NtmBlocks.ORE_SELLAFIELD_DIAMOND.get(),

                        NtmBlocks.PRESS_PREHEATER.get(),
                        NtmBlocks.MACHINE_PRESS.get(),
                        NtmBlocks.HEAT_BOILER.get(),
                        NtmBlocks.MACHINE_INDUSTRIAL_BOILER.get(),
                        NtmBlocks.HEATER_FIREBOX.get(),
                        NtmBlocks.HEATER_OVEN.get(),
                        NtmBlocks.HEATER_OILBURNER.get(),
                        NtmBlocks.HEATER_ELECTRIC.get(),
                        NtmBlocks.HEATER_HEATEX.get(),
                        NtmBlocks.MACHINE_SHREDDER.get(),
                        NtmBlocks.MACHINE_SOLDERING_STATION.get(),
                        NtmBlocks.MACHINE_WELL.get(),
                        NtmBlocks.MACHINE_PUMPJACK.get(),
                        NtmBlocks.MACHINE_FRACKING_TOWER.get(),
                        NtmBlocks.MACHINE_REFINERY.get(),
                        NtmBlocks.MACHINE_BLAST_FURNACE.get(),
                        NtmBlocks.MACHINE_WOOD_BURNER.get(),
                        NtmBlocks.FURNACE_COMBINATION.get(),
                        NtmBlocks.MACHINE_CENTRIFUGE.get(),
                        NtmBlocks.MACHINE_CHEMICAL_PLANT.get(),
                        NtmBlocks.CRATE_IRON.get(),
                        NtmBlocks.CRATE_TUNGSTEN.get(),
                        NtmBlocks.CRATE_STEEL.get(),
                        NtmBlocks.CRATE_DESH.get(),
                        NtmBlocks.CRATE_TEMPLATE.get(),
                        NtmBlocks.TRANSFORMER.get(),

                        NtmBlocks.MACHINE_FLUID_TANK.get(),
                        NtmBlocks.MACHINE_CHUNGUS.get(),
                        NtmBlocks.MACHINE_BATTERY_REDD.get(),
                        NtmBlocks.MACHINE_BATTERY_SOCKET.get(),
                        NtmBlocks.MACHINE_ASSEMBLY_MACHINE.get(),
                        NtmBlocks.LAUNCH_PAD.get(),
                        NtmBlocks.LAUNCH_PAD_LARGE.get(),
                        NtmBlocks.SOYUZ_LAUNCHER.get(),
                        NtmBlocks.MACHINE_RADAR.get(),
                        NtmBlocks.MACHINE_RADAR_LARGE.get(),
                        NtmBlocks.MACHINE_SATLINKER.get(),
                        NtmBlocks.ANVIL.get()
                );

        this.tag(BlockTags.ANVIL).add(NtmBlocks.ANVIL.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        NtmBlocks.WASTE_LOG.get(),
                        NtmBlocks.WASTE_PLANKS.get(),
                        NtmBlocks.FROZEN_LOG.get(),
                        NtmBlocks.FROZEN_PLANKS.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(
                        NtmBlocks.WASTE_EARTH.get(),
                        NtmBlocks.WASTE_MYCELIUM.get(),
                        NtmBlocks.WASTE_TRINITITE.get(),
                        NtmBlocks.WASTE_TRINITITE_RED.get(),
                        NtmBlocks.FROZEN_DIRT.get(),
                        NtmBlocks.FROZEN_GRASS.get(),
                        NtmBlocks.FALLOUT.get(),
                        NtmBlocks.MOON_TURF.get(),
                        NtmBlocks.SAND_QUARTZ.get()

                );

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(
                        NtmBlocks.WASTE_LEAVES.get(),
                        NtmBlocks.LEAVES_LAYER.get()
                );

        // vanilla compat
        this.tag(BlockTags.STRIDER_WARM_BLOCKS).add(NtmBlocks.VOLCANIC_LAVA.get());
    }
}
