package com.hbm.datagen;

import com.hbm.blocks.NtmBlocks;
import com.hbm.blocks.generic.OreBasaltBlock;
import com.hbm.items.NtmItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.ArrayList;
import java.util.Set;

public class NtmBlockLootTableProvider extends BlockLootSubProvider {

    protected NtmBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        this.dropSelf(NtmBlocks.STONE_CRACKED.get());
        this.dropSelf(NtmBlocks.DIRT_OILY.get());
        this.dropSelf(NtmBlocks.SAND_OILY.get());
        this.dropSelf(NtmBlocks.SAND_RED_OILY.get());
        this.dropSelf(NtmBlocks.DIRT_DEAD.get());
        this.dropSelf(NtmBlocks.OIL_SPILL.get());
        this.dropSelf(NtmBlocks.ORE_OIL.get());
        this.dropSelf(NtmBlocks.ORE_OIL.get());
        this.dropSelf(NtmBlocks.ORE_OIL_EMPTY.get());
        this.dropSelf(NtmBlocks.ORE_OIL_SAND.get());
        this.dropSelf(NtmBlocks.ORE_BEDROCK_OIL.get());
        this.dropSelf(NtmBlocks.ORE_URANIUM.get());
        this.dropSelf(NtmBlocks.ORE_URANIUM_DEEPSLATE.get());
        this.dropSelf(NtmBlocks.ORE_URANIUM_SCORCHED.get());
        this.dropSelf(NtmBlocks.ORE_BERYLLIUM.get());
        this.dropSelf(NtmBlocks.ORE_BERYLLIUM_DEEPSLATE.get());
        this.dropSelf(NtmBlocks.ORE_TUNGSTEN.get());
        this.dropSelf(NtmBlocks.ORE_TUNGSTEN_DEEPSLATE.get());
        this.dropSelf(NtmBlocks.ORE_TITANIUM.get());
        this.dropSelf(NtmBlocks.ORE_TITANIUM_DEEPSLATE.get());
        this.dropSelf(NtmBlocks.ORE_LEAD.get());
        this.dropSelf(NtmBlocks.ORE_LEAD_DEEPSLATE.get());
        this.dropSelf(NtmBlocks.ORE_ALUMINIUM.get());
        this.dropSelf(NtmBlocks.ORE_ALUMINIUM_DEEPSLATE.get());
        this.dropSelf(NtmBlocks.ORE_ASBESTOS.get());
        this.dropSelf(NtmBlocks.ORE_ASBESTOS_DEEPSLATE.get());
        this.dropSelf(NtmBlocks.ORE_THORIUM.get());
        this.dropSelf(NtmBlocks.ORE_THORIUM_DEEPSLATE.get());
        this.add(NtmBlocks.ORE_NITER.get(), block -> this.oreDrop(block, NtmItems.NITER.get()));
        this.add(NtmBlocks.ORE_NITER_DEEPSLATE.get(), block -> this.oreDrop(block, NtmItems.NITER.get()));
        this.add(NtmBlocks.ORE_COBALT.get(), block -> this.oreDrop(block, NtmItems.FRAGMENT_COBALT.get(), 5, 8));
        this.add(NtmBlocks.ORE_COBALT_DEEPSLATE.get(), block -> this.oreDrop(block, NtmItems.FRAGMENT_COBALT.get(), 5, 8));
        this.add(NtmBlocks.ORE_CINNABAR.get(), block -> this.oreDrop(block, NtmItems.CINNABAR.get()));
        this.add(NtmBlocks.ORE_CINNABAR_DEEPSLATE.get(), block -> this.oreDrop(block, NtmItems.CINNABAR.get()));
        this.add(NtmBlocks.ORE_FLUORITE.get(), block -> this.oreDrop(block, NtmItems.FLUORITE.get(), 2, 4));
        this.add(NtmBlocks.ORE_FLUORITE_DEEPSLATE.get(), block -> this.oreDrop(block, NtmItems.FLUORITE.get(), 2, 4));
        this.dropSelf(NtmBlocks.ORE_METEOR_IRON.get());
        this.dropSelf(NtmBlocks.ORE_METEOR_COBALT.get());
        this.dropSelf(NtmBlocks.ORE_METEOR_ALUMINIUM.get());
        this.dropSelf(NtmBlocks.ORE_METEOR_COPPER.get());
        this.dropSelf(NtmBlocks.ORE_METEOR_RARE.get());
        this.add(NtmBlocks.ORE_LIGNITE.get(), block -> this.oreDropNoFortune(block, NtmItems.LIGNITE.get()));
        this.add(NtmBlocks.ORE_DEEPSLATE_LIGNITE.get(), block -> this.oreDropNoFortune(block, NtmItems.LIGNITE.get()));
        this.add(NtmBlocks.ORE_RARE.get(), block -> this.oreDrop(block, NtmItems.RARE_EARTH_ORE_CHUNK.get()));
        this.add(NtmBlocks.ORE_RARE_DEEPSLATE.get(), block -> this.oreDrop(block, NtmItems.RARE_EARTH_ORE_CHUNK.get()));
        this.add(NtmBlocks.ORE_SULFUR.get(), block -> this.oreDrop(block, NtmItems.SULFUR.get(), 2, 4));
        this.add(NtmBlocks.ORE_SULFUR_DEEPSLATE.get(), block -> this.oreDrop(block, NtmItems.SULFUR.get(), 2, 4));
        this.dropSelf(NtmBlocks.ORE_SCHRABIDIUM.get());
        this.dropSelf(NtmBlocks.ORE_NETHER_URANIUM.get());
        this.dropSelf(NtmBlocks.ORE_NETHER_URANIUM_SCORCHED.get());
        this.dropSelf(NtmBlocks.ORE_NETHER_PLUTONIUM.get());
        this.dropSelf(NtmBlocks.ORE_NETHER_SCHRABIDIUM.get());
        this.dropSelf(NtmBlocks.ORE_TIKITE.get());
        this.dropSelf(NtmBlocks.ORE_GNEISS_URANIUM.get());
        this.dropSelf(NtmBlocks.ORE_GNEISS_URANIUM_SCORCHED.get());
        this.dropSelf(NtmBlocks.ORE_GNEISS_SCHRABIDIUM.get());
        this.dropSelf(NtmBlocks.RESOURCE_LIMESTONE.get());
        this.dropSelf(NtmBlocks.RESOURCE_BAUXITE.get());
        this.dropSelf(NtmBlocks.RESOURCE_HEMATITE.get());
        this.dropSelf(NtmBlocks.RESOURCE_MALACHITE.get());
        this.dropSelf(NtmBlocks.RESOURCE_CHRYSOTILE.get());
        this.dropSelf(NtmBlocks.RESOURCE_SULFUROUS_STONE.get());
        this.dropSelf(NtmBlocks.DECO_ALUMINIUM.get());
        this.dropSelf(NtmBlocks.DECO_BERYLLIUM.get());
        this.dropSelf(NtmBlocks.DECO_LEAD.get());
        this.dropSelf(NtmBlocks.DECO_RED_COPPER.get());
        this.dropSelf(NtmBlocks.DECO_STEEL.get());
        this.dropSelf(NtmBlocks.DECO_ALUMINIUM.get());
        this.dropSelf(NtmBlocks.DECO_RUSTY_STEEL.get());
        this.dropSelf(NtmBlocks.DECO_TITANIUM.get());
        this.dropSelf(NtmBlocks.DECO_ALUMINIUM.get());
        this.dropSelf(NtmBlocks.DECO_TUNGSTEN.get());
        this.dropSelf(NtmBlocks.DECO_ASBESTOS.get());


        this.add(NtmBlocks.ORE_BASALT.get(), block -> LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1F))
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(NtmItems.NOTHING).when(this.propertyEquals(block, OreBasaltBlock.SUBTYPE, 0)),
                                LootItem.lootTableItem(NtmItems.DETONATOR).when(this.propertyEquals(block, OreBasaltBlock.SUBTYPE, 1)),
                                LootItem.lootTableItem(NtmItems.CAN_KEY).when(this.propertyEquals(block, OreBasaltBlock.SUBTYPE, 2)),
                                LootItem.lootTableItem(NtmItems.CRACKPIPE).when(this.propertyEquals(block, OreBasaltBlock.SUBTYPE, 3)),
                                LootItem.lootTableItem(NtmItems.CIGARETTE).when(this.propertyEquals(block, OreBasaltBlock.SUBTYPE, 4))
                        ))
                )
        );

        this.dropSelf(NtmBlocks.BASALT.get());
        this.dropSelf(NtmBlocks.BASALT_SMOOTH.get());
        this.dropSelf(NtmBlocks.BASALT_BRICK.get());
        this.dropSelf(NtmBlocks.BASALT_POLISHED.get());
        this.dropSelf(NtmBlocks.BASALT_TILES.get());

        this.dropSelf(NtmBlocks.BLOCK_SCRAP.get());

        this.dropSelf(NtmBlocks.BOBBLEHEAD.get());
        this.dropSelf(NtmBlocks.PLUSHIE.get());
        this.dropSelf(NtmBlocks.PLANT_FLOWER.get());

        this.dropSelf(NtmBlocks.GRAVEL_OBSIDIAN.get());
        this.dropSelf(NtmBlocks.GRAVEL_DIAMOND.get());
        this.dropSelf(NtmBlocks.MOON_TURF.get());

        this.dropSelf(NtmBlocks.ASPHALT.get());
        this.dropSelf(NtmBlocks.ASPHALT_LIGHT.get());

        this.dropSelf(NtmBlocks.BRICK_CONCRETE.get());
        this.dropSelf(NtmBlocks.BRICK_CONCRETE_MOSSY.get());
        this.dropSelf(NtmBlocks.BRICK_CONCRETE_BROKEN.get());
        this.dropSelf(NtmBlocks.BRICK_CONCRETE_CRACKED.get());
        this.dropSelf(NtmBlocks.BRICK_CONCRETE_MARKED.get());
        this.dropSelf(NtmBlocks.BRICK_OBSIDIAN.get());
        this.dropSelf(NtmBlocks.BRICK_LIGHT.get());
        this.dropSelf(NtmBlocks.BRICK_ASBESTOS.get());
        this.dropSelf(NtmBlocks.BRICK_FIRE.get());
        this.dropSelf(NtmBlocks.CONCRETE.get());
        this.dropSelf(NtmBlocks.CONCRETE_SMOOTH.get());
        this.dropSelf(NtmBlocks.CONCRETE_ASBESTOS.get());
        this.dropSelf(NtmBlocks.DUCRETE.get());
        this.dropSelf(NtmBlocks.DUCRETE_SMOOTH.get());
        this.dropSelf(NtmBlocks.DUCRETE_REINFORCED.get());
        this.dropSelf(NtmBlocks.DUCRETE_BRICK.get());
        this.dropSelf(NtmBlocks.REINFORCED_LAMINATE.get());
        this.dropSelf(NtmBlocks.STEEL_SCAFFOLD.get());
        this.dropSelf(NtmBlocks.SAND_QUARTZ.get());
        this.dropSelf(NtmBlocks.GLASS_QUARTZ.get());

        this.dropSelf(NtmBlocks.ANVIL.get());

        this.add(NtmBlocks.BRICK_CONCRETE_SLAB.get(), this::createSlabItemTable);
        this.add(NtmBlocks.BRICK_CONCRETE_MOSSY_SLAB.get(), this::createSlabItemTable);
        this.add(NtmBlocks.BRICK_CONCRETE_BROKEN_SLAB.get(), this::createSlabItemTable);
        this.add(NtmBlocks.BRICK_CONCRETE_CRACKED_SLAB.get(), this::createSlabItemTable);

        this.dropSelf(NtmBlocks.BRICK_CONCRETE_STAIRS.get());
        this.dropSelf(NtmBlocks.BRICK_CONCRETE_MOSSY_STAIRS.get());
        this.dropSelf(NtmBlocks.BRICK_CONCRETE_BROKEN_STAIRS.get());
        this.dropSelf(NtmBlocks.BRICK_CONCRETE_CRACKED_STAIRS.get());

        this.dropSelf(NtmBlocks.BARBED_WIRE.get());
        this.dropSelf(NtmBlocks.SPIKES.get());

        this.add(NtmBlocks.WASTE_EARTH.get(), block -> createSingleItemTable(Blocks.DIRT));
        this.dropSelf(NtmBlocks.WASTE_MYCELIUM.get());
        this.dropSelf(NtmBlocks.WASTE_TRINITITE.get());
        this.dropSelf(NtmBlocks.WASTE_TRINITITE_RED.get());
        this.add(NtmBlocks.WASTE_LOG.get(), block ->
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(AlternativesEntry.alternatives(
                                        LootItem.lootTableItem(NtmItems.BURNT_BARK.get()).when(LootItemRandomChanceCondition.randomChance(0.001f)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))),
                                        LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
                                ))
                )
        );
        this.add(NtmBlocks.WASTE_LEAVES.get(), BlockLootSubProvider::createShearsOnlyDrop);
        this.dropSelf(NtmBlocks.WASTE_PLANKS.get());
        this.add(NtmBlocks.FROZEN_DIRT.get(), block -> createSingleItemTable(Items.SNOWBALL));
        this.add(NtmBlocks.FROZEN_GRASS.get(), block -> createSingleItemTable(Items.SNOWBALL));
        this.add(NtmBlocks.FROZEN_LOG.get(), block -> createSingleItemTable(Items.SNOWBALL));
        this.add(NtmBlocks.FROZEN_PLANKS.get(), block -> createSingleItemTable(Items.SNOWBALL));
        this.add(NtmBlocks.LEAVES_LAYER.get(), BlockLootSubProvider::createShearsOnlyDrop);
        this.dropSelf(NtmBlocks.FALLOUT.get()); // todo make item drop
        this.dropSelf(NtmBlocks.SELLAFIELD_SLAKED.get());
        this.add(NtmBlocks.ORE_SELLAFIELD_EMERALD.get(), block -> this.createOreDrop(block, Items.EMERALD));
        this.add(NtmBlocks.ORE_SELLAFIELD_DIAMOND.get(), block -> this.createOreDrop(block, Items.DIAMOND));
        // SELLAFIELD_BEDROCK has no drops

        this.dropSelf(NtmBlocks.NUKE_GADGET.get());
        this.dropSelf(NtmBlocks.NUKE_LITTLE_BOY.get());
        this.dropSelf(NtmBlocks.NUKE_FAT_MAN.get());
        this.dropSelf(NtmBlocks.NUKE_IVY_MIKE.get());
        this.dropSelf(NtmBlocks.NUKE_TSAR_BOMBA.get());
        this.dropSelf(NtmBlocks.NUKE_PROTOTYPE.get());
        this.dropSelf(NtmBlocks.NUKE_FLEIJA.get());
        this.dropSelf(NtmBlocks.NUKE_SOLINIUM.get());
        this.dropSelf(NtmBlocks.NUKE_N2.get());
        this.dropSelf(NtmBlocks.NUKE_FSTBMB.get());

        // CRASHED_BOMB has no drops
        this.dropSelf(NtmBlocks.DYNAMITE.get());
        this.dropSelf(NtmBlocks.TNT.get());
        this.dropSelf(NtmBlocks.SEMTEX.get());
        this.dropSelf(NtmBlocks.C4.get());
        this.dropSelf(NtmBlocks.FISSURE_BOMB.get());

        this.dropSelf(NtmBlocks.MINE_AP.get());
        this.dropSelf(NtmBlocks.MINE_HE.get());
        this.dropSelf(NtmBlocks.MINE_SHRAP.get());
        this.dropSelf(NtmBlocks.MINE_FAT.get());
        this.dropSelf(NtmBlocks.MINE_NAVAL.get());

        this.dropSelf(NtmBlocks.DET_CORD.get());
        this.dropSelf(NtmBlocks.DET_CHARGE.get());
        this.dropSelf(NtmBlocks.DET_NUKE.get());
        this.dropSelf(NtmBlocks.DET_MINER.get());
        this.dropSelf(NtmBlocks.BARREL_RED.get());
        this.dropSelf(NtmBlocks.BARREL_PINK.get());
        this.dropSelf(NtmBlocks.BARREL_LOX.get());
        this.dropSelf(NtmBlocks.BARREL_TAINT.get());
        this.dropSelf(NtmBlocks.BARREL_PLASTIC.get());
        this.dropSelf(NtmBlocks.BARREL_STEEL.get());
        this.dropSelf(NtmBlocks.BARREL_CORRODED.get());
        this.dropSelf(NtmBlocks.BARREL_TCALLOY.get());
        this.dropSelf(NtmBlocks.CRATE_IRON.get());
        this.dropSelf(NtmBlocks.CRATE_TUNGSTEN.get());
        this.dropSelf(NtmBlocks.CRATE_STEEL.get());
        this.dropSelf(NtmBlocks.CRATE_DESH.get());
        this.dropSelf(NtmBlocks.CRATE_TEMPLATE.get());

        this.dropSelf(NtmBlocks.GEIGER.get());

        this.dropSelf(NtmBlocks.PRESS_PREHEATER.get());
        this.dropSelf(NtmBlocks.MACHINE_PRESS.get());

        this.dropSelf(NtmBlocks.REACTOR_ZIRNOX.get());
        this.dropSelf(NtmBlocks.ZIRNOX_DESTROYED.get());

        this.dropSelf(NtmBlocks.RED_CABLE.get());

        this.dropSelf(NtmBlocks.FLUID_DUCT_NEO.get());
        this.dropSelf(NtmBlocks.RADIO_TORCH_SENDER.get());
        this.dropSelf(NtmBlocks.RADIO_TORCH_RECEIVER.get());

        this.dropSelf(NtmBlocks.MACHINE_BATTERY_SOCKET.get());
        this.dropSelf(NtmBlocks.MACHINE_BATTERY_REDD.get());
        this.dropSelf(NtmBlocks.MACHINE_ASSEMBLY_MACHINE.get());
        this.dropSelf(NtmBlocks.MACHINE_FLUID_TANK.get());
        this.dropSelf(NtmBlocks.MACHINE_CHUNGUS.get());
        this.dropSelf(NtmBlocks.MACHINE_SOLDERING_STATION.get());
        this.dropSelf(NtmBlocks.HEATER_FIREBOX.get());
        this.dropSelf(NtmBlocks.HEATER_OVEN.get());
        this.dropSelf(NtmBlocks.HEATER_OILBURNER.get());
        this.dropSelf(NtmBlocks.HEATER_ELECTRIC.get());
        this.dropSelf(NtmBlocks.HEATER_HEATEX.get());
        this.dropSelf(NtmBlocks.MACHINE_WELL.get());
        this.dropSelf(NtmBlocks.MACHINE_PUMPJACK.get());
        this.dropSelf(NtmBlocks.MACHINE_FRACKING_TOWER.get());
        this.dropSelf(NtmBlocks.MACHINE_REFINERY.get());
        this.dropSelf(NtmBlocks.MACHINE_BLAST_FURNACE.get());
        this.dropSelf(NtmBlocks.MACHINE_WOOD_BURNER.get());
        this.dropSelf(NtmBlocks.MACHINE_CENTRIFUGE.get());
        this.dropSelf(NtmBlocks.MACHINE_CHEMICAL_PLANT.get());
        this.dropSelf(NtmBlocks.MACHINE_ARC_WELDER.get());
        this.dropSelf(NtmBlocks.MACHINE_SHREDDER.get());
        this.dropSelf(NtmBlocks.HEAT_BOILER.get());
        this.dropSelf(NtmBlocks.MACHINE_INDUSTRIAL_BOILER.get());
        this.dropSelf(NtmBlocks.FURNACE_COMBINATION.get());
        this.dropSelf(NtmBlocks.EMP_BOMB.get());
        this.dropSelf(NtmBlocks.TRANSFORMER.get());

        this.dropSelf(NtmBlocks.MACHINE_SATLINKER.get());

        this.dropSelf(NtmBlocks.DECONTAMINATOR.get());

        this.dropSelf(NtmBlocks.PWR_CONTROLLER.get());

        this.add(NtmBlocks.BALEFIRE.get(), noDrop());
        this.add(NtmBlocks.FIRE_DIGAMMA.get(), noDrop());
        this.add(NtmBlocks.VOLCANO_CORE.get(), noDrop());
        this.add(NtmBlocks.VOLCANO_RAD_CORE.get(), noDrop());

        this.dropSelf(NtmBlocks.LAUNCH_PAD.get());
        this.dropSelf(NtmBlocks.LAUNCH_PAD_LARGE.get());
        this.dropSelf(NtmBlocks.SOYUZ_LAUNCHER.get());
        this.dropSelf(NtmBlocks.MACHINE_RADAR.get());
        this.dropSelf(NtmBlocks.MACHINE_RADAR_LARGE.get());

        // liquid blocks has no drops

        // gas blocks has no drops

        // ??? blocks has no drops

        this.dropSelf(NtmBlocks.BLOCK_ACTINIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_STEEL.get());
        this.dropSelf(NtmBlocks.BLOCK_ALUMINIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_ASBESTOS.get());
        this.dropSelf(NtmBlocks.BLOCK_AUSTRALIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_BERYLLIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_BISMUTH.get());
        this.dropSelf(NtmBlocks.BLOCK_CADMIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_CDALLOY.get());
        this.dropSelf(NtmBlocks.BLOCK_COLTAN.get());
        this.dropSelf(NtmBlocks.BLOCK_COMBINE_STEEL.get());
        this.dropSelf(NtmBlocks.BLOCK_COPPER.get());
        this.dropSelf(NtmBlocks.BLOCK_DESH.get());
        this.dropSelf(NtmBlocks.BLOCK_DINEUTRONIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_DURA_STEEL.get());
        this.dropSelf(NtmBlocks.BLOCK_EUPHEMIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_FOAM.get());
        this.dropSelf(NtmBlocks.BLOCK_LANTHANIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_LEAD.get());
        this.dropSelf(NtmBlocks.BLOCK_LITHIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_MAGNETIZED_TUNGSTEN.get());
        this.dropSelf(NtmBlocks.BLOCK_METEOR.get());
        this.add(NtmBlocks.BLOCK_METEOR_COBBLE.get(), block -> this.oreDrop(block, NtmItems.FRAGMENT_METEORITE.get(), 1, 3));
        this.add(NtmBlocks.BLOCK_METEOR_BROKEN.get(), block -> this.oreDrop(block, NtmItems.FRAGMENT_METEORITE.get(), 1, 3));
        this.dropSelf(NtmBlocks.BLOCK_METEOR_MOLTEN.get());
        this.add(NtmBlocks.BLOCK_METEOR_TREASURE.get(), this::meteorTreasureDrop);
        this.dropSelf(NtmBlocks.BLOCK_MOX_FUEL.get());
        this.dropSelf(NtmBlocks.BLOCK_NEPTUNIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_NIOBIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_NITER.get());
        this.dropSelf(NtmBlocks.BLOCK_PLUTONIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_PLUTONIUM_FUEL.get());
        this.dropSelf(NtmBlocks.BLOCK_POLONIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_PU238.get());
        this.dropSelf(NtmBlocks.BLOCK_PU239.get());
        this.dropSelf(NtmBlocks.BLOCK_PU240.get());
        this.dropSelf(NtmBlocks.BLOCK_PU_MIX.get());
        this.dropSelf(NtmBlocks.BLOCK_RA226.get());
        this.dropSelf(NtmBlocks.BLOCK_RED_COPPER.get());
        this.dropSelf(NtmBlocks.BLOCK_SATURNITE.get());
        this.dropSelf(NtmBlocks.BLOCK_SCHRABIDATE.get());
        this.dropSelf(NtmBlocks.BLOCK_SCHRABIDIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_SCHRABIDIUM_FUEL.get());
        this.dropSelf(NtmBlocks.BLOCK_SCHRARANIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_SMORE.get());
        this.dropSelf(NtmBlocks.BLOCK_SOLINIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_SULFUR.get());
        this.dropSelf(NtmBlocks.BLOCK_TANTALIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_TCALLOY.get());
        this.dropSelf(NtmBlocks.BLOCK_THORIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_THORIUM_FUEL.get());
        this.dropSelf(NtmBlocks.BLOCK_TITANIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_TUNGSTEN.get());
        this.dropSelf(NtmBlocks.BLOCK_U233.get());
        this.dropSelf(NtmBlocks.BLOCK_U235.get());
        this.dropSelf(NtmBlocks.BLOCK_U238.get());
        this.dropSelf(NtmBlocks.BLOCK_URANIUM.get());
        this.dropSelf(NtmBlocks.BLOCK_URANIUM_FUEL.get());
        this.dropSelf(NtmBlocks.BLOCK_WASTE.get());
        this.dropSelf(NtmBlocks.BLOCK_WASTE_PAINTED.get());
        this.dropSelf(NtmBlocks.BLOCK_WASTE_VITRIFIED.get());
        this.dropSelf(NtmBlocks.BLOCK_YELLOWCAKE.get());
        this.dropSelf(NtmBlocks.BLOCK_FIBERGLASS.get());
        this.dropSelf(NtmBlocks.BLOCK_INSULATOR.get());
        this.dropSelf(NtmBlocks.BLOCK_SLAG.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        NtmBlocks.BLOCKS.getEntries().stream().map(Holder::value).forEach(blocks::add);
        return blocks;
    }

    private LootTable.Builder oreDrop(Block block, Item item) {
        return this.oreDrop(block, item, 1, 1);
    }

    private LootTable.Builder oreDrop(Block block, Item item, int min, int max) {
        return this.createSilkTouchDispatchTable(block, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                .apply(ApplyBonusCount.addOreBonusCount(
                        this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE))));
    }

    private LootTable.Builder oreDropNoFortune(Block block, Item item) {
        return this.createSilkTouchDispatchTable(block, LootItem.lootTableItem(item));
    }

    private LootTable.Builder meteorTreasureDrop(Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(NtmItems.COBALT_PICKAXE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(NtmItems.INGOT_ZIRCONIUM.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 16))))
                        .add(LootItem.lootTableItem(NtmItems.INGOT_NIOBIUM.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 16))))
                        .add(LootItem.lootTableItem(NtmItems.INGOT_COBALT.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 16))))
                        .add(LootItem.lootTableItem(NtmItems.INGOT_BORON.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 16))))
                        .add(LootItem.lootTableItem(NtmItems.INGOT_STARMETAL.get()).setWeight(5))
                        .add(LootItem.lootTableItem(NtmItems.CRYSTAL_GOLD.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                        .add(LootItem.lootTableItem(NtmItems.CIRCUIT_VACUUM_TUBE.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                        .add(LootItem.lootTableItem(NtmItems.CIRCUIT_MICROCHIP.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                        .add(LootItem.lootTableItem(NtmItems.LAUNCH_CODE_PIECE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(NtmItems.GEM_ALEXANDRITE.get()).setWeight(1))
                );
    }

    public LootItemCondition.Builder propertyEquals(Block block, IntegerProperty property, int equals) {
        return LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(property, equals));
    }
}
