package com.hbm.inventory;

import com.hbm.blocks.NtmBlocks;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.items.IMetaItem;
import com.hbm.items.NtmItems;
import com.hbm.items.food.DrinkItem.DrinkType;
import com.hbm.items.machine.FluidIDMultiItem;
import com.hbm.items.special.StarterKitItem.KitType;
import com.hbm.main.NuclearTechMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class NtmCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NuclearTechMod.MODID);

    // ingots, nuggets, wires, machine parts
    public static final Supplier<CreativeModeTab> PARTS = CREATIVE_MODE_TABS.register(
            "parts",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NtmItems.INGOT_URANIUM.get()))
                    .title(Component.translatable("itemGroup.parts"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(NtmItems.INGOT_URANIUM.get());
                        output.accept(NtmItems.INGOT_U233.get());
                        output.accept(NtmItems.INGOT_U235.get());
                        output.accept(NtmItems.INGOT_U238.get());
                        output.accept(NtmItems.INGOT_PLUTONIUM.get());
                        output.accept(NtmItems.INGOT_PU238.get());
                        output.accept(NtmItems.INGOT_PU239.get());
                        output.accept(NtmItems.INGOT_PU240.get());
                        output.accept(NtmItems.INGOT_PU241.get());
                        output.accept(NtmItems.INGOT_PU_MIX.get());
                        output.accept(NtmItems.INGOT_AM241.get());
                        output.accept(NtmItems.INGOT_AM242.get());
                        output.accept(NtmItems.INGOT_AM_MIX.get());
                        output.accept(NtmItems.INGOT_NEPTUNIUM.get());
                        output.accept(NtmItems.INGOT_POLONIUM.get());
                        output.accept(NtmItems.INGOT_TECHNETIUM.get());
                        output.accept(NtmItems.INGOT_CO60.get());
                        output.accept(NtmItems.INGOT_SR90.get());
                        output.accept(NtmItems.INGOT_AU198.get());
                        output.accept(NtmItems.INGOT_PB209.get());
                        output.accept(NtmItems.INGOT_RA226.get());
                        output.accept(NtmItems.INGOT_TITANIUM.get());
                        output.accept(NtmItems.INGOT_TUNGSTEN.get());
                        output.accept(NtmItems.INGOT_ALUMINIUM.get());
                        output.accept(NtmItems.INGOT_STEEL.get());
                        output.accept(NtmItems.INGOT_TCALLOY.get());
                        output.accept(NtmItems.INGOT_CDALLOY.get());
                        output.accept(NtmItems.INGOT_BISMUTH_BRONZE.get());
                        output.accept(NtmItems.INGOT_ARSENIC_BRONZE.get());
                        output.accept(NtmItems.INGOT_BSCCO.get());
                        output.accept(NtmItems.INGOT_LEAD.get());
                        output.accept(NtmItems.INGOT_BISMUTH.get());
                        output.accept(NtmItems.INGOT_ARSENIC.get());
                        output.accept(NtmItems.INGOT_CALCIUM.get());
                        output.accept(NtmItems.INGOT_CADMIUM.get());
                        output.accept(NtmItems.INGOT_TANTALIUM.get());
                        output.accept(NtmItems.INGOT_SILICON.get());
                        output.accept(NtmItems.INGOT_NIOBIUM.get());
                        output.accept(NtmItems.INGOT_BERYLLIUM.get());
                        output.accept(NtmItems.INGOT_COBALT.get());
                        output.accept(NtmItems.INGOT_ASBESTOS.get());
                        output.accept(NtmItems.INGOT_BORON.get());
                        output.accept(NtmItems.INGOT_GRAPHITE.get());
                        output.accept(NtmItems.INGOT_FIREBRICK.get());
                        output.accept(NtmItems.INGOT_DURA_STEEL.get());
                        output.accept(NtmItems.INGOT_POLYMER.get());
                        output.accept(NtmItems.INGOT_BAKELITE.get());
                        output.accept(NtmItems.INGOT_BIORUBBER.get());
                        output.accept(NtmItems.INGOT_RUBBER.get());
                        output.accept(NtmItems.INGOT_PC.get());
                        output.accept(NtmItems.INGOT_PVC.get());
                        output.accept(NtmItems.INGOT_MUD.get());
                        output.accept(NtmItems.INGOT_CTF.get());
                        output.accept(NtmItems.INGOT_SCHRARANIUM.get());
                        output.accept(NtmItems.INGOT_SCHRABIDIUM.get());
                        output.accept(NtmItems.INGOT_SCHRABIDATE.get());
                        output.accept(NtmItems.INGOT_MAGNETIZED_TUNGSTEN.get());
                        output.accept(NtmItems.INGOT_COMBINE_STEEL.get());
                        output.accept(NtmItems.INGOT_SOLINIUM.get());
                        output.accept(NtmItems.INGOT_GH336.get());
                        output.accept(NtmItems.INGOT_URANIUM_FUEL.get());
                        output.accept(NtmItems.INGOT_THORIUM_FUEL.get());
                        output.accept(NtmItems.INGOT_PLUTONIUM_FUEL.get());
                        output.accept(NtmItems.INGOT_NEPTUNIUM_FUEL.get());
                        output.accept(NtmItems.INGOT_MOX_FUEL.get());
                        output.accept(NtmItems.INGOT_AMERICIUM_FUEL.get());
                        output.accept(NtmItems.INGOT_SCHRABIDIUM_FUEL.get());
                        output.accept(NtmItems.INGOT_HES.get());
                        output.accept(NtmItems.INGOT_LES.get());
                        output.accept(NtmItems.INGOT_AUSTRALIUM.get());
                        output.accept(NtmItems.INGOT_LANTHANIUM.get());
                        output.accept(NtmItems.INGOT_ACTINIUM.get());
                        output.accept(NtmItems.INGOT_DESH.get());
                        output.accept(NtmItems.INGOT_FERROURANIUM.get());
                        output.accept(NtmItems.INGOT_STARMETAL.get());
                        output.accept(NtmItems.INGOT_GUNMETAL.get());
                        output.accept(NtmItems.INGOT_WEAPON_STEEL.get());
                        output.accept(NtmItems.INGOT_SATURNITE.get());
                        output.accept(NtmItems.INGOT_EUPHEMIUM.get());
                        output.accept(NtmItems.INGOT_DINEUTRONIUM.get());
                        output.accept(NtmItems.INGOT_ELECTRONIUM.get());
                        output.accept(NtmItems.INGOT_SMORE.get());
                        output.accept(NtmItems.INGOT_OSMIRIDIUM.get());
                        output.accept(NtmItems.INGOT_ZIRCONIUM.get());
                        output.accept(NtmItems.LITHIUM.get());
                        output.accept(NtmItems.POWDER_IRON.get());
                        output.accept(NtmItems.POWDER_GOLD.get());
                        output.accept(NtmItems.POWDER_DIAMOND.get());
                        output.accept(NtmItems.POWDER_EMERALD.get());
                        output.accept(NtmItems.POWDER_LAPIS.get());
                        output.accept(NtmItems.POWDER_TITANIUM.get());
                        output.accept(NtmItems.POWDER_TUNGSTEN.get());
                        output.accept(NtmItems.POWDER_COPPER.get());
                        output.accept(NtmItems.POWDER_BERYLLIUM.get());
                        output.accept(NtmItems.POWDER_ALUMINIUM.get());
                        output.accept(NtmItems.POWDER_LEAD.get());
                        output.accept(NtmItems.POWDER_STEEL.get());
                        output.accept(NtmItems.POWDER_COMBINE_STEEL.get());
                        output.accept(NtmItems.POWDER_QUARTZ.get());
                        output.accept(NtmItems.POWDER_SCHRABIDIUM.get());
                        output.accept(NtmItems.POWDER_ASBESTOS.get());
                        output.accept(NtmItems.POWDER_DURA_STEEL.get());
                        output.accept(NtmItems.POWDER_POLYMER.get());
                        output.accept(NtmItems.POWDER_BAKELITE.get());
                        output.accept(NtmItems.POWDER_DESH.get());
                        output.accept(NtmItems.POWDER_LITHIUM.get());
                        output.accept(NtmItems.POWDER_COBALT.get());
                        output.accept(NtmItems.POWDER_DINEUTRONIUM.get());
                        output.accept(NtmItems.POWDER_COAL.get());
                        output.accept(NtmItems.POWDER_BISMUTH.get());
                        output.accept(NtmItems.POWDER_LIGNITE.get());
                        output.accept(NtmItems.POWDER_ZIRCONIUM.get());
                        output.accept(NtmItems.POWDER_URANIUM.get());
                        output.accept(NtmItems.POWDER_NIOBIUM.get());
                        output.accept(NtmItems.COKE_COAL.get());
                        output.accept(NtmItems.COKE_LIGNITE.get());
                        output.accept(NtmItems.COKE_PETROLEUM.get());
                        output.accept(NtmItems.BRIQUETTE_COAL.get());
                        output.accept(NtmItems.BRIQUETTE_LIGNITE.get());
                        output.accept(NtmItems.BRIQUETTE_WOOD.get());
                        output.accept(NtmItems.POWDER_METEORITE.get());
                        output.accept(NtmItems.POWDER_METEORITE_TINY.get());
                        output.accept(NtmItems.POWDER_ASH_WOOD.get());
                        output.accept(NtmItems.POWDER_ASH_COAL.get());
                        output.accept(NtmItems.POWDER_ASH_MISC.get());
                        output.accept(NtmItems.NUCLEAR_WASTE.get());
                        output.accept(NtmItems.NUCLEAR_WASTE_VITRIFIED.get());
                        output.accept(NtmItems.FRAGMENT_NIOBIUM.get());
                        output.accept(NtmItems.FRAGMENT_NEODYMIUM.get());
                        output.accept(NtmItems.FRAGMENT_COBALT.get());
                        output.accept(NtmItems.FRAGMENT_CERIUM.get());
                        output.accept(NtmItems.FRAGMENT_BORON.get());
                        output.accept(NtmItems.FRAGMENT_LANTHANIUM.get());
                        output.accept(NtmItems.FRAGMENT_ACTINIUM.get());
                        output.accept(NtmItems.FRAGMENT_METEORITE.get());
                        output.accept(NtmItems.BILLET_COBALT.get());
                        output.accept(NtmItems.BILLET_TH232.get());
                        output.accept(NtmItems.BILLET_URANIUM.get());
                        output.accept(NtmItems.BILLET_U233.get());
                        output.accept(NtmItems.BILLET_U235.get());
                        output.accept(NtmItems.BILLET_U238.get());
                        output.accept(NtmItems.BILLET_UZH.get());
                        output.accept(NtmItems.BILLET_PLUTONIUM.get());
                        output.accept(NtmItems.BILLET_PU238.get());
                        output.accept(NtmItems.BILLET_PU239.get());
                        output.accept(NtmItems.BILLET_PU240.get());
                        output.accept(NtmItems.BILLET_PU241.get());
                        output.accept(NtmItems.BILLET_PU_MIX.get());
                        output.accept(NtmItems.BILLET_AM241.get());
                        output.accept(NtmItems.BILLET_AM242.get());
                        output.accept(NtmItems.BILLET_AM_MIX.get());
                        output.accept(NtmItems.BILLET_NEPTUNIUM.get());
                        output.accept(NtmItems.BILLET_POLONIUM.get());
                        output.accept(NtmItems.BILLET_TECHNETIUM.get());
                        output.accept(NtmItems.BILLET_CO60.get());
                        output.accept(NtmItems.BILLET_SR90.get());
                        output.accept(NtmItems.BILLET_AU198.get());
                        output.accept(NtmItems.BILLET_PB209.get());
                        output.accept(NtmItems.BILLET_RA226.get());
                        output.accept(NtmItems.BILLET_ACTINIUM.get());
                        output.accept(NtmItems.BILLET_GH336.get());
                        output.accept(NtmItems.BILLET_BERYLLIUM.get());
                        output.accept(NtmItems.BILLET_BISMUTH.get());
                        output.accept(NtmItems.BILLET_ZIRCONIUM.get());
                        output.accept(NtmItems.BILLET_ZFB_BISMUTH.get());
                        output.accept(NtmItems.BILLET_ZFB_PU241.get());
                        output.accept(NtmItems.BILLET_ZFB_AM_MIX.get());
                        output.accept(NtmItems.BILLET_SCHRABIDIUM.get());
                        output.accept(NtmItems.BILLET_SOLINIUM.get());
                        output.accept(NtmItems.BILLET_THORIUM_FUEL.get());
                        output.accept(NtmItems.BILLET_URANIUM_FUEL.get());
                        output.accept(NtmItems.BILLET_PLUTONIUM_FUEL.get());
                        output.accept(NtmItems.BILLET_MOX_FUEL.get());
                        output.accept(NtmItems.BILLET_AMERICIUM_FUEL.get());
                        output.accept(NtmItems.BILLET_NEPTUNIUM_FUEL.get());
                        output.accept(NtmItems.BILLET_LES.get());
                        output.accept(NtmItems.BILLET_SCHRABIDIUM_FUEL.get());
                        output.accept(NtmItems.BILLET_HES.get());
                        output.accept(NtmItems.BILLET_PO210BE.get());
                        output.accept(NtmItems.BILLET_RA226BE.get());
                        output.accept(NtmItems.BILLET_PU238BE.get());
                        output.accept(NtmItems.BILLET_AUSTRALIUM.get());
                        output.accept(NtmItems.BILLET_AUSTRALIUM_LESSER.get());
                        output.accept(NtmItems.BILLET_AUSTRALIUM_GREATER.get());
                        output.accept(NtmItems.BILLET_UNOBTAINIUM.get());
                        output.accept(NtmItems.BILLET_YHARONITE.get());
                        output.accept(NtmItems.BILLET_BALEFIRE_GOLD.get());
                        output.accept(NtmItems.BILLET_FLASHLEAD.get());
                        output.accept(NtmItems.BILLET_NUCLEAR_WASTE.get());

                        output.accept(NtmItems.PLATE_IRON.get());
                        output.accept(NtmItems.PLATE_GOLD.get());
                        output.accept(NtmItems.PLATE_TITANIUM.get());
                        output.accept(NtmItems.PLATE_ALUMINIUM.get());
                        output.accept(NtmItems.PLATE_STEEL.get());
                        output.accept(NtmItems.PLATE_LEAD.get());
                        output.accept(NtmItems.PLATE_COPPER.get());
                        output.accept(NtmItems.PLATE_GUNMETAL.get());
                        output.accept(NtmItems.PLATE_WEAPON_STEEL.get());
                        output.accept(NtmItems.PLATE_SATURNITE.get());
                        output.accept(NtmItems.PLATE_DURA_STEEL.get());
                        output.accept(NtmItems.PLATE_SCHRABIDIUM.get());
                        output.accept(NtmItems.PLATE_COMBINE_STEEL.get());
                        output.accept(NtmItems.PLATE_BISMUTH.get());
                        output.accept(NtmItems.WIRE_GOLD.get());
                        output.accept(NtmItems.WIRE_COPPER.get());
                        output.accept(NtmItems.WIRE_ALUMINIUM.get());
                        output.accept(NtmItems.WIRE_ZIRCONIUM.get());
                        output.accept(NtmItems.WIRE_LEAD.get());
                        output.accept(NtmItems.WIRE_TUNGSTEN.get());
                        output.accept(NtmItems.WIRE_SCHRABIDIUM.get());
                        output.accept(NtmItems.WIRE_STEEL.get());
                        output.accept(NtmItems.WIRE_MAGNETIZED_TUNGSTEN.get());
                        output.accept(NtmItems.WIRE_CARBON.get());
                        output.accept(NtmItems.WIRE_RED_COPPER.get());
                        output.accept(NtmItems.SHELL_TITANIUM.get());
                        output.accept(NtmItems.SHELL_ALUMINIUM.get());
                        output.accept(NtmItems.SHELL_COPPER.get());
                        output.accept(NtmItems.SHELL_STEEL.get());
                        output.accept(NtmItems.SHELL_WEAPON_STEEL.get());
                        output.accept(NtmItems.SHELL_SATURNITE.get());
                        output.accept(NtmItems.PIPE_IRON.get());
                        output.accept(NtmItems.PIPE_COPPER.get());
                        output.accept(NtmItems.PIPE_ALUMINIUM.get());
                        output.accept(NtmItems.PIPE_LEAD.get());
                        output.accept(NtmItems.PIPE_STEEL.get());
                        output.accept(NtmItems.PIPE_DURA_STEEL.get());
                        output.accept(NtmItems.PIPE_RUBBER.get());
                        addMetaItems(output, NtmItems.WIRE_DENSE.get());
                        addMetaItems(output, NtmItems.BOLT.get());

                        output.accept(NtmItems.CIRCUIT_PRINTED_BOARD.get());
                        output.accept(NtmItems.CIRCUIT_ANALOG_BOARD.get());
                        output.accept(NtmItems.CIRCUIT_INTEGRATED_BOARD.get());
                        output.accept(NtmItems.CIRCUIT_MILITARY_GRADE_BOARD.get());
                        output.accept(NtmItems.CIRCUIT_VERSATILE_INTEGRATED.get());
                        output.accept(NtmItems.CIRCUIT_VERSATILE_BOARD.get());
                        output.accept(NtmItems.CIRCUIT_CAPACITOR.get());
                        output.accept(NtmItems.CIRCUIT_TANTALIUM_CAPACITOR.get());
                        output.accept(NtmItems.CIRCUIT_CAPACITOR_BOARD.get());
                        output.accept(NtmItems.CIRCUIT_VACUUM_TUBE.get());
                        output.accept(NtmItems.CIRCUIT_PRINTED_SILICON_WAFER.get());
                        output.accept(NtmItems.CIRCUIT_MICROCHIP.get());
                        output.accept(NtmItems.CIRCUIT_CONTROL_UNIT_CASING.get());
                        output.accept(NtmItems.CIRCUIT_CONTROL_UNIT.get());
                        output.accept(NtmItems.CIRCUIT_ADVANCED_CONTROL_UNIT.get());
                        output.accept(NtmItems.CIRCUIT_SOLID_STATE_QUANTUM_PROCESSOR.get());
                        output.accept(NtmItems.CIRCUIT_QUANTUM_PROCESSING_UNIT.get());
                        output.accept(NtmItems.CIRCUIT_QUANTUM_COMPUTER.get());
                        output.accept(NtmItems.CIRCUIT_ATOMIC_CLOCK.get());
                        output.accept(NtmItems.COIL_COPPER.get());
                        output.accept(NtmItems.COIL_COPPER_RING.get());
                        output.accept(NtmItems.COIL_GOLD.get());
                        output.accept(NtmItems.COIL_GOLD_RING.get());
                        output.accept(NtmItems.COIL_MAGNETIZED_TUNGSTEN.get());
                        output.accept(NtmItems.COIL_TUNGSTEN.get());
                        output.accept(NtmItems.MOTOR.get());
                        addMetaItems(output, NtmItems.CAST_PLATE_WELDED.get());
                        addMetaItems(output, NtmItems.CAST_PLATE.get());
                        output.accept(NtmItems.PIPES_STEEL.get());
                        output.accept(NtmItems.CRT_DISPLAY.get());
                        output.accept(NtmItems.RING_STARMETAL.get());
                        output.accept(NtmItems.TANK_STEEL.get());
                        output.accept(NtmItems.CATALYST_CLAY.get());
                        output.accept(NtmItems.DEUTERIUM_FILTER.get());
                        output.accept(NtmItems.FINS_FLAT.get());
                        output.accept(NtmItems.FINS_SMALL_STEEL.get());
                        output.accept(NtmItems.FINS_BIG_STEEL.get());
                        output.accept(NtmItems.FINS_TRI_STEEL.get());
                        output.accept(NtmItems.FINS_QUAD_TITANIUM.get());
                        output.accept(NtmItems.SPHERE_STEEL.get());
                        output.accept(NtmItems.PEDESTAL_STEEL.get());
                        output.accept(NtmItems.BLADE_TITANIUM.get());
                        output.accept(NtmItems.BLADE_TUNGSTEN.get());
                        output.accept(NtmItems.TURBINE_TITANIUM.get());
                        output.accept(NtmItems.TURBINE_TUNGSTEN.get());
                        output.accept(NtmItems.FLYWHEEL_BERYLLIUM.get());
                        output.accept(NtmItems.TOOTHPICKS.get());
                        output.accept(NtmItems.DUCTTAPE.get());
                        output.accept(NtmItems.PLANT_ITEM.get());
                        output.accept(NtmBlocks.PLANT_FLOWER.get());
                        addMetaItems(output, NtmItems.PART_GENERIC.get());
                        output.accept(NtmItems.CANISTER_EMPTY.get());
                        output.accept(NtmItems.CANISTER_NAPALM.get());
                        addMetaItems(output, NtmItems.FUEL_ADDITIVE.get());
                        output.accept(NtmItems.BIOMASS.get());
                        output.accept(NtmItems.GLYPHID_MEAT.get());
                        output.accept(NtmItems.PELLET_CHARGED.get());
                        output.accept(NtmItems.SOLID_FUEL.get());
                        output.accept(NtmItems.ROCKET_FUEL.get());
                        output.accept(NtmItems.CORDITE.get());
                        output.accept(NtmItems.CHOCOLATE.get());
                        output.accept(NtmItems.BALL_DYNAMITE.get());
                        output.accept(NtmItems.BALL_TNT.get());
                        output.accept(NtmItems.BALL_TATB.get());
                        output.accept(NtmItems.PELLET_CLUSTER.get());
                        output.accept(NtmItems.MAGNETRON.get());
                        output.accept(NtmItems.PHOTO_PANEL.get());
                        output.accept(NtmItems.MISSILE_ASSEMBLY.get());
                        output.accept(NtmItems.THRUSTER_SMALL.get());
                        output.accept(NtmItems.THRUSTER_MEDIUM.get());
                        output.accept(NtmItems.THRUSTER_LARGE.get());
                        output.accept(NtmItems.FUEL_TANK_SMALL.get());
                        output.accept(NtmItems.FUEL_TANK_MEDIUM.get());
                        output.accept(NtmItems.FUEL_TANK_LARGE.get());
                        output.accept(NtmItems.WARHEAD_GENERIC_SMALL.get());
                        output.accept(NtmItems.WARHEAD_GENERIC_MEDIUM.get());
                        output.accept(NtmItems.WARHEAD_GENERIC_LARGE.get());
                        output.accept(NtmItems.WARHEAD_INCENDIARY_SMALL.get());
                        output.accept(NtmItems.WARHEAD_INCENDIARY_MEDIUM.get());
                        output.accept(NtmItems.WARHEAD_INCENDIARY_LARGE.get());
                        output.accept(NtmItems.WARHEAD_CLUSTER_SMALL.get());
                        output.accept(NtmItems.WARHEAD_CLUSTER_MEDIUM.get());
                        output.accept(NtmItems.WARHEAD_CLUSTER_LARGE.get());
                        output.accept(NtmItems.WARHEAD_BUSTER_SMALL.get());
                        output.accept(NtmItems.WARHEAD_BUSTER_MEDIUM.get());
                        output.accept(NtmItems.WARHEAD_BUSTER_LARGE.get());
                        output.accept(NtmItems.WARHEAD_NUCLEAR.get());
                        output.accept(NtmItems.WARHEAD_MIRV.get());
                        output.accept(NtmItems.WARHEAD_VOLCANO.get());
                        output.accept(NtmItems.NEUTRON_REFLECTOR.get());
                        output.accept(NtmItems.ARC_ELECTRODE_GRAPHITE.get());
                        output.accept(NtmItems.ARC_ELECTRODE_LANTHANIUM.get());
                        output.accept(NtmItems.ARC_ELECTRODE_DESH.get());
                        output.accept(NtmItems.ARC_ELECTRODE_SATURNITE.get());
                        output.accept(NtmItems.ARC_ELECTRODE_GRAPHITE_BURNT.get());
                        output.accept(NtmItems.ARC_ELECTRODE_LANTHANIUM_BURNT.get());
                        output.accept(NtmItems.ARC_ELECTRODE_DESH_BURNT.get());
                        output.accept(NtmItems.ARC_ELECTRODE_SATURNITE_BURNT.get());

                        addMaterialPartItems(output);


                        output.accept(NtmItems.NUGGET_URANIUM.get());
                        output.accept(NtmItems.NUGGET_U233.get());
                        output.accept(NtmItems.NUGGET_U235.get());
                        output.accept(NtmItems.NUGGET_U238.get());
                        output.accept(NtmItems.NUGGET_U238M2.get());
                        output.accept(NtmItems.NUGGET_PLUTONIUM.get());
                        output.accept(NtmItems.NUGGET_PU238.get());
                        output.accept(NtmItems.NUGGET_PU239.get());
                        output.accept(NtmItems.NUGGET_PU240.get());
                        output.accept(NtmItems.NUGGET_PU241.get());
                        output.accept(NtmItems.NUGGET_PU_MIX.get());
                        output.accept(NtmItems.NUGGET_AM241.get());
                        output.accept(NtmItems.NUGGET_AM242.get());
                        output.accept(NtmItems.NUGGET_AM_MIX.get());
                        output.accept(NtmItems.NUGGET_TECHNETIUM.get());
                        output.accept(NtmItems.NUGGET_NEPTUNIUM.get());
                        output.accept(NtmItems.NUGGET_POLONIUM.get());
                        output.accept(NtmItems.NUGGET_THORIUM_FUEL.get());
                        output.accept(NtmItems.NUGGET_URANIUM_FUEL.get());
                        output.accept(NtmItems.NUGGET_MOX_FUEL.get());
                        output.accept(NtmItems.NUGGET_PLUTONIUM_FUEL.get());
                        output.accept(NtmItems.NUGGET_NEPTUNIUM_FUEL.get());
                        output.accept(NtmItems.NUGGET_AMERICIUM_FUEL.get());
                        output.accept(NtmItems.NUGGET_SCHRABIDIUM_FUEL.get());
                        output.accept(NtmItems.NUGGET_HES.get());
                        output.accept(NtmItems.NUGGET_LES.get());
                        output.accept(NtmItems.NUGGET_LEAD.get());
                        output.accept(NtmItems.NUGGET_BERYLLIUM.get());
                        output.accept(NtmItems.NUGGET_CADMIUM.get());
                        output.accept(NtmItems.NUGGET_BISMUTH.get());
                        output.accept(NtmItems.NUGGET_ARSENIC.get());
                        output.accept(NtmItems.NUGGET_ZIRCONIUM.get());
                        output.accept(NtmItems.NUGGET_TANTALIUM.get());
                        output.accept(NtmItems.NUGGET_DESH.get());
                        output.accept(NtmItems.NUGGET_OSMIRIDIUM.get());
                        output.accept(NtmItems.NUGGET_SCHRABIDIUM.get());
                        output.accept(NtmItems.NUGGET_SOLINIUM.get());
                        output.accept(NtmItems.NUGGET_EUPHEMIUM.get());
                        output.accept(NtmItems.NUGGET_DINEUTRONIUM.get());
                        output.accept(NtmItems.NUGGET_NIOBIUM.get());
                        output.accept(NtmItems.NUGGET_SILICON.get());
                        output.accept(NtmItems.NUGGET_ACTINIUM.get());
                        output.accept(NtmItems.NUGGET_COBALT.get());
                        output.accept(NtmItems.NUGGET_CO60.get());
                        output.accept(NtmItems.NUGGET_SR90.get());
                        output.accept(NtmItems.NUGGET_PB209.get());
                        output.accept(NtmItems.NUGGET_GH336.get());
                        output.accept(NtmItems.NUGGET_AU198.get());
                        output.accept(NtmItems.NUGGET_RA226.get());
                        output.accept(NtmItems.SULFUR);
                        output.accept(NtmItems.CINNABAR);
                        output.accept(NtmItems.FLUORITE);
                        output.accept(NtmItems.LIGNITE);
                        output.accept(NtmItems.NITER);
                        output.accept(NtmItems.RARE_EARTH_ORE_CHUNK);
                        output.accept(NtmItems.CHUNK_CRYOLITE);
                        output.accept(NtmItems.CHUNK_MALACHITE);
                        output.accept(NtmItems.OIL_TAR_CRUDE);
                        output.accept(NtmItems.OIL_TAR_CRACK);
                        output.accept(NtmItems.OIL_TAR_COAL);
                        output.accept(NtmItems.OIL_TAR_PARAFFIN);
                        output.accept(NtmItems.OIL_TAR_WOOD);
                        output.accept(NtmItems.OIL_TAR_WAX);
                        output.accept(NtmItems.DUST);
                        output.accept(NtmItems.CRYSTAL_IRON);
                        output.accept(NtmItems.CRYSTAL_GOLD);
                        output.accept(NtmItems.CRYSTAL_REDSTONE);
                        output.accept(NtmItems.CRYSTAL_LAPIS);
                        output.accept(NtmItems.CRYSTAL_DIAMOND);
                        output.accept(NtmItems.CRYSTAL_URANIUM);
                        output.accept(NtmItems.CRYSTAL_THORIUM);
                        output.accept(NtmItems.CRYSTAL_PLUTONIUM);
                        output.accept(NtmItems.CRYSTAL_TITANIUM);
                        output.accept(NtmItems.CRYSTAL_SULFUR);
                        output.accept(NtmItems.CRYSTAL_NITER);
                        output.accept(NtmItems.CRYSTAL_COPPER);
                        output.accept(NtmItems.CRYSTAL_TUNGSTEN);
                        output.accept(NtmItems.CRYSTAL_ALUMINIUM);
                        output.accept(NtmItems.CRYSTAL_FLUORITE);
                        output.accept(NtmItems.CRYSTAL_BERYLLIUM);
                        output.accept(NtmItems.CRYSTAL_LEAD);
                        output.accept(NtmItems.CRYSTAL_ASBESTOS);
                        output.accept(NtmItems.CRYSTAL_SCHRARANIUM);
                        output.accept(NtmItems.CRYSTAL_SCHRABIDIUM);
                        output.accept(NtmItems.CRYSTAL_RARE);
                        output.accept(NtmItems.CRYSTAL_PHOSPHORUS);
                        output.accept(NtmItems.CRYSTAL_LITHIUM);
                        output.accept(NtmItems.CRYSTAL_CINNABAR);
                        output.accept(NtmItems.CRYSTAL_COBALT);
                        output.accept(NtmItems.CRYSTAL_STARMETAL);
                        output.accept(NtmItems.CRYSTAL_TRIXITE);
                        output.accept(NtmItems.CRYSTAL_OSMIRIDIUM);
                        output.accept(NtmItems.CRYSTAL_OSMIRIDIUM);

                        output.accept(NtmItems.LAUNCH_CODE_PIECE);
                        output.accept(NtmItems.LAUNCH_CODE);
                        output.accept(NtmItems.LAUNCH_KEY);
                        output.accept(NtmItems.DRILL_TITANIUM);
                    }).build());

    // items that belong in machines, fuels, etc
    public static final Supplier<CreativeModeTab> CONTROL = CREATIVE_MODE_TABS.register(
            "control",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NtmItems.PELLET_RTG.get()))
                    .withTabsBefore(NuclearTechMod.withDefaultNamespace("parts"))
                    .title(Component.translatable("itemGroup.control"))
                    .displayItems((itemDisplayParameters, output) -> {
                        addMetaItems(output, NtmItems.BLUEPRINTS.get());

                        output.accept(NtmItems.STAMP_STONE_FLAT);
                        output.accept(NtmItems.STAMP_STONE_PLATE);
                        output.accept(NtmItems.STAMP_STONE_WIRE);
                        output.accept(NtmItems.STAMP_STONE_CIRCUIT);
                        output.accept(NtmItems.STAMP_IRON_FLAT);
                        output.accept(NtmItems.STAMP_IRON_PLATE);
                        output.accept(NtmItems.STAMP_IRON_WIRE);
                        output.accept(NtmItems.STAMP_IRON_CIRCUIT);
                        output.accept(NtmItems.STAMP_STEEL_FLAT);
                        output.accept(NtmItems.STAMP_STEEL_PLATE);
                        output.accept(NtmItems.STAMP_STEEL_WIRE);
                        output.accept(NtmItems.STAMP_STEEL_CIRCUIT);
                        output.accept(NtmItems.STAMP_TITANIUM_FLAT);
                        output.accept(NtmItems.STAMP_TITANIUM_PLATE);
                        output.accept(NtmItems.STAMP_TITANIUM_WIRE);
                        output.accept(NtmItems.STAMP_TITANIUM_CIRCUIT);
                        output.accept(NtmItems.STAMP_OBSIDIAN_FLAT);
                        output.accept(NtmItems.STAMP_OBSIDIAN_PLATE);
                        output.accept(NtmItems.STAMP_OBSIDIAN_WIRE);
                        output.accept(NtmItems.STAMP_OBSIDIAN_CIRCUIT);
                        output.accept(NtmItems.STAMP_DESH_FLAT);
                        output.accept(NtmItems.STAMP_DESH_PLATE);
                        output.accept(NtmItems.STAMP_DESH_WIRE);
                        output.accept(NtmItems.STAMP_DESH_CIRCUIT);

                        output.accept(NtmItems.CELL_EMPTY);
                        output.accept(NtmItems.CELL_UF6);
                        output.accept(NtmItems.CELL_PUF6);
                        output.accept(NtmItems.CELL_DEUTERIUM);
                        output.accept(NtmItems.CELL_TRITIUM);
                        output.accept(NtmItems.CELL_SAS3);
                        output.accept(NtmItems.CELL_ANTIMATTER);
                        output.accept(NtmItems.CELL_ANTI_SCHARBIDIUM);
                        output.accept(NtmItems.CELL_BALEFIRE);

                        output.accept(NtmItems.PARTICLE_DIGAMMA);
                        output.accept(NtmItems.PARTICLE_LUTECE);

                        output.accept(NtmItems.SINGULARITY);
                        output.accept(NtmItems.SINGULARITY_COUNTER_RESONANT);
                        output.accept(NtmItems.SINGULARITY_SUPER_HEATED);
                        output.accept(NtmItems.BLACK_HOLE);
                        output.accept(NtmItems.SINGULARITY_SPARK);
                        output.accept(NtmItems.PELLET_ANTIMATTER);

                        FluidType[] types = Fluids.getInNiceOrder();
                        // tanks
                        output.accept(NtmItems.FLUID_TANK_EMPTY.get());
                        for(int i = 1; i < types.length; ++i) {
                            FluidType type = types[i];
                            int id = type.getID();

                            if (type.hasNoContainer()) continue;
                            if (type.needsLeadContainer()) continue;
                            output.accept(MetaHelper.metaStack(new ItemStack(NtmItems.FLUID_TANK_FULL.get(), 1), id));
                        }
                        // lead tanks
                        output.accept(NtmItems.FLUID_TANK_LEAD_EMPTY.get());
                        for(int i = 1; i < types.length; ++i) {
                            FluidType type = types[i];
                            int id = type.getID();

                            if (type.hasNoContainer()) continue;
                            output.accept(MetaHelper.metaStack(new ItemStack(NtmItems.FLUID_TANK_LEAD_FULL.get(), 1), id));
                        }
                        // barrels
                        output.accept(NtmItems.FLUID_BARREL_EMPTY.get());
                        for(int i = 1; i < types.length; ++i) {
                            FluidType type = types[i];
                            int id = type.getID();

                            if (type.hasNoContainer()) continue;
                            if (type.needsLeadContainer()) continue;
                            output.accept(MetaHelper.metaStack(new ItemStack(NtmItems.FLUID_BARREL_FULL.get(), 1), id));
                        }
                        // fluid packs
                        output.accept(NtmItems.FLUID_PACK_EMPTY.get());
                        for(int i = 1; i < types.length; ++i) {
                            FluidType type = types[i];
                            int id = type.getID();

                            if (type.hasNoContainer()) continue;
                            if (type.needsLeadContainer()) continue;
                            output.accept(MetaHelper.metaStack(new ItemStack(NtmItems.FLUID_PACK_FULL.get(), 1), id));
                        }
                        output.accept(NtmItems.FLUID_BARREL_INFINITE.get());
                        output.accept(NtmItems.INF_WATER.get());
                        output.accept(NtmItems.INF_WATER_MK2.get());

                        addMetaItems(output, NtmItems.BATTERY_PACK.get());
                        addMetaItems(output, NtmItems.BATTERY_SC.get());

                        output.accept(NtmItems.BATTERY_CREATIVE);

                        output.accept(NtmItems.ROD_EMPTY);
                        addMetaItems(output, NtmItems.ROD.get());
                        output.accept(NtmItems.ROD_DUAL_EMPTY);
                        addMetaItems(output, NtmItems.ROD_DUAL.get());
                        output.accept(NtmItems.ROD_QUAD_EMPTY);
                        addMetaItems(output, NtmItems.ROD_QUAD.get());

                        output.accept(NtmItems.REACHER);
                        output.accept(NtmItems.MELTDOWN_TOOL);

                        output.accept(NtmItems.UPGRADE_TEMPLATE);
                        output.accept(NtmItems.UPGRADE_SPEED_1);
                        output.accept(NtmItems.UPGRADE_SPEED_2);
                        output.accept(NtmItems.UPGRADE_SPEED_3);
                        output.accept(NtmItems.UPGRADE_EFFECT_1);
                        output.accept(NtmItems.UPGRADE_EFFECT_2);
                        output.accept(NtmItems.UPGRADE_EFFECT_3);
                        output.accept(NtmItems.UPGRADE_POWER_1);
                        output.accept(NtmItems.UPGRADE_POWER_2);
                        output.accept(NtmItems.UPGRADE_POWER_3);
                        output.accept(NtmItems.UPGRADE_FORTUNE_1);
                        output.accept(NtmItems.UPGRADE_FORTUNE_2);
                        output.accept(NtmItems.UPGRADE_FORTUNE_3);
                        output.accept(NtmItems.UPGRADE_AFTERBURN_1);
                        output.accept(NtmItems.UPGRADE_AFTERBURN_2);
                        output.accept(NtmItems.UPGRADE_AFTERBURN_3);
                        output.accept(NtmItems.UPGRADE_RADIUS);
                        output.accept(NtmItems.UPGRADE_HEALTH);
                        output.accept(NtmItems.UPGRADE_OVERDRIVE_1);
                        output.accept(NtmItems.UPGRADE_OVERDRIVE_2);
                        output.accept(NtmItems.UPGRADE_OVERDRIVE_3);
                        addMaterialControlItems(output);

                    }).build());

    // templates, siren tracks
    /** SKIP */

    // ore and blocks
    public static final Supplier<CreativeModeTab> BLOCKS = CREATIVE_MODE_TABS.register(
            "blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NtmBlocks.ORE_URANIUM.get()))
                    .withTabsBefore(NuclearTechMod.withDefaultNamespace("control"))
                    .title(Component.translatable("itemGroup.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                        addMetaItems(output, NtmBlocks.ORE_BASALT.asItem());

                        output.accept(NtmBlocks.BASALT);
                        output.accept(NtmBlocks.BASALT_SMOOTH);
                        output.accept(NtmBlocks.BASALT_BRICK);
                        output.accept(NtmBlocks.BASALT_POLISHED);
                        output.accept(NtmBlocks.BASALT_TILES);

                        addMetaItems(output, NtmBlocks.BOBBLEHEAD.asItem());
                        addMetaItems(output, NtmBlocks.PLUSHIE.asItem());

                        output.accept(NtmBlocks.GRAVEL_OBSIDIAN);
                        output.accept(NtmBlocks.GRAVEL_DIAMOND);
                        output.accept(NtmBlocks.MOON_TURF);

                        output.accept(NtmBlocks.ASPHALT);
                        output.accept(NtmBlocks.ASPHALT_LIGHT);

                        output.accept(NtmBlocks.BRICK_CONCRETE);
                        output.accept(NtmBlocks.CONCRETE);
                        output.accept(NtmBlocks.CONCRETE_SMOOTH);
                        output.accept(NtmBlocks.CONCRETE_ASBESTOS);
                        output.accept(NtmBlocks.DUCRETE);
                        output.accept(NtmBlocks.DUCRETE_SMOOTH);
                        output.accept(NtmBlocks.DUCRETE_REINFORCED);
                        output.accept(NtmBlocks.DUCRETE_BRICK);
                        output.accept(NtmBlocks.BRICK_CONCRETE_MOSSY);
                        output.accept(NtmBlocks.BRICK_CONCRETE_CRACKED);
                        output.accept(NtmBlocks.BRICK_CONCRETE_BROKEN);
                        output.accept(NtmBlocks.BRICK_CONCRETE_MARKED);
                        output.accept(NtmBlocks.BRICK_OBSIDIAN);
                        output.accept(NtmBlocks.BRICK_LIGHT);
                        output.accept(NtmBlocks.BRICK_ASBESTOS);
                        output.accept(NtmBlocks.BRICK_FIRE);
                        output.accept(NtmBlocks.REINFORCED_LAMINATE);
                        output.accept(NtmBlocks.STEEL_SCAFFOLD);
                        output.accept(NtmBlocks.SAND_QUARTZ);
                        output.accept(NtmBlocks.GLASS_QUARTZ);

                        output.accept(NtmBlocks.BRICK_CONCRETE_SLAB);
                        output.accept(NtmBlocks.BRICK_CONCRETE_MOSSY_SLAB);
                        output.accept(NtmBlocks.BRICK_CONCRETE_CRACKED_SLAB);
                        output.accept(NtmBlocks.BRICK_CONCRETE_BROKEN_SLAB);

                        output.accept(NtmBlocks.BRICK_CONCRETE_STAIRS);
                        output.accept(NtmBlocks.BRICK_CONCRETE_MOSSY_STAIRS);
                        output.accept(NtmBlocks.BRICK_CONCRETE_CRACKED_STAIRS);
                        output.accept(NtmBlocks.BRICK_CONCRETE_BROKEN_STAIRS);

                        addMetaItems(output, NtmBlocks.BARBED_WIRE.asItem());
                        output.accept(NtmBlocks.SPIKES);

                        output.accept(NtmBlocks.WASTE_EARTH);
                        output.accept(NtmBlocks.WASTE_MYCELIUM);
                        output.accept(NtmBlocks.WASTE_TRINITITE);
                        output.accept(NtmBlocks.WASTE_TRINITITE_RED);
                        output.accept(NtmBlocks.WASTE_LOG);
                        output.accept(NtmBlocks.WASTE_LEAVES);
                        output.accept(NtmBlocks.WASTE_PLANKS);
                        output.accept(NtmBlocks.FROZEN_GRASS);
                        output.accept(NtmBlocks.FROZEN_DIRT);
                        output.accept(NtmBlocks.FROZEN_PLANKS);
                        output.accept(NtmBlocks.FROZEN_LOG);
                        output.accept(NtmBlocks.FALLOUT);
                        output.accept(NtmBlocks.LEAVES_LAYER);

                        output.accept(NtmBlocks.DECO_ALUMINIUM);
                        output.accept(NtmBlocks.DECO_BERYLLIUM);
                        output.accept(NtmBlocks.DECO_LEAD);
                        output.accept(NtmBlocks.DECO_RED_COPPER);
                        output.accept(NtmBlocks.DECO_STEEL);
                        output.accept(NtmBlocks.DECO_RUSTY_STEEL);
                        output.accept(NtmBlocks.DECO_TITANIUM);
                        output.accept(NtmBlocks.DECO_TUNGSTEN);
                        output.accept(NtmBlocks.DECO_ASBESTOS);

                        output.accept(NtmBlocks.STONE_CRACKED);
                        output.accept(NtmBlocks.DIRT_DEAD);
                        output.accept(NtmBlocks.DIRT_OILY);
                        output.accept(NtmBlocks.OIL_SPILL);
                        output.accept(NtmBlocks.SELLAFIELD_SLAKED);
                        output.accept(NtmBlocks.SELLAFIELD_BEDROCK);
                        output.accept(NtmBlocks.ORE_SELLAFIELD_DIAMOND);
                        output.accept(NtmBlocks.ORE_SELLAFIELD_EMERALD);
                        output.accept(NtmBlocks.ORE_OIL);
                        output.accept(NtmBlocks.ORE_OIL_EMPTY);
                        output.accept(NtmBlocks.ORE_OIL_SAND);
                        output.accept(NtmBlocks.ORE_BEDROCK_OIL);
                        output.accept(NtmBlocks.ORE_URANIUM);
                        output.accept(NtmBlocks.ORE_URANIUM_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_BERYLLIUM);
                        output.accept(NtmBlocks.ORE_BERYLLIUM_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_TUNGSTEN);
                        output.accept(NtmBlocks.ORE_TUNGSTEN_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_TITANIUM);
                        output.accept(NtmBlocks.ORE_TITANIUM_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_LEAD);
                        output.accept(NtmBlocks.ORE_LEAD_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_ALUMINIUM);
                        output.accept(NtmBlocks.ORE_ALUMINIUM_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_ASBESTOS);
                        output.accept(NtmBlocks.ORE_ASBESTOS_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_THORIUM);
                        output.accept(NtmBlocks.ORE_THORIUM_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_NITER);
                        output.accept(NtmBlocks.ORE_NITER_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_COBALT);
                        output.accept(NtmBlocks.ORE_COBALT_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_CINNABAR);
                        output.accept(NtmBlocks.ORE_CINNABAR_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_FLUORITE);
                        output.accept(NtmBlocks.ORE_FLUORITE_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_METEOR_IRON);
                        output.accept(NtmBlocks.ORE_METEOR_COBALT);
                        output.accept(NtmBlocks.ORE_METEOR_ALUMINIUM);
                        output.accept(NtmBlocks.ORE_METEOR_COPPER);
                        output.accept(NtmBlocks.ORE_METEOR_RARE);
                        output.accept(NtmBlocks.ORE_RARE);
                        output.accept(NtmBlocks.ORE_RARE_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_SULFUR);
                        output.accept(NtmBlocks.ORE_SULFUR_DEEPSLATE);
                        output.accept(NtmBlocks.ORE_LIGNITE);
                        output.accept(NtmBlocks.RESOURCE_LIMESTONE);
                        output.accept(NtmBlocks.RESOURCE_BAUXITE);
                        output.accept(NtmBlocks.RESOURCE_HEMATITE);
                        output.accept(NtmBlocks.RESOURCE_MALACHITE);
                        output.accept(NtmBlocks.RESOURCE_CHRYSOTILE);
                        output.accept(NtmBlocks.RESOURCE_SULFUROUS_STONE);
                        addMaterialBlocks(output);
                    }).build());

    // machines, structure parts
    public static final Supplier<CreativeModeTab> MACHINE = CREATIVE_MODE_TABS.register(
            "machine",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NtmBlocks.PWR_CONTROLLER.get()))
                    .withTabsBefore(NuclearTechMod.withDefaultNamespace("blocks"))
                    .title(Component.translatable("itemGroup.machine"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(NtmBlocks.GAS_RADON);
                        output.accept(NtmBlocks.GAS_RADON_DENSE);
                        output.accept(NtmBlocks.GAS_RADON_TOMB);
                        output.accept(NtmBlocks.GAS_MELTDOWN);
                        output.accept(NtmBlocks.GAS_MONOXIDE);
                        output.accept(NtmBlocks.GAS_ASBESTOS);
                        output.accept(NtmBlocks.GAS_COAL);
                        output.accept(NtmBlocks.GAS_FLAMMABLE);
                        output.accept(NtmBlocks.GAS_EXPLOSIVE);

                        output.accept(NtmBlocks.GEIGER);

                        output.accept(NtmBlocks.REACTOR_ZIRNOX);
                        output.accept(NtmBlocks.RED_CABLE);

                        addMetaItems(output, NtmBlocks.FLUID_DUCT_NEO.asItem());

                        output.accept(NtmBlocks.PRESS_PREHEATER);
                        output.accept(NtmBlocks.MACHINE_PRESS);

                        output.accept(NtmBlocks.MACHINE_BATTERY_SOCKET);
                        output.accept(NtmBlocks.MACHINE_BATTERY_REDD);
                        output.accept(NtmBlocks.MACHINE_ASSEMBLY_MACHINE);
                        output.accept(NtmBlocks.MACHINE_SHREDDER);
                        output.accept(NtmBlocks.MACHINE_FLUID_TANK);
                        output.accept(NtmBlocks.MACHINE_CHUNGUS);
                        output.accept(NtmBlocks.MACHINE_SOLDERING_STATION);
                        output.accept(NtmBlocks.MACHINE_WELL);
                        output.accept(NtmBlocks.MACHINE_PUMPJACK);
                        output.accept(NtmBlocks.MACHINE_FRACKING_TOWER);
                        output.accept(NtmBlocks.MACHINE_REFINERY);
                        output.accept(NtmBlocks.FURNACE_COMBINATION);
                        output.accept(NtmBlocks.MACHINE_BLAST_FURNACE);
                        output.accept(NtmBlocks.MACHINE_WOOD_BURNER);
                        output.accept(NtmBlocks.MACHINE_CENTRIFUGE);
                        output.accept(NtmBlocks.MACHINE_CHEMICAL_PLANT);
                        output.accept(NtmBlocks.HEAT_BOILER);
                        output.accept(NtmBlocks.MACHINE_INDUSTRIAL_BOILER);
                        output.accept(NtmBlocks.HEATER_OVEN);
                        output.accept(NtmBlocks.HEATER_FIREBOX);
                        output.accept(NtmBlocks.HEATER_OILBURNER);
                        output.accept(NtmBlocks.HEATER_ELECTRIC);
                        output.accept(NtmBlocks.HEATER_HEATEX);
                        output.accept(NtmBlocks.MACHINE_ARC_WELDER);
                        output.accept(NtmBlocks.TRANSFORMER);

                        addMetaItems(output, NtmBlocks.ANVIL.asItem());
                        output.accept(NtmBlocks.BARREL_PLASTIC);
                        output.accept(NtmBlocks.BARREL_STEEL);
                        output.accept(NtmBlocks.BARREL_CORRODED);
                        output.accept(NtmBlocks.BARREL_TCALLOY);
                        output.accept(NtmBlocks.CRATE_IRON);
                        output.accept(NtmBlocks.CRATE_TUNGSTEN);
                        output.accept(NtmBlocks.CRATE_STEEL);
                        output.accept(NtmBlocks.CRATE_DESH);
                        output.accept(NtmBlocks.CRATE_TEMPLATE);
                        output.accept(NtmBlocks.MACHINE_SATLINKER);
                        output.accept(NtmBlocks.DECONTAMINATOR);

                        FluidType[] types = Fluids.getInNiceOrder();
                        // multi identifiers
                        for(int i = 1; i < types.length; ++i) {
                            FluidType type = types[i];

                            output.accept(FluidIDMultiItem.createStack(type));
                        }
                    }).build());

    // bombs
    public static final Supplier<CreativeModeTab> NUKE = CREATIVE_MODE_TABS.register(
            "nuke",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NtmBlocks.NUKE_FAT_MAN.get()))
                    .withTabsBefore(NuclearTechMod.withDefaultNamespace("machine"))
                    .title(Component.translatable("itemGroup.nuke"))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(NuclearTechMod.MODID, "textures/gui/nuke_tab.png"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(NtmBlocks.NUKE_GADGET);
                        output.accept(NtmBlocks.NUKE_LITTLE_BOY);
                        output.accept(NtmBlocks.NUKE_FAT_MAN);
                        output.accept(NtmBlocks.NUKE_IVY_MIKE);
                        output.accept(NtmBlocks.NUKE_TSAR_BOMBA);
                        output.accept(NtmBlocks.NUKE_PROTOTYPE);
                        output.accept(NtmBlocks.NUKE_FLEIJA);
                        output.accept(NtmBlocks.NUKE_SOLINIUM);
                        output.accept(NtmBlocks.NUKE_N2);
                        output.accept(NtmBlocks.NUKE_FSTBMB);

                        addMetaItems(output, NtmBlocks.CRASHED_BOMB.asItem());

                        output.accept(NtmBlocks.DYNAMITE);
                        output.accept(NtmBlocks.TNT);
                        output.accept(NtmBlocks.SEMTEX);
                        output.accept(NtmBlocks.C4);
                        output.accept(NtmBlocks.FISSURE_BOMB);

                        output.accept(NtmBlocks.MINE_AP);
                        output.accept(NtmBlocks.MINE_SHRAP);
                        output.accept(NtmBlocks.MINE_HE);
                        output.accept(NtmBlocks.MINE_FAT);
                        output.accept(NtmBlocks.MINE_NAVAL);

                        output.accept(NtmBlocks.DET_CORD);
                        output.accept(NtmBlocks.DET_CHARGE);
                        output.accept(NtmBlocks.DET_NUKE);
                        output.accept(NtmBlocks.DET_MINER);

                        output.accept(NtmBlocks.BARREL_RED);
                        output.accept(NtmBlocks.BARREL_PINK);
                        output.accept(NtmBlocks.BARREL_LOX);
                        output.accept(NtmBlocks.BARREL_TAINT);

                        addMetaItems(output, NtmBlocks.VOLCANO_CORE.asItem());
                        addMetaItems(output, NtmBlocks.VOLCANO_RAD_CORE.asItem());

                        output.accept(NtmItems.BATTERY_SPARK);
                        output.accept(NtmItems.BATTERY_TRIXITE);

                        output.accept(NtmItems.EARLY_EXPLOSIVE_LENSES);
                        output.accept(NtmItems.EXPLOSIVE_LENSES);

                        output.accept(NtmItems.GADGET_WIREING);
                        output.accept(NtmItems.GADGET_CORE);

                        output.accept(NtmItems.LITTLE_BOY_SHIELDING);
                        output.accept(NtmItems.LITTLE_BOY_TARGET);
                        output.accept(NtmItems.LITTLE_BOY_BULLET);
                        output.accept(NtmItems.LITTLE_BOY_PROPELLANT);
                        output.accept(NtmItems.LITTLE_BOY_IGNITER);

                        output.accept(NtmItems.FAT_MAN_CORE);
                        output.accept(NtmItems.FAT_MAN_IGNITER);

                        output.accept(NtmItems.IVY_MIKE_CORE);
                        output.accept(NtmItems.IVY_MIKE_DEUT);
                        output.accept(NtmItems.IVY_MIKE_COOLING_UNIT);

                        output.accept(NtmItems.TSAR_BOMBA_CORE);

                        output.accept(NtmItems.FLEIJA_IGNITER);
                        output.accept(NtmItems.FLEIJA_PROPELLANT);
                        output.accept(NtmItems.FLEIJA_CORE);

                        output.accept(NtmItems.SOLINIUM_IGNITER);
                        output.accept(NtmItems.SOLINIUM_PROPELLANT);
                        output.accept(NtmItems.SOLINIUM_CORE);

                        output.accept(NtmItems.N2_CHARGE);

                        output.accept(NtmItems.EGG_BALEFIRE_SHARD);
                        output.accept(NtmItems.EGG_BALEFIRE);

                        output.accept(NtmItems.IGNITER);
                        output.accept(NtmItems.DETONATOR);
                        output.accept(NtmItems.DETONATOR_MULTI);
                        output.accept(NtmItems.DETONATOR_LASER);
                        output.accept(NtmItems.DETONATOR_DEADMAN);
                        output.accept(NtmItems.DETONATOR_DE);

                        // this is sucks
                        output.accept(MetaHelper.newStack(NtmItems.STARTER_KIT, KitType.GADGET));
                        output.accept(MetaHelper.newStack(NtmItems.STARTER_KIT, KitType.LITTLE_BOY));
                        output.accept(MetaHelper.newStack(NtmItems.STARTER_KIT, KitType.FAT_MAN));
                        output.accept(MetaHelper.newStack(NtmItems.STARTER_KIT, KitType.IVY_MIKE));
                        output.accept(MetaHelper.newStack(NtmItems.STARTER_KIT, KitType.TSAR_BOMBA));
                        output.accept(MetaHelper.newStack(NtmItems.STARTER_KIT, KitType.PROTOTYPE));
                        output.accept(MetaHelper.newStack(NtmItems.STARTER_KIT, KitType.FLEIJA));
                        output.accept(MetaHelper.newStack(NtmItems.STARTER_KIT, KitType.SOLINIUM));
                    }).build());

    // missiles, satellites
    public static final Supplier<CreativeModeTab> MISSILE = CREATIVE_MODE_TABS.register(
            "missile",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NtmItems.MISSILE_DOOMSDAY.get()))
                    .withTabsBefore(NuclearTechMod.withDefaultNamespace("nuke"))
                    .title(Component.translatable("itemGroup.missile"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(NtmBlocks.LAUNCH_PAD);
                        output.accept(NtmBlocks.LAUNCH_PAD_LARGE);
                        output.accept(NtmBlocks.SOYUZ_LAUNCHER);

                        output.accept(NtmItems.DESIGNATOR);
                        output.accept(NtmItems.DESIGNATOR_RANGE);
                        output.accept(NtmItems.MISSILE_ASSEMBLY);
                        output.accept(NtmItems.THRUSTER_SMALL);
                        output.accept(NtmItems.THRUSTER_MEDIUM);
                        output.accept(NtmItems.THRUSTER_LARGE);
                        output.accept(NtmItems.FUEL_TANK_SMALL);
                        output.accept(NtmItems.FUEL_TANK_MEDIUM);
                        output.accept(NtmItems.FUEL_TANK_LARGE);
                        output.accept(NtmItems.WARHEAD_GENERIC_SMALL);
                        output.accept(NtmItems.WARHEAD_GENERIC_MEDIUM);
                        output.accept(NtmItems.WARHEAD_GENERIC_LARGE);
                        output.accept(NtmItems.WARHEAD_INCENDIARY_SMALL);
                        output.accept(NtmItems.WARHEAD_INCENDIARY_MEDIUM);
                        output.accept(NtmItems.WARHEAD_INCENDIARY_LARGE);
                        output.accept(NtmItems.WARHEAD_CLUSTER_SMALL);
                        output.accept(NtmItems.WARHEAD_CLUSTER_MEDIUM);
                        output.accept(NtmItems.WARHEAD_CLUSTER_LARGE);
                        output.accept(NtmItems.WARHEAD_BUSTER_SMALL);
                        output.accept(NtmItems.WARHEAD_BUSTER_MEDIUM);
                        output.accept(NtmItems.WARHEAD_BUSTER_LARGE);
                        output.accept(NtmItems.WARHEAD_NUCLEAR);
                        output.accept(NtmItems.WARHEAD_MIRV);
                        output.accept(NtmItems.WARHEAD_VOLCANO);

                        output.accept(NtmItems.MISSILE_TAINT);
                        output.accept(NtmItems.MISSILE_MICRO);
                        output.accept(NtmItems.MISSILE_BHOLE);
                        output.accept(NtmItems.MISSILE_SCHRABIDIUM);
                        output.accept(NtmItems.MISSILE_EMP);
                        output.accept(NtmItems.MISSILE_GENERIC);
                        output.accept(NtmItems.MISSILE_DECOY);
                        output.accept(NtmItems.MISSILE_INCENDIARY);
                        output.accept(NtmItems.MISSILE_CLUSTER);
                        output.accept(NtmItems.MISSILE_BUSTER);
                        output.accept(NtmItems.MISSILE_STEALTH);
                        output.accept(NtmItems.MISSILE_ANTI_BALLISTIC);
                        output.accept(NtmItems.MISSILE_STRONG);
                        output.accept(NtmItems.MISSILE_INCENDIARY_STRONG);
                        output.accept(NtmItems.MISSILE_CLUSTER_STRONG);
                        output.accept(NtmItems.MISSILE_BUSTER_STRONG);
                        output.accept(NtmItems.MISSILE_EMP_STRONG);
                        output.accept(NtmItems.MISSILE_BURST);
                        output.accept(NtmItems.MISSILE_INFERNO);
                        output.accept(NtmItems.MISSILE_RAIN);
                        output.accept(NtmItems.MISSILE_DRILL);
                        output.accept(NtmItems.MISSILE_SHUTTLE);
                        output.accept(NtmItems.MISSILE_NUCLEAR);
                        output.accept(NtmItems.MISSILE_NUCLEAR_CLUSTER);
                        output.accept(NtmItems.MISSILE_VOLCANO);
                        output.accept(NtmItems.MISSILE_DOOMSDAY);
                        output.accept(NtmItems.MISSILE_DOOMSDAY_RUSTED);
                        addMetaItems(output, NtmItems.MISSILE_SOYUZ.get());

                        addMetaItems(output, NtmItems.SATELLITE.get());
                        output.accept(NtmItems.SAT_GERALD);
                        output.accept(NtmItems.SAT_CHIP);
                        output.accept(NtmItems.SAT_COORD);
                        output.accept(NtmItems.SAT_DESIGNATOR);

                    }).build());

    // turrets, weapons, ammo
    /** SKIP */

    // drinks, kits, tools
    public static final Supplier<CreativeModeTab> CONSUMABLE = CREATIVE_MODE_TABS.register(
            "consumable",
            () -> CreativeModeTab.builder().icon(() -> MetaHelper.newStack(NtmItems.DRINK, DrinkType.NUKA))
                    .withTabsBefore(NuclearTechMod.withDefaultNamespace("missile"))
                    .title(Component.translatable("itemGroup.consumable"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(NtmItems.SPAWN_DUCK);

                        output.accept(NtmItems.DOSIMETER);
                        output.accept(NtmItems.GEIGER_COUNTER);
                        output.accept(NtmItems.OIL_DETECTOR);
                        output.accept(NtmItems.DIGAMMA_DIAGNOSTIC);
                        output.accept(NtmItems.METEOR_REMOTE);
                        output.accept(NtmItems.METEOR_CHARM);
                        output.accept(NtmItems.PROTECTION_CHARM);

                        output.accept(NtmItems.BALEFIRE_AND_STEEL);

                        addMetaItems(output, NtmItems.DRINK.get());
                        output.accept(NtmItems.BOTTLE_OPENER);
                        addMetaItems(output, NtmItems.CANNED_CONSERVE.get());
                        addMetaItems(output, NtmItems.CAP.get());
                        output.accept(NtmItems.RING_PULL);
                        output.accept(NtmItems.CAN_KEY);

                        output.accept(NtmItems.CHOCOLATE_MILK);
                        output.accept(NtmItems.CIGARETTE);
                        output.accept(NtmItems.CRACKPIPE);

                        addMetaItems(output, NtmItems.BOMB_CALLER.get());

                        output.accept(NtmItems.STEEL_PICKAXE);
                        output.accept(NtmItems.STEEL_AXE);
                        output.accept(NtmItems.STEEL_SHOVEL);
                        output.accept(NtmItems.STEEL_HOE);
                        output.accept(NtmItems.TITANIUM_PICKAXE);
                        output.accept(NtmItems.TITANIUM_AXE);
                        output.accept(NtmItems.TITANIUM_SHOVEL);
                        output.accept(NtmItems.TITANIUM_HOE);
                        output.accept(NtmItems.DESH_PICKAXE);
                        output.accept(NtmItems.DESH_AXE);
                        output.accept(NtmItems.DESH_SHOVEL);
                        output.accept(NtmItems.DESH_HOE);
                        output.accept(NtmItems.COBALT_PICKAXE);
                        output.accept(NtmItems.COBALT_AXE);
                        output.accept(NtmItems.COBALT_SHOVEL);
                        output.accept(NtmItems.COBALT_HOE);
                        output.accept(NtmItems.COBALT_DECORATED_PICKAXE);
                        output.accept(NtmItems.COBALT_DECORATED_AXE);
                        output.accept(NtmItems.COBALT_DECORATED_SHOVEL);
                        output.accept(NtmItems.COBALT_DECORATED_HOE);
                        output.accept(NtmItems.CMB_PICKAXE);
                        output.accept(NtmItems.CMB_AXE);
                        output.accept(NtmItems.CMB_SHOVEL);
                        output.accept(NtmItems.CMB_HOE);
                        output.accept(NtmItems.BISMUTH_PICKAXE);
                        output.accept(NtmItems.BISMUTH_AXE);
                        output.accept(NtmItems.STARMETAL_PICKAXE);
                        output.accept(NtmItems.STARMETAL_AXE);
                        output.accept(NtmItems.STARMETAL_SHOVEL);
                        output.accept(NtmItems.STARMETAL_HOE);
                        output.accept(NtmItems.VOLCANIC_PICKAXE);
                        output.accept(NtmItems.VOLCANIC_AXE);
                        output.accept(NtmItems.CHLOROPHYTE_PICKAXE);
                        output.accept(NtmItems.CHLOROPHYTE_AXE);
                        output.accept(NtmItems.MESE_PICKAXE);
                        output.accept(NtmItems.MESE_AXE);
                        output.accept(NtmItems.SCHRABIDIUM_PICKAXE);
                        output.accept(NtmItems.SCHRABIDIUM_AXE);
                        output.accept(NtmItems.SCHRABIDIUM_SHOVEL);
                        output.accept(NtmItems.SCHRABIDIUM_HOE);
                        output.accept(NtmItems.POLAROID);
                    }).build());

    private static void addMetaItems(CreativeModeTab.Output output, Item item) {
        if(item instanceof IMetaItem metaItem) {
            List<ItemStack> stacks = new ArrayList<>();
            metaItem.getSubItems(item, stacks);

            for(ItemStack stack : stacks) {
                output.accept(stack);
            }
        }
    }

    private static void addMaterialPartItems(CreativeModeTab.Output output) {
        output.accept(NtmItems.PLATE_POLYMER);
        output.accept(NtmItems.INGOT_COPPER);
        output.accept(NtmItems.INGOT_ASTATINE);
        output.accept(NtmItems.INGOT_BROMINE);
        output.accept(NtmItems.INGOT_C4);
        output.accept(NtmItems.INGOT_CAESIUM);
        output.accept(NtmItems.INGOT_CERIUM);
        output.accept(NtmItems.INGOT_CHAINSTEEL);
        output.accept(NtmItems.INGOT_DAFFERGON);
        output.accept(NtmItems.INGOT_FIBERGLASS);
        output.accept(NtmItems.INGOT_I131);
        output.accept(NtmItems.INGOT_IODINE);
        output.accept(NtmItems.INGOT_METEORITE);
        output.accept(NtmItems.INGOT_METEORITE_FORGED);
        output.accept(NtmItems.INGOT_PHOSPHORUS);
        addMetaItems(output, NtmItems.INGOT_RAW.get());
        output.accept(NtmItems.INGOT_RED_COPPER);
        output.accept(NtmItems.INGOT_REIIUM);
        output.accept(NtmItems.INGOT_SEMTEX);
        output.accept(NtmItems.INGOT_STEEL_DUSTED);
        output.accept(NtmItems.INGOT_TENNESSINE);
        output.accept(NtmItems.INGOT_TH232);
        output.accept(NtmItems.INGOT_TUNGSTEN_CARBIDE);
        output.accept(NtmItems.INGOT_UNOBTAINIUM);
        output.accept(NtmItems.INGOT_VERTICIUM);
        output.accept(NtmItems.INGOT_WEIDANIUM);
        output.accept(NtmItems.NUGGET_AUSTRALIUM);
        output.accept(NtmItems.NUGGET_AUSTRALIUM_GREATER);
        output.accept(NtmItems.NUGGET_AUSTRALIUM_LESSER);
        output.accept(NtmItems.NUGGET_DAFFERGON);
        output.accept(NtmItems.NUGGET_MERCURY);
        output.accept(NtmItems.NUGGET_REIIUM);
        output.accept(NtmItems.NUGGET_STRONTIUM);
        output.accept(NtmItems.NUGGET_TH232);
        output.accept(NtmItems.NUGGET_UNOBTAINIUM);
        output.accept(NtmItems.NUGGET_UNOBTAINIUM_GREATER);
        output.accept(NtmItems.NUGGET_UNOBTAINIUM_LESSER);
        output.accept(NtmItems.NUGGET_VERTICIUM);
        output.accept(NtmItems.NUGGET_WEIDANIUM);
        output.accept(NtmItems.PLATE_ARMOR_AJR);
        output.accept(NtmItems.PLATE_ARMOR_DNT);
        output.accept(NtmItems.PLATE_ARMOR_FAU);
        output.accept(NtmItems.PLATE_ARMOR_HEV);
        output.accept(NtmItems.PLATE_ARMOR_LUNAR);
        output.accept(NtmItems.PLATE_ARMOR_TITANIUM);
        output.accept(NtmItems.PLATE_DALEKANIUM);
        output.accept(NtmItems.PLATE_DESH);
        output.accept(NtmItems.PLATE_DINEUTRONIUM);
        output.accept(NtmItems.PLATE_EUPHEMIUM);
        output.accept(NtmItems.PLATE_KEVLAR);
        output.accept(NtmItems.PLATE_MIXED);
        output.accept(NtmItems.PLATE_PAA);
        output.accept(NtmItems.POWDER_ACTINIUM);
        output.accept(NtmItems.POWDER_ACTINIUM_TINY);
        output.accept(NtmItems.POWDER_ASTATINE);
        output.accept(NtmItems.POWDER_AT209);
        output.accept(NtmItems.POWDER_AT209_TINY);
        output.accept(NtmItems.POWDER_AU198);
        output.accept(NtmItems.POWDER_AU198_TINY);
        output.accept(NtmItems.POWDER_AUSTRALIUM);
        output.accept(NtmItems.POWDER_BALEFIRE);
        output.accept(NtmItems.POWDER_BORAX);
        output.accept(NtmItems.POWDER_BORON);
        output.accept(NtmItems.POWDER_BORON_TINY);
        output.accept(NtmItems.POWDER_BROMINE);
        output.accept(NtmItems.POWDER_CADMIUM);
        output.accept(NtmItems.POWDER_CAESIUM);
        output.accept(NtmItems.POWDER_CALCIUM);
        output.accept(NtmItems.POWDER_CDALLOY);
        output.accept(NtmItems.POWDER_CEMENT);
        output.accept(NtmItems.POWDER_CERIUM);
        output.accept(NtmItems.POWDER_CERIUM_TINY);
        output.accept(NtmItems.POWDER_CHLOROCALCITE);
        output.accept(NtmItems.POWDER_CHLOROPHYTE);
        output.accept(NtmItems.POWDER_CLOUD);
        output.accept(NtmItems.POWDER_CO60);
        output.accept(NtmItems.POWDER_CO60_TINY);
        output.accept(NtmItems.POWDER_COAL_TINY);
        output.accept(NtmItems.POWDER_COBALT_TINY);
        output.accept(NtmItems.POWDER_COLTAN);
        output.accept(NtmItems.POWDER_COLTAN_ORE);
        output.accept(NtmItems.POWDER_CS137);
        output.accept(NtmItems.POWDER_CS137_TINY);
        output.accept(NtmItems.POWDER_DAFFERGON);
        output.accept(NtmItems.POWDER_DESH_MIX);
        output.accept(NtmItems.POWDER_DESH_READY);
        output.accept(NtmItems.POWDER_EUPHEMIUM);
        output.accept(NtmItems.POWDER_FERTILIZER);
        output.accept(NtmItems.POWDER_FIRE);
        output.accept(NtmItems.POWDER_FLUX);
        output.accept(NtmItems.POWDER_I131);
        output.accept(NtmItems.POWDER_I131_TINY);
        output.accept(NtmItems.POWDER_ICE);
        output.accept(NtmItems.POWDER_IMPURE_OSMIRIDIUM);
        output.accept(NtmItems.POWDER_IODINE);
        output.accept(NtmItems.POWDER_IODINE_TINY);
        output.accept(NtmItems.POWDER_LANTHANIUM);
        output.accept(NtmItems.POWDER_LANTHANIUM_TINY);
        output.accept(NtmItems.POWDER_LIMESTONE);
        output.accept(NtmItems.POWDER_LITHIUM_TINY);
        output.accept(NtmItems.POWDER_MAGIC);
        output.accept(NtmItems.POWDER_MAGNETIZED_TUNGSTEN);
        output.accept(NtmItems.POWDER_MOLYSITE);
        output.accept(NtmItems.POWDER_NEODYMIUM);
        output.accept(NtmItems.POWDER_NEODYMIUM_TINY);
        output.accept(NtmItems.POWDER_NEPTUNIUM);
        output.accept(NtmItems.POWDER_NIOBIUM_TINY);
        output.accept(NtmItems.POWDER_NITAN_MIX);
        output.accept(NtmItems.POWDER_OSMIRIDIUM);
        output.accept(NtmItems.POWDER_PALEOGENITE);
        output.accept(NtmItems.POWDER_PALEOGENITE_TINY);
        output.accept(NtmItems.POWDER_PB209);
        output.accept(NtmItems.POWDER_PB209_TINY);
        output.accept(NtmItems.POWDER_PLUTONIUM);
        output.accept(NtmItems.POWDER_POISON);
        output.accept(NtmItems.POWDER_POLONIUM);
        output.accept(NtmItems.POWDER_POWER);
        output.accept(NtmItems.POWDER_RA226);
        output.accept(NtmItems.POWDER_RED_COPPER);
        output.accept(NtmItems.POWDER_REIIUM);
        output.accept(NtmItems.POWDER_SAWDUST);
        output.accept(NtmItems.POWDER_SCHRABIDATE);
        output.accept(NtmItems.POWDER_SEMTEX_MIX);
        output.accept(NtmItems.POWDER_SODIUM);
        output.accept(NtmItems.POWDER_SPARK_MIX);
        output.accept(NtmItems.POWDER_SR90);
        output.accept(NtmItems.POWDER_SR90_TINY);
        output.accept(NtmItems.POWDER_STEEL_TINY);
        output.accept(NtmItems.POWDER_STRONTIUM);
        output.accept(NtmItems.POWDER_TANTALIUM);
        output.accept(NtmItems.POWDER_TCALLOY);
        output.accept(NtmItems.POWDER_TEKTITE);
        output.accept(NtmItems.POWDER_TENNESSINE);
        output.accept(NtmItems.POWDER_THERMITE);
        output.accept(NtmItems.POWDER_THORIUM);
        output.accept(NtmItems.POWDER_UNOBTAINIUM);
        output.accept(NtmItems.POWDER_VERTICIUM);
        output.accept(NtmItems.POWDER_WEIDANIUM);
        output.accept(NtmItems.POWDER_XE135);
        output.accept(NtmItems.POWDER_XE135_TINY);
        output.accept(NtmItems.POWDER_YELLOWCAKE);
        output.accept(NtmItems.GEM_ALEXANDRITE);
        output.accept(NtmItems.GEM_RAD);
        output.accept(NtmItems.GEM_SODALITE);
        output.accept(NtmItems.GEM_TANTALIUM);
        output.accept(NtmItems.GEM_VOLCANIC);
        output.accept(NtmItems.CRYSTAL_CHARRED);
        output.accept(NtmItems.CRYSTAL_COAL);
        output.accept(NtmItems.CRYSTAL_HORN);
    }

    private static void addMaterialControlItems(CreativeModeTab.Output output) {
        output.accept(NtmItems.PLATE_FUEL_MOX);
        output.accept(NtmItems.PLATE_FUEL_PU238BE);
        output.accept(NtmItems.PLATE_FUEL_PU239);
        output.accept(NtmItems.PLATE_FUEL_RA226BE);
        output.accept(NtmItems.PLATE_FUEL_SA326);
        output.accept(NtmItems.PLATE_FUEL_U233);
        output.accept(NtmItems.PLATE_FUEL_U235);
        output.accept(NtmItems.CRYSTAL_ENERGY);
        output.accept(NtmItems.CRYSTAL_XEN);
    }

    private static void addMaterialBlocks(CreativeModeTab.Output output) {
        output.accept(NtmBlocks.BLOCK_ACTINIUM);
        output.accept(NtmBlocks.BLOCK_STEEL);
        output.accept(NtmBlocks.BLOCK_ALUMINIUM);
        output.accept(NtmBlocks.BLOCK_ASBESTOS);
        output.accept(NtmBlocks.BLOCK_AUSTRALIUM);
        output.accept(NtmBlocks.BLOCK_BERYLLIUM);
        output.accept(NtmBlocks.BLOCK_BISMUTH);
        output.accept(NtmBlocks.BLOCK_CADMIUM);
        output.accept(NtmBlocks.BLOCK_CDALLOY);
        output.accept(NtmBlocks.BLOCK_COLTAN);
        output.accept(NtmBlocks.BLOCK_COMBINE_STEEL);
        output.accept(NtmBlocks.BLOCK_COPPER);
        output.accept(NtmBlocks.BLOCK_DESH);
        output.accept(NtmBlocks.BLOCK_DINEUTRONIUM);
        output.accept(NtmBlocks.BLOCK_DURA_STEEL);
        output.accept(NtmBlocks.BLOCK_EUPHEMIUM);
        output.accept(NtmBlocks.BLOCK_FOAM);
        output.accept(NtmBlocks.BLOCK_LANTHANIUM);
        output.accept(NtmBlocks.BLOCK_LEAD);
        output.accept(NtmBlocks.BLOCK_LITHIUM);
        output.accept(NtmBlocks.BLOCK_MAGNETIZED_TUNGSTEN);
        output.accept(NtmBlocks.BLOCK_METEOR);
        output.accept(NtmBlocks.BLOCK_METEOR_COBBLE);
        output.accept(NtmBlocks.BLOCK_METEOR_BROKEN);
        output.accept(NtmBlocks.BLOCK_METEOR_MOLTEN);
        output.accept(NtmBlocks.BLOCK_METEOR_TREASURE);
        output.accept(NtmBlocks.BLOCK_MOX_FUEL);
        output.accept(NtmBlocks.BLOCK_NEPTUNIUM);
        output.accept(NtmBlocks.BLOCK_NIOBIUM);
        output.accept(NtmBlocks.BLOCK_NITER);
        output.accept(NtmBlocks.BLOCK_PLUTONIUM);
        output.accept(NtmBlocks.BLOCK_PLUTONIUM_FUEL);
        output.accept(NtmBlocks.BLOCK_POLONIUM);
        output.accept(NtmBlocks.BLOCK_PU238);
        output.accept(NtmBlocks.BLOCK_PU239);
        output.accept(NtmBlocks.BLOCK_PU240);
        output.accept(NtmBlocks.BLOCK_PU_MIX);
        output.accept(NtmBlocks.BLOCK_RA226);
        output.accept(NtmBlocks.BLOCK_RED_COPPER);
        output.accept(NtmBlocks.BLOCK_SATURNITE);
        output.accept(NtmBlocks.BLOCK_SCHRABIDATE);
        output.accept(NtmBlocks.BLOCK_SCHRABIDIUM);
        output.accept(NtmBlocks.BLOCK_SCHRABIDIUM_FUEL);
        output.accept(NtmBlocks.BLOCK_SCHRARANIUM);
        output.accept(NtmBlocks.BLOCK_SMORE);
        output.accept(NtmBlocks.BLOCK_SOLINIUM);
        output.accept(NtmBlocks.BLOCK_SULFUR);
        output.accept(NtmBlocks.BLOCK_TANTALIUM);
        output.accept(NtmBlocks.BLOCK_TCALLOY);
        output.accept(NtmBlocks.BLOCK_THORIUM);
        output.accept(NtmBlocks.BLOCK_THORIUM_FUEL);
        output.accept(NtmBlocks.BLOCK_TITANIUM);
        output.accept(NtmBlocks.BLOCK_TUNGSTEN);
        output.accept(NtmBlocks.BLOCK_U233);
        output.accept(NtmBlocks.BLOCK_U235);
        output.accept(NtmBlocks.BLOCK_U238);
        output.accept(NtmBlocks.BLOCK_URANIUM);
        output.accept(NtmBlocks.BLOCK_URANIUM_FUEL);
        output.accept(NtmBlocks.BLOCK_WASTE);
        output.accept(NtmBlocks.BLOCK_WASTE_PAINTED);
        output.accept(NtmBlocks.BLOCK_WASTE_VITRIFIED);
        output.accept(NtmBlocks.BLOCK_YELLOWCAKE);
        output.accept(NtmBlocks.BLOCK_FIBERGLASS);
        output.accept(NtmBlocks.BLOCK_INSULATOR);
        output.accept(NtmBlocks.BLOCK_SLAG);

    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
