package com.hbm.inventory;

import com.hbm.inventory.menus.*;
import com.hbm.main.NuclearTechMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NtmMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, NuclearTechMod.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<AnvilMenu>> ANVIL = reg("anvil", AnvilMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<MachineSolderingStationMenu>> MACHINE_SOLDERING_STATION = reg("machine_soldering_station", MachineSolderingStationMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachineArcWelderMenu>> MACHINE_ARC_WELDER = reg("machine_arc_welder", MachineArcWelderMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachineShredderMenu>> MACHINE_SHREDDER = reg("machine_shredder", MachineShredderMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachineOilWellMenu<?>>> MACHINE_OIL_WELL = reg("machine_oil_well", MachineOilWellMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachineRefineryMenu>> MACHINE_REFINERY = reg("machine_refinery", MachineRefineryMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachineFurnaceCombinationMenu>> FURNACE_COMBINATION = reg("furnace_combination", MachineFurnaceCombinationMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachineBlastFurnaceMenu>> MACHINE_BLAST_FURNACE = reg("machine_blast_furnace", MachineBlastFurnaceMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachineWoodBurnerMenu>> MACHINE_WOOD_BURNER = reg("machine_wood_burner", MachineWoodBurnerMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachineCentrifugeMenu>> MACHINE_CENTRIFUGE = reg("machine_centrifuge", MachineCentrifugeMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachineChemicalPlantMenu>> MACHINE_CHEMICAL_PLANT = reg("machine_chemical_plant", MachineChemicalPlantMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachineSatLinkerMenu>> SAT_LINKER = reg("sat_linker", MachineSatLinkerMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<BarrelMenu>> BARREL = reg("barrel", BarrelMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<CrateMenu>> CRATE = reg("crate", CrateMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<HeaterFireboxMenu>> HEATER_FIREBOX = reg("heater_firebox", HeaterFireboxMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<HeaterOvenMenu>> HEATER_OVEN = reg("heater_oven", HeaterOvenMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<HeaterOilburnerMenu>> HEATER_OILBURNER = reg("heater_oilburner", HeaterOilburnerMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<HeaterHeatexMenu>> HEATER_HEATEX = reg("heater_heatex", HeaterHeatexMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<MachineAssemblyMachineMenu>> ASSEMBLY_MACHINE = reg("assembly_machine", MachineAssemblyMachineMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<MachinePressMenu>> PRESS = reg("press", MachinePressMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<ReactorZirnoxMenu>> REACTOR_ZIRNOX = reg("machine_zirnox", ReactorZirnoxMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<MachineFluidTankMenu>> FLUID_TANK = reg("fluid_tank", MachineFluidTankMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<BatterySocketMenu>> BATTERY_SOCKET = reg("battery_socket", BatterySocketMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<BatteryREDDMenu>> BATTERY_REDD = reg("battery_redd", BatteryREDDMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<NukeGadgetMenu>> NUKE_GADGET = reg("nuke_gadget", NukeGadgetMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<NukeLittleBoyMenu>> NUKE_LITTLE_BOY = reg("nuke_little_boy", NukeLittleBoyMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<NukeFatManMenu>> NUKE_FAT_MAN = reg("nuke_fat_man", NukeFatManMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<NukeIvyMikeMenu>> NUKE_IVY_MIKE = reg("nuke_ivy_mike", NukeIvyMikeMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<NukeTsarBombaMenu>> NUKE_TSAR_BOMBA = reg("nuke_tsar_bomba", NukeTsarBombaMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<NukePrototypeMenu>> NUKE_PROTOTYPE = reg("nuke_prototype", NukePrototypeMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<NukeFleijaMenu>> NUKE_FLEIJA = reg("nuke_fleija", NukeFleijaMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<NukeSoliniumMenu>> NUKE_SOLINIUM = reg("nuke_solinium", NukeSoliniumMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<NukeN2Menu>> NUKE_N2 = reg("nuke_n2", NukeN2Menu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<NukeFstbmbMenu>> NUKE_FSTBMB = reg("nuke_fstbmb", NukeFstbmbMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<LaunchPadLargeMenu>> LAUNCH_PAD_LARGE = reg("launch_pad_large", LaunchPadLargeMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<SoyuzLauncherMenu>> SOYUZ_LAUNCHER = reg("soyuz_launcher", SoyuzLauncherMenu::new);

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> reg(String name, IContainerFactory<T> factory) {
        return MENU_TYPES.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}
