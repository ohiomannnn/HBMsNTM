package com.hbm.blockentity;

import com.hbm.blockentity.bomb.*;
import com.hbm.blockentity.machine.*;
import com.hbm.blockentity.machine.boiler.MachineHeatBoilerBlockEntity;
import com.hbm.blockentity.machine.boiler.MachineIndustrialBoilerBlockEntity;
import com.hbm.blockentity.machine.heater.*;
import com.hbm.blockentity.machine.oil.MachineFrackingTowerBlockEntity;
import com.hbm.blockentity.machine.oil.MachineOilWellBlockEntity;
import com.hbm.blockentity.machine.oil.MachinePumpjackBlockEntity;
import com.hbm.blockentity.machine.oil.MachineRefineryBlockEntity;
import com.hbm.blockentity.machine.storage.*;
import com.hbm.blockentity.network.CableBaseBlockEntity;
import com.hbm.blockentity.network.PipeBaseBlockEntity;
import com.hbm.blockentity.network.RadioTorchReceiverBlockEntity;
import com.hbm.blockentity.network.RadioTorchSenderBlockEntity;
import com.hbm.blocks.NtmBlocks;
import com.hbm.blocks.bomb.VolcanoBlock.VolcanoCoreBlockEntity;
import com.hbm.blocks.generic.BobbleBlock.BobbleBlockEntity;
import com.hbm.blocks.generic.PlushieBlock.PlushieBlockEntity;
import com.hbm.main.NuclearTechMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@SuppressWarnings("DataFlowIssue") // kill yourself
public class NtmBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, NuclearTechMod.MODID);

    // Machines
    public static final Supplier<BlockEntityType<MachineSolderingStationBlockEntity>> MACHINE_SOLDERING_STATION = BLOCK_ENTITY_TYPES.register(
            "machine_soldering_station",
            () -> BlockEntityType.Builder.of(
                            MachineSolderingStationBlockEntity::new,
                            NtmBlocks.MACHINE_SOLDERING_STATION.get())
                    .build(null));
    public static final Supplier<BlockEntityType<MachineArcWelderBlockEntity>> MACHINE_ARC_WELDER = BLOCK_ENTITY_TYPES.register(
            "machine_arc_welder",
            () -> BlockEntityType.Builder.of(
                            MachineArcWelderBlockEntity::new,
                            NtmBlocks.MACHINE_ARC_WELDER.get())
                    .build(null));

    public static final Supplier<BlockEntityType<MachineHeatBoilerBlockEntity>> HEAT_BOILER = BLOCK_ENTITY_TYPES.register(
            "heat_boiler",
            () -> BlockEntityType.Builder.of(
                            MachineHeatBoilerBlockEntity::new,
                            NtmBlocks.HEAT_BOILER.get())
                    .build(null));

    public static final Supplier<BlockEntityType<MachineIndustrialBoilerBlockEntity>> MACHINE_INDUSTRIAL_BOILER = BLOCK_ENTITY_TYPES.register(
            "machine_industrial_boiler",
            () -> BlockEntityType.Builder.of(
                            MachineIndustrialBoilerBlockEntity::new,
                            NtmBlocks.MACHINE_INDUSTRIAL_BOILER.get())
                    .build(null));

    public static final Supplier<BlockEntityType<HeaterFireboxBlockEntity>> HEATER_FIREBOX = BLOCK_ENTITY_TYPES.register(
            "heater_firebox",
            () -> BlockEntityType.Builder.of(
                            HeaterFireboxBlockEntity::new,
                            NtmBlocks.HEATER_FIREBOX.get())
                    .build(null));

    public static final Supplier<BlockEntityType<HeaterOvenBlockEntity>> HEATER_OVEN = BLOCK_ENTITY_TYPES.register(
            "heater_oven",
            () -> BlockEntityType.Builder.of(
                            HeaterOvenBlockEntity::new,
                            NtmBlocks.HEATER_OVEN.get())
                    .build(null));

    public static final Supplier<BlockEntityType<HeaterOilburnerBlockEntity>> HEATER_OILBURNER = BLOCK_ENTITY_TYPES.register(
            "heater_oilburner",
            () -> BlockEntityType.Builder.of(
                            HeaterOilburnerBlockEntity::new,
                            NtmBlocks.HEATER_OILBURNER.get())
                    .build(null));

    public static final Supplier<BlockEntityType<HeaterElectricBlockEntity>> HEATER_ELECTRIC = BLOCK_ENTITY_TYPES.register(
            "heater_electric",
            () -> BlockEntityType.Builder.of(
                            HeaterElectricBlockEntity::new,
                            NtmBlocks.HEATER_ELECTRIC.get())
                    .build(null));

    public static final Supplier<BlockEntityType<HeaterHeatexBlockEntity>> HEATER_HEATEX = BLOCK_ENTITY_TYPES.register(
            "heater_heatex",
            () -> BlockEntityType.Builder.of(
                            HeaterHeatexBlockEntity::new,
                            NtmBlocks.HEATER_HEATEX.get())
                    .build(null));

    public static final Supplier<BlockEntityType<MachineShredderBlockEntity>> MACHINE_SHREDDER = BLOCK_ENTITY_TYPES.register(
            "machine_shredder",
            () -> BlockEntityType.Builder.of(
                            MachineShredderBlockEntity::new,
                            NtmBlocks.MACHINE_SHREDDER.get())
                    .build(null));

    public static final Supplier<BlockEntityType<ReactorZirnoxBlockEntity>> REACTOR_ZIRNOX = BLOCK_ENTITY_TYPES.register("machine_zirnox", () -> BlockEntityType.Builder.of(ReactorZirnoxBlockEntity::new, NtmBlocks.REACTOR_ZIRNOX.get()).build(null));
    public static final Supplier<BlockEntityType<ZirnoxDestroyedBlockEntity>> ZIRNOX_DESTROYED = BLOCK_ENTITY_TYPES.register("zirnox_destroyed", () -> BlockEntityType.Builder.of(ZirnoxDestroyedBlockEntity::new, NtmBlocks.ZIRNOX_DESTROYED.get()).build(null));

    public static final Supplier<BlockEntityType<RadioTorchReceiverBlockEntity>> RADIO_TORCH_RECEIVER = BLOCK_ENTITY_TYPES.register("radio_torch_receiver", () -> BlockEntityType.Builder.of(RadioTorchReceiverBlockEntity::new, NtmBlocks.RADIO_TORCH_RECEIVER.get()).build(null));
    public static final Supplier<BlockEntityType<RadioTorchSenderBlockEntity>> RADIO_TORCH_SENDER = BLOCK_ENTITY_TYPES.register("radio_torch_sender", () -> BlockEntityType.Builder.of(RadioTorchSenderBlockEntity::new, NtmBlocks.RADIO_TORCH_SENDER.get()).build(null));

    public static final Supplier<BlockEntityType<MachineOilWellBlockEntity>> MACHINE_OIL_WELL = BLOCK_ENTITY_TYPES.register("machine_oil_well", () -> BlockEntityType.Builder.of(MachineOilWellBlockEntity::new, NtmBlocks.MACHINE_WELL.get()).build(null));
    public static final Supplier<BlockEntityType<MachinePumpjackBlockEntity>> MACHINE_PUMPJACK = BLOCK_ENTITY_TYPES.register("machine_pumpjack", () -> BlockEntityType.Builder.of(MachinePumpjackBlockEntity::new, NtmBlocks.MACHINE_PUMPJACK.get()).build(null));
    public static final Supplier<BlockEntityType<MachineFrackingTowerBlockEntity>> MACHINE_FRACKING_TOWER = BLOCK_ENTITY_TYPES.register("machine_fracking_tower", () -> BlockEntityType.Builder.of(MachineFrackingTowerBlockEntity::new, NtmBlocks.MACHINE_FRACKING_TOWER.get()).build(null));

    public static final Supplier<BlockEntityType<MachineRefineryBlockEntity>> MACHINE_REFINERY = BLOCK_ENTITY_TYPES.register(
            "machine_refinery",
            () -> BlockEntityType.Builder.of(
                            MachineRefineryBlockEntity::new,
                            NtmBlocks.MACHINE_REFINERY.get())
                    .build(null));

    public static final Supplier<BlockEntityType<MachineFurnaceCombinationBlockEntity>> FURNACE_COMBINATION = BLOCK_ENTITY_TYPES.register(
            "furnace_combination",
            () -> BlockEntityType.Builder.of(
                            MachineFurnaceCombinationBlockEntity::new,
                            NtmBlocks.FURNACE_COMBINATION.get())
                    .build(null));

    public static final Supplier<BlockEntityType<MachineBlastFurnaceBlockEntity>> MACHINE_BLAST_FURNACE = BLOCK_ENTITY_TYPES.register(
            "machine_blast_furnace",
            () -> BlockEntityType.Builder.of(
                            MachineBlastFurnaceBlockEntity::new,
                            NtmBlocks.MACHINE_BLAST_FURNACE.get())
                    .build(null));

    public static final Supplier<BlockEntityType<MachineWoodBurnerBlockEntity>> MACHINE_WOOD_BURNER = BLOCK_ENTITY_TYPES.register(
            "machine_wood_burner",
            () -> BlockEntityType.Builder.of(
                            MachineWoodBurnerBlockEntity::new,
                            NtmBlocks.MACHINE_WOOD_BURNER.get())
                    .build(null));

    public static final Supplier<BlockEntityType<MachineCentrifugeBlockEntity>> MACHINE_CENTRIFUGE = BLOCK_ENTITY_TYPES.register(
            "machine_centrifuge",
            () -> BlockEntityType.Builder.of(
                            MachineCentrifugeBlockEntity::new,
                            NtmBlocks.MACHINE_CENTRIFUGE.get())
                    .build(null));
    public static final Supplier<BlockEntityType<MachineChemicalPlantBlockEntity>> MACHINE_CHEMICAL_PLANT = BLOCK_ENTITY_TYPES.register(
            "machine_chemical_plant",
            () -> BlockEntityType.Builder.of(
                            MachineChemicalPlantBlockEntity::new,
                            NtmBlocks.MACHINE_CHEMICAL_PLANT.get())
                    .build(null));

    public static final Supplier<BlockEntityType<BarrelBlockEntity>> BARREL = BLOCK_ENTITY_TYPES.register(
            "barrel",
            () -> BlockEntityType.Builder.of(
                            BarrelBlockEntity::new,
                            NtmBlocks.BARREL_PLASTIC.get(),
                            NtmBlocks.BARREL_STEEL.get(),
                            NtmBlocks.BARREL_TCALLOY.get())
                    .build(null));

    public static final Supplier<BlockEntityType<MachineSatLinkerBlockEntity>> MACHINE_SATLINKER = BLOCK_ENTITY_TYPES.register(
            "machine_satlinker",
            () -> BlockEntityType.Builder.of(
                            MachineSatLinkerBlockEntity::new,
                            NtmBlocks.MACHINE_SATLINKER.get())
                    .build(null));

    public static final Supplier<BlockEntityType<CrateIronBlockEntity>> CRATE_IRON = BLOCK_ENTITY_TYPES.register(
            "crate_iron",
            () -> BlockEntityType.Builder.of(
                            CrateIronBlockEntity::new,
                            NtmBlocks.CRATE_IRON.get())
                    .build(null));
    public static final Supplier<BlockEntityType<CrateTungstenBlockEntity>> CRATE_TUNGSTEN = BLOCK_ENTITY_TYPES.register(
            "crate_tungsten",
            () -> BlockEntityType.Builder.of(
                            CrateTungstenBlockEntity::new,
                            NtmBlocks.CRATE_TUNGSTEN.get())
                    .build(null));
    public static final Supplier<BlockEntityType<CrateSteelBlockEntity>> CRATE_STEEL = BLOCK_ENTITY_TYPES.register(
            "crate_steel",
            () -> BlockEntityType.Builder.of(
                            CrateSteelBlockEntity::new,
                            NtmBlocks.CRATE_STEEL.get())
                    .build(null));
    public static final Supplier<BlockEntityType<CrateDeshBlockEntity>> CRATE_DESH = BLOCK_ENTITY_TYPES.register(
            "crate_desh",
            () -> BlockEntityType.Builder.of(
                            CrateDeshBlockEntity::new,
                            NtmBlocks.CRATE_DESH.get())
                    .build(null));
    public static final Supplier<BlockEntityType<CrateTemplateBlockEntity>> CRATE_TEMPLATE = BLOCK_ENTITY_TYPES.register(
            "crate_template",
            () -> BlockEntityType.Builder.of(
                            CrateTemplateBlockEntity::new,
                            NtmBlocks.CRATE_TEMPLATE.get())
                    .build(null));

    public static final Supplier<BlockEntityType<MachinePressBlockEntity>> PRESS = BLOCK_ENTITY_TYPES.register("press", () -> BlockEntityType.Builder.of(MachinePressBlockEntity::new, NtmBlocks.MACHINE_PRESS.get()).build(null));

    public static final Supplier<BlockEntityType<MachineFluidTankBlockEntity>> FLUID_TANK = BLOCK_ENTITY_TYPES.register("fluid_tank", () -> BlockEntityType.Builder.of(MachineFluidTankBlockEntity::new, NtmBlocks.MACHINE_FLUID_TANK.get()).build(null));
    public static final Supplier<BlockEntityType<ChungusBlockEntity>> MACHINE_CHUNGUS = BLOCK_ENTITY_TYPES.register("machine_chungus", () -> BlockEntityType.Builder.of(ChungusBlockEntity::new, NtmBlocks.MACHINE_CHUNGUS.get()).build(null));

    public static final Supplier<BlockEntityType<BatterySocketBlockEntity>> BATTERY_SOCKET = BLOCK_ENTITY_TYPES.register(
            "battery_socket",
            () -> BlockEntityType.Builder.of(
                            BatterySocketBlockEntity::new,
                            NtmBlocks.MACHINE_BATTERY_SOCKET.get())
                    .build(null));

    public static final Supplier<BlockEntityType<BatteryREDDBlockEntity>> BATTERY_REDD = BLOCK_ENTITY_TYPES.register(
            "battery_redd",
            () -> BlockEntityType.Builder.of(
                            BatteryREDDBlockEntity::new,
                            NtmBlocks.MACHINE_BATTERY_REDD.get())
                    .build(null));

    public static final Supplier<BlockEntityType<MachineAssemblyMachineBlockEntity>> ASSEMBLY_MACHINE = BLOCK_ENTITY_TYPES.register(
            "assembly_machine",
            () -> BlockEntityType.Builder.of(
                            MachineAssemblyMachineBlockEntity::new,
                            NtmBlocks.MACHINE_ASSEMBLY_MACHINE.get())
                    .build(null));

    public static final Supplier<BlockEntityType<ProxyComboBlockEntity>> PROXY_COMBO = BLOCK_ENTITY_TYPES.register("proxy_combo", () -> BlockEntityType.Builder.of(ProxyComboBlockEntity::new).build(null));

    public static final Supplier<BlockEntityType<BobbleBlockEntity>> BOBBLEHEAD = BLOCK_ENTITY_TYPES.register("bobblehead", () -> BlockEntityType.Builder.of(BobbleBlockEntity::new, NtmBlocks.BOBBLEHEAD.get()).build(null));
    public static final Supplier<BlockEntityType<PlushieBlockEntity>> PLUSHIE = BLOCK_ENTITY_TYPES.register("plushie", () -> BlockEntityType.Builder.of(PlushieBlockEntity::new, NtmBlocks.PLUSHIE.get()).build(null));

    public static final Supplier<BlockEntityType<CableBaseBlockEntity>> NETWORK_CABLE = BLOCK_ENTITY_TYPES.register("network_cable", () -> BlockEntityType.Builder.of(CableBaseBlockEntity::new, NtmBlocks.RED_CABLE.get()).build(null));
    public static final Supplier<BlockEntityType<PipeBaseBlockEntity>> FLUID_DUCT = BLOCK_ENTITY_TYPES.register("fluid_duct", () -> BlockEntityType.Builder.of(PipeBaseBlockEntity::new, NtmBlocks.FLUID_DUCT_NEO.get()).build(null));

    public static final Supplier<BlockEntityType<TowerSmallBlockEntity>> TOWER_SMALL = BLOCK_ENTITY_TYPES.register("tower_small", () -> BlockEntityType.Builder.of(TowerSmallBlockEntity::new, NtmBlocks.FLUID_DUCT_NEO.get()).build(null));

    public static final Supplier<BlockEntityType<DecontaminatorBlockEntity>> DECONTAMINATOR = BLOCK_ENTITY_TYPES.register(
            "decontaminator",
            () -> BlockEntityType.Builder.of(
                            DecontaminatorBlockEntity::new,
                            NtmBlocks.DECONTAMINATOR.get())
                    .build(null));

    public static final Supplier<BlockEntityType<NukeGadgetBlockEntity>> NUKE_GADGET = BLOCK_ENTITY_TYPES.register("nuke_gadget", () -> BlockEntityType.Builder.of(NukeGadgetBlockEntity::new, NtmBlocks.NUKE_GADGET.get()).build(null));
    public static final Supplier<BlockEntityType<NukeLittleBoyBlockEntity>> NUKE_LITTLE_BOY = BLOCK_ENTITY_TYPES.register("nuke_little_boy", () -> BlockEntityType.Builder.of(NukeLittleBoyBlockEntity::new, NtmBlocks.NUKE_LITTLE_BOY.get()).build(null));
    public static final Supplier<BlockEntityType<NukeFatManBlockEntity>> NUKE_FAT_MAN = BLOCK_ENTITY_TYPES.register("nuke_fat_man", () -> BlockEntityType.Builder.of(NukeFatManBlockEntity::new, NtmBlocks.NUKE_FAT_MAN.get()).build(null));
    public static final Supplier<BlockEntityType<NukeIvyMikeBlockEntity>> NUKE_IVY_MIKE = BLOCK_ENTITY_TYPES.register("nuke_ivy_mike", () -> BlockEntityType.Builder.of(NukeIvyMikeBlockEntity::new, NtmBlocks.NUKE_IVY_MIKE.get()).build(null));
    public static final Supplier<BlockEntityType<NukeTsarBombaBlockEntity>> NUKE_TSAR_BOMBA = BLOCK_ENTITY_TYPES.register("nuke_tsar_bomba", () -> BlockEntityType.Builder.of(NukeTsarBombaBlockEntity::new, NtmBlocks.NUKE_TSAR_BOMBA.get()).build(null));
    public static final Supplier<BlockEntityType<NukePrototypeBlockEntity>> NUKE_PROTOTYPE = BLOCK_ENTITY_TYPES.register("nuke_prototype", () -> BlockEntityType.Builder.of(NukePrototypeBlockEntity::new, NtmBlocks.NUKE_PROTOTYPE.get()).build(null));
    public static final Supplier<BlockEntityType<NukeFleijaBlockEntity>> NUKE_FLEIJA = BLOCK_ENTITY_TYPES.register("nuke_fleija", () -> BlockEntityType.Builder.of(NukeFleijaBlockEntity::new, NtmBlocks.NUKE_FLEIJA.get()).build(null));
    public static final Supplier<BlockEntityType<NukeSoliniumBlockEntity>> NUKE_SOLINUIM = BLOCK_ENTITY_TYPES.register("nuke_solinium", () -> BlockEntityType.Builder.of(NukeSoliniumBlockEntity::new, NtmBlocks.NUKE_SOLINIUM.get()).build(null));
    public static final Supplier<BlockEntityType<NukeN2BlockEntity>> NUKE_N2 = BLOCK_ENTITY_TYPES.register("nuke_n2", () -> BlockEntityType.Builder.of(NukeN2BlockEntity::new, NtmBlocks.NUKE_N2.get()).build(null));
    public static final Supplier<BlockEntityType<NukeBalefireBlockEntity>> NUKE_FSTBMB = BLOCK_ENTITY_TYPES.register("nuke_fstbmb", () -> BlockEntityType.Builder.of(NukeBalefireBlockEntity::new, NtmBlocks.NUKE_FSTBMB.get()).build(null));

    public static final Supplier<BlockEntityType<LaunchPadBlockEntity>> LAUNCH_PAD = BLOCK_ENTITY_TYPES.register("launch_pad", () -> BlockEntityType.Builder.of(LaunchPadBlockEntity::new, NtmBlocks.LAUNCH_PAD.get()).build(null));
    public static final Supplier<BlockEntityType<LaunchPadLargeBlockEntity>> LAUNCH_PAD_LARGE = BLOCK_ENTITY_TYPES.register("launch_pad_large", () -> BlockEntityType.Builder.of(LaunchPadLargeBlockEntity::new, NtmBlocks.LAUNCH_PAD_LARGE.get()).build(null));
    public static final Supplier<BlockEntityType<SoyuzLauncherBlockEntity>> SOYUZ_LAUNCHER = BLOCK_ENTITY_TYPES.register("soyuz_launcher", () -> BlockEntityType.Builder.of(SoyuzLauncherBlockEntity::new, NtmBlocks.SOYUZ_LAUNCHER.get()).build(null));
    public static final Supplier<BlockEntityType<MachineRadarBlockEntity>> MACHINE_RADAR = BLOCK_ENTITY_TYPES.register("machine_radar", () -> BlockEntityType.Builder.of(MachineRadarBlockEntity::new, NtmBlocks.MACHINE_RADAR.get()).build(null));

    public static final Supplier<BlockEntityType<GeigerBlockEntity>> GEIGER_COUNTER = BLOCK_ENTITY_TYPES.register("geiger_counter", () -> BlockEntityType.Builder.of(GeigerBlockEntity::new, NtmBlocks.GEIGER.get()).build(null));

    public static final Supplier<BlockEntityType<LandmineBlockEntity>> LANDMINE = BLOCK_ENTITY_TYPES.register("landmine", () -> BlockEntityType.Builder.of(LandmineBlockEntity::new, NtmBlocks.MINE_AP.get(), NtmBlocks.MINE_HE.get(), NtmBlocks.MINE_SHRAP.get(), NtmBlocks.MINE_FAT.get(), NtmBlocks.MINE_NAVAL.get()).build(null));
    public static final Supplier<BlockEntityType<VolcanoCoreBlockEntity>> VOLCANO_CORE = BLOCK_ENTITY_TYPES.register("volcano_core", () -> BlockEntityType.Builder.of(VolcanoCoreBlockEntity::new, NtmBlocks.VOLCANO_CORE.get(), NtmBlocks.VOLCANO_RAD_CORE.get()).build(null));

    public static final Supplier<BlockEntityType<CrashedBombBlockEntity>> CRASHED_BOMB = BLOCK_ENTITY_TYPES.register("crashed_bomb", () -> BlockEntityType.Builder.of(CrashedBombBlockEntity::new, NtmBlocks.CRASHED_BOMB.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
